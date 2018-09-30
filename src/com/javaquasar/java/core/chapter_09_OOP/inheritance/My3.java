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

		System.out.println(objectA.count);
		B objectB = new C();
		A objectB_A = objectB;
		
		objectB.a();
		objectB_A.a();
		objectB.b();

		//Object n = new C();
		C mC = (C) objectB;
		mC.c();
		A mA = objectB;
		mA.a();
		A objectA2= new My3.A(10);
		System.out.println(mC instanceof A); // true
		System.out.println(objectA2 instanceof C); // false
		System.out.println(mA instanceof C); // true
		A aA = new A(10);
		//C cC = (C) aA;
		//cC.c(); // java.lang.ClassCastException

		for(int i = 0; i < 1_000_000; i++) {
			A a = new A(10);
			System.out.println("count = " + a.count);
		}
		System.gc();
		while(true) {

		}
	}

	public static class A {

		public int d;

		public static int count = 0;

		static {
			//count = 10;
			System.out.println("count = " + count);
		}
		
		public A(int a) {
			count++;
			d = 10;
			System.out.println("конструктор A");
		}

		public static void a() {
			System.out.println("A.a");
		}

		@Override
		protected void finalize() throws Throwable {
			super.finalize();
			count--;
			System.out.println("count finalize = " + count);
		}
	}

	public static class B extends A {
		
		public B() {
			super(10);
			System.out.println("конструктор B");
		}

		public static void a() {
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

		@Override
		public void b() {
			System.out.println("C.b");
		}

		public void c() {
			System.out.println("C.c");
		}

	}

}
