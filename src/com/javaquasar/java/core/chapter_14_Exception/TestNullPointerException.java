package com.javaquasar.java.core.chapter_14_Exception;

/**
 * Created by Java Quasar on 16.05.17.
 */
//Кроме того, throw требуется не-null аргумент, иначе NullPointerException в момент выполнения
public class TestNullPointerException {
	public static void main(String[] args) {
		NullPointerException nullPointerException = new NullPointerException();
		getException(nullPointerException);
		getExceptionRecursion(null);
	}

	public static void getExceptionRecursion(NullPointerException e) {
		try {
			throw e;
		} catch (NullPointerException npe) {
			System.err.println("Привет getException()" + npe);
			getExceptionRecursion(npe);
		}
	}
	
	public static void getException(NullPointerException e) {
		try {
			throw e;
		} catch (NullPointerException npe) {
			System.err.println("Привет getException()" + npe);
		}
	}
}
