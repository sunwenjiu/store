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
 * 首页用户登录状态处理
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//乱码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session= request.getSession(false);
	
		if (session==null || session.getAttribute("username")==null) {

			//没有找到cookie也要转发给首页
			//没有用户信息，首页你就显示让用户登录吧
			User user=null;
			//将用户转发给index.jsp
			
			//绑定数据
			request.setAttribute("user", user);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}else {
			String	username=(String)	session.getAttribute("username");
			
			UserDAO dao= new UserDAO();
			User user= dao.getUserByUsername(username);
			//将用户转发给index.jsp
			String datastr=user.getIndate();
			
			String[] datestr=datastr.split("-");
			datastr=datestr[0]+"年"+datestr[1]+"月"+datestr[2]+"日";
			
			user.setIndate(datastr);
			
			//绑定数据
			request.setAttribute("user", user);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
			
		}
		
		/*
		 之前写的用cookie查看登录状态，现在改用session 
		 //获取cookie查看是否有cookie username 
		//如果cookie 不是null就去遍历查找username
		// 找到了就说明用户登录了（之前设置半小时有效）
		//登录了用
		Cookie findC=null;
		Cookie[] cs=request.getCookies();
		if(cs!=null) {
			for (Cookie c : cs) {
				if (c.getName().equals("username")) {
					//说明有这个cookie
					findC=c;
				}			
			}
			}
		//System.out.println(findC);
		if (findC!=null) {
			//说明保存了用户信息
			//取出用户信息
			String username=findC.getValue();
			//t通过用户名查出用户信息
			UserDAO dao= new UserDAO();
			User user= dao.getUserByUsername(username);
			//将用户转发给index.jsp
			//绑定数据
			request.setAttribute("user", user);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			//没有找到cookie也要转发给首页
			//没有用户信息，首页你就显示让用户登录吧
			User user=null;
			//将用户转发给index.jsp
			//绑定数据
			request.setAttribute("user", user);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}*/
		

	}

}
