package com.iu.api2.collections.ex1;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex1Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//학생은 이름 번호 국어 영어 수학 총점 평균으로 이루어짐
		//1.학생정보초기화
		//2.학생정보전체조회
		//3.학생정보검색조회(이름으로 검색)
		//4.학생정보추가
		//5.학생정보삭제(이름으로 검색)
		//6.프로그램 종료
		new StudentController().start();
		
//		//향상된 for
//		//ar에서 하나 꺼내서 studentDTO에 대입해서 중괄호 -> ar의 길이만큼 자동으로 반복
//		for(StudentDTO studentDTO:ar) {
//			
//		}
//		//향상된 for EX)
//		int [] nums = new int [3];
//		for(/*collection에서 꺼내고 싶은 타입*/ int n:/*어디서 꺼내고 싶은가*/nums) {
//			//단점 : 인덱스번호를 사용할 수 없음
//		}
		
//		StudentDTO studentDTO = sd.findByName(ar);
//		System.out.println(studentDTO.getName());
//		System.out.println(studentDTO.getAvg());
		

	}

}
