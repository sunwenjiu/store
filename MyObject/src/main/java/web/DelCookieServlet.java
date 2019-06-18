package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DelCookieServlet
 */
public class DelCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession(false);
		if (session!=null) {
			session.invalidate();
		}
		
		
		/*Cookie c = new Cookie("username", "");
		c.setPath(request.getContextPath());
		
		c.setMaxAge(0);
		response.addCookie(c);*/
		response.sendRedirect("index");
		
		
		
	}

}
