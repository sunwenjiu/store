package cn.tedu.store.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.store.controller.ex.FileEmptyException;
import cn.tedu.store.controller.ex.FileIOException;
import cn.tedu.store.controller.ex.FileSizeException;
import cn.tedu.store.controller.ex.FileStateException;
import cn.tedu.store.controller.ex.FileTypeException;
import cn.tedu.store.entity.User;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.ServiceException;
import cn.tedu.store.service.ex.UsernameDuplicateException;
import cn.tedu.store.util.ResponseResult;

@RestController
@RequestMapping("users")
public class UserController extends BaseController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping("reg")
	public ResponseResult<Void> reg(User user){
		
			userService.reg(user);
			return new ResponseResult<>(SUCCESS);
	
	}
	
	@RequestMapping("login")
	public ResponseResult<User> login(String username,String password,HttpSession session){
	User result= userService.login(username, password);
		
	session.setAttribute("uid", result.getUid());
	session.setAttribute("username", result.getUsername());
	
		
		return new ResponseResult<User>(SUCCESS, result);
	}
	
	@RequestMapping("change_password")
	public ResponseResult<Void>    changePassword(@RequestParam("old_password") String oldPassword,@RequestParam("new_password") String newPassword,HttpSession session){
		Integer uid=getUidFromSession(session);
		String username=session.getAttribute("username").toString();
		userService.changePassword(uid, oldPassword, newPassword, username);
		
		return new ResponseResult<>(SUCCESS);
	}
	
	@RequestMapping("change_info")
	public ResponseResult<Void> changeInfo(User user,HttpSession session){
		Integer uid = getUidFromSession(session);
		
		String username= session.getAttribute("username").toString();
		
		user.setUid(uid);
		user.setUsername(username);
		
		userService.changeInfo(user);
		
		return new ResponseResult<>(SUCCESS);
	}
	
	/**
	 * 返回用户信息
	 * @param session
	 * @return
	 */
	@GetMapping("details")
	public ResponseResult<User> getByUid(HttpSession session){
		Integer uid= getUidFromSession(session);
		User data= userService.getByUid(uid);
		
		return  new ResponseResult<>(SUCCESS, data);
	}
	/**
	 * 上传头像的文件夹名称
	 */
	public static final String UPLOAD_DIR ="upload";
	/**
	 * 上传文件的大小
	 */
	public static final long UPLOAD_AVATAR_MAX_SIZE=1*1024*1024;
	
	public static final List<String> UPLOAD_AVATAR_TYPES=new ArrayList<String>();
	
	static {
		UPLOAD_AVATAR_TYPES.add("image/jpg");
		UPLOAD_AVATAR_TYPES.add("image/png");
		UPLOAD_AVATAR_TYPES.add("image/gif");
	}
	
	@PostMapping("change_avatar")
	public ResponseResult<String> changeAvatar(HttpServletRequest request,@RequestParam("avatar") MultipartFile avatar,HttpSession session){
		//  判断isEmpty
		if (avatar.isEmpty()) {
			//抛出异常FileEmptyException
			throw new FileEmptyException("上传头像失败,未选择头像或选择的文件是空的");
		}
		
		// TODO 判断文件大小
		long size =avatar.getSize();
		if (size>UPLOAD_AVATAR_MAX_SIZE) {
			//  抛出异常:FileSizeException
			throw new FileSizeException("文件大小超过限制,上传失败,不可以超过"+UPLOAD_AVATAR_MAX_SIZE/1024+"kb");
			
		}
		//  判断文件类型
		String contentType= avatar.getContentType();
		
		if (!UPLOAD_AVATAR_TYPES.contains(contentType)) {
			// TODO 抛出异常FileTypeException
			throw new FileTypeException("文件类型不匹配,上传失败,允许的文件类型有:"+UPLOAD_AVATAR_TYPES);
			
		}
		
		//创建保存文件的文件夹的对象
		String parentPath= request.getServletContext().getRealPath(UPLOAD_DIR);
		File parent = new File(parentPath);
		if (!parent.exists()) {
			parent.mkdirs();
		}
		//确定保存的文件的文件名
		String originalFilename = avatar.getOriginalFilename();
		// 确定上传的文件的扩展名
				String suffix = "";
				int beginIndex = originalFilename.lastIndexOf(".");
				if (beginIndex != -1) {
					suffix = originalFilename.substring(beginIndex);
				}
				// 确定上传的文件最终保存时使用的文件名
				String child = UUID.randomUUID().toString() + suffix;
		
		//创建保存文件的file对象
		
		File dest= new File(parent, child);
				//执行上传并保存文件
		
				try {
					avatar.transferTo(dest);
				} catch (IllegalStateException e) {
					//FileStateException
					throw new FileStateException("选择的文件不可用,上传失败");
				}catch ( IOException e) {
					//抛出异常 FileIOException
					throw new FileIOException("文件上传时失败,读写数据出现错误");
				}
		
		
		
				//c从session中回去UId 和username
				Integer uid=getUidFromSession(session);
				String avatarPath="/"+UPLOAD_DIR+"/"+child;
				String username=session.getAttribute("username").toString();
		//执行修改数据
				userService.changeAvatar(uid, avatarPath, username);
		
		//返回成功及avatarPath
				ResponseResult<String> rr = new ResponseResult<>();
				rr.setState(SUCCESS);
				rr.setData(avatarPath);
				
		return rr;
	}
	
}
