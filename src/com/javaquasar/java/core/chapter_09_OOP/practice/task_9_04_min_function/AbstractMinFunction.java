package com.javaquasar.java.core.chapter_09_OOP.practice.task_9_04_min_function;

public abstract class AbstractMinFunction {

	abstract double findMin(double x);

	public double solve(double a, double b, double eps) {

		double temp = 0;
		
		if (a > b) {
			temp = b;
			b = a;
			a = temp;
		}
		temp = findMin(a);
		for(double i = a; a < b; a += eps) {
			if(temp > findMin(i)) {
				temp = findMin(i);
			}
		}
		return temp;
	}
}
