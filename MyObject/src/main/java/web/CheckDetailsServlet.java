package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ChecksDAO;
import entity.ChecksEntity;

/**
 * Servlet implementation class checkDetails
 */
public class CheckDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
	
		int id = Integer.parseInt(request.getParameter("id"));
		
		ChecksDAO dao = new ChecksDAO();
		ChecksEntity che=dao.getChecksById(id);
		
		request.setAttribute("che", che);
		request.getRequestDispatcher("checkDetails.jsp").forward(request, response);

		
		
		
		
	}

}
