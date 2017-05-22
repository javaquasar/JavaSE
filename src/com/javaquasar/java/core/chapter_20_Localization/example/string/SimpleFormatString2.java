package com.javaquasar.java.core.chapter_20_Localization.example.string;

import java.util.Formatter;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class SimpleFormatString2 {

	public static void main(String[] args) {
		Formatter f = new Formatter();
		f.format("|%10.2f|", 123.123); // выравнивание влево
		System.out.println(f);
		f = new Formatter(); // выравнивание вправо
		f.format("|%-10.2f|", 123.123); // применение флага '-'
		System.out.println(f);
		f = new Formatter();
		f.format("%,.2f", 123456789.34);// применение флага ','
		System.out.println(f);
		f = new Formatter();
		f.format("%.4f", 1111.1111111); // задание точности представления для чисел
		System.out.println(f);
		f = new Formatter();
		f.format("%.6s", "Работа с текстовыми данными."); // задание точности представления для строк
		System.out.println(f);
	}

}
