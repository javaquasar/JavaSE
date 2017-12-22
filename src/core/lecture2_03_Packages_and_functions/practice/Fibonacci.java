package core.lecture2_03_Packages_and_functions.practice;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите последнее число.");
		int number = scanner.nextInt();
		fibDemo(number);
		
		/*for(int i = 1; i < 40; i++)
		{
			System.out.println("Элемент номер " + i);
			fibDemo(i);
		}*/
		/*int fibC = fibCycle(294590);
		System.out.println(fibC + " - циклически за " +  " миллисекунд");*/
		
		/*for(int i = 1; i < 100; i++){
			long number = fibCycle(i);
			int numberEnd = fibEndNumber(i);
			System.out.println(""+number +"     "+ numberEnd);
		}*/
			
	}
	
	private static void fibDemo(int index)
	{
		long startTime1 = System.currentTimeMillis();
		long fibR = fibRecursion(index);
		long timeSpent1 = System.currentTimeMillis() - startTime1;
		
		long startTime2 = System.currentTimeMillis();
		long fibC = fibCycle(index);
		long timeSpent2 = System.currentTimeMillis() - startTime2;
		
		System.out.println(fibR + " - рекрсивно за " + timeSpent1 + " миллисекунд");
		System.out.println(fibC + " - циклически за " + timeSpent2 + " миллисекунд");
	}
	
	//Этот подход использует рекусрию
	private static long fibRecursion(int index) {
        if (index <= 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        } else if (index == 2) {
            return 1;
        } else {
            return fibRecursion(index - 1) + fibRecursion(index - 2);
        }
    }
	//Этот подход к вычислению называется динамическое программирование снизу-вверх
	private static long fibCycle(int index) {
		
        long a = 1, b = 1;
        long fib = 2, i = 2;
        while (i < index) {
            fib = a + b;
            a = b;
            b = fib;
            i++;
        }
        if (index <= 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        } else if (index == 2) {
            return 1;
        } else {
        	return fib;
        }
		
	}
	
	private static int fibEndNumber(int index)
	{
		   int a = 1, b = 1;
	       int fib = 2, i = 2;
	       while (i < index) {
	           fib = a + b;
	           if (fib>10) fib = fib%10;
	           else if(fib == 10)fib = 0;
	           a = b;
	           b = fib;
	           i++;
	       }
	       
	       if (index <= 0) {
	    	   return 0;
	       } else if (index == 1) {
	    	   return 1;
	       } else if (index == 2) {
	    	   return 1;
	       } else {
	    	   return fib;
	       }
	}
	

}
