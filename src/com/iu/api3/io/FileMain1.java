package com.iu.api3.io;

import java.io.File;

public class FileMain1 {
	public static void main(String[] args) {
		//1. java.io.File 클래스
		//	 HDD에 파일과 폴더의 정보를 담을려고하는 클래스
		File file = new File("C:\\");
		
		System.out.println(file.isDirectory());
		System.out.println(file.isFile());
		System.out.println(file.length());
		System.out.println(file.exists());
		file.mkdir();
		
		if(!file.exists())
		file.mkdirs(); // 새 폴더 안에 새 폴더를 만들기 ㅜ이해서는 mkdirs()를 사용;
		//file.delete();
		
		String[] files = file.list();
		for(String name : files) {
		System.out.println(name);
		File f = new File("C:\\",name); // 절대경로  (부모경로,내결오) or (file,name)->(파일객체,내경로)
		System.out.println(f.isDirectory());
		}
		File [] fs = file.listFiles();
	}

}
