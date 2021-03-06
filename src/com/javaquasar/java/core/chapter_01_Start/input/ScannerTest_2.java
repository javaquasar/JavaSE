package com.javaquasar.java.core.chapter_01_Start.input;

// Импорт системного класса
import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class ScannerTest_2 {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст");
        String s = scanner.next();       // чтение строки
        double d = scanner.nextDouble(); // чтение вещественного числа
        int i = scanner.nextInt();       // чтение целого числа

        // ... использование введенных данных
        System.out.println("Вы ввели = " + s);
        System.out.printf("%f %d%n", d, i);
    }

    // Примечание: Аннотация @SuppressWarnings("resource") добавлена для того, чтобы компилятор не требовал закрыть
    // поток, связанный с объектом scanner. Стандартные консольные потоки не предполагают закрытия.

    /*
    Для обеспечения консольного ввода Java предоставляет несколько вариантов:

    - непосредственное использование потока ввода System.in, в частности его функции read();
    - использование класса java.io.Console;
    - использование класса java.util.Scanner.

    Недостатком непосредственного использования функции System.in.read() является обилие ручной работы.
    Так, чтение данных с помощью потока System.in осуществляется в массив элементов типа byte. Далее, требуется
    определение реального количества введенных байтов. Кроме того, необходима обработка возможных исключений.
    С появлением классов java.io.Console и java.util.Scanner ввод данных с клавиатуры существенно упростился.

    Класс java.io.Console, появившийся в JDK 1.6, предоставляет упрощенные средства консольного ввода-вывода.
    Например, так с клавиатуры можно прочитать строку:

    java.io.Console console = System.console(); // Получение системной консоли
    String s = console.readLine();              // Чтение строки

    К недостаткам использования данного класса можно отнести следующие:

    - класс предоставляет простые функции только для чтения строки и вывода в стиле языка C, что связано с необходимостью
        дополнительной "ручной" работы;
    - консольное окно интегрированной среды Eclipse не поддерживает консольного ввода, осуществляемого средствами
        класса java.io.Console, следовательно, отладка таких программ затруднена.

    Наиболее удобным средством ввода данных являестя класс java.util.Scanner.
    Класс Scanner предоставляет функции для чтения данных из различных источников, например, из файлов.
    В нашем случае мы указываем на необходимость чтения с клавиатуры (стандартный поток ввода System.in).
    Для чтения данных используются функции
        nextDouble() (чтение вещественного числа, которое может быть как целым, так и дробным),
        nextInt() (чтение заведомо целого числа) и т. д.

    Для возможности работы с классом Scanner перед описанием класса необходимо добавить:

    import java.util.Scanner;

    Это позволит использовать имя Scanner без дополнительного префикса.

    Для организации чтения данных с помощью класса Scanner необходимо создать объект этого класса, проинициализировав
    его стандартным потоком System.in. Далее можно читать данные.

    Большим удобством класса является возможность произвольного размещения данных во входном потоке: отдельные данные
    можно разделять пробелами, табуляцией, либо переводом строки.
    Единственное исключение – использование функции nextLine(), которая читает данные до перевода строки.

    Для вывода в консольное окно используются функции print(), println() и printf() потока out класса System.
    Функции print() и println() реализованы для всех стандартных типов данных, но чаще всего их используют с параметрами
    строкового типа. Данные выводятся "как есть", с использованием форматирования по умолчанию.
    В отличие от print(), println() функция осуществляет перевод курсора на новую строку после вывода.

    Функция printf() во многом аналогична подобной функции языка C. Первый параметр – так называемая строка форматирования.
    Далее следует произвольное количество параметров, значения которых следует вывести на консоль. Например:
    */
}
