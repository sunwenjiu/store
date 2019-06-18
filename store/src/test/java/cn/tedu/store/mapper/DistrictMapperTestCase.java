package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.District;
import cn.tedu.store.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DistrictMapperTestCase {

	@Autowired
	public DistrictMapper mapper;

	@Test
	public void findByParent() {
		String parent="86";
	List<District>	 dis=mapper.findByParent(parent);
	for (District district : dis) {
		System.err.println(district);
	}

	}
	
	@Test
	public void findByCode() {
		String code="530300";
	District dis=	mapper.findByCode(code);
		System.err.println(dis);
	}



}
