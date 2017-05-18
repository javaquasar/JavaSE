package com.javaquasar.java.core.chapter_15_Exception.multiple_exceptions;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Java Quasar on 16.05.17.
 */
/* Можно и вот так: EOFException и FileNotFoundException «обобщаем до» IOException, 
 * а InterruptedException «пропускаем нетронутым» (InterruptedException — НЕ потомок IOException)*/

public class MultipleExceptions_04 {
	public static void main(String[] args) throws IOException, InterruptedException {
		f0();
		f1();
		f2();
	}

	public static void f0() throws EOFException {
		// ...
	}

	public static void f1() throws FileNotFoundException {
		// ...
	}

	public static void f2() throws InterruptedException {
		// ...
	}
}
