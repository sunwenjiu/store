package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtils;

public class ListUserServlet2 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=utf-8");
	request.setCharacterEncoding("utf-8");
		
		//1从数据库中查询所有用户信息
		String sql ="select * from t_user";
		Connection conn =null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		
		try {
			conn=DBUtils.getConn();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
		/*	while (rs.next()) {
				System.out.println(rs.getInt("id")+","+rs.getString("username")+","+rs.getString("password")+","+rs.getString("email"));
			}*/
			//2.动态生成用户列表
			//获取向response中输出数据的字符流
			
			PrintWriter pw=response.getWriter();
			pw.write("<!DOCTYPE html>" + 
					"<html>" + 
					"<head>" + 
					"<meta charset=\"UTF-8\">" + 
					"<title>Insert title here</title>" + 
					"</head>");
			
			pw.write("<body>\n" + 
					"	<table border=\"1\" width=\"60%\" cellspacing=\"0\" cellpadding=\"0\">");
			
			pw.write("<tr>\n" + 
					"<th>ID</th>\n" + 
					"<th>姓名</th>\n" + 
					"<th>密码</th>\n" + 
					"<th>邮箱</th>\n" + 
					"</tr>");
			
			
			
			while (rs.next()) {
				pw.write("<tr><td>"+rs.getInt("id")+"</td><td>"+rs.getString("username")+"</td><td>"+rs.getString("password")+"</td><td>"+rs.getString("email")+"</td></tr>");
				
			}
			pw.write("</table>\n" + 
					"\n" + 
					"</body>\n" + 
					"</html>");
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
			
		}
		
	
	
		
		
		
	}

}
