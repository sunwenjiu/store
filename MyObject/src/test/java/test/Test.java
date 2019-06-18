package test;

import java.util.List;

import dao.ChecksDAO;
import dao.DisDAO;
import dao.DrugsDAO;
import dao.UserDAO;
import entity.ChecksEntity;
import entity.DiseaseEntity;
import entity.DrugsEntity;
import entity.User;

public class Test {
	@org.junit.Test
	public void testgetChecks() {
		ChecksDAO dao=new ChecksDAO();
		List<ChecksEntity> list=dao.getChecks(2, 5);
		for (ChecksEntity che : list) {
			System.out.println(che);
		}
		
	}
	
	@org.junit.Test
	public void testgetChecksById() {
		ChecksDAO dao=new ChecksDAO();
		System.out.println(dao.getChecksById(20));
		
	}
	
	
	@org.junit.Test
	public void testChecksGetMax() {
		ChecksDAO dao=new ChecksDAO();
	System.out.println(dao.getMaxNo());	
		
	}
	
	@org.junit.Test
	public void testgetUserByUsername() {
		UserDAO dao = new UserDAO();
	User user=	dao.getUserByUsername("12   ");
	System.out.println(user);
	}
	
	/**
	 * 测试通过Id取出医药的详情
	 */
	@org.junit.Test
	public void testgetDrugsById() {
		DrugsDAO dao = new DrugsDAO();
		DrugsEntity dru=dao.getDrugsById(5);
		System.out.println(dru);
		
	}
	
	
	/**
	 * 测试医药百科的最大条数
	 */
	@org.junit.Test
	public void testgetMaxNoForDrugs() {
		DrugsDAO dao = new DrugsDAO();
		System.out.println(dao.getMaxNo());
		
	}
	
	/**
	 * 测试医药百科是否按条件返回数据
	 */
	@org.junit.Test
	public void testgetDrugs() {
		DrugsDAO dao = new DrugsDAO();
		List<DrugsEntity> list = dao.getDrugs(5, 5);
		for (DrugsEntity dr : list) {
			System.out.println(dr.getId()+",name:"+dr.getName());
		}
		
		
	}
	
	
	/**
	 * tg通过用户名查询用户是否存在 null表示不存在
	 */
	@org.junit.Test
	public void tsetgetUserByUsername() {
		UserDAO dao = new UserDAO();
		String username= "123";
		User user=dao.getUserByUsername(username);
		System.out.println(user);
		
	}
	
	
	/**
	 * 测试通过用户名和密码查询用户
	 */
	@org.junit.Test
	public void testgetUserByUAP() {
		UserDAO dao = new UserDAO();
		String username="123";
		String password="123";
		boolean flag= dao.getUserByUAP(username, password);
		System.out.println(flag);
		
	}
	
	/**
	 * 测试添加用户
	 */
	@org.junit.Test
	public void testAdduser() {
		UserDAO dao = new UserDAO();
		String username = "535512199009091000";
		String password	 = "123";
		String tel = "15198829959";
		
		boolean falg = dao.addUser(username, password, tel);
		System.out.println(falg);
	}
	
	
	
	
	/**
	 * 测试数据库连接是否成功
	 */
	@org.junit.Test
	public void testSQL() {
		UserDAO dao = new UserDAO();
		dao.testSQL();
		
	}
	/**
	 * 测试获取疾病百科
	 */
	@org.junit.Test
	public void testgetDisease() {
		DisDAO dao = new DisDAO();
		List<DiseaseEntity> list = dao.getDisease(2,15);
		for (DiseaseEntity dis : list) {
			System.out.println(dis.getName());
		}
		
		
	}

	//测试读取疾病的全部信息
	@org.junit.Test
	public void testgetDiseaseById() {
		DisDAO dao = new DisDAO();
		DiseaseEntity dis=dao.getDiseaseById(2);
		System.out.println(dis);
		
	}
	
	@org.junit.Test
	public void testgetMaxNo() {
		DisDAO dao = new DisDAO();
	int i=dao.getMaxNo();
	
			System.out.println(i);
		
		
	}
	
	
}
