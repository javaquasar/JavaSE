package com.javaquasar.java.core.chapter_06_Methods.practice;

import java.util.Scanner;

public class ToBinary2 {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int b = scanner.nextInt();
		System.out.println(binar(b));
	}

	public static String binar(int a) {
		int b;
		String temp = "";
		while (a != 0) {
			b = a % 2;
			temp = b + temp;
			a /= 2;
		}
		return temp;
	}

}
