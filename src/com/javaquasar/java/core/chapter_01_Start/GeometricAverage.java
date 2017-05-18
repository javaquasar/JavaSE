package com.javaquasar.java.core.chapter_01_Start;

import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
/*Среднее геометрическое

 Реализовать алгоритм и программу, в которой вводится два числа и определяется 
 их среднее геометрическое - квадратный корень из их произведения. 
 Для обозначения умножения в Java, как и в других языках программирования, 
 используется знак *. Использовать форматированный вывод.*/

public class GeometricAverage {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите числа a и b: ");
		double a = scanner.nextDouble();
		double b = scanner.nextDouble();
		double c = Math.sqrt(a * b);
		System.out.print("Среднее геометрическое: ");
		System.out.printf("%.3f%n", c);
	}

}