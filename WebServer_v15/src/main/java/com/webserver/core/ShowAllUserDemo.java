package com.webserver.core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 显示所有用户消息
 * @author soft01
 *
 */
public class ShowAllUserDemo {

	public static void main(String[] args) throws IOException {
		RandomAccessFile raf =new RandomAccessFile("user.dat", "r");
		for (int i = 0; i < raf.length()/100; i++) {
			
			//读取用户名
			byte[] data = new byte[32];
			raf.read(data);
			String username =new String(data,"utf-8").trim();
			//读取密码
			raf.read(data);
			String password=new String(data,"utf-8").trim();
			
			//读取昵称
			raf.read(data);
			String nikename =new String(data,"utf-8").trim();
			
			//年龄
			int age = raf.readInt();
		
		
		System.out.println(username+","+password+","+nikename+","+age);
		}
		
		
		
		raf.close();

	}

}
