package mvc;

import javax.servlet.http.HttpServletRequest;

import dao.UserDAO;

public class LoginController {
	
	@RequestMapping("/login-form.do")
	public String loginForm(HttpServletRequest request) {
		
		
		return "login";
	}
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request) {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		UserDAO dao = new UserDAO();
	boolean flag=	 dao.getUserByUAP(username, password);
		if (flag) {
			//用户存在,登录成功
			return "redirect:/listUser.do";
			
		}
		request.setAttribute("msg", "用户名或密码错误");
		
		return "login";
	}

}
