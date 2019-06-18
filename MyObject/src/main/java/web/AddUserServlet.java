package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.User;

/**
 * 注册用户
 */
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决乱码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		//获取数据
	String  username=	request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		String tel = request.getParameter("tel").trim();
		
		//System.out.println(username+",密码："+password+",tel:"+tel);
		
		//判断有没有该用户
		UserDAO dao = new UserDAO();
		User hasUsername=dao.getUserByUsername(username);
		if (hasUsername!=null) {
			//用户存在
			//添加失败了重新去注册
			//绑定信息
			request.setAttribute("msg", "用户名重复");
			request.setAttribute("username", username);
			request.setAttribute("tel", tel);
			//获取转发器和转发
			request.getRequestDispatcher("reg.jsp").forward(request, response);
			
			
		}else if (username!=null && password!=null && tel!=null) {
			//将数据写入数据库
			boolean falg= dao.addUser(username, password, tel);
			
			
			//判断是否成功，失败了转发继续登录，成功就重定向到首页保存Cookie 用户名和ID
			if(falg) {
				//添加成功了
				HttpSession session = request.getSession(true);
				
				session.setAttribute("username", username);
				
				/*//cookie处理
				Cookie c=new Cookie("username", username);
				c.setPath(request.getContextPath());
				c.setMaxAge(60*30);//半小时有效
				response.addCookie(c);
				*/
				//重定向到首页
				response.sendRedirect("index");
			}else {
				
				request.setAttribute("msg", "添加失败");
				request.setAttribute("username", username);
				request.setAttribute("tel", tel);
				//获取转发器和转发
				request.getRequestDispatcher("reg.jsp").forward(request, response);
				
			}
		}else {
			response.sendRedirect("reg.jsp");
		}
		
		
		
		
		
	}

}
