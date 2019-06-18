package cn.tedu.spring;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	public UserController() {
		super();
		System.out.println("UserController构造");
	}

	
	
	
	@RequestMapping("login.do")
	public String showLogin() {
		System.out.println("UserController.login()");
		return "login";
	}


	@RequestMapping("reg.do")
	public String showReg() {

		System.out.println("UserController.reg()");
		return "reg";
	}

	@RequestMapping("info.do")
	public String showInfo() {
		System.out.println("UserController.showInfo()");
		return "info";
	}
	
	@RequestMapping("password.do")
	public String showPassword() {
		System.out.println("UserController.showPassword()");

		return "password";
	}
	

	
	
	@RequestMapping("handle_reg.do")
	public String handleRegister(User user) {
		System.out.println("UserController.handleRegister()");
		//	System.out.println(username+","+password+","+age+","+phone+","+email);
		System.out.println(user);
		return "redirect:login.do";
	}

	/*@RequestMapping("handle_reg.do")
	public String handleRegister(String username,String password,Integer age,String phone,String email) {
		System.out.println("UserController.handleRegister()");
		System.out.println(username+","+password+","+age+","+phone+","+email);
		return null;
		}*/

	/*	@RequestMapping("handle_reg.do")
	public String handleRegister(HttpServletRequest request) {
		System.out.println("UserController.handleRegister()");
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		String age= request.getParameter("age");
		String phone= request.getParameter("phone");
		String email= request.getParameter("email");
		return null;
	}*/

	@RequestMapping("handle_login.do")
	public String handleLogin(String username,String password,ModelMap modelMap,HttpSession session) {
		System.out.println("UserController.handleLogin()");
		System.out.println("username:"+username+",password:"+password);
		String message;
		if ("root".equals(username)) {
		
			//用户名正确
			if ("1234".equals(password)) {
				//允许登录
				session.setAttribute("id", 9527);
				
				return "redirect:info.do";
			}else {
				//密码错误
				message="登录失败,密码错误!";
				modelMap.addAttribute("msg", message);


				return "error";
			}

		}else {
			//用户名错误
			message="登录失败用户名错误";
			modelMap.addAttribute("msg", message);
			return "error";
		}

	//	return null;
	}

}
