package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.Cart;
import cn.tedu.store.entity.User;
import cn.tedu.store.vo.CartVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartMapperTestCase {

	@Autowired
	public CartMapper mapper;

	@Test
	public void addnew() {
			Cart cart=new Cart();
			cart.setUid(12);
			
			cart.setGid(12l);;
		Integer rows=	mapper.addnew(cart);
		System.err.println(rows);

	}
	

	@Test
	public void updateNum() {
		
		Integer cid=4;
		Integer num=6;
		String modifiedUser="管理员";
		Date modifiedTime=new Date();
		Integer rows=	mapper.updateNum(cid, num, modifiedUser, modifiedTime);
		System.err.println(rows);

	}
	
	
	@Test
	public void findByUidAndGid() {
		

		Integer uid=12;
		Long gid=12l;
		Cart c=	mapper.findByUidAndGid(uid, gid);
		System.err.println(c);

	}
	
	@Test
	public void findByUid() {
		

	
		Integer uid=1;
		List<CartVO> list =	mapper.findByUid(uid);
		for (CartVO vo : list) {
			System.err.println(vo);
		}

	}
	
	
	@Test
	public void fingByCid() {
		Integer cid=3;
		Cart c=mapper.fingByCid(cid);
		System.err.println(c);
	}
	
	@Test
	public void findByCids() {
		
		Integer[] cids= {1,2,3};
		List<CartVO> list=mapper.findByCids(cids);
		for (CartVO cartVO : list) {
			System.err.println(cartVO);
		}
	}
}
