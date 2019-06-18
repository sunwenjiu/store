package cn.tedu.store.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import cn.tedu.store.entity.User;
import cn.tedu.store.service.ex.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTestCase {
	
	@Autowired
	public IUserService service;

	@Test
	public void reg() {
		try {
			User user=new User();
			user.setUsername("digest");
			user.setPassword("987654321");
			service.reg(user);
		} catch (ServiceException e) {
			System.err.println(e.getClass());
		System.err.println(	service.getClass());
		System.err.println(e.getMessage());
		}
	
	}
	
	@Test
	public void login() {
		try {
			String username="digest";
			String password="987654321";
			User result=	service.login(username, password);
			System.err.println(result);
			
			
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getClass().getName());
		}
	}
	
	@Test
	public void changePassword() {
		try {
			Integer uid=3;
			String oldPassword="12345678";
			String newPassword="1234";
			String username="admin";
			service.changePassword(uid, oldPassword, newPassword, username);
			
			
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getClass().getName());
		}
		
	}
	
@Test
public void changeInfo() {
	try {
		User user= new User();
		user.setUid(2);
		user.setPhone("12345678912");
		user.setEmail("723@qq.com");
		user.setGender(1);
		user.setModifiedUser("超级管理员");
		
		service.changeInfo(user);
	} catch (ServiceException e) {
System.err.println(e.getMessage());
System.err.println(e.getClass().getName());
	}

}

@Test
public void changeAvatar() {
	try {
		
		Integer uid=3;
		String avatar="upload/4.jpg";
		String username="超级管理员";
		service.changeAvatar(uid, avatar, username);
		
	} catch (ServiceException e) {
		System.err.println(e.getMessage());
	}
}


@Test
public void getByUid() {
	try {
		Integer uid=2;
	User user=	service.getByUid(uid);
		System.err.println(user);
	} catch (ServiceException e) {
		System.err.println(e.getMessage());
		System.err.println(e.getClass().getName());
	}
	
	
}

}
