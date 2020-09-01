package com.jy.pjt.vo;

public class BoardVO {
	private int i_board;
	private int i_user;
	private int i_like;
	private String title;
	private String ctnt;
	private int hits;
	private String r_dt;
	private String m_dt;
	private String nm;
	private String searchText;
	private String profile_img;
	
	
	
	
	
	public String getProfile_img() {
		return profile_img;
	}
	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	// 페이징 관련 VO
	private int record_cnt;
	private int page;
	
		
	// 페이징관련 겟터 셋터
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRecord_cnt() {
		return record_cnt;
	}
	public void setRecord_cnt(int record_cnt) {
		this.record_cnt = record_cnt;
	}
	
	
	
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	public int getI_board() {
		return i_board;
	}	
	public void setI_board(int i_board) {
		this.i_board = i_board;
	}	
	
	public int getI_user() {
		return i_user;
	}
	public int getI_like() {
		return i_like;
	}
	public void setI_like(int i_like) {
		this.i_like = i_like;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCtnt() {
		return ctnt;
	}
	public void setCtnt(String ctnt) {
		this.ctnt = ctnt;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public String getR_dt() {
		return r_dt;
	}
	public void setR_dt(String r_dt) {
		this.r_dt = r_dt;
	}
	public String getM_dt() {
		return m_dt;
	}
	public void setM_dt(String m_dt) {
		this.m_dt = m_dt;
	}
	
	public void setI_user(int i_user) {
		this.i_user = i_user;
	}

}
