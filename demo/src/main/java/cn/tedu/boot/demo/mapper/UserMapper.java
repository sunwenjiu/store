package cn.tedu.boot.demo.mapper;

import cn.tedu.boot.demo.entity.User;

public interface UserMapper {
	
	Integer insert(User user);
	
	//select id from t_user where username=?
	User findByUsername(String username);
	
}
