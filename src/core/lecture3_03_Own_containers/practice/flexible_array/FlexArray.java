package core.lecture3_03_Own_containers.practice.flexible_array;

import java.util.AbstractList;
import java.util.Iterator;

public class FlexArray<E> extends AbstractList<E> implements Iterable<E> {

	private Object[] arr;

	public FlexArray() {
		arr = new Object[0];
	}
	
	public FlexArray(int size) {
		arr = new Object[size];
	}

	private class MyIterator implements Iterator<E> {
		int cursor = -1;

		@Override
		public boolean hasNext() {
			return cursor < arr.length - 1;
		}

		@Override
		public E next() {
			return (E) arr[++cursor];
		}
	}

	public void setArr(Object[] arr) {
		this.arr = arr;
	}

	@Override
	public Iterator<E> iterator() {
		return new MyIterator();
	}

	@Override
	public E get(int index) {
		if (index >= arr.length) {
			Object[] tmp = new Object[index + 1];
			for (int i = 0; i < arr.length; i++) {
				tmp[i] = arr[i];
			}
			arr = tmp;
			return (E) arr[index];
		} else {
			return (E) arr[index];
		}
	}

	@Override
	public E set(int index, E element) {
		if (index >= arr.length) {
			Object[] tmp = new Object[index + 1];
			for (int i = 0; i < arr.length; i++) {
				tmp[i] = arr[i];
			}
			arr = tmp;
			arr[index] = element;
		} else {
			arr[index] = element;
		}
		return (E) arr[0];
	}

	@Override
	public int size() {
		return arr.length;
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				builder.append(arr[i]);
				break;
			}
			builder.append(arr[i] + ", ");
		}
		builder.append("]");
		return builder.toString();
	}
}
