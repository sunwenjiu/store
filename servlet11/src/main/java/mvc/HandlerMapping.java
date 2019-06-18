package mvc;
/**
 * 用来管理Map集合的类
 * 1.Map集合管理了url和Handler的映射关系
 * 2.提供对Map进行初始化的方法
 * 
 * 3.提供了使用URL从Map中查询handler的方法
 * 
 * @author soft01
 *
 */

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
	Map<String, Handler> mapping= new HashMap<String, Handler>();
	
	/**
	 * 1. 加载ClassNmae对应的类   ->Controller
	 * 2.遍历该类的所有方法和方法的注解
	 * 3.将注解和方法对应的关系保存到Map中
	 * 
	 * @param className Controller的包名.类名 
	 */
	public void parseController(String className) throws Exception{
		Class cz = Class.forName(className);		
		//反射创建该Controller对象
		Object controller=cz.newInstance();
		
		Method [] methods=cz.getDeclaredMethods();
		for (Method method : methods) {
			
			RequestMapping an= method.getAnnotation(RequestMapping.class);
		
			if (an!=null) {
				//获取注解的值
				String url=an.value();
				//创建Handler对象
				Handler handler=new Handler(controller, method);
	
				//将对应关系保存到集合
				mapping.put(url, handler);
				
			}
			
			
		}
		
	}
	
	/**
	 * 根据url查找对应的Handler方法
	 * 
	 * @param url 用户请求的url
	 * @return 
	 */
public Handler getHandler(String url) {
	
	return mapping.get(url);
}
	
	
	
	@Override
	public String toString() {
		return "HandlerMapping [mapping=" + mapping + "]";
	}
	
	
	public static void main(String[] args) throws Exception {
		//测试HandlerMapping
		HandlerMapping hm= new HandlerMapping();
		
		hm.parseController("mvc.Demo");
		
	//	System.out.println(hm);
		Handler handler= hm.getHandler("/listUser.do");
	//	System.out.println(handler);
		Object result=handler.execute();
	//	System.out.println(result);
		
	}

}
