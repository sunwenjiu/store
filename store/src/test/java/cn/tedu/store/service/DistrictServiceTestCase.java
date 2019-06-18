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
import cn.tedu.store.entity.User;
import cn.tedu.store.service.ex.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DistrictServiceTestCase {

	@Autowired
	public IDistrictService service;

	@Test
	public void getByParent() {
		List<District> list=	service.getByParent("86");
		for (District district : list) {
			System.err.println(district);
		}	

	}
	

	@Test
	public void getByCode() {
		String code="530000";
		District dis=	service.getByCode(code);
		System.err.println(dis);
	}


}
