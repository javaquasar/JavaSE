package com.javaquasar.java.core.chapter_15_Exception.multiple_exceptions;

import java.io.EOFException;
import java.io.FileNotFoundException;

/**
 * Created by Java Quasar on 16.05.17.
 */
/*Рассмотрим ситуацию с кодом, который может бросать проверяемые исключения разных типов. 
 Далее учитывайте, что EOFException и FileNotFoundException — потомки IOException.

 Мы можем точно указать, что выбрасываем*/

public class MultipleExceptions_02 {
	// пугаем ОБОИМИ исключениями
	public static void main(String[] args) throws EOFException, FileNotFoundException {
		f0();
		f1();
	}

	public static void f0() throws EOFException {
		// ...
	}

	public static void f1() throws FileNotFoundException {
		// ...
	}
}
