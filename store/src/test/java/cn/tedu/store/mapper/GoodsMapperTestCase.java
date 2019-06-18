package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.Goods;
import cn.tedu.store.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsMapperTestCase {

	@Autowired
	public GoodsMapper mapper;

	@Test
	public void findHotList() {
		List<Goods> list=	mapper.findHotList();
		for (Goods goods : list) {
			System.err.println(goods);
		}

	}
	
	@Test
	public void findById() {
		long id=10000001l;
		Goods g=mapper.findById(id);
		System.err.println(g);
		
	}
}
