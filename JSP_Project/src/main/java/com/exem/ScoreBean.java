package com.exem;

public class ScoreBean {
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	
	//setter
	public void setName(String name) {
		this.name = name;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void setMath(int math) {
		this.math = math;
	}

	
	//getter
	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}

	
	//총점 구하는 메소드
	public int getTotal() {
		return kor+eng+math;
	}
	
	//평균
	public float getAvg() {
		return (kor+eng+math)/3.0f;
	}
	
	//학점
	public String getGrade() {
		String grade ="";
		switch((int)getAvg()/10) {
		case 10:
		case 9:grade = "A";break;
		case 8:grade = "B";break;
		case 7:grade = "C";break;
		default:grade = "F";break;
		}
		return grade;
	}
}
