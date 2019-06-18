package cn.tedu.store.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.User;
import cn.tedu.store.service.ex.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTestCase {
	
	@Autowired
	public IAddressService service;
	
	@Test
	public void insert() {
		try {
			Address address= new Address();
			address.setName("addr");
			address.setUid(9);
			
			String username ="系统管理员";
			service.addnew(address, username);
			System.err.println("ok");
			
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
		
	}

	@Test
	public void getByUid() {
		Integer uid=1;
	List<Address> list=	service.getByUid(uid);
	for (Address address : list) {
		System.err.println(address);
	}
		
	}
	
	@Test
	public void setDefault() {
		Integer aid=15;
		Integer uid=1;
		String username="超级管理员";
		try {
			service.setDefault(aid, uid, username);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void delete() {
		try {
			
			Integer aid=150;
			Integer uid=1;
			String username="管理员";
			service.delete(aid, uid, username);
			System.err.println("ok");
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getClass().getName());
		}
		
	}
	
	@Test
	public void getByAid() {
		Integer aid=6;
		Address a=service.getByAid(aid);
		System.err.println(a);
	}

}
