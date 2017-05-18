package com.javaquasar.java.core.chapter_31_Java_8.function_for_lamda;

public class PrintWithLambda {
	public static void print(double from, double to, double step, FuncForLambda func) {
		for (double x = from; x <= to; x += step) {
			System.out.printf("x = %8.5f  f(x) = %8.5f%n", x, func.f(x));
		}
		System.out.println();
	}

	public static void main(String[] args) {
		print(-2.0, 2.0, 0.5, x -> x * x * x);
	}
}
