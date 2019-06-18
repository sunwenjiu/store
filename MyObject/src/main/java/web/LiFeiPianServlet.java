package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DrugsDAO;
import entity.DrugsEntity;


public class LiFeiPianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
	
		//huo获取数据
		int id = Integer.parseInt(request.getParameter("id"));
		
		DrugsDAO dao = new DrugsDAO();
		DrugsEntity dru=dao.getDrugsById(id);
		
		request.setAttribute("dru", dru);
		
		request.getRequestDispatcher("liFeiPian.jsp").forward(request, response);
	}

}
