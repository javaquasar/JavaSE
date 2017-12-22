package core.lecture3_04_Localization.practice.task_8_10;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/*8.10 Форматированный вывод*

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

public class Test {

	public static void main(String[] args) {
		Date d = new Date();
		Conference conference = new Conference("Java", "Kharcov");
		Person perosn1 = new Person("Артур", "Бузов", Country.RUSSIA, Language.RUSSIAN, d);
		Person perosn2 = new Person("Виталий", "Пилипенко", Country.UKRAINE, Language.UKRAINIAN, d);
		Person perosn3 = new Person("Брюс", "Ли", Country.JAPAN, Language.JAPANESE, d);
		
		conference.add(perosn1);
		conference.add(perosn2);
		conference.add(perosn3);
		conference.print();
		/*Locale[] locales = DateFormat.getAvailableLocales();
		for (Locale loc : locales) {
		  DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, loc);
		  System.out.println(loc.toString() + "-> " + df.format(d));
		}
		
		Locale locale = Locale.JAPANESE;
		SimpleDateFormat formatter = (SimpleDateFormat) SimpleDateFormat.getDateInstance(DateFormat.FULL, locale);
		System.out.println(formatter.format(d));*/
	}

}
