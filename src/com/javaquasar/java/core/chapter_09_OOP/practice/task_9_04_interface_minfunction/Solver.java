package com.javaquasar.java.core.chapter_09_OOP.practice.task_9_04_interface_minfunction;

public class Solver {

	static double solve(double a,double b, double eps, Function func){
		double x;
		  while (a - b > eps) {
		      x = (a + b) / 2;
		      if (func.f(a) * func.f(x) < 0){
		         a = x;
		      }
		      else{
		         b = x;
		      }
		   }
		   return (a + b) / 2;
	}
}
