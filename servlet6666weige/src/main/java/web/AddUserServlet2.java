package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtils;

public class AddUserServlet2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决乱码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");


		//1.h获取用户的表单数据
		String username= request.getParameter("username");
		String password =request.getParameter("password");
		String email = request.getParameter("email");

		//测试将数据输出到控制台
	//	System.out.println("username="+username+",password="+password+",email="+email);

		//2.将数据存入数据库
		String sql ="insert into t_user values(null,?,?,?)";
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtils.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, email);
			
			int i=ps.executeUpdate();
			if (i>0) {
				response.getWriter().write("注册成功");

			}else {
				response.getWriter().write("注册失败");

			}
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("注册失败");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		DBUtils.close(conn, ps, null);
		}


		//3.返回响应信息
	


	}

}
