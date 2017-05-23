package com.javaquasar.java.core.chapter_12_Generics.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class LibraryWithGenerics {
	public static void main(String[] args) {
		String[] testArray = { "a", "b", "c", "d", "e", "f" };
		Integer[] integers = { 1, 2, 3, 6, 6, 6, 6, 5, 7, 8, 9 };
		ArrayWithGenerics.reverse(testArray);
		System.out.println(Arrays.asList(testArray));
		int countEnterOfElement = ArrayWithGenerics.<Integer> countEnterOfElement(integers, 6);
		System.out.println(countEnterOfElement);
		ArrayWithGenerics.<Integer> swapElements(integers, 0, 1);
		System.out.println(Arrays.asList(integers));
	}
}

class ArrayWithGenerics<T> {
	public static <T> void swapElements(T[] mainArray, int firstIndex,
			int secondIndex) {
		if (firstIndex < 0 || firstIndex > mainArray.length || secondIndex < 0
				|| secondIndex > mainArray.length)
			throw new IndexOutOfBoundsException();
		T tmp = mainArray[firstIndex];
		mainArray[firstIndex] = mainArray[secondIndex];
		mainArray[secondIndex] = tmp;
	}

	public static <T> void reverse(T[] mainArray) {
		List<T> tmpList = Arrays.asList(mainArray);
		Collections.reverse(tmpList);
		mainArray = (T[]) tmpList.toArray();
	}

	public static <T> int countEnterOfElement(T[] mainArray, T element) {
		int count = -1;
		List<T> tmpList = Arrays.asList(mainArray);
		count = Collections.frequency(tmpList, element);
		return count;
	}

}
