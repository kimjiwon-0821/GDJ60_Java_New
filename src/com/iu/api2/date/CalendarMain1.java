package com.iu.api2.date;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarMain1 {
	public static void main(String[] args) {
		//GregorianCalendar - calendar type
		Calendar ca = new GregorianCalendar();
		//현재날짜와 시간으로 객체가 만들어짐
		ca = Calendar.getInstance(); // 클래스메소드 선언 = 클래스명.메소드명
		
		System.out.println(ca); //참조변수 선언시 tostring 자동 호출
		
		ca.set(Calendar.YEAR, 2032);
		ca.set(Calendar.MONTH, 11); // 월은 +1을 하니까 12로 바꾸고 싶으면 11로 값을 주어야 한다.
		
		
		
		//year
		int year = ca.get(Calendar.YEAR); // static final YEAR : static으로 멤버변수로 객체 생성 없이 사용 가능 -> 클래스명.변수명으로 호출
		System.out.println("YEAR : "+year);
		//월은 0부터 시작이다 **월만 해당
		int month = ca.get(Calendar.MONTH);
		System.out.println("MONTH : "+(month+1)); // *컴퓨터는 숫자를 셀때 0부터 세기때문에 첫달은 0으로 출력되는 것*
		int date = ca.get(Calendar.DATE);
		System.out.println("DATE : "+date);
		int day = ca.get(Calendar.DAY_OF_WEEK); // 요일 (일,월,화,수,목,금,토)
		System.out.println("DAY : "+day);
		
		//시 분 초
		int hour = ca.get(Calendar.HOUR); // 12시간 기준
		int hour_d = ca.get(Calendar.HOUR_OF_DAY); //24시간 기준
		int min = ca.get(Calendar.MINUTE);
		int sec = ca.get(Calendar.SECOND);
		System.out.println("TIME : "+hour +"-"+min+"-"+sec);
		System.out.println("TIME : "+hour_d +"-"+min+"-"+sec);
		
		
	}

}
