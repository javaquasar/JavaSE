package com.javaquasar.java.core.chapter_08_Look_at_Classes_and_Objects.example;

public class Fraction {
	private int n, d;

	public Fraction() {
		n = 0;
		d = 1;
	}

	public Fraction(int numerator, int denominator) {
		if (denominator <= 0) {
			System.err.println("Знаменатель неположительный!");
			System.exit(1);
		}
		n = numerator;
		d = denominator;
	}

	public int getDenominator() {
		return d;
	}

	public int getNumerator() {
		return n;
	}

	public void set(int numerator, int denominator) {
		if (denominator <= 0) {
			System.err.println("Знаменатель неположительный!");
			System.exit(1);
		}
		n = numerator;
		d = denominator;
	}

	public String toString() {
		return n + "/" + d;
	}

	public static Fraction sum(Fraction a, Fraction b) {
		Fraction c = new Fraction();
		c.n = a.n * b.d + a.d * b.n;
		c.d = a.d * b.d;
		c.reduce();
		return c;
	}

	Fraction reduce() {
		int num = n, den = d;
		while (num != den) {
			if (num > den)
				num -= den;
			else
				den -= num;
		}
		n /= num;
		d /= num;
		return this;
	}

	public static void main(String[] args) {
		Fraction a = new Fraction(10, 20);
		System.out.println("a = " + a.reduce());
		Fraction b = new Fraction(1, 3);
		System.out.println("b = " + b.reduce());
		System.out.println("a + b = " + sum(a, b));
	}
}
