package com.javaquasar.java.core.chapter_12_Generics.practice;

import java.util.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class LibraryWithDecimalList {
	public static void main(String[] args) {
		List<Integer> listForTest = Arrays.asList(1, 2, 3, 4, 5, 6, 7, -8, 0, 99);
		System.out.println(LibraryForList.sumOfPositiveNumbers(listForTest));
		System.out.println(LibraryForList.newPositiveList(listForTest));
		System.out.println(LibraryForList.indexOfFirstZero(listForTest));
		System.out.println(LibraryForList.sumOfMinAndMax(listForTest));
		System.out.println(LibraryForList.reverseList(listForTest));
	}
}

class LibraryForList {
	public static int sumOfPositiveNumbers(List<Integer> mainList) {
		int sum = 0;
		for (Integer integer : mainList) {
			if (integer > 0)
				sum += integer;
		}
		return sum;
	}

	public static int indexOfFirstZero(List<Integer> mainList) {
		int index = mainList.indexOf(0);
		return index;
	}

	public static List<Integer> newPositiveList(List<Integer> mainList) {
		List<Integer> finalList = new ArrayList<>();
		for (Integer integer : mainList) {
			if (integer > 0)
				finalList.add(integer);
		}
		;
		return finalList;
	}

	public static int sumOfMinAndMax(List<Integer> mainList) {
		int sum = Collections.min(mainList) + Collections.max(mainList);
		return sum;
	}

	public static List<Integer> reverseList(List<Integer> mainList) {
		Collections.reverse(mainList);
		return mainList;
	}
}
