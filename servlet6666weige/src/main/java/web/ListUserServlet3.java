package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;
import util.DBUtils;

public class ListUserServlet3 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=utf-8");
	request.setCharacterEncoding("utf-8");
		
	//1从数据库中回去用户信息
	UserDAO dao =new UserDAO();
	List<User> list =dao.listUser();
	
	
	//2动态生成响应内容
	PrintWriter pw=response.getWriter();
	pw.write("<!DOCTYPE html>" + 
			"<html>" + 
			"<head>" + 
			"<meta charset=\"UTF-8\">" + 
			"<title>Insert title here</title>" + 
			"</head>");
	
	pw.write("<body>\n" + 
			"	<table border=\"1\" width=\"60%\" cellspacing=\"0\" cellpadding=\"0\">");
	
	pw.write("<tr>\n" + 
			"<th>ID</th>\n" + 
			"<th>姓名</th>\n" + 
			"<th>密码</th>\n" + 
			"<th>邮箱</th><th>操作</th></tr>");
	
	//遍历list集合获取用户信息
		for (User user : list) {

		//	pw.write("<tr><td>"+user.getId()+"</td><td>"+user.getUsername()+"</td><td>"+user.getPassword()+"</td><td>"+user.getEmail()+"</td></tr>");
			pw.write("<tr>");
			pw.write("<td>"+user.getId()+"</td>");
			pw.write("<td>"+user.getUsername()+"</td>");
			pw.write("<td>"+user.getPassword()+"</td>");
			pw.write("<td>"+user.getEmail()+"</td>");
			pw.write("<td><a href='delUser?id="+user.getId()+"'>删除</a></td>");
			
			pw.write("</tr>");
			
			
		}
		
		pw.write("</table>");
		pw.write("<br><a href='addUser.html'>添加用户</a> ");
		
		pw.write("</body></html>");
	}

}
