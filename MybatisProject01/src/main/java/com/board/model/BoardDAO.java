package com.board.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.address.config.MybatisManager;

public class BoardDAO {
	SqlSession  session ;
	
	public BoardDAO() {
		SqlSessionFactory sqlSessionFactory
		   = MybatisManager.getSessionFactory();
		session = sqlSessionFactory.openSession();
	}
	//추가
	
	//전체보기
	
	//상세보기
	
	//수정
	
	//삭제
}
