package com.javaquasar.java.core.chapter_02_Primitive_Data_Types;

/**
 * Created by Java Quasar on 25.05.17.
 */
public class DefaultValuesForPrimitives {
    /*
    Type	Default Value
    boolean	false
    byte	0
    short	0
    int     0
    long	0L
    char	\u0000
    float	0.0f
    double	0.0d
    object reference	null
     */
    static boolean bool;
    static byte by;
    static char ch;
    static double d;
    static float f;
    static int i;
    static long l;
    static short sh;
    static String str;

    public static void main(String[] args) {
        System.out.println("boolean = " + bool);
        System.out.println("byte = " + by);
        System.out.println("char = " + ch);
        System.out.println("char to int = " + (int) ch);

        System.out.println("double = " + d);
        System.out.println("float = " + f);
        System.out.println("int = " + i);
        System.out.println("long = " + l);
        System.out.println("short = " + sh);
        System.out.println("String = " + str);

    }
}
