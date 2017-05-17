package com.javaquasar.java.core.chapter_14_Exception;

/**
 * Created by Java Quasar on 16.05.17.
 */
/*Обратите внимание, мы не напечатали «3», хотя у нас летит Error а «ниже» расположен catch по Error. 
 * Но важный момент в том, что catch имеет отношение исключительно к try-секции, но не к другим catch-секциям.*/
public class SkipErrors {
	public static void main(String[] args) {
		try {
			System.err.print(" 0");
			if (true) {
				throw new RuntimeException();
			}
			System.err.print(" 1");
		} catch (RuntimeException e) { // перехватили RuntimeException
			System.err.print(" 2");
			if (true) {
				throw new Error();
			} // и бросили новый Error
		} catch (Error e) { // хотя есть cath по Error "ниже", но мы в него не
							// попадаем
			System.err.print(" 3");
		}
		System.err.println(" 4");
	}
}
