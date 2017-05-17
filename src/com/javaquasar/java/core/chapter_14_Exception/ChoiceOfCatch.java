package com.javaquasar.java.core.chapter_14_Exception;

/* Выбор catch осуществляется в runtime (а не в compile-time), 
 * значит учитывается не тип ССЫЛКИ (Throwable), а тип ССЫЛАЕМОГО (Exception)*/

/**
 * Created by Java Quasar on 16.05.17.
 */
public class ChoiceOfCatch {
	public static void main(String[] args) {
		try {
			Throwable t = new Exception(); // ссылка типа Throwable указывает на
											// объект типа Exception
			throw t;
		} catch (RuntimeException e) {
			System.err.println("catch RuntimeException");
		} catch (Exception e) {
			System.err.println("catch Exception");
		} catch (Throwable e) {
			System.err.println("catch Throwable");
		}
		System.err.println("next statement");
	}
}
