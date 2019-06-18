package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.DrugsEntity;
import util.DBUtils;

public class DrugsDAO {
	/**
	 * 用于在医药百科展示，只返回name 和id ,通过翻页查询；
	 * @param page   从第几条开始
	 * @param pageTwo 查询几条
	 * @return
	 */
	
	public List<DrugsEntity> getDrugs(int page,int pageTwo){
		List<DrugsEntity> list = new  ArrayList<DrugsEntity>();
		String sql ="select id,name from drugs limit ?,?";
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
				DrugsEntity dru=new DrugsEntity(id, name);
				list.add(dru);
				
				
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
	 * 返回医药的最大条数，用于提供给翻页判断是否还有下一页
	 * @return
	 */
	public int getMaxNo() {
		String sql="select max(id) from drugs ";
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
	
	
	public DrugsEntity getDrugsById(int idd) {
		DrugsEntity dru=null;
		String sql="select * from drugs where id=?";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBUtils.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, idd);
			
			rs=ps.executeQuery();
			while (rs.next()) {
				int	id=rs.getInt("id"); // comment '主键约束',
				  String name=rs.getString("name") ;// comment '药名',
				  String basis=rs.getString("basis");// text comment '主要成分',
				  String indication=rs.getString("indication") ;//text comment '适应症',
				  String dosage=rs.getString("dosage");// text comment '用法用量',
				  String reaction=rs.getString("reaction");// text comment '不良反应', 
				  String attentions=rs.getString("attentions") ;//text comment '注意事项',
				  String taboo=rs.getString("taboo");// text comment '禁忌',
				  String dosage_forms=rs.getString("dosage_forms") ;//text comment '剂型',
				  String yao_character=rs.getString("yao_character") ;//text comment '性状',
				  String store=rs.getString("store");// text comment '贮藏',
				  String effective=rs.getString("effective");
				  dru=new DrugsEntity(id, name, basis, indication, dosage, reaction, attentions, taboo, dosage_forms, yao_character, store, effective);
						  
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
			
		}
		
		
		
		return dru;
	}

}
