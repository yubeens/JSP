package com.board.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface BoardDAO {
	//p.506
	//검색포함 카운트
	public int selectCount(Map<String, Object>map);
	//검색포함 전체보기
	public List<BoardDTO>selectListPage(Map<String,Object>map);
	
	//추가
	public int boardInsert(BoardDTO board);
	//전체보기
	public ArrayList<BoardDTO> boardList(int startRow,int endRow);
	//상세보기
	public BoardDTO findByNum(int num);
	//수정
	public int boardUpdate(BoardDTO board);
	//삭제
	public int boardDelete(int num);
	//게시글 수
	public int boardCount();
	//조회수 증가
	public void updateReadCount(int num);
	public void close();
	
	
}
