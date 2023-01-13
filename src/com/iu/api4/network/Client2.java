package com.iu.api4.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
	public static void main(String[] args) {
		//1. 서버 접속 시도
		//2. 1.점심, 2. 저녁, 3.종료 출력
		//3. 선택하기
		//	1번 : 서버에서 점심메뉴 중 하나를 보내줌, 출력
		//	2번 : 서버에서 저녁메뉴 중 하나를 보내줌, 출력
		//	3번 : 둘다 종료
		Socket sc = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br=null;
		Scanner scanner = new Scanner(System.in);
		boolean check = true;
		
		try {
			sc = new Socket("localhost",8282);
			System.out.println("server 접속 성공");
			while(check) {
				System.out.println("1.점심, 2. 저녁, 3.종료");
				os = sc.getOutputStream();
				ow = new OutputStreamWriter(os);
				bw = new BufferedWriter(ow);
				String msg = scanner.next();
				switch(msg) {
				case "1" :
					System.out.println("점심 메뉴입니다.");
					bw.write(msg+"\r\n");
					bw.flush();
					break;
				case "2" :
					System.out.println("저녁 메뉴입니다.");
					bw.write(msg+"\r\n");
					bw.flush();
					break;
				case "3" :
					System.out.println("프로그램을 종료합니다.");
					bw.write(msg+"\r\n");
					bw.flush();
					check = false;
					break;
				}
				if(check==false)
					continue;
				
					is = sc.getInputStream();
					ir = new InputStreamReader(is);
					br = new BufferedReader(ir);
					msg=br.readLine();
					System.out.println(msg);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				ir.close();
				is.close();
				bw.close();
				ow.close();
				os.close();
				sc.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
