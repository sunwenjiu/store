package test;

import java.sql.Connection;

import util.DBUtils;

public class test {

	public static void main(String[] args) throws Exception {

	
		Connection conn =DBUtils.getConn();
		System.out.println(conn);
		
		
		
	}

}
