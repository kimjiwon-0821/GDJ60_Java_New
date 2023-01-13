package com.iu.api2.collections.ex1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StudentDAO {
	private StringBuffer sb;
	private Scanner sc; // 멤버변수로 선언
	public StudentDAO() {
		this.sc = new Scanner(System.in); //보통 멤버변수의 객체는 기본생성자에서 생성
		this.sb = new StringBuffer();	
//		sb.append("iu-1-90-60-70-");
//		sb.append("winter-2-86-84-75-");
//		sb.append("suji, 3, 89, 74, 87 ");
//		sb.append("choa, 4, 71, 25, 99 ");
	}
	
	//DAO를 DTO에 넣어주는 학생정보 초기화
	public ArrayList<StudentDTO> init() throws Exception {
		//5가지가 모여야 학생 하나가 만들어지기 때문에 Tokenizer가 알맞은 - 다른것은 split
		ArrayList<StudentDTO> ar = new ArrayList<>(); // 지역변수
		File file = new File("C:\\fileTest");
		String [] names = file.list();
		long max = 0;
		for(String name:names) {
			name = name.substring(0,name.lastIndexOf("."));
			long data = Long.parseLong(name);
			
			if(data>max)
				max = data;
		}
		file = new File(file, max+".txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		while(true) {
		String data = br.readLine();
		if(data==null)
			return ar;
		data= data.replace(" ", "-");
		data = data.replace(",", "");
		StringTokenizer st = new StringTokenizer(data,"-");
			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setName(st.nextToken());
			studentDTO.setNum(Integer.parseInt(st.nextToken()));
			studentDTO.setKor(Integer.parseInt(st.nextToken()));
			studentDTO.setEng(Integer.parseInt(st.nextToken()));
			studentDTO.setMath(Integer.parseInt(st.nextToken()));
			studentDTO.setTotal(studentDTO.getEng()+studentDTO.getKor()+studentDTO.getMath());
			studentDTO.setAvg(studentDTO.getTotal()/3.0);
			ar.add(studentDTO);
		}
	}
	
	//학생정보검색
	public StudentDTO findByName(ArrayList<StudentDTO> ar) {
		System.out.println("검색할 이름 입력:");
		String name = sc.next();
		StudentDTO st = null;
		for(StudentDTO studentDTO : ar) {
			if(name.equals(studentDTO.getName())) {
				st=studentDTO; //주소 대입
				break;
			}
		}
		return st;	
	}
	
	//학생정보추가
	public void addStudent(ArrayList<StudentDTO> ar) {
		StudentDTO studentDTO = new StudentDTO();
		System.out.println("추가할 학생 이름 입력:");
		studentDTO.setName(sc.next());
		System.out.println("추가할 학생 번호 입력:");
		studentDTO.setNum(sc.nextInt());
		System.out.println("추가할 학생 국어 입력:");
		studentDTO.setKor(sc.nextInt());
		System.out.println("추가할 학생 영어 입력:");
		studentDTO.setEng(sc.nextInt());
		System.out.println("추가할 학생 수학 입력:");
		studentDTO.setMath(sc.nextInt());
		studentDTO.setTotal(studentDTO.getEng()+studentDTO.getKor()+studentDTO.getMath());
		studentDTO.setAvg(studentDTO.getTotal()/3.0);
		ar.add(studentDTO);	
	}
	
	public int removeStudent(ArrayList<StudentDTO> ar) {
		//삭제확인용 변수
		//0이면 삭제 실패, 1이면 삭제 성고
		int result =0;
		System.out.println("삭제할 학생 이름:");
		String name = sc.next();
		//ar.remove(인덱스번호) -> for문
		//ar.remove(object) -> 향상된for문
		//1,
//		for(int i=0;i<ar.size();i++) {
//			if(name.equals(studentDTO.getName())){
//				ar.remove(i);
//				result =1;
//				break;
//			}
//		}
		//2.
		for(StudentDTO studentDTO:ar) {
			if(name.equals(studentDTO.getName())) {
				ar.remove(studentDTO);
				result = 1;
				break;
			}
		}
		return result;
		}
	
	//학생정보백업
	//현재시간을 파일명으로 해서 파일작성
	public void studentBackUp(ArrayList<StudentDTO> ar) throws IOException {
		Calendar ca = Calendar.getInstance();
		String name = ca.getTimeInMillis()+".txt";
		File file = new File("C:\\fileTest",name);
		for(StudentDTO studentDTO : ar) {
			FileWriter fw = new FileWriter(file,true);
			fw.flush();
			fw.write(studentDTO.getName()+"-");
			fw.write(studentDTO.getNum()+"-");
			fw.write(studentDTO.getKor()+"-");
			fw.write(studentDTO.getEng()+"-");
			fw.write(studentDTO.getMath()+"-");
			fw.write(studentDTO.getTotal()+"-");
			fw.write(studentDTO.getAvg()+"\r\n");
			fw.flush();
		}
	}
		
	}

