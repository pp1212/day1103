package com.sist.inner;

public class A {
	public String title="Hello";
	public void pro() {
		System.out.println("A클래스의 pro입니다.");
		
		//System.out.println(year);		
		//outter클래스는 inner클래스의 맴버에 자유롭게 접근 할 수 없음
		//접근하려면 객체를 생성하고 객체를 통해서 접근할 수 있음
		B ob = new B();
		System.out.println(ob.year);
		ob.test();
	}
	
	class B{
		public int year=2021;
		public void test() {
			System.out.println("B의 test입니다.");
			System.out.println(title);	//inner클래스는 outter클래스의 맴버에 자유롭게 접근할 수 있음
		}
	}
	
	public static void main(String[] args) {
		A a = new A();
		a.pro();
		//A.B b = new A.B();
		
	}
}


