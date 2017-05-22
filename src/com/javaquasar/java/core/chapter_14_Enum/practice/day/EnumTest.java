package com.javaquasar.java.core.chapter_14_Enum.practice.day;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class EnumTest {

	public static void main(String[] args) {
		DayOfWeek d = DayOfWeek.MONDAY;
		for (int i = 0; i < 7; i++) {
			d = d.next();
			System.out.println(d + " " + d.isWeekend());
		}
	}

}
