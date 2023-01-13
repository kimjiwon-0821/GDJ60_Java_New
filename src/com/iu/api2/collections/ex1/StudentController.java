package com.iu.api2.collections.ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {
	private Scanner sc;
	private StudentDAO sd; // 의존적이다.
	private StudentView sv; // 의존저깅다.
	private ArrayList<StudentDTO> ar;
	
	public StudentController() {
		sc = new Scanner(System.in);
		sd = new StudentDAO(); // 주입 -> dependency injection
		sv = new StudentView(); // 의존성주입 (DI)
	}
	
	public void start() throws Exception {
		boolean check = true;
		while(check) {
			System.out.println("1.학생정보초기화");
			System.out.println("2.학생정보전체조회");
			System.out.println("3.학생정보검색조회");
			System.out.println("4.학생정보추가");
			System.out.println("5.학생정보삭제");
			System.out.println("6.학생정보백업");
			System.out.println("7.종료");
			int select=sc.nextInt();
			switch(select) {
			case 1: 
				ar = sd.init();
				System.out.println("초기화가 완료되었습니다.");
				break;
			case 2: 
				sv.view(ar); // ArrayList가 매개변수인 view 메소드가 호출됨 - return 값은 없음
				break;
			case 3: 
				StudentDTO studentDTO = sd.findByName(ar);
				if(studentDTO != null)
					sv.view(studentDTO);
				else
					sv.view("찾는 학생이 없다");
				break;
			case 4: 
				sd.addStudent(ar);
				break;
			case 5: 
				select = sd.removeStudent(ar);
				if(select==1)
					sv.view("삭제가 성공했습니다");
				else
					sv.view("삭제가 실패했습니다");
				break;
			case 6:
				sd.studentBackUp(ar);
				System.out.println("백업이 성공했습니다.");
				break;
			default: 
				check = false;
				break;
			}
		}
		
	}

}
