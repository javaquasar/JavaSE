package com.javaquasar.java.core.chapter_31_Java_8.practice;

/*5.2 Минимум функции с использованием лямбда-выражений*

Реализовать программу нахождения минимума функции с использованием лямбда-выражений.*/

public class SolveUsingLambda {
	public static void main(String[] args) {
		System.out.println(FunctionToSolve.solve(0, 10, 0.000001, x -> x * x + Math.cos(2.0*x)));
	}
}
