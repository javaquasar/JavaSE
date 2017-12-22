package core.lecture2_03_Packages_and_functions.practice;

import java.util.Scanner;

public class PiNumberRecursion {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Введите последнее число.");
		double eps = scanner.nextDouble();
		double piPrint = pi(eps);
		System.out.println(piPrint);
	}

	static double pi(double eps, int i) {
		byte plusMinus = 0;
		if (i % 2 == 1) {
			plusMinus = 1;
		} else if (i % 2 == 0) {
			plusMinus = -1;
		}
		double temp = 4.0 / ((i * 2) * (i * 2 + 1) * (i * 2 + 2));
		if (temp < eps) {
			return temp;
		}
		return plusMinus * temp + pi(eps, i + 1);
	}

	static double pi(double eps) {
		return 3 + pi(eps, 1);
	}

}
