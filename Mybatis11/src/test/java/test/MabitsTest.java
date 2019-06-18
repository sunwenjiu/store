package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.mapper.UserMapper;
import cn.tedu.pojo.User;

public class MabitsTest {
	@Test
	public void test01() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("application-mabits.xml");
		UserMapper mapper=ac.getBean("userMapper",UserMapper.class);
		List<User> users=mapper.findAll();
		for (User user : users) {
			System.out.println(user);
		}
		//User user=mapper.findUserById("0001");
	//	System.out.println(user);
	}
}
