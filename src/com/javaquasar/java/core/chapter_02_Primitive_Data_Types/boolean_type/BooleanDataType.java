package com.javaquasar.java.core.chapter_02_Primitive_Data_Types.boolean_type;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class BooleanDataType {

    public static void main(String[] args) {
        System.out.println("Less than 3 < 8 = " + (3 < 8));
        System.out.println("Less than 8 < 3 = " + (8 < 3));
        System.out.println();

        System.out.println("Greater than 4 > 2 = " + (4 > 2));
        System.out.println("Greater than 2 > 4 = " + (2 > 4));
        System.out.println();

        System.out.println("Less than or equal to 5 <= 5 = " + (5 <= 5));
        System.out.println("Less than or equal to 8 <= 6 = " + (8 <= 6));
        System.out.println();

        System.out.println("Greater than or equal to 7 >= 3 = " + (7 >= 3));
        System.out.println("Greater than or equal to 1 >= 2 = " + (1 >= 2));
        System.out.println();

        System.out.println("Equal to 7 == 7 = " + (7 == 7));
        System.out.println("Equal to 7 == 7 = " + (7 == 9));
        System.out.println();

        System.out.println("Not equal to 7 != 7 = " + (7 != 7));
        System.out.println("Not equal to 7 != 7 = " + (7 != 9));
        System.out.println();
    }
}
