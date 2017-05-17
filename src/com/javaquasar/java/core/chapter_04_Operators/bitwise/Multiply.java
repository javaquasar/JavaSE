package com.javaquasar.java.core.chapter_04_Operators.bitwise;

/**
 * Created by Java Quasar on 16.05.17.
 */
/* Напишите программу, перемножающую два натуральных числа, 
 * которая не использует операции умножения, и имеет при 
 * этом логарифмическую сложность.*/

public class Multiply {

	public static void main(String args[]) {
		int i = 10;
		int j = 35;
		while (i != 0 && j > 0) {
			System.out.println(i << j);
			i++;
			j--;
		}
		System.out.println(i);
		System.out.println(j);
	}

}
