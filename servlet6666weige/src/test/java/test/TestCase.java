package test;

import java.util.List;

import org.junit.Test;

import dao.UserDAO;
import entity.User;

public class TestCase {

	@Test
	public void testLiseUser() {
		UserDAO dao =new UserDAO();
		List<User> list=dao.listUser();
		for (User user : list) {
			System.out.println(user);
		}
		
	}
	
	public void testAddUser() {
		
	}
	@Test
	public void testUserAddUser() {
		UserDAO dao =new UserDAO();
		boolean flag=dao.getUserByUsername("ads");
		System.out.println(flag);
	}
	
	
	@Test
	public void testDelUser() {
		int id=5;
		UserDAO dao = new UserDAO();
		boolean flag=dao.delUser(id);
		System.out.println(flag);
	}
	@Test
	public void testLogin() {
		UserDAO dao =new UserDAO();
		boolean flag=dao.getUserByUAP("ads", "asd");
		System.out.println(flag);
				
		
	}
	@Test
	public void testupPassword() {
		UserDAO dao = new UserDAO();
		boolean flag=dao.upUserPassword(18, "ads");
		System.out.println(flag);
		
		
	}
	
}
