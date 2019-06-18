package cn.tedu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.mapper.UserMapper;
import cn.tedu.pojo.User;

@Service
public class UserService {
	@Autowired
	private UserMapper mapper;
	public User checkName(String id) {
		User user=mapper.findUserById(id);
		return user;	
	}
}
