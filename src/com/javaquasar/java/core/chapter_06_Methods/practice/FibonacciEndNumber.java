package com.javaquasar.java.core.chapter_06_Methods.practice;

/*Задача на программирование. 
 * Дано число n (1≤n≤107), 
 * необходимо найти последнюю цифру n-го числа Фибоначчи.

Как мы помним, числа Фибоначчи растут очень 
быстро, поэтому при их вычислении нужно быть 
аккуратным с переполнением. В данной задаче, 
впрочем, этой проблемы можно избежать, 
поскольку нас интересует только последняя 
цифра числа Фибоначчи: если 0≤a,b≤9 – последние 
цифры чисел Fi и Fi+1 соответственно, то (a+b)mod10 – 
последняя цифра числа Fi+2.
Sample Input:
294590
Sample Output:
5
Memory Limit: 256 MB
Time Limit: 5 seconds*/

import java.util.Scanner;

public class FibonacciEndNumber {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int index = s.nextInt();
        
        int a = 1, b = 1;
	       int fib = 2, i = 2;
	       while (i < index) {
	           fib = a + b;
	           if (fib>10) fib = fib%10;
	           a = b;
	           b = fib;
	           i++;
	       }
	       
	       if (index <= 0) {
	    	   System.out.println(0);;
	       } else if (index == 1) {
	    	   System.out.println(1);;
	       } else if (index == 2) {
	    	   System.out.println(1);;
	       } else {
	    	   System.out.println(fib);
	       }
       

	}
	
}
