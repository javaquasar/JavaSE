package com.javaquasar.java.core.chapter_09_OOP.embedded_classes;

public class Solver {

	public interface Function {
		double f(double x);
	}

	public static class EquationError extends Exception {
		public void printError() {
			System.out.println("Wrong data!");
			System.exit(1);
		}
	}

	static double solve(double a, double b, double eps, Function func)
			throws EquationError {
		if (a >= b || func.f(a) * func.f(b) > 0)
			throw new EquationError();
		double x = (a + b) / 2;
		while (Math.abs(b - a) > eps) {
			if (func.f(a) * func.f(x) > 0) {
				a = x;
			} else {
				b = x;
			}
			x = (a + b) / 2;
		}
		return x;
	}

}
