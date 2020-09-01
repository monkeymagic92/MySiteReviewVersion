package com.jy.pjt.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jy.pjt.vo.BoardCmtVO;

public class BoardCmtDAO {
	
	public static int insCmt(BoardCmtVO param) {
		String sql = " INSERT INTO my_board_cmt "
				+ " (i_cmt, i_board, i_user, cmt)"
				+ " VALUES"
				+ " (seq_board4_cmt.nextval, ?, ?, ?) ";
		
		return JdbcTemplate.executeUpdate(sql, new JdbcUpdateInterface() {

			@Override
			public void update(PreparedStatement ps) throws SQLException {
				ps.setInt(1, param.getI_board());
				ps.setInt(2, param.getI_user());
				ps.setNString(3, param.getCmt());
			}
		});
	}

	
	public static int updCmt(BoardCmtVO param) {
		String sql = " UPDATE my_board_cmt"
				+ " SET cmt = ? "
				+ " , m_dt = sysdate"
				+ " WHERE i_cmt = ? ANd i_user = ?  ";
		
		return JdbcTemplate.executeUpdate(sql, new JdbcUpdateInterface() {

			@Override
			public void update(PreparedStatement ps) throws SQLException {
				ps.setNString(1, param.getCmt());
				ps.setInt(2, param.getI_cmt());
				ps.setInt(3, param.getI_user());				
			}	
		});
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
