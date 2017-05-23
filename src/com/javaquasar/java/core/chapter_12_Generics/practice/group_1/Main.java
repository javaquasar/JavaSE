package com.javaquasar.java.core.chapter_12_Generics.practice.group_1;

import java.util.Arrays;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class Main {

	public static void main(String[] args) {
		
		Student stud1 = new Student("Артур", 19, 1, "");
		Student stud2 = new Student("Виталий", 20, 1, "");
		Student stud3 = new Student("Олег", 23, 1, "");
		Student stud4 = new Student("Валерий", 21, 1, "");
		Student stud5 = new Student("Владимир", 18, 1, "");
		
		StudentsWithList listStudent =  new StudentsWithList();
		listStudent.addStudent(stud1);
		listStudent.addStudent(stud2);
		listStudent.addStudent(stud3);
		listStudent.addStudent(stud4);
		listStudent.addStudent(stud5);

		System.out.println(listStudent);
		listStudent.sortList();
		System.out.println(listStudent);
		
		StudentsWithArray arrayStudent = new StudentsWithArray();
		arrayStudent.addStudent(stud1);
		arrayStudent.addStudent(stud2);
		arrayStudent.addStudent(stud3);
		arrayStudent.addStudent(stud4);
		arrayStudent.addStudent(stud5);
		
		System.out.println(arrayStudent);
		arrayStudent.sortList();
		System.out.println(arrayStudent);
		
		Student[] testArray = {stud1, stud2, stud3, stud4, stud5};
		Arrays.sort(testArray);
		for(Student s : testArray) {
			System.out.println(s);
		}
	    //System.out.println(testArray.toString());

	}

}
