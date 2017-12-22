package com.javaquasar.java.core.chapter_09_OOP.practice.task_6_04_calculation_function_of_the_fourth_degree;

import java.util.Scanner;

public class FourthDegree {
	
	private static Scanner s;
	
	public static void main(String[] args) {
		System.out.println("Нахождение корня четвертой степени");
        s = new Scanner(System.in);
        System.out.print("Введите число > 0 -> ");
        double number = s.nextDouble();
        try {
			System.out.println("Корень = " + getDegree(number));
		} catch (NumberIsNegative e) {
			System.err.println(e);
			System.err.println("Неверное число = " + e.getNumber());
		}
	}

	public static class NumberIsNegative extends Exception {
		
		private double number = 0;
		
		public NumberIsNegative(String message, double number) {
			super(message);
			this.number = number;
		}
		
		public double getNumber() {
			return number;
		}
	}

	public static double getDegree(double number) throws NumberIsNegative {
		if (number < 0) {
			throw new NumberIsNegative("Неверный аргумент ", number);
		} else {
			return Math.pow(number, 1.0/4); 
		}
	}
}
