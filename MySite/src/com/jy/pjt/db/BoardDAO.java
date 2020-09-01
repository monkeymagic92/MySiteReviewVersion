package com.jy.pjt.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jy.pjt.vo.BoardVO;

public class BoardDAO {
	
	// 페이징관련) 몇번 페이지까지 나타낼지 결정하는 메소드
	// 만약 한페이지당 5글 나타낸다고 가정하였을떄 글이 27개면
	// 총 페이지수는 6개 나타남
	public static int selPagingCnt(BoardVO param) {
		
		String sql = " SELECT CEIL(COUNT(i_board) / ?) FROM my_board ";
		
		return JdbcTemplate.executeQuery(sql, new JdbcSelectInterface() {

			@Override
			public void prepared(PreparedStatement ps) throws SQLException {
				ps.setInt(1, param.getRecord_cnt());
			}

			@Override
			public int executeQuery(ResultSet rs) throws SQLException {
				if(rs.next()) {
					return rs.getInt(1); // 첫번째 컬럼 : CEIL(COUNT(i_board) / ?) 값을 가르킴
				}
				return 0;
			}
			
		});
	}
	
	// 페이징관련) 현재 페이지의 전체글 나타내는 메소드 
	public static List<BoardVO> selBoardList(BoardVO param) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		String sql = " SELECT A.* FROM"
				+ " ( "
				+ " SELECT ROWNUM as RNUM, A.* FROM"
				+ " 	("
				+ " 		SELECT A.i_board, A.title, A.hits, A.i_user, "
				+ "			TO_CHAR(A.r_dt, 'YYYY/MM/DD HH24:MI') as r_dt, B.nm, B.profile_img "
				+ "			FROM my_board A "
				+ "			INNER JOIN my_user B "
				+ " 		ON A.i_user = B.i_user "
				+ "			ORDER BY i_board DESC "
				+ " 	) A"
				+ " 	WHERE ROWNUM <= ? "
				+ " ) A "
				+ " WHERE A.RNUM > ? ";
				
		
		int result = JdbcTemplate.executeQuery(sql, new JdbcSelectInterface() {

			@Override
			public void prepared(PreparedStatement ps) throws SQLException {
				// 일단 이렇게 만들기
				// 추후 값 삭제
				int eIdx = param.getPage() * param.getRecord_cnt();
				int sIdx = eIdx - param.getRecord_cnt();
				
				ps.setInt(1, eIdx);
				ps.setInt(2, sIdx);
			}

			@Override
			public int executeQuery(ResultSet rs) throws SQLException {
				while(rs.next()) {
					int i_board = rs.getInt("i_board");	
					String title = rs.getNString("title");
					int hits = rs.getInt("hits");
					int i_user = rs.getInt("i_user");
					String r_dt = rs.getNString("r_dt");
					String nm = rs.getNString("nm");
					String profile_img = rs.getNString("profile_img");
					
					
					BoardVO vo = new BoardVO();
					vo.setI_board(i_board);
					vo.setTitle(title);
					vo.setHits(hits);
					vo.setI_user(i_user);
					vo.setR_dt(r_dt);
					vo.setNm(nm);
					vo.setProfile_img(profile_img);
					
					//
					
					
					list.add(vo);
				}
				return 1;
			}
			
		}); 
		return list;
		
	}
	
	
	
	// 글쓰기 기능
	public static int insBoard(BoardVO param) {
		
		String sql = " INSERT INTO my_board "
				+ " (i_board, title, ctnt, i_user) "
				+ " SELECT nvl(max(i_board),0) + 1, ?, ?, ? "
				+ " FROM my_board ";
		
		return JdbcTemplate.executeUpdate(sql, new JdbcUpdateInterface() {

			@Override
			public void update(PreparedStatement ps) throws SQLException {				
				ps.setNString(1, param.getTitle());
				ps.setNString(2, param.getCtnt());
				ps.setInt(3, param.getI_user());
								
			}			
		});						
	}
	
	public static BoardVO detailBoard(BoardVO param) {
		String sql = " SELECT A.i_board, A.title, A.ctnt, A.r_dt, "
				+ " A.hits, B.nm FROM my_board A "
				+ " INNER JOIN my_user B "
				+ " ON A.i_user = B.i_user "
				+ " WHERE A.i_board = ? ";
				
		
		BoardVO vo = new BoardVO();
		
		JdbcTemplate.executeQuery(sql, new JdbcSelectInterface() {

			@Override
			public void prepared(PreparedStatement ps) throws SQLException {
				ps.setInt(1, param.getI_board());				
			}

			@Override
			public int executeQuery(ResultSet rs) throws SQLException {				
				if(rs.next()) {					
					vo.setI_board(rs.getInt("i_board"));
					vo.setTitle(rs.getNString("title"));
					vo.setCtnt(rs.getNString("ctnt"));
					vo.setR_dt(rs.getNString("r_dt"));					
					vo.setHits(rs.getInt("hits"));
					vo.setNm(rs.getNString("nm"));					
				}				
				return 0;
			}			
		});
		return vo;
	}
	
	// 게시글 삭제
	public static int delBoard(BoardVO param) {
		
		String sql = " DELETE my_board "
				+ " WHERE i_board = ? ";
		
		return JdbcTemplate.executeUpdate(sql, new JdbcUpdateInterface() {

			@Override
			public void update(PreparedStatement ps) throws SQLException {
				ps.setInt(1, param.getI_board());				
			}
		});	
	}	
	
	// 게시글 수정
	public static int updBoard(BoardVO param) {
		
		String sql = " UPDATE my_board "
				+ " SET title = ? "
				+ " , ctnt = ? "				
				+ " WHERE i_board = ? AND i_user = ? ";
		
		return JdbcTemplate.executeUpdate(sql, new JdbcUpdateInterface() {

			@Override
			public void update(PreparedStatement ps) throws SQLException {
				ps.setNString(1, param.getTitle());
				ps.setNString(2, param.getCtnt());
				ps.setInt(3, param.getI_board());
				ps.setInt(4, param.getI_user());
				
			}
			
		});
	}
	
	public static int selPaginCnt(BoardVO param) {
		
		String sql = " SELECT CEIL(COUNT(i_board) / ?) FROM my_board ";
		
		return JdbcTemplate.executeQuery(sql, new JdbcSelectInterface() {

			@Override
			public void prepared(PreparedStatement ps) throws SQLException {
				ps.setInt(1, param.getRecord_cnt());
				ps.setNString(2, param.getSearchText());
				
			}

			@Override
			public int executeQuery(ResultSet rs) throws SQLException {
				if(rs.next()) {
					return rs.getInt(1); // 첫번째 인덱스 값 가져오기 ( CEIL(COUNT(i_board) / ? ) <-- 이부분 
				}
				return 0;
			} 
			
		});
	}


}
