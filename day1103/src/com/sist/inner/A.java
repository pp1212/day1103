package com.sist.inner;

public class A {
	public String title="Hello";
	public void pro() {
		System.out.println("AŬ������ pro�Դϴ�.");
		
		//System.out.println(year);		
		//outterŬ������ innerŬ������ �ɹ��� �����Ӱ� ���� �� �� ����
		//�����Ϸ��� ��ü�� �����ϰ� ��ü�� ���ؼ� ������ �� ����
		B ob = new B();
		System.out.println(ob.year);
		ob.test();
	}
	
	class B{
		public int year=2021;
		public void test() {
			System.out.println("B�� test�Դϴ�.");
			System.out.println(title);	//innerŬ������ outterŬ������ �ɹ��� �����Ӱ� ������ �� ����
		}
	}
	
	public static void main(String[] args) {
		A a = new A();
		a.pro();
		//A.B b = new A.B();
		
	}
}


