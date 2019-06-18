package demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Scanner;

import mvc.RequestMapping;

public class Test2 {

	public static void main(String[] args) throws ClassNotFoundException {
		//通过scanner接受
		//2在控制台输出该类对应的所有方法
		System.out.println("请输入包名");
		Scanner scan= new Scanner(System.in);
		String pack=scan.nextLine();
		System.out.println("类名输入");
		String cla=scan.nextLine();
		
		
		Class cz=Class.forName(pack+"."+cla);
		
		Method[] me= cz.getDeclaredMethods();
		for (Method m : me) {
			System.out.println(m);
			//获取该方法所有的注解
		Annotation[] ans= m.getAnnotations();
		for (Annotation an : ans) {
			System.out.println("注解是:"+an);
			//如果当前注解是RequestMapping类型
			if (an instanceof RequestMapping) {
				//将an强转为RequestMapping类型
				RequestMapping rm=(RequestMapping) an;
				//调用value 方法,获取注解的值
				System.out.println(rm.value());
			}
			
		}
		
		
		
		
		}
		
	}

}
