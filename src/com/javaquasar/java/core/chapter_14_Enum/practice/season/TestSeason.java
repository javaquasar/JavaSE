package com.javaquasar.java.core.chapter_14_Enum.practice.season;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class TestSeason {

	public static void main(String[] args) {
		Season season = Season.SPRING;
		System.out.println(season);
		System.out.println(season.getNextSeason());
		System.out.println(season.getLastSeason());
		System.out.println(Season.valueOf("SPRING").ordinal());
	}

}
