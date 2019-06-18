package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;

public class loginServlet  extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//乱码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//取
		String username= request.getParameter("username");
		String password=request.getParameter("password");
		
		//调方法
		UserDAO dao = new UserDAO();
		boolean flag=dao.getUserByUAP(username, password);
		if (flag) {
			request.getSession().setAttribute("user", username);
			
			
			response.sendRedirect("user/listUser");
		}else {
		//	response.getWriter().write("登录失败");
			//将请求转发给login.jsp 生成包含错误提示信息的登录页面
			
			//1 向request 绑定参数
			request.setAttribute("msg", "用户名或密码错误");
			//获取一个请求转发器
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			
			//转发一个请求
			rd.forward(request, response);
			
			
		}
		
		
	}
	
	
	
	
}
