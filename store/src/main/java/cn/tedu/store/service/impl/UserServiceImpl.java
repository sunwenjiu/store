package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import cn.tedu.store.entity.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameDuplicateException;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public void reg(User user) throws UsernameDuplicateException, InsertException {

		User result=		userMapper.findByUsername(user.getUsername());

		if (result==null) {
			//是允许注册
			//封装is_delete
			user.setIsDelete(0);
			//封装日志
			Date now =new Date();
			user.setCreatedUser(user.getUsername());
			user.setCreatedTime(now);
			user.setModifiedUser(user.getUsername());
			user.setModifiedTime(now);

			//密码加密
			//生成随机盐
			String salt=UUID.randomUUID().toString().toUpperCase();
			//执行加密
			String md5password =getMd5password(user.getPassword(), salt);
			//将盐和加密结果封装到user对象中
			user.setSalt(salt);
			user.setPassword(md5password);
			//执行注册
			Integer rows=	userMapper.insert(user);
			if (rows!=1) {
				throw new InsertException("注册时发生未知错误,请联系管理员处理!");
			}

		}else {
			//否 不允许注册,抛出异常
			throw new UsernameDuplicateException("尝试注册的用户名"+user.getUsername()+"已经被注册,请换一个用户名");
		}


	}

	@Override
	public User login(String username, String password) throws UserNotFoundException, PasswordNotMatchException {
		// 根据参数username查询匹配的用户信息
		User result= userMapper.findByUsername(username);
		// 判断查询结果是否为null
		if (result==null) {
			// 是：用户名对应的数据不存在，抛出UserNotFoundException
			throw new UserNotFoundException("登录失败,用户名不存在");
		}

		// 判断isDelete值是否为1
		if (result.getIsDelete()==1) {
			// 是：用户标记为“已删除”，抛出UserNotFoundException
			throw new UserNotFoundException("登录失败,用户名不存在");
		}

		// 基于盐值和参数password执行加密
		String salt =result.getSalt();
		String md5Passwprd=getMd5password(password, salt);
		// 判断加密后的密码与查询结果中的密码是否不匹配
		if (!result.getPassword().equals(md5Passwprd)) {
			// 是：密码不匹配，抛出PasswordNotMatchException

			throw new PasswordNotMatchException("登录失败,密码错误!");
		}

		// 将查询结果中的salt, password, isDelete设置为null
		result.setSalt(null);
		result.setPassword(null);
		result.setIsDelete(null);
		// 返回查询结果


		return result;
	}


	@Override
	public void changePassword(Integer uid, String oldPassword, String newPassword, String username)
			throws UserNotFoundException, PasswordNotMatchException, UpdateException {

		// 根据参数uid查询用户数据

		User result=userMapper.findByUid(uid);

		// 判断查询结果是否为null
		if (result==null) {
			// 是：抛出UserNotFoundException
			throw new UserNotFoundException("修改密码错误,尝试访问的用户数据不存在");
		}

		// 判断查询结果中的isDelete是否为1
		if (result.getIsDelete()==1) {
			// 是：抛出UserNotFoundException
			throw new UserNotFoundException("修改密码错误,尝试访问的用户数据不存在");
		}

		// 取出查询结果中的盐值
		String salt =result.getSalt();
		// 基于参数oldPassword和盐值执行加密
		String oldMd5Password=getMd5password(oldPassword, salt);
		// 判断加密结果与查询结果中的密码是否不匹配
		if (!oldMd5Password.equals(result.getPassword())) {
			// 是：抛出PasswordNotMatchException
			throw new PasswordNotMatchException("修改密码错误,原密码错误");
		}

		// 基于参数newPassword和盐值执行加密
		String newMd5Password=getMd5password(newPassword, salt);
		// 创建当前时间对象，作为最后修改时间
		Date modifiedTime=new Date();
		// 调用持久层执行更新密码（新密码是以上加密的结果），并获取返回值
		Integer row=	userMapper.updatePassword(uid, newMd5Password, username, modifiedTime);
		// 判断返回值是否不为1
		if (row!=1) {
			// 是：抛出UpdateException
			throw new UpdateException("修改密码失败,更新数据发送未知错误!");
		}


	}
	
	@Override
	public void changeInfo(User user) throws UserNotFoundException, UpdateException {
		// 从参数user中获取uid
		Integer uid= user.getUid();
				// 调用持久层对象的方法，根据uid查询用户数据
	User result=	userMapper.findByUid(uid);

				// 判断查询结果是否为null
		if (result==null) {
			// 是：抛出UserNotFoundException
			throw new UserNotFoundException("修改个人资料错误,尝试访问的用户数据不存在");
		}
		
		// 判断查询结果中的isDelete是否为1
		if (result.getIsDelete()==1) {
			// 是：抛出UserNotFoundException
			throw new UserNotFoundException("修改个人资料错误,尝试访问的用户数据不存在");
		}

		
				// 创建当前时间对象，封装到user中
		Date now = new Date();
		//  确保modifiedUser属性是有值的
		user.setModifiedTime(now);

				// 调用持久层对象执行修改，并获取返回值（即受影响的行数）
		Integer rows=	userMapper.updateInfo(user);
				
				// 判断返回值是否不为1
		if (rows!=1) {
			// 是：抛出UpdateException
			throw new UpdateException("修改个人资料错误,更新数据时出现未知错误");
		}
		
	}
	
	@Override
	public void changeAvatar(Integer uid, String avatar, String username)
			throws UserNotFoundException, UpdateException {
		User result=userMapper.findByUid(uid);
		if (result==null) {
			throw new UserNotFoundException("修改个人资料错误,尝试访问的用户数据不存在");
		}
		if (result.getIsDelete()==1) {
			throw new UserNotFoundException("修改个人资料错误,尝试访问的用户数据不存在");
		}
		
		Date modifiedTime = new Date();
		
	Integer rows=	userMapper.updateAvatar(uid, avatar, username, modifiedTime);
		if (rows!=1) {
			throw new UpdateException("修改个人资料错误,更新数据时出现未知错误");
		}
		
		
	}


	
	@Override
	public User getByUid(Integer uid) throws UserNotFoundException {
		
		User result =userMapper.findByUid(uid);
		
		if (result==null) {
			throw new UserNotFoundException("查询出错,尝试访问的用户数据不存在");
		}
		if (result.getIsDelete()==1) {
			throw new UserNotFoundException("查询出错,尝试访问的用户数据不存在");
		}
		
		result.setPassword(null);
		result.setSalt(null);
		result.setIsDelete(null);
		
		
		return result;
	}
	
	





	/**
	 * 拼接盐和密码
	 * @param password
	 * @param salt 盐
	 * @return
	 */
	private String getMd5password(String password,String salt) {
		//拼接
		String str=salt+ password+salt;
		//循环加密5次
		for (int i = 0; i < 5; i++) {
			str=DigestUtils.md5DigestAsHex(str.getBytes()).toUpperCase();
		}
		//返回结果

		return str;

	}








}
