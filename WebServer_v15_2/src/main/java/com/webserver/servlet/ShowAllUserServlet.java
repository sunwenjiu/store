package com.webserver.servlet;

import java.io.RandomAccessFile;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

/**
 * 显示所有用户信息
 * @author soft01
 *
 */
public class ShowAllUserServlet {
	public void service(HttpRequest request,HttpResponse response) {
		System.out.println("ShowAllUserServlet:开始执行");
		try(
				RandomAccessFile raf = new RandomAccessFile("user.dat", "r");
				) {
			StringBuilder builder = new StringBuilder();
			builder.append("<html>");
			builder.append("<head>");
			builder.append("<meta charset='UTF-8'>");
			builder.append("<title>用户列表</title>");
			builder.append("</head>");
			builder.append("<body>");
			builder.append("<center>");
			builder.append("<h1>用户列表</h1>");
			builder.append("<table border='1'>");
			builder.append("<tr><td>用户名</td><td>密码</td><td>昵称</td><td>年龄</td></tr>");
			for (int i = 0; i <raf.length()/100; i++) {
				byte[] data = new byte[32];
				raf.read(data);
				String username=new String(data,"utf-8").trim();
				raf.read(data);
				String password=new String(data,"utf-8").trim();
				raf.read(data);
				String nikename=new String(data,"utf-8").trim();
				int age =raf.readInt();
				
			builder.append("<tr>");
			builder.append("<tr><td>"+username+"</td><td>"+password+"</td><td>"+nikename+"</td><td>"+age+"</td></tr>");
			
			builder.append("</tr>");
			}
			builder.append("</table>");
			builder.append("</center>");
			builder.append("</body>");
			builder.append("</html>");
			
			byte[] data =builder.toString().getBytes("UTF-8");
			response.putHeader("Content-Length", data.length+"");
			response.putHeader("Content-Type", "text/html");
			response.setContentData(data);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

		
		System.out.println("ShowAllUserServlet:执行完毕");
	}


}
