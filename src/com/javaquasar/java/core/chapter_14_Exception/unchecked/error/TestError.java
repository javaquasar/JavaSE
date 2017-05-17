package com.javaquasar.java.core.chapter_14_Exception.unchecked.error;

/**
 * Created by Java Quasar on 16.05.17.
 */
// необрабатываемые ошибки не требуют отловки
public class TestError {

	public static void main(String[] args) {
		throw new Error();
	}
}

/*
 * OutOfMemoryError (кончилась память) 
 * AssertionError (ошибка в условии оператора assert, начиная с Java 1.4) 
 * ThreadDeath (кидается в останавливаемом потоке, при вызове у него метода stop() 
 * NoSuchMethodError (обычно отсутствует метод main) 
 * NoClassDefFoundError (отсутствует код загружаемого класса)
 */

/* ThreadDeath - вызывается при неожиданной остановке потока посредством метода Thread.stop().
 * StackOverflowError - ошибка переполнение стека. Часто возникает в рекурсивных функциях из-за неправильного условия выхода.
 * OutOfMemoryError - ошибка переполнения памяти.*/
