package com.javaquasar.java.core.chapter_04_Conditional;

/**
 * Created by Java Quasar on 16.05.17.
 */
//control_statements
public class SwitchCaseTest {

    public static void main(String[] args) {

        // Test 1
        // Страндартный способ написания
        switch (3) {
            case 0:
                System.out.println("Test 1 i is zero.");
                break;
            case 1:
                System.out.println("Test 1 i is one.");
                break;
            case 2:
                System.out.println("Test 1 i is two.");
                break;
            case 3:
                System.out.println("Test 1 i is three.");
                break;
            default:
                System.out.println("Test 1 i is greater than 3.");
        }


        // Test 2
        // Если убрать операторы break
        switch (0) {
            case 0:
                System.out.println("Test 2 i is zero.");
            case 1:
                System.out.println("Test 2 i is one.");
            case 2:
                System.out.println("Test 2 i is two.");
            case 3:
                System.out.println("Test 2 i is three.");
                break;
            default:
                System.out.println("Test 2 i is greater than 3.");
        }


        // Test 3
        // Что выведет этот код?
        switch (5) {
            default:
                System.out.print("Test 3 i is zero.");
            case 1:
                System.out.print("Test 3 i is one.");
                break;
            case 4:
                System.out.print("Test 3 i is two.");
            case 2:
                System.out.print("Test 3 i is three.");
        }

    }

}
