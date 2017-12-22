package com.javaquasar.java.core.chapter_06_Methods.practice;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class FibonacciFinal {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите последнее число.");
		int number = scanner.nextInt();
		fibDemo(number);
	}

	private static void fibDemo(int index) {

		SortedSet<Long> intset = new TreeSet<Long>();

		long startTime1 = System.currentTimeMillis();
		long fibR = fibRecursion(index, intset);
		for (Long e : intset) {
			if (e == 1) {
				System.out.println(1);
			}
			System.out.println(e);
		}
		//System.out.println(intset.toString());
		long timeSpent1 = System.currentTimeMillis() - startTime1;

		long startTime2 = System.currentTimeMillis();
		long fibC = fibCycle(index);
		long timeSpent2 = System.currentTimeMillis() - startTime2;

		System.out.println(fibR + " - рекурсивно за " + timeSpent1
				+ " миллисекунд");
		System.out.println(fibC + " - циклически за " + timeSpent2
				+ " миллисекунд");
	}

	// Этот подход использует рекусрию
	private static long fibRecursion(int index, SortedSet<Long> intset) {

		long result = 0;

		if (index == 1) {
			result = 0;
		} else if (index == 2) {
			result = 1;
		} else {
			result = fibRecursion(index - 1, intset)
					+ fibRecursion(index - 2, intset);
		}

		intset.add(result);
		return result;
	}

	// Этот подход к вычислению называется динамическое программирование
	// снизу-вверх
	private static long fibCycle(int index) {

		long a = 0, b = 1;
		long fib = 2, i = 1;
		while (i <= index) {

			if (i == 1) {
				fib = a;
			} else if (i == 2) {
				fib = b;
			} else {
				fib = a + b;
				a = b;
				b = fib;
			}
			System.out.println(fib);
			i++;
		}
		return fib;
	}

	private static int fibEndNumber(int index) {
		int a = 1, b = 1;
		int fib = 2, i = 2;
		while (i < index) {
			fib = a + b;
			if (fib > 10)
				fib = fib % 10;
			else if (fib == 10)
				fib = 0;
			a = b;
			b = fib;
			i++;
		}

		if (index <= 0) {
			return 0;
		} else if (index == 1) {
			return 1;
		} else if (index == 2) {
			return 1;
		} else {
			return fib;
		}
	}

}
