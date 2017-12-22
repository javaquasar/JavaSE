package com.javaquasar.java.core.chapter_28_Reflection.example;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class ListSize {

	public static void main(String[] args) throws Exception {
		List<String> list = Arrays.asList("one", "two");
		Method method = Class.forName("java.util.List").getMethod("size");
		System.out.println(method.invoke(list));
	}

}
