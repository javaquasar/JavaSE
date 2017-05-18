package com.javaquasar.java.core.chapter_27_Java_8.practice;

import java.util.function.Function;

/*5.3 Минимум функции с использованием ссылок на методы*

Реализовать программу нахождения минимума функции с использованием ссылок на методы. 
Использовать стандартные функциональные интерфейсы пакета java.util.function.*/

public class SolveWithReference {
	
	public static double f(double x) {
		return x * x - 2;
	}
	
	static double solve(double a, double b, double eps, Function<Double, Double> func) {
		double x;
		while (a - b > eps) {
			x = (a + b) / 2;
			if (func.apply(a) * func.apply(x) < 0) {
				a = x;
			} else {
				b = x;
			}
		}
		return (a + b) / 2;
	}

	public static void main(String[] args) {
		Function<Double, Double> ms = SolveWithReference::f;
		System.out.println(solve(0, 5, 0.000001, ms));
	}
}
