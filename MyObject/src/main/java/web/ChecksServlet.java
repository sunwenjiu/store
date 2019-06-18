package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ChecksDAO;
import entity.ChecksEntity;
import entity.DrugsEntity;

/**
 * Servlet implementation class ChecksServlet
 */
public class ChecksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
	
		int page=0;
		int pageTwo=18;
		//获取第几页
		if(request.getParameter("page")!=null) {
			
			page=Integer.parseInt(request.getParameter("page"));
		}
		request.setAttribute("page", page);
		page=page*pageTwo;
		
		ChecksDAO dao = new ChecksDAO();
		List<ChecksEntity> list = dao.getChecks(page, pageTwo);
		int maxNo=dao.getMaxNo();
		boolean pageok=true;
		for (ChecksEntity che: list) {
			if (che.getId()==maxNo) {
				pageok=false;
			}
			
		}

		//绑定参数
				request.setAttribute("list", list);
				request.setAttribute("maxNo", maxNo);
				request.setAttribute("pageok", pageok);
				//转发请求
				request.getRequestDispatcher("checks.jsp").forward(request, response);
				
		
		
		
		
	}

}
