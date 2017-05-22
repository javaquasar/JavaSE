package com.javaquasar.java.core.chapter_06_Loops.example;

import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class Product2 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите x, k и n:");
		double x = scanner.nextDouble();
		int k = scanner.nextInt();
		int n = scanner.nextInt();
		double y = 1;
		for (int i = 0; i <= n; i++) {
			if (i != k)
				y *= (x + i);
		}
		System.out.println("y = " + y);
	}
}
