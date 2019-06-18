package cn.tedu.store.service;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.Cart;
import cn.tedu.store.entity.District;
import cn.tedu.store.entity.User;
import cn.tedu.store.service.ex.ServiceException;
import cn.tedu.store.vo.CartVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartServiceTestCase {

	@Autowired
	public ICartService service;

	@Test
	public void addToCart() {
		try {
			Cart cart=new Cart();
			//cart.setCid(cid);
			cart.setUid(122);
			cart.setGid(122l);;
			cart.setNum(122);
			
			String username="管理员2";
			service.addToCart(cart, username);
			System.err.println("ok");
		} catch (ServiceException e) {
		System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void getByUid() {
		try {
			
			
	
			Integer uid=1;
			List<CartVO> list=	service.getByUid(uid);
			for (CartVO c : list) {
				System.err.println(c);
			}
			
		} catch (ServiceException e) {
		System.err.println(e.getMessage());
		}
	}
	@Test
	public void addnum() {
		try {
			Integer cid=2;
			Integer uid=1;
			String username="管理员";
			Integer num=service.addNum(cid, uid, username);
			System.err.println(num);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
		
		
	}
	
	
	@Test
	public void getByCids() {
		try {
			
			
	
			
			Integer[] cids= {1,2,3,4};
			List<CartVO> list=	service.getByCids(cids);
			for (CartVO c : list) {
				System.err.println(c);
			}
			
		} catch (ServiceException e) {
		System.err.println(e.getMessage());
		}
	}

}
