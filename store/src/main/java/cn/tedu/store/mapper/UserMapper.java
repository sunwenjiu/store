package cn.tedu.store.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.User;

/**
 * 处理用户数据的持久层接口
 * @author soft01
 *
 */
public interface UserMapper {
	
	/**
	 * 插入数据
	 * @param user
	 * @return 收影响的行数
	 */
	Integer insert(User user);
	
	/**
	 * 通过uid找到用户
	 * @param uid
	 * @return
	 */
	User findByUid(Integer uid);
	
	/**
	 * 根据用户名查询用户数据
	 * @param username
	 * @return
	 */
	User findByUsername(String username);
	
	/**
	 * 修改用户数据
	 * @param user
	 * @return
	 */
	Integer updateInfo(User user);
	
	/**
	 * 修改密码
	 * @param uid 用户的id
	 * @param password
	 * @param modifiedUser zuih最后修改执行人
	 * @param modifiedTime 最后修改时间
	 * @return 返回函数
	 */
	Integer updatePassword(
			@Param("uid") Integer uid,
			@Param("password") String password,
			@Param("modifiedUser") String modifiedUser,
			@Param("modifiedTime") Date modifiedTime);
	

	/**
	 * 更新头像
	 * @param uid
	 * @param avatar
	 * @param modifiedUser
	 * @param modifiedTime
	 * @return
	 */
	Integer updateAvatar(
			@Param("uid")	Integer uid,
			@Param("avatar")String avatar,
			@Param("modifiedUser")	String modifiedUser,
			@Param("modifiedTime")	Date modifiedTime);
	

}
