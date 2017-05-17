package com.javaquasar.java.core.chapter_02_Primitive_Data_Types.number_type;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class FloatingPointDataTypes {

    public static void main(String[] args) {
        String Type = "float";
        String SizeInBytes = "4";
        float floatMin = -1 * (Float.MAX_VALUE + 1);
        float floatMax = Float.MAX_VALUE;
        //Print.printStatic(Type, floatMin, floatMax, SizeInBytes);

        Type = "double";
        SizeInBytes = "8";
        double doubleMin = -1 * (Double.MAX_VALUE + 1);
        double doubleMax = Double.MAX_VALUE;
        //Print pr = new Print();
        //pr.print(Type, doubleMin, doubleMax, SizeInBytes);
    }

}
