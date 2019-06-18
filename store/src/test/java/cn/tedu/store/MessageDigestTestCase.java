package cn.tedu.store;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageDigestTestCase {

	@Test
	public void md5() {
		String password="1";
	String md5password=	 DigestUtils.md5DigestAsHex(password.getBytes());
	System.err.println(md5password);
	
	}
	
	@Test
	public void uuid() {
		for (int i = 0; i < 10; i++) {
			
			String uuid=UUID.randomUUID().toString();
			System.err.println(uuid);
		}
		
	}
	
	@Test
	public void testUuidMd5password() {
	String str=	getMd5password("123456", "CD533D57-4357-4D3D-8861-213DD10C575D");
		System.out.println(str);
		//E610C14DA7AD92B4F9BC0F673DCCA4AC
	}
	
	/**
	 * 拼接盐和密码
	 * @param password
	 * @param salt 盐
	 * @return
	 */
	private String getMd5password(String password,String salt) {
		//拼接
		String str=salt+ password+salt;
		//循环加密5次
		for (int i = 0; i < 5; i++) {
			str=DigestUtils.md5DigestAsHex(str.getBytes()).toUpperCase();
		}
		//返回结果
		
		return str;
		
	}
	
	
}
