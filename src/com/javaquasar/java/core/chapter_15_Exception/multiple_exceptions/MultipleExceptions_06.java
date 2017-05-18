package com.javaquasar.java.core.chapter_15_Exception.multiple_exceptions;

import java.io.EOFException;
import java.io.FileNotFoundException;

/**
 * Created by Java Quasar on 16.05.17.
 */
/* Если вы часть перехватили, то можете этим не пугать*/

public class MultipleExceptions_06 {
	// EOFException перехватили catch-ом, им не пугаем
	public static void main(String[] args) throws FileNotFoundException {
		try {
			if (System.currentTimeMillis() % 2 == 0) {
				throw new EOFException();
			} else {
				throw new FileNotFoundException();
			}
		} catch (EOFException e) {
			// ...
		}
	}
}
