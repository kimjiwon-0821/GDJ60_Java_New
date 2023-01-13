package com.iu.api2.collections.sample;

import java.util.ArrayList;

public class CollectionMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child1 child1 = new Child1();
		Child2 child2 = new Child2();
		
		ArrayList<Parent> ar = new ArrayList<>();
		ar.add(child1);
		ar.add(child2);
		
		//Child1 ch1 = (Child1)ar.get(0); // 폴리모프 -> 모든 ar이 Child1 타입은 아님.
		
		System.out.println(ar.get(0)instanceof Child1);//0번째 인덱스가 child1의 멤버입니까?
		ArrayList<? extends Parent> ar2 = new ArrayList<>(); //parent하고 상속받는 하위타입을 모으겠다.
		ArrayList<? super Parent> ar3 = new ArrayList<>(); // parent하고 그 부모타입을 모으겠다.
		
		

	}

}
