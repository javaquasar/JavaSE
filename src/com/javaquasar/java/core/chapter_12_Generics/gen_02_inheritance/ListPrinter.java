package com.javaquasar.java.core.chapter_12_Generics.gen_02_inheritance;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Java Quasar on 16.05.17.
 */

/*
Над данными типа параметра обобщения можно осуществлять только действия, разрешенные для объектов класса Object.
Иногда для расширения функциональности желательным является конкретизация типа.
Например, мы хотим вызвать методы, объявленные в определенном классе или интерфейсе.
Тогда можно применить следующий синтаксис описания параметра:
    <T extends SomeBaseType> или <T extends FirstType & SecondType> и т.д.
    Слово extends используется как для классов, так и для интерфейсов.

Синтаксис обобщений предполагает использование так называемых масок (wildcard, символ ‘?’).
Маска применяется, например, для описания ссылок на пока неизвестный тип.
Использование масок делает обобщенные классы и функции более совместимыми.
Маска предоставляет альтернативный способ создания обобщенных функций.
Например:
 */
public class ListPrinter {

    public static void printList(List<?> a) {
        for (Object x : a) {
            System.out.print(x + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("First", "Second", "Third");
        printList(list);
        List<?> list2 = Arrays.asList(1, 2, 3); // List<?> вместо List<Integer>
        printList(list2);
    }

}
