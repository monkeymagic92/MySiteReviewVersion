package com.jy.pjt.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 글 읽기용 인터페이스
public interface JdbcSelectInterface {
	void prepared(PreparedStatement ps) throws SQLException;
	int executeQuery(ResultSet rs) throws SQLException;
}
