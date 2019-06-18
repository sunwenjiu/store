package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;
import util.DBUtils;

public class AddUserServlet3 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决乱码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");


		//1.h获取用户的表单数据
		String username= request.getParameter("username");
		String password =request.getParameter("password");
		String email = request.getParameter("email");
		
		User user = new User(-1,username,password,email);
		UserDAO dao=new UserDAO();
		boolean flag=dao.addUser(user);
		if(flag) {
			//sad szadsad 
			response.sendRedirect("listUser2.jsp");//重定向
			
		}else {
			response.getWriter().write("添加失败");
		}
		
		//String result=flag?"添加成功":"添加失败";
		
		
		//	response.getWriter().write(result);
		
			
		


		
		
			
			
			
			
		

		//3.返回响应信息
	


	}

}
