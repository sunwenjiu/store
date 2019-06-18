package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItem;
import cn.tedu.store.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTestCase {

	@Autowired
	public OrderMapper mapper;

	@Test
	public void insertOrder() {

		Order order= new Order();
		order.setUid(1);
		order.setRecvName("孙文九");
		Integer rows=	mapper.insertOrder(order);
		System.err.println(rows);

	}
	
	@Test
	public void insertOrderItem() {

		
		OrderItem orderItem=new OrderItem();
		orderItem.setGid(15l);
		
		Integer rows=	mapper.insertOrderItem(orderItem);
		System.err.println(rows);

	}
	
	@Test
	public void insertOrder3() {

		Order order= new Order();
		order.setUid(1);
		order.setRecvName("孙文九");
		Integer rows=	mapper.insertOrder(order);
		System.err.println(rows);
		
		
		OrderItem orderItem=new OrderItem();
		orderItem.setGid(15l);
		orderItem.setOid(order.getOid());
			mapper.insertOrderItem(orderItem);

	}

}
