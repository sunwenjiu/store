package demo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test1 {

	public static void main(String[] args) {
			List<String> list = new ArrayList<String>();
			Iterator<String> it =list.iterator();
			
			//test(it);
			test("abc");

	}
	
	public static void test(Object obj) {
		
		Class cz=obj.getClass();
		System.out.println(cz);
		
		//获取该类声明的所有属性
	Field[] fs=	cz.getDeclaredFields();
	for (Field field : fs) {
	//	System.out.println(field);
	}
	
	//获取该类声明的所有方法
	Method[] ms= cz.getDeclaredMethods();
	
	for (Method method : ms) {
		System.out.println(method);
	}
	
	
	}
	
	

}
