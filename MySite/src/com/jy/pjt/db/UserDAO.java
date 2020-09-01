package com.jy.pjt.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jy.pjt.vo.UserVO;

public class UserDAO {
		
	// (인터페이스 X) 전체 회원목록 
	public static List<UserVO> selUser() {
		List<UserVO> list = new ArrayList<UserVO>();		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT i_user, user_id, nm, gender, m_dt "
				+ " FROM my_user ORDER BY i_user DESC ";
		
		try {
			con = DbCon.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				UserVO vo = new UserVO();
				vo.setI_user(rs.getInt("i_user"));
				vo.setUser_id(rs.getNString("user_id"));
				vo.setNm(rs.getNString("nm"));
				vo.setGender(rs.getNString("gender"));
				vo.setM_dt(rs.getNString("m_dt"));
				list.add(vo);			
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.close(rs, ps, con);
		}		
		return list;	
	}
	
	// (인터페이스 O) 회원가입
	public static int intUser(UserVO param) {
		
		String sql = " INSERT INTO my_user "
				+ " (i_user, user_id, user_pw, nm, phone, email, gender) "
				+ " SELECT nvl(max(i_user),0) + 1, ?, ?, ?, ?, ?, ?"
				+ " FROM my_user ";
		
		return JdbcTemplate.executeUpdate(sql, new JdbcUpdateInterface() {

			@Override
			public void update(PreparedStatement ps) throws SQLException {
				ps.setNString(1, param.getUser_id());
				ps.setNString(2, param.getUser_pw());
				ps.setNString(3, param.getNm());
				ps.setInt(4, param.getPhone());
				ps.setNString(5, param.getEmail());
				ps.setNString(6, param.getGender());				
			}			
		});
	}
	
	// (인터페이스 O) 회원상세(detail) 나타내기
	public static UserVO detailUser(UserVO param) {
		
		String sql = " SELECT user_id, nm, phone, profile_img, email, gender "
				+ " FROM my_user "
				+ " WHERE i_user = ? ";
				
		
		JdbcTemplate.executeQuery(sql, new JdbcSelectInterface() {

			@Override
			public void prepared(PreparedStatement ps) throws SQLException {
				ps.setInt(1, param.getI_user());
			}

			@Override
			public int executeQuery(ResultSet rs) throws SQLException {
				if(rs.next()) {
					param.setUser_id(rs.getNString("user_id"));
					param.setNm(rs.getNString("nm"));
					param.setPhone(rs.getInt("phone"));
					param.setEmail(rs.getNString("email"));
					param.setGender(rs.getNString("gender"));
					param.setProfile_img(rs.getNString("profile_img"));
				}
				return 1;
			}			
		});		
		return param;
	}

	// (인터페이스 X) 비밀번호 찾기전 회원정보 일치하는지 체크
	public static String chkUser(UserVO param) {
		UserVO vo = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String chk = "";
		
		String sql = " SELECT user_id, nm, phone FROM my_user ";
		
		try {
			con = DbCon.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				vo = new UserVO();
				vo.setUser_id(rs.getNString("user_id"));
				vo.setNm(rs.getNString("nm"));
				vo.setPhone(rs.getInt("phone"));
				
				if(param.getUser_id().equals(vo.getUser_id()) 
						&& param.getNm().equals(vo.getNm())
						&& param.getPhone() == vo.getPhone()) {
					chk = "ok";
				}				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.close(rs, ps, con);
		}		
		return chk;
	}
	
	// (인터페이스 O) 비밀번호 변경
	public static void changePw(UserVO param) {
		
		String sql = " UPDATE my_user "
				+ " SET user_pw = ? "
				+ " WHERE user_id = ? ";
		
		JdbcTemplate.executeUpdate(sql, new JdbcUpdateInterface() {

			@Override
			public void update(PreparedStatement ps) throws SQLException {
				ps.setNString(1, param.getUser_pw());
				ps.setNString(2, param.getUser_id());				
			}			
		});
	}
	
	// (인터페이스O) 계정삭제 
	public static int delUser(UserVO param) {
		
		String sql = " DELETE my_user"
				+ " WHERE i_user = ? ";
		
		return JdbcTemplate.executeUpdate(sql, new JdbcUpdateInterface() {

			@Override
			public void update(PreparedStatement ps) throws SQLException {
				ps.setInt(1, param.getI_user());
			}
		});
	}
	
	// (인터페이스O) 아이디 비밀번호 검사 후 로그인 메소드 
	public static int loginUser(UserVO param) {
		
		String sql = " SELECT i_user, user_pw, nm "
				+ " FROM my_user "
				+ " WHERE user_id = ? ";
		
		return JdbcTemplate.executeQuery(sql, new JdbcSelectInterface() {

			@Override
			public void prepared(PreparedStatement ps) throws SQLException {
				ps.setNString(1, param.getUser_id());
			}
			
			@Override
			public int executeQuery(ResultSet rs) throws SQLException {
				if(rs.next()) {
					String dbPw = rs.getNString("user_pw");
					if(dbPw.equals(param.getUser_pw())) { // 로그인 성공
						param.setUser_pw(null);
						param.setI_user(rs.getInt("i_user"));
						param.setNm(rs.getNString("nm"));
						return 1; // 로그인 성공						
					} else {
						return 2; // 비밀번호틀림
					}
				} else {
					return 3; // 아이디 없음
				}				
			}			
		});
	}
	
	
	
	public static int updUser(UserVO param) {
		StringBuilder sb = new StringBuilder(" UPDATE my_user SET m_dt = sysdate");
		
		if(param.getUser_pw() != null) {
			sb.append(" , user_pw= '");
			sb.append(param.getUser_pw());
			sb.append("' ");
		}
		
		if(param.getNm() != null) {
			sb.append(" ,nm = '");
			sb.append(param.getNm());
			sb.append("' ");			
		}
		
		if(param.getEmail() != null) {
			sb.append(" ,email = '");
			sb.append(param.getEmail());
			sb.append("' ");
		}
		
		
		if(param.getProfile_img() != null) {
			sb.append(" ,profile_img = '");
			sb.append(param.getProfile_img());
			sb.append("' ");
		}
		
		sb.append(" WHERE i_user = ");
		sb.append(param.getI_user());
		
		System.out.println("sb : " + sb.toString());
	
		return JdbcTemplate.executeUpdate(sb.toString(), new JdbcUpdateInterface() {

			@Override
			public void update(PreparedStatement ps) throws SQLException {}
		});
	
	}
	
}
