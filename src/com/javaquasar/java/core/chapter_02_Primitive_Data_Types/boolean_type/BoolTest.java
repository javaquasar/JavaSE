package com.javaquasar.java.core.chapter_02_Primitive_Data_Types.boolean_type;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class BoolTest {

    public static void main(String args[]) {
        boolean b;
        b = false;
        System.out.println("b is " + b);
        b = true;
        System.out.println("b is " + b);
        // a boolean value can control the if statement
        if (b) {
            System.out.println("This is executed.");
        }
        b = false;
        if (b) {
            System.out.println("This is not executed.");
        }
        // outcome of a relational operator is a boolean value
        System.out.println("10 > 9 is " + (10 > 9));
    }
}
