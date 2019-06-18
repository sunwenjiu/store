package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

public class UpUserPassword extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8");
		
//获取
String password=request.getParameter("password");
int id=Integer.parseInt(request.getParameter("id"));

UserDAO dao = new UserDAO();
boolean flag=dao.upUserPassword(id, password);
if (flag) {
	response.sendRedirect("listUser2.jsp");
}else {
	response.getWriter().write("修改失败");
}


	}

}
