package com.javaquasar.java.core.chapter_14_Enum.practice.month;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class TestMonth {

	public static void main(String[] args) {
		Month month = Month.APRIL;
		Month.printAll();
		System.out.println(month);
		System.out.println(month.getSeason());
		System.out.println(month.getNextMonth());
		System.out.println(month.getLastMonth());
	}
}
