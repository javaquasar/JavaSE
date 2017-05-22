package com.javaquasar.java.core.chapter_20_Localization.example.date;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.text.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class Task {

	public static void main(String args[]) {
		try {
			String[] months = { "января", "февраля", "марта", "апреля", "мая", "июня", "июля", "августа", "сентября", "октября", "ноября", "декабря" };
			DateFormatSymbols dfs = new DateFormatSymbols(new Locale("ru"));
			dfs.setMonths(months);
			SimpleDateFormat sdf = new SimpleDateFormat("d MMMM yyyy 'г.'", dfs);
			System.out.println("Сегодня: " + sdf.format(new Date()));
			Calendar c = Calendar.getInstance();
			c.set(2011, 5, 1);
			System.out.println("Начало лета: " + sdf.format(c.getTime()));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
