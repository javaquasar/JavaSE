package com.javaquasar.java.core.chapter_14_Exception.unchecked.runtime_exception;

/**
 * Created by Java Quasar on 16.05.17.
 */
//необрабатываемые ошибки не требуют отловки
public class TestRuntimeException {

	public static void main(String[] args) {
		throw new RuntimeException(); 
	}

}

/* IndexOutOfBoundsException - выбрасывается, когда индекс некоторого элемента в структуре данных(массив/коллекция) не попадает в диапазон имеющихся индексов.
 * NullPointerException - ссылка на объект, к которому вы обращаетесь хранит null/
 * ClassCastException – Ошибка приведения типов. Всякий раз при приведении типов делается проверка на возможность приведения (проверка осуществляется с помощью instanceof.
 * ArithmeticException - бросается когда выполняются недопустимые арифметические операции, например деление на ноль.*/
