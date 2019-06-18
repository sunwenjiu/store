package com.webserver.servlet;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Arrays;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

/**
 * 用于处理用户注册业务
 * @author soft01
 *
 */

public class RegServlet {
	
	public void service( HttpRequest request,HttpResponse response) {
		System.out.println("RegServlet:开始用户注册...");
		/*
		 * 1:获取用户在页面上输入的注册信息
		 * 2:将用户注册信息写入到文件user.dat
		 * 3:设置response响应注册成功页面
		 * 
		 */
		//1 
		String username=request.getParameter("username");
		String password =request.getParameter("password");
		String nickname =request.getParameter("nickname");
		int age = Integer.parseInt(request.getParameter("age"));
		
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		System.out.println("nickname:"+nickname);
		System.out.println("age:"+age);
		
		//2
		try(
				RandomAccessFile  raf= new RandomAccessFile("user.dat", "rw");
				){
			/*
			 * 首先判断该用户名是否已经存在
			 * 这里循环读取每条记录的用户名,若用户名已经存在,
			 * 则直接跳转用户名已经存在的页面,
			 * 若文件中没有该用户,再执行注册操作
			 * 1:循环读取user.dat文件每条记录
			 * 2:首先将指针移动到每条记录开始位置(用户名位置)
			 * 3:连续读取32字节,并转换为字符串,读取用户名
			 * 	然后根用户输入本次注册消息的用户名对比,若不一致则执行下次循环,
			 * 	若一致说明找到该用户,那么设置response响应
			 * 	页面为reg_fail.html,并使方法返回,不再执行后续操作,
			 * 4:若循环正常结束,说明该用户名不操作,那么则执行后续的注册操作;
			 * 
			 */
			
			
			for (int i = 0; i < raf.length()/100; i++) {
				raf.seek(i*100);
				byte[] data= new byte[32];
				raf.read(data);
				String name =new String(data, "utf-8").trim();
				if (username.equals(name)) {
					response.setEntity(new File("webapps/myweb/reg_fail.html"));
					return;
				}
			}
			
			
			
			
			
			
			
			
			
			
			//将指针移动到文件末尾
			raf.seek(raf.length());
			//写用户名
			byte[] data = username.getBytes("utf-8");
			data=Arrays.copyOf(data, 32);
			raf.write(data);
			
			//写密码
			data =password.getBytes("utf-8");
			data=Arrays.copyOf(data, 32);
			raf.write(data);
			
			//写昵称
			data =nickname.getBytes("utf-8");
			data=Arrays.copyOf(data, 32);
			raf.write(data);
			
			//写年龄
			raf.writeInt(age);
			
			
			//3响应客户端注册成功
			
			response.setEntity(new File("webapps/myweb/reg_success.html"));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println("RegServlet:用户注册完毕");
	}

}
