package com.exem;

import java.util.Calendar;

public class DateBean {
 Calendar ca = Calendar.getInstance();
 String[] arr = {"일","월","화","수","목","금","토"};
 
 public String getToday() {
	 String str =ca.get(Calendar.YEAR)+"년"; //년 월 일 요일
	 	str += ca.get(Calendar.MONTH)+1+"월";
	 	str += ca.get(Calendar.DATE)+"일";
	 	str += ca.get(Calendar.DAY_OF_WEEK)+"요일~~~~";
        str += arr[ca.get(Calendar.DAY_OF_WEEK)-1];
	 return str;
 }
 
}
