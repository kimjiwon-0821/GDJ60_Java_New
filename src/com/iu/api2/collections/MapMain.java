package com.iu.api2.collections;

import java.util.HashMap;
import java.util.Iterator;

public class MapMain {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		//데이터추가
		map.put("k1", "v1");
		map.put("k2", "v2");
		map.put("k3", "v3");
		map.put("k2", "v2RE"); // 같은 key가 있으면 value 수정
		
		//데이터 조회
		String v = map.get("k3");
		
		//삭제
		//map.remove("k2");//키를 삭제하여 값까지 삭제
		//map.clear();//전부 삭제
		
		boolean check = map.containsKey("k1");
		System.out.println(check);
		
		check = map.containsKey("v1");
		System.out.println(check);
		
		//반복
		//1.key들의 정보를 알아야 함
		//  key들을 set으로 변환
		//  set을 Iterator로 변환	
		Iterator<String> it =map.keySet().iterator();
		while(it.hasNext()) {
			String key=it.next();
			System.out.println("key : "+key);
			String value = map.get(key);
			System.out.println("value : "+value);
		}
		
		
		System.out.println(map);
		System.out.println(v);
		
		//수정은 그냥 같은 키값을 사용하여 함/
		
		//순서가 유지되지 않기때문에 끼워넣기 메소드 없음
		
	}

}
