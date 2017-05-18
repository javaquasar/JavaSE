package com.javaquasar.java.core.chapter_03_String;

import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class Reciprocal {
	// Обратная величина:
	static Double reciprocal(double x) {
		if (x == 0)
			return null;
		return 1 / x;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double x = s.nextDouble();
		Double y = reciprocal(x);
		if (y == null)
			System.out.println("Ошибка");
		else
			System.out.println(y);
	}
}
