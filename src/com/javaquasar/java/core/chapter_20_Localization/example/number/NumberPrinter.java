package com.javaquasar.java.core.chapter_20_Localization.example.number;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class NumberPrinter {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		NumberFormat form = NumberFormat.getInstance(new Locale("uk"));
		Scanner scan = new Scanner(System.in);
		double x = scan.nextDouble();
		System.out.println(form.format(x));
	}

}
