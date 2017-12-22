package com.javaquasar.java.core.chapter_06_Methods.practice;

import java.util.Scanner;

public class PiNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите eps.");
		double eps = scanner.nextDouble();
		double pi = 3;
		double temp = eps;
		int i = 0;
		while (temp >= eps) {
			System.out.println("i=" + i);
			if (i > 0) {
				temp = 4.0 / ((i * 2) * (i * 2 + 1) * (i * 2 + 2));
			}
			System.out.println("temp=" + temp);
			if ((i > 0) && (i % 2 == 1)) {
				pi += temp;
			} else if ((i > 0) && (i % 2 == 0)) {
				pi -= temp;
			}
			i++;
		}
		System.out.print("pi = " + pi);
	}
}
