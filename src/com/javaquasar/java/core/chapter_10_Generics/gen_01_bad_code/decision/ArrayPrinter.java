package com.javaquasar.java.core.chapter_10_Generics.gen_01_bad_code.decision;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class ArrayPrinter {

    /*
    Кроме обобщенных классов, можно создавать обобщенные интерфейсы.
    Параметр может быть использован в описании функций, объявленных в интерфейсе.
    Java также позволяет создавать обобщенные функции внутри как обобщенных, так и обычных (необобщенных) классов:
     */
    public static<T> void printArray(T[] a) {
        for (T x : a) {
            System.out.print(x + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] as = {"First", "Second", "Third"};
        printArray(as);
        Integer[] ai = {1, 2, 4, 8};
        printArray(ai);

        /*
        Как видно из примера, вызов обобщенной функции не требует явного определения типа. Иногда такое определение
        необходимо, например, когда в функции нет параметров обобщенного типа. Если это статическая функция,
        необходимо явно указывать ее класс. Например:
         */
        Object o = "Some Text";
        String s = TypeConverter.<String>convert(o); //?
        System.out.println(s);
    }
}

class TypeConverter {

    public static<T> T convert(Object object) {
        return (T) object;
    }

    public static void main(String[] args) {
        Object o = "Some Text";
        String s = TypeConverter.<String>convert(o);
        System.out.println(s);
    }

}
