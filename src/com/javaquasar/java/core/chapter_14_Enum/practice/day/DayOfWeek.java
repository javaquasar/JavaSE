package com.javaquasar.java.core.chapter_14_Enum.practice.day;

/**
 * Created by Java Quasar on 16.05.17.
 */
enum DayOfWeek {
	SUNDAY,
	MONDAY,
	TUESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY;

	@Override
	public String toString() {
		return name() + " " + ordinal();
	}

	DayOfWeek next() {
		DayOfWeek day = values()[(ordinal() + 1) % values().length];
		return day;
	}

	boolean isWeekend() {
		switch (this) {
		case SATURDAY:
		case SUNDAY:
			return true;
		default:
			return false;
		}
	}

}
