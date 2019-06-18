package cn.tedu.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {
	
	// converter
	// String > StringHttpMessageConverter
	// ??? > Jackson

	// user/login.do
	@RequestMapping("login.do")
	@ResponseBody
	public ResponseResult handleLogin(
		String username, String password) {
		// 输出客户端提交的参数，仅用于调试代码
		System.out.println("username=" + username);
		System.out.println("password=" + password);
		
		// 验证登录，假设root/1234是正确的用户名/密码
		if ("root".equals(username)) {
			// 用户名正确，则继续判断密码
			if ("1234".equals(password)) {
				// 密码也正确，则允许登录
				return new ResponseResult(1, "登录成功！");
			} else {
				// 密码错误
				return new ResponseResult(3, "密码错误");
			}
		} else {
			// 用户名错误
			return new ResponseResult(2, "用户名错误");
		}
	}
	
}





