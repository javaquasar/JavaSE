package core.lecture2_02_Syntax.practice;

import java.util.Scanner;

public class Pow {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите степень восьмерки от 0 до 10.");
		int exponent = scanner.nextInt();
		double y = 1;
		Pow.powArithmetic(10, 8);
		int i = 0;
		double temp = 0;
		while (i <= exponent) {

			if (i == 0) {
				temp = 1;
				System.out.println("8^" + i + "=" + temp);
				temp = 8;
			} else if (i == 1) {
				temp = 8;
				System.out.println("8^" + i + "=" + temp);
			} else if (i > 0) {
				temp *= 8;
				System.out.println("8^" + i + "=" + temp);
			}

			i++;

		}

		powArithmetic(10, 8);

	}

	public static void powArithmetic(int exponent, int baseNumber) {

		if (exponent < 0) {

			int i = 0;
			double temp = 0;
			while (i <= exponent) {

				if (i == 0) {
					temp = 1;
					System.out.println(baseNumber + "^" + i + "=" + temp);
				} else if (i == 1) {
					temp = baseNumber;
					System.out.println(baseNumber + "^" + i + "=" + temp);
				} else if (i > 0) {
					temp *= baseNumber;
					System.out.println(baseNumber + "^" + i + "=" + temp);
				}

				i++;

			}
		}
	}
}
