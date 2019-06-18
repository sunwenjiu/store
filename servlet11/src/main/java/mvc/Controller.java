package mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.UserDAO;
import entity.User;

/**
 * 子控制器,封装具体的处理逻辑
 * @author soft01
 *
 */


public class Controller {

	@RequestMapping("/listUser.do")
	public String listUser( HttpServletRequest request) {
		UserDAO dao= new UserDAO();
		List<User> list=dao.listUser();

		request.setAttribute("list", list);

		//return "/WEB-INF/jsp/listUser.jsp";
		return "listUser";
	}

	@RequestMapping("/addUser-form.do")
	public String addUserForm(HttpServletRequest request) {
		//addUser是addUser.jsp的名称
		return "addUser";
	}
	@RequestMapping("/addUser.do")
	public String addUser(HttpServletRequest request) {
		//获取请求参数
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");

		UserDAO dao = new UserDAO();

		//判断用户名是否存在
		boolean flag=	dao.getUserByUsername(username);
		if (flag) {
			//用户存在,绑定错误提示信息
			request.setAttribute("msg",	 "用户名已存在");
			
			return "addUser";
			
		}
			//如果不存在再执行添加用户的操作
		User user=new User(-1, username, password, email);	
		
		boolean flag2=dao.addUser(user);
		if (flag2) {
			//重定向到用户列表
			return "redirect:/listUser.do";
		}
		//如果添加失败
		request.setAttribute("msg", "添加失败");

		return "addUser";
	}

	@RequestMapping("/delUser.do")
	public String delUser(HttpServletRequest request) {
		
	int id= Integer.parseInt(	request.getParameter("id"));
	UserDAO dao = new UserDAO();
	boolean flag=	dao.delUser(id);
	
	if (flag) {
		
		return "redirect:/listUser.do";
	}
		
		return "success";//错误提示页面
	}
	
	
}
