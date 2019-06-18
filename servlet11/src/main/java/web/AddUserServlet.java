package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;
import util.DBUtils;

public class AddUserServlet extends HttpServlet {

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
		
		UserDAO dao=new UserDAO();
		boolean hasUsername=dao.getUserByUsername(username);
		if (hasUsername ) {
			//用户存在
			//绑定参数
			request.setAttribute("msg", "用户名重复,请重新输入");
			
			//获取一个转发器
			RequestDispatcher rd= request.getRequestDispatcher("/user/addUser.jsp");
			//转发请求
			rd.forward(request, response);
		}else if(username!=null && password!=null &&email!=null){
			

			//不存在就添加
			
			User user = new User(-1,username,password,email);
			boolean		flag=dao.addUser(user);
			if(flag) {
				//sad szadsad 
				response.sendRedirect(request.getContextPath()+"/user/listUser");//重定向
				
					}else {
				//添加错误提示信息然后并转发addUser.jsp
request.setAttribute("msg", "添加失败");
						request.getRequestDispatcher("/user/addUser.jsp").forward(request, response);
			}
			
		
		}else{
			response.sendRedirect(request.getContextPath()+"/user/addUser.jsp");
			
		}
		
		
		//String result=flag?"添加成功":"添加失败";
		
		
		//	response.getWriter().write(result);
		
			
		


		
		
			
			
			
			
		

		//3.返回响应信息
	


	}

}
