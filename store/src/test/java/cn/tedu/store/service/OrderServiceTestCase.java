package cn.tedu.store.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.District;
import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.User;
import cn.tedu.store.service.ex.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTestCase {

	@Autowired
	public IOrderService service;

	@Test
	public void getByParent() {
		try {
			Integer aid=6;
			Integer[] cids= {1,2,3};
			Integer uid=1;
			String username="管理员";
		Order order=	service.create(aid, cids, uid, username);
			System.err.println(order);
		} catch (ServiceException e) {
		System.err.println(e.getMessage());	
		}
		
		}	

	}
	



