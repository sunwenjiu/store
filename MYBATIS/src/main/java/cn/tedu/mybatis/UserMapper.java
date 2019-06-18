package cn.tedu.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;



public interface UserMapper {
	
	//插入数据
	Integer insert(User user);
	
	//查询所有
	List<User> findAll();
	
	//根据用户名查询用户数据
	User findByUsername(String username);
	
	//将所有的用户的is_delete设置为0或1
	//set 
	Integer updateIsdelete(Integer isDelete);
	
	//修改用户密码
	//update xx set password=? where id=?
	Integer updatePassword(@Param("id")Integer id,@Param("password") String password);
	
	//统计数据的数量
	Integer countById();
	
	//批量删除多条
	// DELETE FROM t_user WHERE id IN(3,5,7)
	//
	Integer deleteByIds(Integer[] ids);

	List<User> select(
		@Param("where") String where,
		@Param("orderBy") String orderBy,
		@Param("limit") String limit);
	
	
	List<UserVO> findAll2();
	
}
