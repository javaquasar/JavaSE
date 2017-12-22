package com.javaquasar.java.core.chapter_09_OOP.practice.task_6_05_min_function;


public class Specific {
	
	static double showMinFunction(MinFunction b) {
		return b.solve();
	}

	public static void main(String[] args){
		double x = showMinFunction(new MinFunction(10, 50, 0.00005) {
			@Override
			double findMin(double x){
				return x*x + 2*x - Math.cos(x)*x;
			}

			@Override
			public double solve() {
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
		});
		System.out.println("Минимум функции " + x);
	}
}
