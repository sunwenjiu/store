package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginFilter implements Filter {

 


	public void destroy() {

	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req=(HttpServletRequest) request;
		//判断用户是否已经登录,Session中是否有登录状态
		HttpSession session = req.getSession(false);
		
		//用户没有session或者有session没有登录状态
		if (session==null || session.getAttribute("user")==null) {
		((	HttpServletResponse)response).sendRedirect(req.getContextPath()+"/login.jsp");
		
		}else {
	
			chain.doFilter(request, response);
		}
		
		//如果登录则放行
		
		//如果没有登录,重定向到登录页面
		
		
	}


	public void init(FilterConfig fConfig) throws ServletException {

	}

}
