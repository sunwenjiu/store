package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.ChecksEntity;

import util.DBUtils;

/**
 * 处理检查表的DAO
 * 
 * @author Administrator
 *
 */
public class ChecksDAO {
	/**
	 * 用于检查首页的分页查询，只返回ID和name
	 * 测试成功
	 * @param page 起始条
	 * @param pageTwo 每页条
	 * @return
	 */
	
	public List<ChecksEntity> getChecks(int page,int pageTwo){
		List<ChecksEntity> list = new  ArrayList<ChecksEntity>();
		String sql ="select id,name from checks limit ?,?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs= null;
		
		try {
			conn=DBUtils.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, page);
			ps.setInt(2, pageTwo);
			rs=ps.executeQuery();
			while (rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				ChecksEntity che=new ChecksEntity(id, name);
				list.add(che);
				
				
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
	 * 通过ID获取检查的数据，返回检查对象
	 * 测试成功
	 * @param idd
	 * @return
	 */

	public ChecksEntity getChecksById(int idd) {
		ChecksEntity che=null;
		String sql="select * from checks where id=?";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBUtils.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, idd);
			
			rs=ps.executeQuery();
			while (rs.next()) {
				int	id=rs.getInt("id"); 
				  String name=rs.getString("name") ;
				  String unsuitable=rs.getString("unsuitable");
				 che= new ChecksEntity(id, name, unsuitable);
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
			
		}
		
		
		
		return che;
	}

	
	/**
	 * 返回医药的最大条数，用于提供给翻页判断是否还有下一页
	 * 测试成功
	 * @return 主键最大值
	 */
	public int getMaxNo() {
		String sql="select max(id) from checks ";
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		try {
			conn=DBUtils.getConn();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		
		return -1;
	}
	
	

}
