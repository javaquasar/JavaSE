package com.javaquasar.java.core.chapter_01_Start;

import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class Average {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите a и b: ");
		double a = scanner.nextDouble();
		double b = scanner.nextDouble();
		double c = (a + b) / 2;
		System.out.println("Среднее арифметическое: " + c);
	}

}
