package com.webserver.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

import javax.imageio.stream.FileImageInputStream;

import com.webserver.http.HttpContext;
import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;
import com.webserver.servlet.LoginServlet;
import com.webserver.servlet.RegServlet;
import com.webserver.servlet.ShowAllUserServlet;
/**
 * 用户处理客户端请求并予以响应的处理类
 * 
 * @author soft01
 *
 */

public class ClientHandler implements Runnable {
	private Socket socket;

	public ClientHandler(Socket socket) {
		super();
		this.socket = socket;
	}

	public void run() {
		try {
			/*
			 * 处理客户端请求分为三部
			 * 1:解析请求
			 * 2:处理请求
			 * 3:发送响应
			 */
			//1.1解析请求
			HttpRequest request = new HttpRequest(socket);
			//1.2创建响应对象
			HttpResponse response =new HttpResponse(socket);
			
			//2
			//2.1获取请求的抽象路径
			String path = request.getRequestURI();
			//是否为请求一个业务
			//根据URL查找类名
			String className =HttpContext.getServletClass(path);
			
			/**
			 * 如果用户请求的URL path能用找到对应的Servlet类
			 * 则利用反射执行这个Servlet
			 * 相反如果没有对应的Servlet类,则查找磁盘url对应的磁盘文件资源作为响应结果
			 */
			if (className!=null) {
				//利用反射执行
				//1动态加载类
				Class cls=Class.forName(className);
				System.out.println("cls:"+cls);
				//2动态创建对象
				Object obj =cls.newInstance();
				System.out.println("obj:"+obj);
				//3动态查找service方法
				Method method =cls.getDeclaredMethod("service", HttpRequest.class,HttpResponse.class);
				
				System.out.println("method:"+method);
				//4利用反射执行方法
				method.invoke(obj, request,response);
				
				
			}			else {
			
			//2.2去webapps目录下找到对应资源
			File file=new File("webapps"+path);
			//2.3判断该资源是否真实存在
			if (file.exists()) {
				System.out.println("资源已找到!");
				/*
				 * 发送一个标准的HTTP响应给客户端
				 */
				//将要响应给客户端的资源设置到响应对象中
				response.setEntity(file);
		/*		//响应该内容给客户端
				response.flush();
			*/
				
				
				
			}else {
				System.out.println("资源未找到!");
				//设置状态代码为404
				response.setStatusCode(404);
			
				
				//响应404页面
				response.setEntity(new File("webapps/root/404.html"));
				
			
			
			}
			
			}
			//3响应客户端
			response.flush();
			
		}catch(EmptyRequestException e) {
			System.out.println("空请求...忽略:kon");
			
		}		catch (Exception e) {
			e.printStackTrace();
		}finally {
			//最后要与客户端断开链接
			try {
				socket.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}

	}
	


}
