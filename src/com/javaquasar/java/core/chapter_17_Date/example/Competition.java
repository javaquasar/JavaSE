package com.javaquasar.java.core.chapter_17_Date.example;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class Competition {
	String place;
	Calendar date;

	public Competition(String place, Calendar date) {
		this.place = place;
		this.date = date;
	}

	public static String between(Competition c1, Competition c2) {
		int years = c2.date.get(Calendar.YEAR) - c1.date.get(Calendar.YEAR);
		int months = c2.date.get(Calendar.MONTH) - c1.date.get(Calendar.MONTH);
		int day = c2.date.get(Calendar.DAY_OF_MONTH) - c1.date.get(Calendar.DAY_OF_MONTH);
		return years + " год (года, лет) " + months + " мес. " + day + " дн.";
	}

	public static void main(String[] args) {
		Competition c1 = new Competition("Харьков", new GregorianCalendar(2012, 02, 11));
		Competition c2 = new Competition("Киев", new GregorianCalendar(2013, 06, 20));
		System.out.println(between(c1, c2));
	}

}
