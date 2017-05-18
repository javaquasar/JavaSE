package com.javaquasar.java.core.chapter_03_String.practice;

import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class NewtonRaphson {

	static final double DIFFERENCE = 0.00005;
	double n;
	double x;
	double derivative;
	double function;
	double xold;
	double xnew;
	int i;

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter a number you would like to find the square root of");
		int a = reader.nextInt();
		NewtonRaphson nr = new NewtonRaphson(5.0, a);
		nr.findSqRtA();
	}

	public NewtonRaphson(double n2, int x2) {
		n = n2;
		x = x2;
		function = Math.pow(n, 2) - x;
		derivative = 2 * n;
		xnew = n - function / derivative;
		xold = 0;
	}

	boolean positive() {
		return (n >= 0);
	}

	public double findXNew(double xold2) {
		function = Math.pow(xold2, 2) - x;
		derivative = 2 * xold2;
		return xold2 - function / derivative;
	}

	public void findSqRtA() {
		i = 0;
		while (Math.abs(xnew - xold) > DIFFERENCE) {
			xold = xnew;
			xnew = findXNew(xold);
			i++;
			System.out.println(this);
		}
		System.out
				.println("\nIteration completed, difference is less than 0.00005");

	}

	public String toString() {
		NumberFormat nf = NumberFormat.getInstance();
		DecimalFormat df = (DecimalFormat) nf;
		df.applyPattern("0.00000000");
		return "The approximate value of the square root of " + x + " is "
				+ xnew + "\nThe number of iterations is " + i;
	}
}
