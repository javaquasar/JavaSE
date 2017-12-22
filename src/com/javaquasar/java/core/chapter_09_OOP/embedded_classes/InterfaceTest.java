package com.javaquasar.java.core.chapter_09_OOP.embedded_classes;

public class InterfaceTest {

	public static void main(String[] args) {
		try {
			System.out.println(Solver.solve(0, 2, 0.000001,
					new Solver.Function() {
						public double f(double x) {
							return x * x - 2;
						}
					}));
		} catch (Solver.EquationError err) {
			err.printError();
		}
	}

}
