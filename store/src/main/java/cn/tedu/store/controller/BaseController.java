package cn.tedu.store.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ExceptionHandler;

import cn.tedu.store.controller.ex.FileEmptyException;
import cn.tedu.store.controller.ex.FileIOException;
import cn.tedu.store.controller.ex.FileSizeException;
import cn.tedu.store.controller.ex.FileStateException;
import cn.tedu.store.controller.ex.FileTypeException;
import cn.tedu.store.controller.ex.FileUploadException;
import cn.tedu.store.service.ex.AccessDeniedExcption;
import cn.tedu.store.service.ex.AddressNotFoundException;
import cn.tedu.store.service.ex.CartNotFoundException;
import cn.tedu.store.service.ex.DeleteExcption;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.ServiceException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameDuplicateException;
import cn.tedu.store.util.ResponseResult;

/**
 * 控制器类的基类
 * @author soft01
 *
 */
public abstract class BaseController {

	/**
	 * 响应结果时用于表示成功
	 */
	protected static final int SUCCESS=200;
	
	@ExceptionHandler({ServiceException.class,FileUploadException.class})
	public ResponseResult<Void> handleException(Throwable e){
		
		ResponseResult<Void> rr=new ResponseResult<>();
		rr.setMessage(e.getMessage());
		
		if (e instanceof UsernameDuplicateException ) {
			// 400-用户名冲突异常
			rr.setState(400);
		}else if (e instanceof UserNotFoundException) {
			//401尝试访问的用户数据不存在
			rr.setState(401);
		}else if (e instanceof PasswordNotMatchException) {
			//402验证密码失败,密码错误
			rr.setState(402);
		}else if (e instanceof AddressNotFoundException) {
			//403 添加收货地址异常
			rr.setState(403);
		}else if (e instanceof AccessDeniedExcption) {
			//404 非法访问异常
			rr.setState(404);
		}else if (e instanceof CartNotFoundException) {
			//405购物车数据未找到
			rr.setState(405);
		}else if (e instanceof InsertException) {
			// 500-插入数据异常
			rr.setState(500);
		}else if (e instanceof UpdateException) {
			// 501更新数据异常
			rr.setState(501);
		}else if (e instanceof DeleteExcption) {
			// 502删除时出现异常
			rr.setState(502);
		}else if (e instanceof FileEmptyException) {//开始
			// 600文件是空的,通常是没有选择文件,或者文件是0k
			rr.setState(600);
		}else if (e instanceof FileSizeException) {
			// 601上传文件的大小超出了限制
			rr.setState(601);
		}else if (e instanceof FileTypeException) {
			// 602文件类型异常,尝试上传了不支持的文件类型
			rr.setState(602);
		}else if (e instanceof FileIOException) {
			// 603上传文件时读写异常
			rr.setState(603);
		}else if (e instanceof FileStateException) {
			// 604上传文件时操作状态异常
			rr.setState(604);
		}
		
		
		return rr;
	}
	/**
	 * 从session中回去Uid
	 * @param session
	 * @return
	 */
	protected final Integer getUidFromSession(HttpSession session) {
		
		return Integer.valueOf( session.getAttribute("uid").toString());
	}
}
