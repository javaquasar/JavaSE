package com.javaquasar.java.core.chapter_06_Loops.example;

import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class PowersOfTwo {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите n в диапазоне от 0 до 30");
		int n = scanner.nextInt();
		if (n < 0 || n > 30)
			System.err.println("Неправильное значение n!");
		else {
			for (int i = 0; i <= n; i++) {
				System.out.printf("2 ^ %3d = %d\n", i, 1 << i);
			}
		}
	}

}
