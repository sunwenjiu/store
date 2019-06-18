package com.webserver.http;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * HTTP协议规定的相关内容
 * 
 * 
 * @author soft01
 *
 */

public class HttpContext {
	/**
	 * 状态代码与对应的描述
	 * key:状态代码
	 * value:状态描述
	 */
	private static final Map<Integer,String> STATUS_MAPPING = new HashMap<Integer,String>();
	
	/**
	 * 介质类型映射
	 * key:文件的后缀名
	 * value:Content-Type对应的值
	 */
	
	
	private static final Map<String,String> MIME_TYPE_MAPPING =new HashMap<String,String>();
	/**
	 * URL与Servlet之间的映射
	 * key:URL
	 * value:Servlet的类名
	 * 
	 */
	private static final Map<String,String> URL_MAPPING =new HashMap<String,String>();

	
	static {
		//初始化资源
		initStatusMapping();
		initMimeTypeMapping();
		initUrlMapping();
	}
	/**
	 * 初始化URL与Servlet之间的对应关系
	 */
			
	private static void initUrlMapping() {
		try {
			SAXReader reader = new SAXReader();
		Document doc=	reader.read(new File("conf/web.xml"));
			Element root = doc.getRootElement();
			//解析XML算法
			List<Element>  mappings = root.elements("servlet-mapping");
			List<Element>  servlets= root.elements("servlet");
			
			//System.out.println("mappings:"+mappings);
		//	System.out.println("servlets:"+servlets);
			for (Element mapping : mappings) {
				String url =mapping.elementTextTrim("url-pattern");
				String name =mapping.elementTextTrim("servlet-name");
			//	System.out.println(url+":"+name);
				//根据name找到对应的className
				for (Element servlet : servlets) {
					String name_=servlet.elementTextTrim("servlet-name");
					String className=servlet.elementTextTrim("servlet-class");
					System.out.println(name_+":"+className);
					if (name.equals(name_)) {
					//	System.out.println("找到:"+url+":"+className);
						URL_MAPPING.put(url, className);
					}
					
				}
				
				
			}
			
		//	System.out.println("URL_MAPPING:"+URL_MAPPING);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	
	private static void initMimeTypeMapping() {
		
//		MIME_TYPE_MAPPING.put("html", "text/html");
//		MIME_TYPE_MAPPING.put("css", "text/css");
//		MIME_TYPE_MAPPING.put("png", "image/png");
//		MIME_TYPE_MAPPING.put("gif", "image/gif");
//		MIME_TYPE_MAPPING.put("jpg", "image/jpg");
//		MIME_TYPE_MAPPING.put("js", "application/javascript");
		
		
		try {
			
			
			//第三遍
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File("conf/web.xml"));
			Element  root = doc.getRootElement();
		//	System.out.println(root.getName());
			List<Element>  list = root.elements("mime-mapping");
			for (Element element : list) {
				Element keyElm =element.element("extension");
				String key =keyElm.getTextTrim();
				
				
				String value =element.elementText("mime-type");
				
				MIME_TYPE_MAPPING.put(key, value);
				
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
/**
 * 初始化状态代码与对应描述
 * 
 */
private static void initStatusMapping() {
	/*
													"200"   ; OK
                      | "201"   ; Created
                      | "202"   ; Accepted
                      | "204"   ; No Content
                      | "301"   ; Moved Permanently
                      | "302"   ; Moved Temporarily
                      | "304"   ; Not Modified
                      | "400"   ; Bad Request
                      | "401"   ; Unauthorized
                      | "403"   ; Forbidden
                      | "404"   ; Not Found
                      | "500"   ; Internal Server Error
                      | "501"   ; Not Implemented
                      | "502"   ; Bad Gateway
                      | "503"   ; Service Unavailable
*/
	STATUS_MAPPING.put(200, "OK");
	STATUS_MAPPING.put(201, "Created");
	STATUS_MAPPING.put(202, "Accepted");
	STATUS_MAPPING.put(204, "No Content");
	STATUS_MAPPING.put(301, "Moved Permanently");
	STATUS_MAPPING.put(302, "Moved Temporarily");
	STATUS_MAPPING.put(304, "Not Modified");
	STATUS_MAPPING.put(400, "Bad Request");
	STATUS_MAPPING.put(401, "Unauthorized");
	STATUS_MAPPING.put(403, "Forbidden");
	STATUS_MAPPING.put(404, "Not Found");
	STATUS_MAPPING.put(500, "Internal Server Error");
	STATUS_MAPPING.put(501, "Not Implemented");
	STATUS_MAPPING.put(502, "Bad Gateway");
	STATUS_MAPPING.put(503, "Service Unavailable");

}
/**
 * 根据给定的状态代码获取对应的状态描述
 * 
 */
public static String getStatusReason(int code) {
	return STATUS_MAPPING.get(code);
}
public static String getMimeType(String ext) {
	return MIME_TYPE_MAPPING.get(ext);
}
/**
 * 根据URL 映射到对应的Servlet Class Name
 * 
 * @param url 用户请求的URL
 * @return
 */
public  static String getServletClass(String  url) {
	return  URL_MAPPING.get(url);
}

public static void main(String[] args) {
	String  fileName ="jquery-1.8.3.min.js";
	//方法1
	String[] str =fileName.split("\\.");
	String fileName2 =str[str.length-1];

	//方法2
	//找最后一个点
	int index =fileName.lastIndexOf(".")+1;
	String fileName3 =fileName.substring(index);
	System.out.println(fileName3);
	
	
	String line =getMimeType(fileName3);
	System.out.println(line);
}

}
