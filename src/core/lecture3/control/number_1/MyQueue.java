package core.lecture3.control.number_1;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Iterator;

public class MyQueue<E> extends AbstractQueue<E> implements Iterable<E> {

	private Object[] arr;
	private int start = 0;
	private int end = 0;
	private int size = 0;

	public MyQueue() {
		arr = new Object[10];
	}

	public MyQueue(int size) {
		arr = new Object[size];
	}

	private class QueueIterator implements Iterator<E> {
		int cursor = start;
        int sizeTemp = size;
		@Override
		public boolean hasNext() {
			//System.out.println("sizeTemp" + sizeTemp);
			return !(sizeTemp == 0);
		}

		@Override
		public E next() {
			E tempElement = (E) arr[cursor];
			if ((cursor + 1) == arr.length) {
				cursor = 0;
			} else {
				cursor++;
			}
			sizeTemp--;
			return tempElement;
		}
		/*
		 * int cursor = -1;
		 * 
		 * @Override public boolean hasNext() { return cursor < arr.length - 1;
		 * }
		 * 
		 * @Override public E next() { return (E) arr[++cursor]; }
		 */
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	@Override
	public boolean offer(E arg0) {
		// добавляет элемент в очередь
		if (!isFull(start, end) || (size == 0)) {
			arr[end] = arg0;
			if (end == arr.length - 1) {
				end = 0;
			} else {
				end++;
			}
			++size;
			return true;
		} else {
			return false;
		}

	}

	@Override
	public E peek() {
		// получает первый элемент очереди но не удаляет его
		if (!isEmpty()) {
			return (E) arr[start];
		} else {
			return null;
		}
	}

	@Override
	public E poll() {
		// // получает и удаляет первый элемент очереди
		if (!isEmpty(start, end) || (size != 0)) {
			E tempElement = (E) arr[start];
			int temp = start;
			if ((start + 1) == arr.length) {
				arr[start] = null;
				start = 0;
			} else {
				arr[start] = null;
				start++;
			}
			--size;
			return tempElement;
		} else {
			return null;
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	@Override
	public int size() {
		// возвращает размер
		return size;
	}

	private boolean isEmpty(int start, int end) {
		return start == end;
	}

	private boolean isFull(int start, int end) {
		return start == end;
	}
	
	public boolean isEmpty() {
		return isEmpty(start, end);
	}

	public boolean isFull() {
		return isFull(start, end);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (E s : this) {
			//System.out.println(s);
			stringBuilder.append(s);
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}

	public void print() {
		System.out.println("-----Полный массив-----");
		for (Object s : arr) {
			System.out.println(s);
		}
	}
	
	public ArrayList<E> getArray () {
		ArrayList<E> ar = new ArrayList<>();
		for (Object o : arr) {
			if(o != null) {
				ar.add((E) o);
			}
		}
		return ar;
	}
}
