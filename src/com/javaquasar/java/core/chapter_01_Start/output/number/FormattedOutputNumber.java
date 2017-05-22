package com.javaquasar.java.core.chapter_01_Start.output.number;

import java.util.Formatter;

/**
 * Created by Java Quasar on 16.05.17.
 */

/*Форматированный вывод числа*

Вывести число 100 в шестнадцатеричном и восьмеричном представлении. 
Вывести числа в диапазоне от 100000 до 10000000 с шагом 100000 в формате, 
выбирающем более короткое представление. Вывести 5 вещественных чисел, 
выровняв их по левому краю и задав ширину поля вывода 12, 
а точность – 4 знака после запятой.*/

public class FormattedOutputNumber {
	public static void main(String[] args) {
	    int i = 100; 
	    System.out.printf("Число %d в восьмеричном представлении %o %n", i, i);
	    System.out.printf("Число %d в шестнадцатеричном представлении %x %n", i, i); 
	    Formatter f = new Formatter(); 
	    f.format("Число %d в восьмеричном представлении %o %n", i, i);   
	    f.format("Число %d в шестнадцатеричном представлении %x %n", i, i);  
	    System.out.print(f); 
	    
	    
	    System.out.println();
	    System.out.println("Короткое представление чисел");
	    for(i = 100_000; i <= 1000_000; i += 100_000) {
	    	System.out.printf("%1.0g %n", i*1.0);
	    	//System.out.printf("%1.0e %n", i*1.0);
	    }
	    
	    double[] doubleArray = {1.5 , 24.895566, Math.PI, Math.E, Math.cos(45)};
	    for(double d : doubleArray)	{
	    	System.out.printf("|%-12.4f|%n", d);
	    }
	  
	}
	
}
