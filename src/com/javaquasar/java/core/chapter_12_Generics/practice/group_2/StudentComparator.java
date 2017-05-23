package com.javaquasar.java.core.chapter_12_Generics.practice.group_2;

import java.util.Comparator;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return -Integer.compare(o1.getAge(), o2.getAge());
	}
}
