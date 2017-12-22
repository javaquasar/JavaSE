package com.javaquasar.java.core.chapter_06_Methods.practice;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите последнее число.");
		int number = scanner.nextInt();
		printPrimeNumber(number);
	}

	public static void printPrimeNumber(int number) {
		if (number < 0) {
			number = -1 * number;
		}
		for (int i = 1; i <= number; i++) {
			if (isPrimeNumber(i)) {
				System.out.println(i);
			}
		}
	}

	public static boolean isPrimeNumber(int number) {
		if (number < 2) {
			return false;
		} else {

			for (int i = 2; i * i <= number; i++) {
				if (number % i == 0) {
					return false;
				}
			}
		}
		return true;
	}
}
