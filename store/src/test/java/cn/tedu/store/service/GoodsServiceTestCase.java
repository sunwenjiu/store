package cn.tedu.store.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.Goods;
import cn.tedu.store.entity.User;
import cn.tedu.store.service.ex.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsServiceTestCase {
	
	@Autowired
	public IGoodsService service;
	
	
	@Test
	public void getByUid() {
		
	List<Goods> list=	service.getHotList();
	for (Goods address : list) {
		System.err.println(address);
	}
		
	}
	
	@Test
	public void getByid() {
		long id=10000001;
	Goods list=	service.getById(id);
	
		System.err.println(list);
	
		
	}
	

}
