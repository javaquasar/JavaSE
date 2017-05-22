package com.javaquasar.java.core.chapter_06_Loops.example;

import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class Powers {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите n в диапазоне от 0 до 30");
		int n = scanner.nextInt();
		int power = 1;
		final int k = 2;
		if (n < 0 || n > 30)
			System.err.println("Неправильное значение n");
		else {
			for (int i = 0; i <= n; i++) {
				System.out.printf("2 ^ %2d = %d\n", i, power);
				power *= k;
			}
		}
	}

}