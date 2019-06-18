package cn.tedu.store.mapper;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTestCase {
	
	@Autowired
	public UserMapper mapper;

	@Test
	public void insert() {
		User user =new User();
		user.setUsername("root789");
		user.setPassword("1234");
		Integer rows=mapper.insert(user);
		System.err.println("rows="+rows);
		
	}
	
	@Test
	public void findByUsername() {
		String username="spring";
		User user=mapper.findByUsername(username);
		System.err.println(user);
		
	}
	
	@Test
	public void findByUid() {
		
		User user=mapper.findByUid(2);
		System.err.println(user);
	}

	@Test
	public void updatePassword() {
		
		String password="123456";
		String modifiedUser="admin";
		Date modifiedTime=new Date();
	Integer row=	mapper.updatePassword(2, password, modifiedUser, modifiedTime);
		System.err.println(row);
	}
	
	@Test
	public void updateInfo() {
		
		User user= new User();
		user.setUid(2);
		user.setPhone("12345678911");
		user.setEmail("72@qq.com");
		user.setGender(1);
		user.setModifiedUser("admin");
		Date date =new Date();
		user.setModifiedTime(date);
		
	Integer row=	mapper.updateInfo(user);
		System.err.println(row);
	}
	
	
	@Test
	public void updateAvatar() {
		
			Integer uid=3;
			String avatar="upload/2.jpg";
			String modifiedUser="admin";
		
			Date modifiedTime=new Date();
		Integer rows=	mapper.updateAvatar(uid, avatar, modifiedUser, modifiedTime);
		System.err.println(rows);
			
	}
	
}
