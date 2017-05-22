package com.javaquasar.java.core.chapter_19_Localization.example.date;

import java.util.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class Time {

	public static void main(String args[]) {
		Formatter f = new Formatter();
		Calendar calendar = Calendar.getInstance();
		f.format("%tr", calendar);// вывод в 12-часовом временном формате
		System.out.println(f);
		f = new Formatter();
		f.format("%tc", calendar);// полноформатный вывод времени и даты
		System.out.println(f);
		f = new Formatter();
		f.format("%tl:%tM", calendar, calendar);// вывод текущего часа и минуты
		System.out.println(f);
		f = new Formatter();
		f.format("%tB %tb %tm", calendar, calendar, calendar);// различные варианты вывода месяца
		System.out.println(f);
	}

}
