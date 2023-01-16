package com.iu.api4.network.servers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.iu.api2.collections.ex1.StudentDTO;

public class ServerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket ss = null;
		Socket sc = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		
		try {
//서버 접속
			ss = new ServerSocket(8282);
			System.out.println("client 접속 대기중...");
			sc= ss.accept();
			System.out.println("client 접속 성공");
//파일접속
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
			//파일접속 완료
			
//학생초기화
			ArrayList<StudentDTO> ar = new ArrayList<>();
			FileReader fr = new FileReader(file);
			br = new BufferedReader(fr);
			while(true) {
				String data = br.readLine();
				if(data==null)
					break;
				StringTokenizer st = new StringTokenizer(data,"-");
				StudentDTO studentDTO = new StudentDTO();
				studentDTO.setName(st.nextToken());
				studentDTO.setNum(Integer.parseInt(st.nextToken()));
				studentDTO.setKor(Integer.parseInt(st.nextToken()));
				studentDTO.setEng(Integer.parseInt(st.nextToken()));
				studentDTO.setMath(Integer.parseInt(st.nextToken()));
				studentDTO.setTotal(Integer.parseInt(st.nextToken()));
				studentDTO.setAvg(Double.parseDouble(st.nextToken()));
				ar.add(studentDTO);
			} // arraylist<StudentDTO> ar에 학생정보 초기화 성공
			
			for(StudentDTO studentDTO:ar) {
				System.out.println("Name : "+studentDTO.getName());
				System.out.println("NUM : "+studentDTO.getNum());
				System.out.println("Kor : "+studentDTO.getKor());
				System.out.println("Eng : "+studentDTO.getEng());
				System.out.println("Math : "+studentDTO.getMath());
				System.out.println("Total : "+studentDTO.getTotal());
				System.out.println("Avg : "+studentDTO.getAvg());
			}
			
			is = sc.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);
			String select=br.readLine();
//학생 출력    
			if(select.equals("1")) {
			os = sc.getOutputStream();
			ow = new OutputStreamWriter(os);
			bw = new BufferedWriter(ow);
			for(StudentDTO studentDTO:ar) {
				bw.write("Name : "+studentDTO.getName()+"\r\n");
				bw.flush();
				bw.write("NUM : "+studentDTO.getNum()+"\r\n");
				bw.flush();
				bw.write("Kor : "+studentDTO.getKor()+"\r\n");
				bw.flush();
				bw.write("Eng : "+studentDTO.getEng()+"\r\n");
				bw.flush();
				bw.write("Math : "+studentDTO.getMath()+"\r\n");
				bw.flush();
				bw.write("Total : "+studentDTO.getTotal()+"\r\n");
				bw.flush();
				bw.write("Avg : "+studentDTO.getAvg()+"\r\n");
				bw.flush();
			}
			bw.write("모든 학생 정보가 출력되었습니다.");
			bw.flush();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
