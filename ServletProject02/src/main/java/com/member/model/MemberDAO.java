package com.member.model;

import java.util.ArrayList;

public interface MemberDAO {
	//추가
	public void memberJoin(MemberDTO member);
	//전체보기
	public ArrayList<MemberDTO> getMember();
	//수정
	public void memberUpdate(MemberDTO member);
	//삭제
	public void memberDelete(String userid);
	//상세보기
	public MemberDTO findById(String userid);
	//회원수
	public int getCount();
	//아이디중복확인
	public String memberIdCheck(String userid);
	//로그인
	public MemberDTO memberLoginCheck(String userid, String pwd);

}
