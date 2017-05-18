package com.javaquasar.java.core.chapter_01_Start.output;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class FormattedOutput {
    public static void main(String[] args) {
        System.out.printf("%f %d%n", 5.6, 10);
    }
}

/*
При форматировании используются следующие спецификаторы формата:

    %a - Шестнадцатеричное значение с плавающей точкой

    %b - Логическое (булево) значение аргумента

    %c - Символьное представление аргумента

    %d - Десятичное целое значение аргумента

    %h - Хэш-код аргумента

    %e - Экспоненциальное представление аргумента

    %f - Десятичное значение с плавающей точкой

    %g - Выбирает более короткое представление из двух: %е или %f

    %o - Восьмеричное целое значение аргумента

    %n - Вставка символа новой строки

    %t - Время и дата

    %x - Шестнадцатеричное целое значение аргумента

    %% - Вставка знака %
*/