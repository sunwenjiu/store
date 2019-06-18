package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import util.DBUtils;

public class UserDAO {
	
	/**
	 * 用于查询所有用户信息的方法
	 * @return 封装了用户信息的集合
	 */
	public List<User> listUser(){
		List<User> list = new ArrayList<User>();
		String sql ="select * from t_user";
		Connection conn= null;
		PreparedStatement ps =null;
		ResultSet rs=null;
		
		try {
			conn=DBUtils.getConn();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				//用于封装本行的User对象
				User user =new User();
				//从rs中获取的数据封装到user对象中
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				//将user对象存如list集合
				list.add(user);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
			
		}
		
		
		
		
		
		return list;
	}
/**
 * 添加用户信息的方法
 * @param user 封装了用户信息的对象
 * @return true代表添加成功,false代表添加失败
 */
	public boolean addUser(User user) {
		//得到的对象 添加到数据库
	
		String sql ="insert into t_user values(null,?,?,?)";
		Connection conn=null;
		PreparedStatement ps=null;
		
		
		try {
			conn=DBUtils.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			int i=ps.executeUpdate();
			if (i>0) {
				return true;

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, null);
		}
		
		
		return false;
	}
	
	/**
	 * 删除指定id用户
	 * @param 用户id
	 * @return 返回true代表删除成功,false删除失败 
	 * 
	 */
	public boolean delUser(int id) {
		String sql="delete from t_user where id=?";
		Connection conn=null;
		PreparedStatement ps=null;
		
		try {
			conn=DBUtils.getConn();
			ps=conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
		int i=	ps.executeUpdate();
		if(i>0) {
			return true;
		}	
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, null);
			
		}
		
		
		
		
		return false;
	}
	
	public boolean upUserPassword(int id ,String password) {
		String sql="update t_user set password=? where id=?";
		Connection conn=null;
		PreparedStatement ps=null;
		
		try {
			conn=DBUtils.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(2, id);
			ps.setString(1, password);
			int i=ps.executeUpdate();
			if (i>0) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}
	
	/**
	 * 根据用户名和密码查询用户的方法
	 * @param username
	 * @param password
	 * @return true 用户存在, false用户不存在
	 */
	
	public boolean getUserByUAP(String username,String password) {
		String sql ="select * from t_user where username=? and password=?";
		Connection conn=null;
		PreparedStatement ps =null;
		ResultSet rs=null;
		
		try {
			conn=DBUtils.getConn();
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			 rs=ps.executeQuery();
			if (rs.next()) {
				return true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
			
		}
		
		
		
		return false;
	}
	/**
	 * 通过用户名查看用户是否存在
	 * @param username
	 * @return true为存在,false不存在
	 */
	public boolean getUserByUsername(String username) {
		String sql="select * from t_user where username=?";
		Connection conn=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		
		try {
			conn=DBUtils.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			
			rs=ps.executeQuery();
			if (rs.next()) {
				return true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
			
			
		}
		
		
		return false;
	}
	
}
