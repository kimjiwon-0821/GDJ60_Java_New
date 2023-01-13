package com.iu.api4.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket ss = null; // 
		Socket sc = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		Scanner scanner = new Scanner(System.in);
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		boolean check = true;
		try {
			ss = new ServerSocket(8282); //socket에서 사용할 포트번호 지정
			System.out.println("Client 접속을 기다리는 중...");
			sc = ss.accept(); //client가 실행되면 socket과 serverSocket을 연결
			System.out.println("Client 연결 성공");
			
			while(check) {
			//메시지 받기
				is =sc.getInputStream();
				ir = new InputStreamReader(is);
				br = new BufferedReader(ir);
				
				String msg = br.readLine();
				if(msg.toUpperCase().equals("Q")) {
					System.out.println("Clinet에의해 프로그램이 종료되었습니다.");
					check = false;
					continue;
				}
				System.out.println("Client : "+msg);
				
				//메시지 보내기
				os = sc.getOutputStream();
				ow = new OutputStreamWriter(os);
				bw = new BufferedWriter(ow);
				
				System.out.println("client에게 보낼 메세지");
				msg=scanner.next(); // 행바꿈하면 Buffer에 저장되는 것.
				bw.write(msg+"\r\n");
				bw.flush(); // buffer비우기
				if(msg.toUpperCase().equals("Q")) {
					System.out.println("프로그램을 종료합니다.");
					check = false;
					continue;
				}
			}
			
		} catch (Exception e) {
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
