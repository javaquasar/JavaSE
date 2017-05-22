package com.javaquasar.java.core.chapter_23_Regular_Expressions.replace;

import java.util.regex.Pattern;

/**
 * Created by Java Quasar on 16.05.17.
 */

/*Заменить в тексте все шаблоны типа %user%Nick%/user% 
 на <a href="http://www.my.by/search.htm?param=Nick">Nick</a>.*/

public class ReplacementTemplate {

	public static void main(String[] args) {
		String testString = new String("Hello %user%Nick%/user% !!! %user%Nick%/user%");
		Pattern p = Pattern.compile("%user%Nick%/user%"); // все пробелы в начале строки
		String s = p.matcher(testString).replaceAll("<a href=\"http://www.my.by/search.htm?param=Nick\">Nick</a>");
		System.out.println(s);
	}

}
