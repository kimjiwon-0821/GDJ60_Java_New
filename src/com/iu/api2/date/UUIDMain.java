package com.iu.api2.date;

import java.util.Calendar;
import java.util.Random;
import java.util.UUID;

public class UUIDMain {
	public static void main(String[] args) {
		//1. UUID
		String name = UUID.randomUUID().toString(); //중복되지 않은 unique한 이름을 지정해주는 메소드
		//2.시간 이용
		//name = calendar.getTimeInMillis()+"abc";
		System.out.println(name);
		
		//Random random; // 가짜 난수 - 어느순간 같은 패턴으로 숫자가 나온다.
		Calendar calendar = Calendar.getInstance();
		Random random = new Random(calendar.getTimeInMillis()); // 시간을 seed로 주어 변칙적인 랜덤을 만든다.	
	}

}
