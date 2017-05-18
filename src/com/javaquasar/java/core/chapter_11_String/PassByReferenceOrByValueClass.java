package com.javaquasar.java.core.chapter_11_String;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class PassByReferenceOrByValueClass {
	public static void main(String[] args) {
		A testClass = new A();
		testClass.name = "A";
		System.out.println(testClass.name);
		f(testClass);
		System.out.println(testClass.name);
	}

	static void f(A classA) {
		classA.name = "new A";
	}
}

class A {
	public String name;
}
