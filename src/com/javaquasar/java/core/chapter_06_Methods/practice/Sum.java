package com.javaquasar.java.core.chapter_06_Methods.practice;

import java.util.Scanner;

public class Sum {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите n.");
		int n = scanner.nextInt();
		double y = 0;
		int i = 0;
		for (i = 1; i <= n; i++) {

			y += 1.0 / i;
			
		}
		
		if (i > n) {// сумма посчитана
			System.out.print("Первый способ y = ");
			System.out.printf("%.3f%n", y);
		}

		y = 0;
		int j = 1;
		while (j <= n) {
			y += 1.0 / j;
			j++;
		}
		if (j > n) {// сумма посчитана
			System.out.print("Второй способ y = ");
			System.out.printf("%.3f%n", y);
		}
		
		
		y = 0;
		int k = 1;
		do {
			y += 1.0 / k;
			k++;
		} while (k <= n);
		if (k > n) {// сумма посчитана
			System.out.print("Второй способ y = ");
			System.out.printf("%.3f%n", y);
		}
	}

}
