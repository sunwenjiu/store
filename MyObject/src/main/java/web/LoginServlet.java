package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;

/**
 * 用户登录页面
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决乱码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取数据
		String username = request.getParameter("username").trim();
		String password= request.getParameter("password").trim();
		
	//	System.out.println(username+","+password);
		
		
		//对比数据，用户存在，保存cookie ，重定向到首页，
		//不存在就重新登录，绑定数据用户名或密码错误
		UserDAO dao = new UserDAO();
		boolean flag=dao.getUserByUAP(username, password);
		if (flag) {
			//表示用户存在，可以添加cookie,然后重定向到首页
			HttpSession session=request.getSession(true);
			session.setAttribute("username", username);
			
			/*Cookie c= new Cookie("username", username);
			c.setPath(request.getContextPath());
			c.setMaxAge(60*30);//半小时有效
			response.addCookie(c);*/
			
			response.sendRedirect("index");
			
		}else {
			//表是账户或密码错误，转发查询登录，并提升错误信息
			//绑定数据
			request.setAttribute("msg", "用户名或密码错误");
			request.setAttribute("username", username);
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
				

		
	}

}
