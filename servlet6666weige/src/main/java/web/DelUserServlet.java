package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

public class DelUserServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决乱吗
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取请求参数
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		//参数的类型转换
		
		//执行删除操作
		UserDAO dao =new UserDAO();
		boolean flag=dao.delUser(id);
		if (flag) {
			response.sendRedirect("listUser");
		}else {
			response.getWriter().write("删除失败");
		}
		
	}

	
	
}
