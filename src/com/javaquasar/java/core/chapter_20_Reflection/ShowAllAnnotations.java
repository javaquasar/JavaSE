package com.javaquasar.java.core.chapter_20_Reflection;

import java.lang.annotation.Annotation;
import com.javaquasar.java.core.chapter_20_Reflection.annotation.NewAnnotation;

/**
 * Created by Java Quasar on 16.05.17.
 */
@Deprecated
@NewAnnotation(firstValue = 1)
class TestClass2 {

}

public class ShowAllAnnotations {

	public static void main(String[] args) {
		String classNameWithPath = TestClass2.class.getName();
		System.out.println(classNameWithPath);
		try {
			Class<?> cls = Class.forName(classNameWithPath);
			for (Annotation ann : cls.getAnnotations())
				System.out.println(ann);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}