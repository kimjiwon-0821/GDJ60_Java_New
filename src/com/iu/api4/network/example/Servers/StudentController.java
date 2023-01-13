package com.iu.api4.network.example.Servers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class StudentController {
	private ServerSocket ss;
	private Socket socket;
	private StudentDAO studentDAO;
	
	public void start() throws Exception {
		ss = new ServerSocket(8282);
		socket = ss.accept();
		studentDAO = new StudentDAO();
		ArrayList<StudentDTO> ar =studentDAO.init();
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		
		is = socket.getInputStream();
		ir = new InputStreamReader(is);
		br = new BufferedReader(ir);
		os = socket.getOutputStream();
		ow = new OutputStreamWriter(os);
		bw = new BufferedWriter(ow);
		
		boolean check = true;
		while(check) {
		String select=br.readLine();//선택번호?데이터 -> 기준으로 코딩
		//파싱하면 잘린 데이터들이 서로 상관이 없기 때문에 split
		String [ ]s = select.split("-");
		
		switch (s[0]) {
			case "1": 
				select = studentDAO.makeList(ar);
				break;
			case "2":
				select = studentDAO.findbyname
				break;
			default:
				check = false;

		}
		if(check) {
			bw.write(select+"\r\n");
			bw.flush();
		}
		
		}
		
		
	}
}
