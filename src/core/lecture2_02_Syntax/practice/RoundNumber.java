package core.lecture2_02_Syntax.practice;

import java.math.BigDecimal;
import java.util.Scanner;

public class RoundNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Введите число.");
		double number = scanner.nextDouble();
		System.out.println("Введите точность.");
		int digit = scanner.nextInt();
		BigDecimal roundNumber = RoundNumber.numberRound(number, digit);
		System.out.println(roundNumber);
		// System.out.printf("%.3f%n", number);

	}

	public static BigDecimal numberRound(double value, int digit) {

		// we approximate the transferred number "value" with accuracy "digits"
		BigDecimal num = new BigDecimal("" + value).setScale(digit,
				BigDecimal.ROUND_HALF_UP);
		return num;
	}

}
