package com.javaquasar.java.core.chapter_19_Localization.example.date;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Java Quasar on 16.05.17.
 */
/*Форматированный вывод*

Создать класс Person с полями 
name (имя), 
surname (фамилия), 
country (страна), 
language (язык), 
date (дату выступления). 
Создать класс Conference (Конференция) с полями 
persons (список лиц), 
topic (тема), 
city (город). 
Создать метод, выводящий информацию о каждом участнике 
конференции в соответствии с локализацией, заданной 
с его страной. Использовать класс SimpleDateFormat 
для задания пользовательского формата.*/

public class TestDateFormat {

	public static void main(String[] args) {
		Date d = new Date();
		Locale[] locales = DateFormat.getAvailableLocales();
		for (Locale loc : locales) {
		  DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, loc);
		  System.out.println(loc.toString() + "-> " + df.format(d));
		}
	}

}
