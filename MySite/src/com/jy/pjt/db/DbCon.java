package com.jy.pjt.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbCon {
	static int num = 0; // 현재 서버 접속 몇번됬는지 ( 추후 나중에 응용할 계획 ) (서버가 몇번끊기고 들어가는지 테스트용으로)
	
	
	// 서버연결할 getCon() 메소드
	public static Connection getCon() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String userName = "hr";
		String userPassword = "orcl";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, userName, userPassword);
		num++;
		System.out.println("Server Connection " + num);		
		return con;
	}
	
	// try - catch 문에서 finally 부분에 들어갈 close() 메소드
	public static void close(ResultSet rs, PreparedStatement ps, Connection con) {
		if(rs != null) try {rs.close();} catch(Exception e) {e.printStackTrace();}
		if(ps != null) try {ps.close();} catch(Exception e) {e.printStackTrace();}
		if(con != null) try {con.close();} catch(Exception e) {e.printStackTrace();}
	}

	public static void close(PreparedStatement ps, Connection con) {
		close(null, ps, con);
	}
}
