package core.lecture2_02_Syntax.practice;

import java.util.Scanner;

public class Pow2 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите степень восьмерки от 0 до 10.");
		int exponent = scanner.nextInt();

		Pow2.powArithmetic(exponent, 8);
		Pow2.powBits(exponent, 8);

	}

	public static void powArithmetic(int exponent, int baseNumber) {

		if (exponent >= 0) {

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
		} else {
			System.out.println("Степень должна быть >= 0.");
		}
	}

	public static void powBits(int exponent, int baseNumber) {

		if (baseNumber % 2 == 0) {

			int tempBaseNumber = baseNumber;
			byte byteShift = 0;

			while (tempBaseNumber != 1) {
				tempBaseNumber /= 2;
				byteShift++;
			}

			if (exponent >= 0) {

				int i = 0;
				long temp = 0;
				while (i <= exponent) {

					if (i == 0) {
						temp = 1;
						System.out.println(baseNumber + "^" + i + "=" + temp);
					} else if (i == 1) {
						temp = baseNumber;
						System.out.println(baseNumber + "^" + i + "=" + temp);
					} else if (i > 0) {
						temp = (long) (temp << byteShift);
						System.out.println(baseNumber + "^" + i + "=" + temp);
					}

					i++;

				}
			} else {
				System.out.println("Степень должна быть >= 0.");
			}
		} else {
			System.out.println("Базовое число должно быть степенью двойки..");
		}

	}
}
