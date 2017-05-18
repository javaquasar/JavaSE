package com.javaquasar.java.core.chapter_15_Exception.multiple_exceptions;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Java Quasar on 16.05.17.
 */
/*Рассмотрим ситуацию с кодом, который может бросать проверяемые исключения разных типов. 
 Далее учитывайте, что EOFException и FileNotFoundException — потомки IOException.

 А можем «испугать» сильнее (предком обоих исключений)*/

public class MultipleExceptions_03 {
	// пугаем ПРЕДКОМ исключений
	public static void main(String[] args) throws IOException {
		if (System.currentTimeMillis() % 2 == 0) {
			f0();
			throw new EOFException();
		} else {
			f1();
			throw new FileNotFoundException();
		}
	}

	public static void f0() throws EOFException {
		// ...
	}

	public static void f1() throws FileNotFoundException {
		// ...
	}
}
