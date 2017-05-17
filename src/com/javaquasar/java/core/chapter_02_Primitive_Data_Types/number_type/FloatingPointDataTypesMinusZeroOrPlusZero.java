package com.javaquasar.java.core.chapter_02_Primitive_Data_Types.number_type;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class FloatingPointDataTypesMinusZeroOrPlusZero {

    public static void main(String[] args) {
        float f1 = 0.0f / 1.0f;
        float f2 = 0.0f / -1.0f;
        System.out.println("f1=" + f1);
        System.out.println("f2=" + f2);
        System.out.println("f1==f2: " + (f1 == f2));
        System.out.println(Float.valueOf(f1).equals(Float.valueOf(f2)));
        float f3 = 1.0f / f1;
        float f4 = 1.0f / f2;
        System.out.println("f3=" + f3);
        System.out.println("f4=" + f4);

        /*
		 * В представлении вещественных чисел старший бит является знаковым. А
		 * что будет, если все остальные биты равны 0? В отличие от целых, где в
		 * такой ситуации получается отрицательное число, находящееся на нижней
		 * границе диапазона представления, вещественное число только со старшим
		 * битом, выставленным в 1, тоже обозначает 0, только со знаком минус.
		 * Таким образом, у нас есть два нуля – +0.0 и -0.0.
         */

 /*
		 * Возникает логичный вопрос – считать ли эти числа равными? Виртуальная
		 * машина считает именно так. Однако, это два разных числа, ибо в
		 * результате операций с ними получаются разные значения (как видно на
		 * приведенном примере). Таким образом, в некоторых случаях есть смысл
		 * расценивать +0.0 и -0.0 как два разных числа. А если у нас есть два
		 * объекта, в одном из которых поле равно +0.0, а в другом -0.0 – эти
		 * объекты точно так же можно расценивать как неравные. Возникает вопрос
		 * – а как понять, что числа неравны, если их прямое сравнение
		 * виртуальной машиной дает true?
		 * 
		 * Ответ таков. Несмотря на то, что виртуальнай машина считает эти числа
		 * равными, представления у них все-таки отличаются. Поэтому –
		 * единственное, что можно сделать, это сравнить представления. А для
		 * того, чтобы его получить, существуют методы int
		 * Float.floatToIntBits(float) и long Double.doubleToLongBits(double),
		 * которые возвращают битовое представление в виде int и long
		 * соответственно (продолжение предыдущего примера):
         */
        int i1 = Float.floatToIntBits(f1);
        int i2 = Float.floatToIntBits(f2);
        System.out.println("i1 (+0.0):" + Integer.toBinaryString(i1));
        System.out.println("i2 (-0.0):" + Integer.toBinaryString(i2));
        System.out.println("i1==i2: " + (i1 == i2));

        /*
		 * Результатом будет i1 (+0.0):0 
		 * i2 (-0.0):10000000000000000000000000000000 
		 * i1==i2: false Таким образом,
		 * если у вас +0.0 и -0.0 – разные числа, то сравнивать вещественные
		 * переменные следует через их битовое представление.
		 * 
		 * P.S. Вопрос, конечно, не для собеседования на джуна, но по-моему,
		 * достаточно интересный для всех.
         */
        System.out.println(Float.NaN == Float.NaN);// будет false

        System.out.println(Double.MAX_VALUE + 23414 == Double.MAX_VALUE);// true
        System.out.println(Integer.MAX_VALUE + 23414 == Integer.MAX_VALUE);// false

        System.out.println(Double.MAX_VALUE + Double.MAX_VALUE / 100000000000000000. == Double.MAX_VALUE); // -->
        // true
        System.out.println(Double.MAX_VALUE + Double.MAX_VALUE / 10000000000000000. == Double.MAX_VALUE); // -->false
    }

}
