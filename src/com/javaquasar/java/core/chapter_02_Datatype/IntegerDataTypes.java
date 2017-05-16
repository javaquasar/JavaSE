package com.javaquasar.java.core.chapter_02_Datatype;

/**
 * Created by Java Quasar on 16.05.17.
 */
/*long 64 –9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
 int 32 –2,147,483,648 to 2,147,483,647
 short 16 –32,768 to 32,767
 byte 8 –128 to 127*/
public class IntegerDataTypes {

    public static void main(String[] args) {
        String Type = "byte";
        String SizeInBytes = "1";
        byte byteMin = -128;
        byte byteMax = 127;
        print(Type, byteMin, byteMax, SizeInBytes);

        Type = "short";
        SizeInBytes = "2";
        short shortMin = -32_768;
        short shortMax = 32_767;
        print(Type, shortMin, shortMax, SizeInBytes);

        Type = "int";
        SizeInBytes = "4";
        int intMin = -2_147_483_648;
        int intMax = 2_147_483_647;
        print(Type, intMin, intMax, SizeInBytes);

        Type = "long";
        SizeInBytes = "8";
        long longMin = -9_223_372_036_854_775_808L;
        long longMax = 9_223_372_036_854_775_807L;
        print(Type, longMin, longMax, SizeInBytes);
    }

    public static void print(String type, long min, long max, String size) {
        System.out.println("Type - " + type);
        System.out.println("Minimum Value = " + min);
        System.out.println("Maximum Value = " + max);
        System.out.println("Size in Bytes = " + size);
        System.out.println();
    }
}
