package com.iu.api3.exception;

import java.util.Random;

public class ExceptionSample1 {
	public void ex1() throws ArithmeticException, NullPointerException{ // exception은 여러개 생성 가능 아니면 Exception or Throwable로 한번에 선언도 가능
		Random random = new Random();
		int num = random.nextInt(2);
		num = 10/num;
		System.out.println(num);
	}
	
	public void ex2() throws Exception{
		//2자리
		int num1 = 65;
		int num2 = 48;
		//int sum = num1+num2;
		int sum = num2-num1;
		
		if(sum<0) {
			throw new CustomException("음수는 읽을 수 없음");
		}
		if(sum>99) {
			throw new CustomException("세자리 수는 모름");
		}
	}

}
