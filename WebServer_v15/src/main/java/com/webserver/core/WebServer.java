package com.webserver.core;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 	WebServer主类
 * 
 * @author soft01
 *
 */

public class WebServer {
	private ServerSocket server;
	private ExecutorService pool;

	public WebServer() {
		try {
			pool=Executors.newFixedThreadPool(100);
			server = new ServerSocket(8088);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void start() {
		try {
			/*
			 * 暂时不开启接收多次客户端链接 
			 */
		while(true) {

				Socket socket=		server.accept();
				//启动一个线程处理该客户端的交互
				ClientHandler handler = new ClientHandler(socket);
				//Thread t = new Thread(handler);
				pool.execute(handler);
			//	t.start();
	}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void main(String[] args) {
		WebServer server = new WebServer();
		server.start();
	}

}
