package com.javaquasar.java.core.chapter_23_Regular_Expressions;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class TestPattern {
	
	
	private static Pattern pattern = Pattern.compile("[A-Za-zА-Яа-я0-9_ +]+[|]{1}[A-Za-zА-Яа-я0-9_ +]+");

	public static void main(String[] args) throws IOException {
		String fileDictionary = "./file/lecture_3_09_task_5_05_dictionary.txt";
		// new Dictionary(fileDictionary).readFromFile(fileDictionary);
		Matcher matcher = pattern.matcher("cat | кот");
		System.out.println(matcher.matches());

	}
}
