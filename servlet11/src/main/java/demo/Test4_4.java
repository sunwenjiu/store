package demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Scanner;

import mvc.RequestMapping;

public class Test4_4 {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("输入包名:mvc.Demo");
		String className= scan.nextLine();
		System.out.println("输入url:如/listUser.do");
		String url=scan.nextLine();


		Class cz = Class.forName(className);

		Object obj=cz.newInstance();

		Method[] ms=cz.getDeclaredMethods();

		for (Method m : ms) {
			Annotation[] anns=		m.getAnnotations();
			for (Annotation an : anns) {
				if (an instanceof RequestMapping) {
					String value=	((RequestMapping)an).value();
					if (value.equals(url)) {
						Object result= m.invoke(obj);
						System.out.println(result);
					}

				}

			}		


		}

	}

}
