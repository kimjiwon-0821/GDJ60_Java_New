package com.iu.api4.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket =null; // exception발생할 수 있기 때문에 close를 위해 위에 생성
		OutputStream os =null;
		OutputStreamWriter ow = null;
		BufferedWriter bw =null;
		Scanner sc = new Scanner(System.in);
		InputStream is=null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		boolean check = true;
		try {
			//객체 생성시 서버 접속 시도
			socket = new Socket("127.0.0.1",8282);//127.0.0.1 -> 무조건 자신의 컴퓨터를 가르키는 ip주소(어떤 컴퓨터든) or localhost
			System.out.println("Server 접속 성공");
			
			while(check) {
				//메시지 보내기
				//0,1
				os = socket.getOutputStream();
				//char
				ow = new OutputStreamWriter(os);
				//stream
				bw = new BufferedWriter(ow);
				
				System.out.println("서버에게 보낼 메세지 입력");
				String msg = sc.next();
				bw.write(msg+"\r\n");
				bw.flush();	
				if(msg.toUpperCase().equals("Q")) {
					System.out.println("프로그램을 종료합니다.");
					check= false;
					continue;
				}
	
				
				//메시지 받기
				is=socket.getInputStream();
				ir = new InputStreamReader(is);
				br = new BufferedReader(ir);
				
				msg = br.readLine();
				if(msg.toUpperCase().equals("Q")) {
					System.out.println("Server에의해 프로그램이 종료되었습니다.");
					check = false;
					continue;
				}
				System.out.println("Server : "+msg);
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
				socket.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
