package com.board.model;

import java.util.ArrayList;

public interface BoardDAO {
	//추가
	public int boardInsert(BoardDTO board);
	//전체보기
	public ArrayList<BoardDTO> boardList();
	//상세보기
	public BoardDTO findByNum(int num);
	//수정
	public  int boardUpdate(BoardDTO board);
	//삭제
	public int boardDelete(int num);
	//게시글 수
	public int boardCount();

}
