package com.javaquasar.java.core.chapter_19_Localization.example.string;

import java.util.Formatter;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class SimpleFormatString {

	public static void main(String[] args) {
		Formatter f = new Formatter();
		f.format("%s %c %nОсновы разработки приложений Java %S ", "Модуль", '2', "se");
		System.out.print(f);
	}

}
