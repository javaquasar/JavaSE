package com.javaquasar.java.core.chapter_06_Methods.practice;

import java.util.Scanner;

/*В данной задаче достаточно просто реализовать 
 * рассмотренный алгоритм Fib2 (в его псевдокоде на п
 * редыдущем степе внимательный слушатель уже заметил 
 * опечатку: цикл должен начинаться с i=2).

Задача на программирование. 
Дано целое число n (1≤n≤40), 
необходимо вычислить n-е число Фибоначчи.
Sample Input:
3
Sample Output:
2
Memory Limit: 256 MB
Time Limit: 5 seconds*/

public class Fibonacci2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int index = s.nextInt();
       
       int a = 1, b = 1;
       int fib = 2, i = 2;
       while (i < index) {
           fib = a + b;
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
