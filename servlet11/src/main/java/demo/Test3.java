package demo;

import java.lang.reflect.Method;

public class Test3 {

	public static void main(String[] args) throws Exception, NoSuchMethodException, SecurityException {
		
	Class cz=	Class.forName("mvc.Demo");

	Method method=  cz.getDeclaredMethod("listUser");
	//动态创建该类对象
	Object obj=cz.newInstance();
	
	//动态调用该方法
	Object result= method.invoke(obj);
	System.out.println("result="+result);
	
	}

}
