package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import entity.User;
import util.DBUtils;

public class UserDAO {
	
	
	
	
	
	/**
	 * 通过用户名和密码匹配用户
	 * @param username
	 * @param password
	 * @return true表示用户存在，false表示用户不存在
	 */
	
	public boolean getUserByUAP(String username,String password) {
		String sql ="select * from user where username=? and password=?";
		Connection conn = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn = DBUtils.getConn();
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
	 * 通过用户名查看用户是否存在，
	 * @param username
	 * @return  user==null表示不存在，user!=null表示存在
	 */
	
	public User getUserByUsername(String username) {
		String sql ="select * from user where username=?";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User user=null;
		
		try {
			conn=DBUtils.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				int id=rs.getInt(1);
				String name= rs.getString(2);
				//密码不用
				String tel= rs.getString(4);
				String indate= rs.getString(5);
				user=new User(id, username, null, tel, indate);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		
		
		
		return user;
		
	}
	
	
	/**
	 * 添加用户
	 * @param username 用户名 医保卡号
	 * @param password 密码
	 * @param tel  电话
	 * @return true表示成功， false表示失败
	 */
	
	public boolean addUser(String username,String password,String tel) {
/*		id int primary key auto_increment comment '主键约束', 
 * username varchar(50) comment '用户名',
 * password varchar(50), 
 * tel varchar(50) comment '电话',
 * cardnun varchar(50) comment '医保卡号',
 * indate date comment '入院日期'
*/		String sql ="insert into user values(null,?,?,?,?) ";
		Connection conn=null;
		PreparedStatement ps=null;
		//新进一个日期，作为注册日子
		Date date = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String datastr=sdf.format(date);
		
		
		
		try {
			conn=DBUtils.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, tel);
			ps.setString(4, datastr);
			
			
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
	
	
	/**
	 * 测试数据库连接是否成功,可以删除了，测试成功就用不到了
	 * 
	 * 
	 */
	public void testSQL() {
		String sql="select name from 疾病百科 where no between 3 and 8 ";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBUtils.getConn();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String str1= rs.getString("name");
				/*String str2= rs.getString("time");
				String str3= rs.getString("ban");*/
				//System.out.println("name:"+str1+",time:"+str2+",ban:"+str3);
				System.out.println("name:"+str1);

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		
	}

}
