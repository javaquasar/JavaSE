package com.javaquasar.java.core.chapter_23_Regular_Expressions;

import java.util.regex.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class FirstRegex {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("text");
		Matcher matcher = pattern.matcher("text");
		System.out.println(matcher.matches());
	}

}