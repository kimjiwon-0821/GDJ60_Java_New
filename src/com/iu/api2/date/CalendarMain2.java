package com.iu.api2.date;

import java.util.Calendar;

public class CalendarMain2 {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		Calendar birth = Calendar.getInstance();
		Calendar sample = Calendar.getInstance();
		
		birth.set(2000, 6, 29);//월은 0부터 시작
		
		sample.set(Calendar.MINUTE,sample.get(Calendar.MINUTE)+1 );
		
		long n = now.getTimeInMillis(); // 현재 시간을 milliseconds로 바꾼것
		long s = sample.getTimeInMillis(); // 숫자 계산을 하고 싶으면 숫자타입으로 변경하여 연산하여라
		
		n=s-n;
		//n/=1000; // 초로 환산
		n/=60*1000; // 분으로 환산
		//n/=60*60*1000; // 시로 환산
		System.out.println("n : "+n);
		System.out.println("s : "+s);
		
		long time_n = now.getTimeInMillis();
		long time_b = birth.getTimeInMillis();
		time_n -= time_b;
		long time = time_n/(60*60*1000);
		long day = time/(24*365);
		
		System.out.println(now.getTime());
		System.out.println(sample.getTime());
		System.out.println(birth.getTime());
		System.out.println("시간 : "+time + "\n년도 : "+day);
		
		
	}

}
