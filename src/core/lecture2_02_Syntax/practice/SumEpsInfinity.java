package core.lecture2_02_Syntax.practice;

import java.util.Scanner;

public class SumEpsInfinity {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите eps.");
		double eps = scanner.nextDouble();
		double y = 1;
		double temp = eps;
		int i = 2;
		while (temp >= eps) {
			System.out.println("i=" + i);
			temp = 1.0 / i;
			System.out.println("temp=" + temp);
			y += temp;
			i *= 2;
		}
		System.out.print("y = ");
		System.out.printf("%.3f%n", y);

	}
}
