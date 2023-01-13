package com.iu.api2.collections.ex1;

import java.util.ArrayList;

public class StudentView {
	//학생한명 조회
	public void view(StudentDTO studentDTO) {
		System.out.println("Name : "+studentDTO.getName());
		System.out.println("NUM : "+studentDTO.getNum());
		System.out.println("Kor : "+studentDTO.getKor());
		System.out.println("Eng : "+studentDTO.getEng());
		System.out.println("Math : "+studentDTO.getMath());
		System.out.println("Total : "+studentDTO.getTotal());
		System.out.println("Avg : "+studentDTO.getAvg());
	}
	
	//학생 여러명 조회
	public void view(ArrayList<StudentDTO> ar) {
		for(StudentDTO studentDTO:ar) {
			this.view(studentDTO);
		}
	}
	
	public void view(String msg) {
		System.out.println(msg);
	}

}
