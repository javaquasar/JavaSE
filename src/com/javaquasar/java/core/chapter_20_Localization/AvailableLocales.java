package com.javaquasar.java.core.chapter_20_Localization;

import java.util.Locale;
import java.text.NumberFormat;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class AvailableLocales {

	public static void main(String[] args) {
		Locale list[] = NumberFormat.getAvailableLocales();
		for (Locale locale : list) {
			System.out.printf("%-25s %s%n", locale.toString(), locale.getDisplayName());
		}
	}

}
