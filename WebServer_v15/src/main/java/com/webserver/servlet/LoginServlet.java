package com.webserver.servlet;

import java.io.File;
import java.io.RandomAccessFile;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

public class LoginServlet {

	public void service(HttpRequest request, HttpResponse response) {
		System.out.println("LoginServlet:开始用户登录...");
		/*
		 * 获取用户输入的信息
		 */
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// System.out.println("username:"+username);
		// System.out.println("password:"+password);

		try (RandomAccessFile raf = new RandomAccessFile("user.dat", "r")) {

			boolean check = false;
			for (int i = 0; i < raf.length() / 100; i++) {
				raf.seek(i * 100);
				byte[] data = new byte[32];
				raf.read(data);
				String name = new String(data, "utf-8").trim();
				if (name.equals(username)) {
					raf.read(data);
					String password2 = new String(data, "utf-8").trim();
					if (password2.equals(password)) {
						response.setEntity(new File("webapps/myweb/login_success.html"));
						check = true;
					} 
						break;
				}
			}
			if (!check) {
				response.setEntity(new File("webapps/myweb/login_fail.html"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("LoginServlet:用户登录完毕");
	}

}
