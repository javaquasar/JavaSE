package com.javaquasar.java.core.chapter_32_Java_8.practice;

public interface FunctionToSolve {
	
	double f(double x);

	static double solve(double a, double b, double eps, FunctionToSolve func) {
		double x;
		while (a - b > eps) {
			x = (a + b) / 2;
			if (func.f(a) * func.f(x) < 0) {
				a = x;
			} else {
				b = x;
			}
		}
		return (a + b) / 2;
	}
}
