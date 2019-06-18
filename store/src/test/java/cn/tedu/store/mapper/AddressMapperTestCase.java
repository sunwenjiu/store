package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressMapperTestCase {

	@Autowired
	public AddressMapper mapper;

	@Test
	public void insert() {

		Address address=new Address();
		address.setUid(2);
		address.setAddress("街道02号");
		address.setPhone("15198822222");
		address.setCity("530325");
		address.setDistrict("北京哪里");

		Integer rows=	mapper.insert(address);
		System.err.println(rows);

	}

	@Test
	public void countByUid() {

		Integer uid=2;
		Integer rows=		mapper.countByUid(uid);
		System.err.println(rows);

	}

	@Test
	public void findByUid() {

		Integer uid=1;
		List<Address>	list=mapper.findByUid(uid);
		for (Address address : list) {
			System.err.println(address);
		}
	}

	@Test
	public void updateDefault() {

		Integer aid=10;
		String modifiedUser="管理员";
		Date modifiedTime=new Date();
		Integer rows=	mapper.updateDefault(aid, modifiedUser, modifiedTime);
		System.err.println(rows);
	}

	@Test
	public void updateNonDefault() {

		Integer uid=1;
		Integer rows=	mapper.updateNonDefault(uid);
		System.err.println(rows);
	}

	@Test
	public void findByAid() {

		Integer aid=14;
		Address ad=	mapper.findByAid(aid);
		System.err.println(ad);
	}

	@Test
	public void deleteByAid() {
		try {
			Integer aid=1;
			Integer rows=mapper.deleteByAid(aid);
			System.err.println(rows);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	@Test
	public void findLastModified() {
		try {
			Integer uid=1;
			Address ad=mapper.findLastModified(uid);
			System.err.println(ad);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
