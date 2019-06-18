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

public class ListUserServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//response.setContentType("text/html;charset=utf-8");
	//request.setCharacterEncoding("utf-8");
		
	//1从数据库中回去用户信息
	UserDAO dao =new UserDAO();
	List<User> list =dao.listUser();
	
	
	//2向request中绑定数据
	request.setAttribute("list", list);
	
	//3将请求转发给listUser.jsp
	request.getRequestDispatcher("/WEB-INF/jsp/listUser.jsp").forward(request, response);
	
	
	
	}

}
