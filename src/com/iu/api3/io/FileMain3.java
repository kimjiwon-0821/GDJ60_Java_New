package com.iu.api3.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileMain3 {
	public static void main(String[] args) {
		File file = new File("C:\\fileTest","test.txt");
		
		try {
			FileReader fr = new FileReader(file);
			//보조스트림
			BufferedReader br = new BufferedReader(fr);
			while(true) {
				String name = br.readLine();
				if(name==null)
					break;
				System.out.println(name);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	}

}
