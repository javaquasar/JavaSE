package com.javaquasar.java.core.chapter_01_Start;

import java.util.Scanner;

public class SquareRoot {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		double y;
		if (x < 0)
			System.out.printf("Квадратный корень не может быть определен%n");
		else {
			y = Math.sqrt(x);
			System.out.printf("Квадратный корень: %f%n", y);
		}
	}

}