package com.iu.api3.exception;

public class ExceptionSample2 {
	public void ex2() throws Exception { // 여기서 예외를 던져서 main에서 받아 처리 가능
		ExceptionSample1 e1 = new ExceptionSample1();
		e1.ex1();
	}

}
