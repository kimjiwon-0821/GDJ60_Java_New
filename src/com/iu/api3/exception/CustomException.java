package com.iu.api3.exception;

public class CustomException extends Exception{ // Exception을 상속 받은 예외클래스
	public CustomException() {
		 // 상속받으면 부모를 확장해서 사용
		
	}
	
	public CustomException(String message) {
		super(message);
		
	}

}
