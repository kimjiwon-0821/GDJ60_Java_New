package com.iu.api2.collections;

import java.util.HashSet;
import java.util.Iterator;

public class SetMain {
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<>();
		hs.add(1);
		hs.add(11);
		hs.add(11);//중복되어서 무시됨.
		hs.add(2);
		hs.remove(1); // 인덱스번호가 없음 -> 데이터값으로 삭제
		System.out.println(hs);//주소가 아닌 대입한 값이 출력되었다 -> toString을 오버라이딩하였다
		System.out.println(hs.size());
		
		//set의 data들을 Iterator 형식으로 묶어 변경해야 꺼내쓸수있음
		//인터페이스의 변수선언
		Iterator<Integer> is = hs.iterator(); // ->다형성
		while(is.hasNext()) {
			Integer num = is.next();
			System.out.println(num);
		}
		
		
		
	}

}
