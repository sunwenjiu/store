package cn.tedu.mybatis;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestCase {
	AbstractApplicationContext ac ;
	BasicDataSource ds;
	UserMapper userMapper;
	DepartmentMapper departmentMapper;
	MapperScannerConfigurer msc;
	SqlSessionFactoryBean ssfb;
	@Before
	public void doBefor() {
		ac = new ClassPathXmlApplicationContext("spring.xml");

		ds=ac.getBean("dataSource", BasicDataSource.class);
		userMapper =ac.getBean("userMapper",UserMapper.class);
		departmentMapper=ac.getBean("departmentMapper",DepartmentMapper.class);

	}
	@After
	public void doAfter() {
		ac.close();
	}




	@Test
	public void getConnection() throws SQLException {

		//BasicDataSource ds=ac.getBean("dataSource", BasicDataSource.class);

		Connection conn=ds.getConnection();
		System.out.println(conn);



	}


	@Test
	public void insert() {

		User user = new User();
		user.setUsername("九007");
		user.setPassword("密码");
		user.setAge(23);
		user.setPhone("15198828888");
		user.setEmail("721@qqcom");
		user.setIsDelete(0);
		System.out.println(user);

		Integer rows=userMapper.insert(user);
		System.out.println("rows="+rows);
		System.out.println(user);



	}
	//RAID
	@Test
	public void findAll() {
		List<User> list=userMapper.findAll();
		for (User user : list) {
			System.out.println(user);
		}

	}
	
	@Test
	public void findByUsername() {
		User user= userMapper.findByUsername("九九");
		System.out.println(user);
	}
	
	@Test
	public void updateIsdelete() {
		Integer isDelete=0;
		Integer rows=userMapper.updateIsdelete(isDelete);
		System.out.println("rows="+rows);
	}
	
	@Test
	public void updatePassword() {
		Integer id=1;
		String password="888";
		Integer rows=userMapper.updatePassword(id, password);
		
		System.out.println("rows="+rows);
		
	}
	
	@Test
	public void countById() {
		Integer count=userMapper.countById();
		System.out.println(count);
		
	}
	
	@Test
	public void deleteByIds() {
		Integer[] ids = {3,4,5}		;
		
		
		Integer rows = userMapper.deleteByIds(ids);
		System.out.println(rows);
	}
	
	@Test
	public void findAllDepartment() {
		List<DepartmentVO> list
			= departmentMapper.findAll();
		System.out.println("BEGIN:");
		for (DepartmentVO departmentVO : list) {
			System.out.println(departmentVO);
		}
		System.out.println("END.");
	}
	
	@Test
	public void findDepartmentById() {
		Integer id = 1;
		DepartmentVO departmentVO
			= departmentMapper.findById(id);
		System.out.println(departmentVO);
	}

}
