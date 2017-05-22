package com.javaquasar.java.core.chapter_28_Reflection.annotation;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class NewAnnotationProcessor {

	public static void main(String[] args) {
		String classNameWithPath = SomeAnnotatedClass.class.getName();
		System.out.println(classNameWithPath);
		try {
			Class<?> cls = Class.forName(classNameWithPath);
			if (cls.isAnnotationPresent(NewAnnotation.class)) {
				NewAnnotation ann = cls.getAnnotation(NewAnnotation.class);
				System.out.println(ann.firstValue());
				System.out.println(ann.secondValue());
			} else
				System.out.println("No such annotation!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
