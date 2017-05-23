package com.javaquasar.java.core.chapter_09_OOP.implementation;

/**
 * Created by Java Quasar on 16.05.17.
 */
/*Какое значение приймет переменная text в 
 * классе Implementor? Что выведется на экран?*/
interface A {
	String text = "a";
}

interface B {
	String text = "b";
}

public class ImplementorVariables implements A, B {
	public static void main(String[] args) {
		// System.out.println(Implementor.text); // Выдаст ошибку
		System.out.println(((A) new ImplementorVariables()).text); // Выведет "a"
		System.out.println(((B) new ImplementorVariables()).text); // Выведет "b"
	}
}
