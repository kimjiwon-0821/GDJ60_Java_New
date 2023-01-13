package com.iu.api3.exception;

import java.util.Random;

public class ExceptionMain1 {
	public static void main(String[] args) {
		String num=null;		
		//exception 에러는 compile에러는 아니고 실행중 발생하는 에러
		
		Random random = new Random();
		int n= random.nextInt(2);
		if(n==0)
			num="Test";
		
		try {
			int a=10;
			System.out.println(3/n);
			//throw new ArithmeticException(); //exception이 발생하면 자동으로 만들어서 던지는데 생략되어 있는 것임.
			System.out.println(num.charAt(0));//charAt() 글자하나 가져오는 메소드
			//throw new NullPointerException();
		//다형성
		}catch(ArithmeticException e) {
			e.printStackTrace();
			System.out.println("예외 발생");
		} // 예외처리의 목적 : 비정상적인 종료를 막기위해
		catch (RuntimeException e) {
			e.printStackTrace(); // 오류가 발생한 부분을 추적해주는 메소드
		}catch (Exception e) {
			// TODO: handle exception
		}catch (Throwable e) {
			// TODO: handle exception
		}
		
		//exception 에러가 발생하면 그즉시 프로그램 종료
		System.out.println("종료합니다.");
		
		
	}

}
