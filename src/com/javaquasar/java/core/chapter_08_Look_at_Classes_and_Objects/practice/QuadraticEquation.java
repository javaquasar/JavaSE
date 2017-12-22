package com.javaquasar.java.core.chapter_08_Look_at_Classes_and_Objects.practice;

import java.util.Scanner;

public class QuadraticEquation {

	private double a, b, c;

	private Double x1, x2;
	
	private double discriminant;
	
	private boolean work = true;

	private static Scanner s;

	public static void main(String[] args) {
		System.out.println("Решение квадратного уравнения");
        s = new Scanner(System.in);
        System.out.print("Введите значение a -> ");
        double a = s.nextFloat();
        System.out.print("Введите значение b -> ");
        double b = s.nextFloat();
        System.out.print("Введите значение c -> ");
        double c = s.nextFloat();
        System.out.println("a = " + a + " b = " + b + " c = " + c);
        QuadraticEquation eq = new QuadraticEquation(a, b, c);
        System.out.println("х1 = " + eq.getX1());
        System.out.println("х2 = " + eq.getX2());
        System.out.println("дискриминант = " + eq.getDiscriminant());
	}
	
	public QuadraticEquation(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	private void solve() {
		discriminant = (b * b) - (4 * a * c);
		if (discriminant < 0) {
		} else if(a == 0) {
			x1 = null;
			x2 = null;
		}else if (discriminant == 0) {
			x1 = (-b) / (2 * a);
			x2 = x1;
		} else {
			x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
			x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
		}
	}

	public double getDiscriminant() {
		if(work) {
			solve();
		}
		return discriminant;
	}

	public Double getX1() {
		if(work) {
			solve();
		}
		return x1;
	}

	public Double getX2() {
		if(work) {
			solve();
		}
		return x2;
	}

	public void setA(double a) {
		work = false;
		this.a = a;
	}

	public void setB(double b) {
		work = false;
		this.b = b;
	}

	public void setC(double c) {
		work = false;
		this.c = c;
	}

}
