package com.iu.api4.network.example.Servers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StudentDAO {
	//List의 내용들을 하나의 String으로 만드렁 주는 메서드
	
	public String makeList(ArrayList<StudentDTO> ar) {
		String result = "";
		StringBuffer sb = new StringBuffer();
		for(StudentDTO studentDTO : ar) {
			sb.append(studentDTO.getName());
			sb.append("-");
			sb.append(studentDTO.getNum());
			sb.append("-");
			sb.append(studentDTO.getKor());
			sb.append("-");
			sb.append(studentDTO.getEng());
			sb.append("-");
			sb.append(studentDTO.getMath());
			sb.append("-");
			sb.append(studentDTO.getTotal());
			sb.append("-");
			sb.append(studentDTO.getAvg());
			sb.append("-");
		}
		result = sb.toString().substring(0,sb.length()-1);
		
		return result;
	}
	public ArrayList<StudentDTO> init() throws Exception {
		ArrayList<StudentDTO> ar = new ArrayList<>();
		File file = new File("C:\\fileTest");
		String [] names = file.list();
		long max = 0;
		for(String name:names) {
			name = name.substring(0,name.lastIndexOf("."));
			long data = Long.parseLong(name);
			if(data>max)
				max = data;
		}
		file = new File(file,max+".txt");
		System.out.println(file);
		
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		boolean check = true;
		while(check) {
			String s = br.readLine();
			if(s==null) {
				break;
			}
			StringTokenizer st = new StringTokenizer(s,"-");
			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setName(st.nextToken());
			studentDTO.setNum(Integer.parseInt(st.nextToken()));
			studentDTO.setKor(Integer.parseInt(st.nextToken()));
			studentDTO.setEng(Integer.parseInt(st.nextToken()));
			studentDTO.setMath(Integer.parseInt(st.nextToken()));
			studentDTO.setTotal(Integer.parseInt(st.nextToken()));
			studentDTO.setAvg(Double.parseDouble(st.nextToken()));
			ar.add(studentDTO);
		}//while 끝
		return ar;
	}

}
