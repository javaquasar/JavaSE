package com.javaquasar.java.core.chapter_15_Exception;

/**
 * Created by Java Quasar on 16.05.17.
 */
class Exc0 {
	public static void main(String args[]) {
		int d, a;
		try { // monitor a block of code.
			d = 0;
			a = 42 / d;
			System.out.println("This will not be printed.");
			throw new ArithmeticException();
		//} catch (ArithmeticException e) { // catch divide-by-zero error
			//System.out.println("Division by zero.");
		} finally {
			System.out.println("finally");
		}
	}
}
