package com.iu.api2.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarMain4 {
	public static void main(String[] args) {
		Calendar ca = Calendar.getInstance(); // calender을 상속받는 gregorianCalender 생성자를 가지고 오는 것임
		//2023년 1월 11일 => format
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd (E)"); // 출력하고 싶은 패턴
		//sd.applyPattern("yyyy-MM-dd (E)"); // 패턴을 변경하는 메소드
		String p = sd.format(ca.getTime()); // foramt의 gettime은 string이 return type이기때문에 리턴값을 넣어줘야한다.
		
		System.out.println(p);
		
	}

}
