package com.javaquasar.java.core.chapter_09_OOP.inheritance;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class My3 {

	public static void main(String[] args) {
		// A nullPoint = null;
		// nullPoint.toString(); //NullPointerException
		
		//int[] masiv = {0, 1, 2};
		// masiv[4];
		// masiv[4] = 5; // ArrayIndexOutOfBoundsException
		//System.out.println(masiv[4]);

		A objectA = new B();
		objectA.a();
		
		B objectB = new C();
		A objectB_A = objectB;
		
		objectB.a();
		objectB.b();
		
		
		//Object n = new C();
		
		C mC = (C) objectB;
		mC.c();
		A mA = objectB;
		mA.a();
		A objectA2= new My3.A();
		System.out.println(mC instanceof A); // true
		System.out.println(objectA2 instanceof C); // false
		System.out.println(mA instanceof C); // true
		 A aA = new A();
		 C cC = (C) aA;
		 cC.c(); // java.lang.ClassCastException
		

	}

	public static class A {
		public int d;
		
		public A() {
			d = 10;
			System.out.println("конструктор A");
		}

		public static void a() {
			System.out.println("A.a");
		}
	}

	public static class B extends A {
		
		public B() {
			System.out.println("конструктор B");
		}

		public  static void a() {
			System.out.println("B.a");
		}

		public void b() {
			System.out.println("B.b");
		}
	}

	public static class C extends B {
		public C() {
			System.out.println("конструктор C");
		}

		public  static  void a() {
			System.out.println("C.a");
		}

		public void b() {
			System.out.println("C.b");
		}

		public void c() {
			System.out.println("C.c");
		}
	}

}
