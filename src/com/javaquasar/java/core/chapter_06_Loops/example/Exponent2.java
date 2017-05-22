package com.javaquasar.java.core.chapter_06_Loops.example;

import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class Exponent2 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double x = scanner.nextDouble();
		double z = 1; // слагаемое
		double y = 0;
		for (int i = 1; z > 0.00001; i++) {
			y += z;
			z *= x / i;
		}
		System.out.println("y = " + y);
	}
}
