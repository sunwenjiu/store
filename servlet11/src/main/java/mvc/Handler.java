package mvc;
/**
 * 处理者,处理器,建立一个Method和他对应的Controller对象的映射
 * 
 * 提供一个可以动态执行该Method的方法
 * 
 * @author soft01
 *
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

public class Handler {
	Object controller;//子控制器对象
	Method method;//子控制器的一个方法
	public Handler() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Handler(Object controller, Method method) {
		super();
		this.controller = controller;
		this.method = method;
	}
	@Override
	public String toString() {
		return "Handler [controller=" + controller + ", method=" + method + "]";
	}
	
	/**
	 * 测试使用
	 * @throws Exception 
	 	 */
	public Object execute() throws Exception {
		
		
		return method.invoke(controller);
	}
	
	public String execute(HttpServletRequest req) throws Exception {
		
		//反射调用controller中的method方法
		return (String)method.invoke(controller, req);
	}
	
	
	

}
