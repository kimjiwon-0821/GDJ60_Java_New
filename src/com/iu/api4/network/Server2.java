package com.iu.api4.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.Random;

public class Server2 {
	public static void main(String[] args) {
		//client 접속 대기
		//1.점심메뉴 중 하나를 랜덤하게 골라서 전송
		//2.저녁메뉴 중 하나를 랜덤하게 골라서 전송
		//3.둘다 종료
		ServerSocket ss = null;
		Socket sc = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null; //try-catch때문에 null값으로 위에서 선언해줘야 함.
		boolean check = true; 
		
		try {
			ss = new ServerSocket(8282); // -> 다른 프로그램에서 8282를 사용하고 있으면 error 뜨기 때문에 try catch 해줌
			System.out.println("client 접속 대기중...");
			sc= ss.accept();
			System.out.println("client 접속 성공");
			String [] arr = {"라면","햄버거","초밥","쌀국수","김치볶음밥","샌드위치"};
			Calendar ca = Calendar.getInstance();
			Random random = new Random(ca.getTimeInMillis());
			
			while(check) {
				is = sc.getInputStream();
				ir = new InputStreamReader(is);
				br = new BufferedReader(ir);
				os = sc.getOutputStream();
				ow = new OutputStreamWriter(os);
				bw = new BufferedWriter(ow);
				String msg=null;
				
				String num = br.readLine();
				//int select = Integer.parseInt(num);
				if(num.equals("1")) {
					int n = random.nextInt(6);
					msg=arr[n];
					bw.write(msg+"\r\n");
					bw.flush();
				}else if(num.equals("2")) {
					int n = random.nextInt(6);
					msg=arr[n];
					bw.write(msg+"\r\n");
					bw.flush();
				}else if(num.equals("3")) {
					System.out.println("프로그램을 종료합니다.");
					check = false;
					continue;
				}
			}
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				ir.close();
				is.close();
				bw.close();
				ow.close();
				os.close();
				sc.close();
				ss.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
