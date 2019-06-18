package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.DiseaseEntity;
import util.DBUtils;

public class DisDAO {
	/**
	 * 获取疾病百科最大的NO
	 * @return
	 */
	public int getMaxNo() {
		String sql="select max(no) from 疾病百科 ";
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
	
	/**
	 * 返回疾病百科的各类病的集合（还没有做翻页）只有名字和no ,用于在疾病百科展示
	 * 没有全部查询，
	 * @return 
	 */
	public List<DiseaseEntity> getDisease(int page ,int pagTwo){
		List<DiseaseEntity> list = new ArrayList<DiseaseEntity>();
		String sql ="select no,name from 疾病百科 limit ?,?";
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		try {
			conn=DBUtils.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, page);
			ps.setInt(2, pagTwo);
			rs=ps.executeQuery();
			while (rs.next()) {
				
			
				int no =rs.getInt("no");
				String name =rs.getString("name");
				
					DiseaseEntity dis=new DiseaseEntity(no, name);
				list.add(dis);	
				
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
	 * 通过NO来查询该病全部信息
	 * @param no 输入NO查看该病全部信息
	 * @return DiseaseEntity对象
	 */
	public DiseaseEntity getDiseaseById(int noo) {
		DiseaseEntity dis=null;
		String sql="select * from 疾病百科 where no=?";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBUtils.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, noo);
			
			rs=ps.executeQuery();
			while (rs.next()) {
				int no =rs.getInt("no");
				String name =rs.getString("name");
				 String buwei =rs.getString("buwei");
				 String percent =rs.getString("percent");
				 String seson =rs.getString("seson");
				 String people =rs.getString("people");
				 String acctive =rs.getString("acctive");
				 String way =rs.getString("way");
				 String keshi =rs.getString("keshi");
				 String yibao =rs.getString("yibao");
				 String time =rs.getString("time");
				 String money =rs.getString("money");
				 String zhiyu =rs.getString("zhiyu");
				 String care =rs.getString("care");
				 String diet =rs.getString("diet");
				 String ban =rs.getString("ban");
				dis= new DiseaseEntity(no, name, buwei, percent, seson, people, acctive, way, keshi, yibao, time, money, zhiyu, care, diet, ban);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
			
		}
		
				
		
		
		
		return dis;
	}
	
	
	
}
