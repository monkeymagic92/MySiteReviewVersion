package com.jy.pjt.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



//	== DAO 클래스에서 익명클래스를 사용하기위한 Template 메소드 ==

public class JdbcTemplate {
	
	// SELECT 용
	public static int executeQuery(String sql, JdbcSelectInterface jdbc) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;		
		try {
			con = DbCon.getCon();
			ps = con.prepareStatement(sql);						
			jdbc.prepared(ps);
			
			rs = ps.executeQuery();
			
			result = jdbc.executeQuery(rs);
		} catch (Exception e) {		
			e.printStackTrace();
		} finally {
			DbCon.close(rs, ps, con);
		}
		return result;
	}
		
	// INSERT, UPDATE, DELETE 용
	public static int executeUpdate(String sql, JdbcUpdateInterface jdbc) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DbCon.getCon();
			ps = con.prepareStatement(sql);
			
			jdbc.update(ps); // - ? 에 값을 추가할 부분
			
			result = ps.executeUpdate(); // 자바 실제 내장객체
		} catch (Exception e) {		
			e.printStackTrace();
		} finally {
			DbCon.close(ps, con);
		}
		return result;
	}
}
