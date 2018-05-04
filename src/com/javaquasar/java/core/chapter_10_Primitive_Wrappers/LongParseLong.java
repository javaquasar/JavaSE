package com.javaquasar.java.core.chapter_10_Primitive_Wrappers;

/**
 * Created by Java Quasar on 04.05.18.
 */
public class LongParseLong {
    public static void main(String[] args) {
        System.out.println(Long.parseLong("0", 10));        //returns 0L
        System.out.println(Long.parseLong("473", 10));      //returns 473L
        System.out.println(Long.parseLong("-0", 10));       //returns 0L
        System.out.println(Long.parseLong("-FF", 16));      //returns -255L
        System.out.println(Long.parseLong("1100110", 2));   //returns 102L
        //System.out.println(Long.parseLong("99", 8));        //throws a NumberFormatException
        //System.out.println(Long.parseLong("Hazelnut", 10)); //throws a NumberFormatException
        System.out.println(Long.parseLong("Hazelnut", 36)); //returns 1356099454469L
        System.out.println(Long.parseLong("999"));               //returns 999L
    }
}
