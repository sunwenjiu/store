package cn.tedu.boot.demo;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.boot.demo.entity.User;
import cn.tedu.boot.demo.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTestCase {

	@Autowired
	public	UserMapper mapper;

	@Test
	public void insert() {
		User user= new User();
		user.setUsername("springboot");
		user.setPassword("8888");
		Integer rows =mapper.insert(user);
		System.err.println("rows="+rows);
		
	}
	
	@Test
	public void findByUsername() {
		String username="tom2d";
		User user=mapper.findByUsername(username);
		System.out.println(user);
		
	}
	
	
}
