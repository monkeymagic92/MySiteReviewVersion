package com.jy.pjt.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

// 글 수정용 인터페이스
public interface JdbcUpdateInterface {
	void update(PreparedStatement ps) throws SQLException;
}
