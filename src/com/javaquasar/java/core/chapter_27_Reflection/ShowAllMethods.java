package com.javaquasar.java.core.chapter_27_Reflection;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class ShowAllMethods {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        System.out.print("Введите полное имя класса: ");
        String className = new Scanner(System.in).next();
        try {
            Class<?> c = Class.forName(className);
            for (Method m : c.getMethods()) {
                System.out.printf("Имя: %s Тип результата: %s%n", m.getName(), m.getReturnType().getCanonicalName());
                for (Class<?> type : m.getParameterTypes()) {
                    System.out.printf("  Тип параметра: %s%n", type.getCanonicalName());
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Ошибка ввода имени класса!");
        }
    }

}
