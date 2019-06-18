package cn.tedu.store.service;

import cn.tedu.store.entity.User;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameDuplicateException;

/**
 * 处理用户数据的业务层接口
 * @author soft01
 *
 */
public interface IUserService {
	
	/**
	 * 用户注册
	 * @param user 将要注册的用户数据
	 * @throws UsernameDuplicateException
	 * @throws InsertException
	 */
	void reg(User user) throws UsernameDuplicateException,InsertException;
	
	User login(String username, String password) throws UserNotFoundException, PasswordNotMatchException;
	
	void changeInfo(User user) throws UserNotFoundException, UpdateException;

	void changePassword (Integer uid,String oldPassword,String newPassword,
			String username) throws UserNotFoundException, PasswordNotMatchException,UpdateException;
	
	User getByUid(Integer uid) throws UserNotFoundException;
	
	void changeAvatar(Integer uid,String avatar,String username)throws UserNotFoundException,UpdateException;
}
