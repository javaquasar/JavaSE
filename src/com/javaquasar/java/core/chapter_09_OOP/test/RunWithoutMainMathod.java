package com.javaquasar.java.core.chapter_09_OOP.test;

/**
 * Created by Java Quasar on 16.05.17.
 */
// Как выполнить действие java приложения без main метода
class RunApp {
	static {
		System.out.println("Я прекрасно работаю без main метода");
		System.exit(0);
	}
}

public class RunWithoutMainMathod {
	
	static RunApp run = new RunApp();
	
	public static void main (String[] args) {
		System.out.println("Эту строку мы не увидим");
	}
}
