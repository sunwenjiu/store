package cn.tedu.store.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 获取session对象
		HttpSession session = request.getSession();
		Object uid=session.getAttribute("uid");
		//判断是否正确获取到了uid
		if (uid==null) {
			//尝试回去UId失败,意味着没有登录或超时
			response.sendRedirect("/web/login.html");
			return false;
		}
		
		return true;
		//return  HandlerInterceptor.super.preHandle(request, response, handler)
	}

	
}
