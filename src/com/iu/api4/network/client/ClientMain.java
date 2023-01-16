package com.iu.api4.network.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {
	public static void main(String[] args) {
		Socket sc = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		String msg;
		boolean check = true;
		Scanner scanner = new Scanner(System.in);
		
		try {
			
//서버 접속
			sc = new Socket("localhost",8282);
			System.out.println("server 접속 성공");
			while(check) {
				System.out.println("번호를 입력해주세요");
				int select = scanner.nextInt();
				os = sc.getOutputStream();
				ow = new OutputStreamWriter(os);
				bw = new BufferedWriter(ow);
				bw.write(select+"\r\n");
				switch(select) {
				case 1:
					while(true) {
					is = sc.getInputStream();
					ir = new InputStreamReader(is);
					br = new BufferedReader(ir);
					msg=br.readLine();
					if(msg==null)
						break;
					System.out.println(msg);
					}
					break;
				case 2:
					
				}
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
