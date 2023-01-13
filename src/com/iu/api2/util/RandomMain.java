package com.iu.api2.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class RandomMain {
	public static void main(String[] args) {
		Random random = new Random();
		//1000원 로또구매 1-45; 번호6개를 랜덤하게 추출 - 중복은 제거하면서
		
		//3. set : 중복없음 - 라이브러리 사용
		HashSet<Integer> hs = new HashSet<>();
		while(hs.size()<6) {
			hs.add(random.nextInt(45)+1); // 중복이 불가능하기 때문에 중복제거 코드가 필요없음
		}
		System.out.println(hs); // 참조변수 찍으면 저장데이터가 출력된다.
		
		
		//1.배열
//		int [] nums = new int[6]; // list와 다르게 크기가 정해져있다는 차이가 있다
//			for(int i=0;i<nums.length;i++) { // 꺼내쓰는 것이기 때문에 향상된 for문이 아님
//				nums[i] = random.nextInt(45)+1;
//				for(int j=0;j<i;j++) {
//					if(nums[j]==nums[i]) {
//						i--; // 다시 i번째를 뽑을 수 있게
//						break;
//					}
//				}
//			}
//		for(int i=0;i<nums.length;i++) {
//			System.out.print(nums[i]+" ");
//		}
		
		
		//2.ArrayList - collection
//		ArrayList<Integer> ar = new ArrayList<>(); // 몇개를 넣을지 모를때 사용 좋음
//		while(ar.size()<6) {
//			boolean check = true;
//			int n = random.nextInt(45)+1;
//			for(int i=0;i<ar.size();i++) {
//				if(n==ar.get(i)) {
//					check = false;
//					break;
//				}
//			}
//			if(check)
//				ar.add(n);
//		}	
//		for(int i=0;i<ar.size();i++) {
//			System.out.print(ar.get(i)+" ");
//		}
	}
}
