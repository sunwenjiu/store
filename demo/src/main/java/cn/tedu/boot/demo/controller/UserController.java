package cn.tedu.boot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.boot.demo.entity.User;
import cn.tedu.boot.demo.mapper.UserMapper;
import cn.tedu.boot.demo.util.ResponseResult;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private 	UserMapper userMapper;

	@RequestMapping("reg")
	public ResponseResult reg (User user) {
		System.out.println(user);
		
		//根据尝试注册的用户名查询数据
		User result=	userMapper.findByUsername(user.getUsername());
		//判断查询结果是否为null
		if (result==null) {
			//是:每找到数据,允许注册
				userMapper.insert(user);
				System.err.println("注册成功");
				return new ResponseResult(1);
		}else {
			//否:找到了数据,则不允许注册
			System.err.println("用户名已经被占用,不允许注册");
			return  new ResponseResult(2, "用户名已经被占用");
		}
		
		
	}
}
