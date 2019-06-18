package cn.tedu.mapper;

import java.util.List;

import cn.tedu.pojo.User;

public interface UserMapper {
	List<User> findAll();
	User findUserById(String id);
}
