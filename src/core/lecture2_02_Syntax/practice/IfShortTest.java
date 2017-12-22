package core.lecture2_02_Syntax.practice;

import java.util.Scanner;

public class IfShortTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Введите число x.");
		double x = scanner.nextDouble();
		int y = x < 0 ? -1 : (x == 0 ? 0 : 1);

		System.out.println(y);

	}
}
