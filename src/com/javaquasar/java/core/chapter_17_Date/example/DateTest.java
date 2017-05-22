package com.javaquasar.java.core.chapter_17_Date.example;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class DateTest {

	public static void main(String[] args) {
		// Установка времени с использованием экземпляра Date:
		Date date = new Date(System.currentTimeMillis());
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		System.out.println(calendar.getTime());

		// Вызов методов getter и setter объекта Calendar:
		calendar.set(Calendar.MONTH, Calendar.JULY);
		calendar.set(Calendar.DAY_OF_MONTH, 15);
		calendar.set(Calendar.YEAR, 1978);
		calendar.set(Calendar.HOUR, 2);
		calendar.set(Calendar.MINUTE, 15);
		calendar.set(Calendar.SECOND, 37);
		System.out.println(calendar.getTime());
		System.out.println("The YEAR is: " + calendar.get(Calendar.YEAR));
		System.out.println("The MONTH is: " + calendar.get(Calendar.MONTH));
		System.out.println("The DAY is: " + calendar.get(Calendar.DATE));
		System.out.println("The HOUR is: " + calendar.get(Calendar.HOUR));
		System.out.println("The MINUTE is: " + calendar.get(Calendar.MINUTE));
		System.out.println("The SECOND is: " + calendar.get(Calendar.SECOND));
		System.out.println("The AM_PM indicator is: " + calendar.get(Calendar.AM_PM));
	}

}
