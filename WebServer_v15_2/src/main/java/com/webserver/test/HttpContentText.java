package com.webserver.test;

public class HttpContentText {
	public static void main(String[] args) throws Exception {
		/**
		 * 测试HttpContext
		 * 利用类加载执行HttpContext中的静态代码块
		 */
		
		String className="com.webserver.http.HttpContext";
		Class.forName(className);
	}

}
