package com.javaquasar.java.core.chapter_01_Start.output.number;

/**
 * Created by Java Quasar on 16.05.17.
 */

/*Форматированный вывод числа*

Вывести число 100 в шестнадцатеричном и восьмеричном представлении. 
Вывести числа в диапазоне от 100000 до 10000000 с шагом 100000 в формате, 
выбирающем более короткое представление. Вывести 5 вещественных чисел, 
выровняв их по левому краю и задав ширину поля вывода 12, 
а точность – 4 знака после запятой.*/

public class FormatNumber {
    public static void main(String[] args) {
        System.out.printf("16 = %x, 8 = %o", 100, 100);
        for (int i = 100000; i <= 10000000; i += 100000) {
            System.out.printf("Number : %g\n", (double) i);
        }
        double a = 15.3, b = 17.7, c = 19.9, d = 21.2, e = 33.4;
        System.out.printf("|%-12.4f|\n", a);
        System.out.printf("|%-12.4f|\n", b);
        System.out.printf("|%-12.4f|\n", c);
        System.out.printf("|%-12.4f|\n", d);
        System.out.printf("|%-12.4f|\n", e);

    }
}
