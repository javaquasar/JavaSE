package com.javaquasar.java.core.chapter_05_Conditional.example;

import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class LinearEquation {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double a = scanner.nextDouble();
		double b = scanner.nextDouble();
		if (a != 0) {
			double x = -b / a;
			System.out.println("Корень: " + x);
		} else {
			if (b == 0)
				System.out.println("Бесчисленное множество решений");
			else
				System.out.println("Нет решений");
		}
	}

}
