package com.javaquasar.java.core.chapter_13_Collections.practice.ownContainers.array_based_container_from_to;

import java.util.*;

public class ArrayBasedContainer<E> extends AbstractList<E> implements Iterable<E>, Collection<E> {
	private Object[] arr;
	private int from;

	private ArrayBasedContainer(int from, int to) {
		this.from = from;
		arr = new Object[(to - from) + 2];
	}

	public static ArrayBasedContainer getArray(int from, int to) {
		if (from > to) {
			return new ArrayBasedContainer(to, from);
		} else if (to > from) {
			return new ArrayBasedContainer(from, to);
		} else {
			return null;
		}
	}

	private class InnerIterator<E> implements Iterator<E> {
		int cursor = -1;

		@Override
		public boolean hasNext() {
			return cursor < arr.length - 1;// 2 l - 3
		}

		@Override
		public E next() {
			return (E) arr[++cursor];
		}
	}

	public void setArr(E[] arr) {
		this.arr = arr;
	}

	@Override
	public E get(int index) {
		if (index == from) {
			return (E) arr[0];
		}
		return (E) arr[index - from];
	}

	@Override
	public Iterator<E> iterator() {
		return new InnerIterator<E>();
	}

	@Override
	public int size() {
		return arr.length;
	}

	@Override
	public E set(int index, E element) {
		if (index < from || index > (arr.length - Math.abs(from))) {
			throw new IndexOutOfBoundsException();
		} else {
			arr[index - from] = element;
		}
		return element;
	}

	@Override
	public E remove(int indexx) {
		int index = indexx - from;
		Object[] tmp = new Object[arr.length - 1];
		for (int i = 0; i < index; i++) {
			tmp[i] = arr[i];
		}
		int j = index;
		for (int i = index + 1; i < arr.length; i++) {
			tmp[j] = arr[i];
			j++;
		}
		arr = tmp;
		return (E) arr[0];
	}

	@Override
	public int indexOf(Object o) {
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == o) {
				index = i;
				break;
			}
		}
		return index + from;
	}

	@Override
	public int lastIndexOf(Object o) {
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == o) {
				index = i;
			}
		}
		return index + from;
	}
	

	@Override
	public String toString() {
		return Arrays.toString(arr);
	}
}
