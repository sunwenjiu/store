package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Hero;
import util.DBUtils;

public class HeroDAO {
	
	public List<Hero> findbyPage(int pageStart,int pageSize){
		Connection conn=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		List<Hero> heros= new ArrayList<Hero>();
		try {
			conn=DBUtils.getConn();
			String sql ="select * from hero limit ?,?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, pageStart);
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			while(rs.next()) {
				
				 int id=rs.getInt(1);
				 String name=rs.getString(2);
				 String  nickname=rs.getString(3);
				 String   sex=rs.getString(4);
				 String   language=rs.getString(5);
				 String   camp=rs.getString(6);
				 String   type=rs.getString(7);
				 heros.add(new Hero(id, name, nickname, sex, language, camp, type));
				 
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
			
			
		}
		
		
		
		
		return heros;
		
	}
	
	public Integer count(){
		Connection conn=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		Integer count=0;
		
		try {
			conn=DBUtils.getConn();
			String sql ="select count(*) from hero ";
			ps=conn.prepareStatement(sql);
			
			rs=ps.executeQuery();
			if (rs.next()) {
				count=rs.getInt(1);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
			
			
		}
		
		
		
		
		return count;
		
	}

	public void update(Integer id, String name, String nickname, String sex, String camp) {
		
		Connection conn=null;
		PreparedStatement ps =null;
	
		try {
			conn=DBUtils.getConn();
			String sql ="update hero set name=?,nickname=?,sex=?,camp=? where id=? ";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, nickname);
			ps.setString(3, sex);
			ps.setString(4, camp);
			ps.setInt(5, id);
			
			ps.executeUpdate();
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, null);
			
			
		}
		
		
		

		
		
	}

}
