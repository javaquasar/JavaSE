package com.javaquasar.java.core.chapter_31_Java_8.example;

public class PrintValues {

	public static void print(double from, double to, double step, Function func) {
		for (double x = from; x <= to; x += step) {
			System.out.printf("x = %7f f(x) = %7f%n", x, func.f(x));
		}
		System.out.println();
	}

	public static void main(String[] args) {
		print(-2, 2, 0.5, new Function() {
		}); // Используем функцию по умолчанию
		print(-2, 2, 0.5, new Function() {
			@Override
			public double f(double x) {
				return x * x * x;
			}
		});
	}

}
