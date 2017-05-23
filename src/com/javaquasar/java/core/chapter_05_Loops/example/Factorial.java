package com.javaquasar.java.core.chapter_05_Loops.example;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class Factorial {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		BigInteger result = BigInteger.ONE;
		int n = new Scanner(System.in).nextInt();
		for (int i = 1; i <= n; i++) {
			result = result.multiply(new BigInteger(i + ""));
		}
		System.out.println(result);
	}

}
