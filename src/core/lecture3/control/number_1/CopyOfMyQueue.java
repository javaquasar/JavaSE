package core.lecture3.control.number_1;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Iterator;

public class CopyOfMyQueue<E> extends AbstractQueue<E> implements Iterable<E> {

	private Object[] arr;
	private int start = 0;
	private int end = 0;
	private boolean full = false;
	private boolean empty = true;

	public CopyOfMyQueue() {
		arr = new Object[10];
	}

	public CopyOfMyQueue(int size) {
		arr = new Object[size];
	}

	private class QueueIterator implements Iterator<E> {
		int cursor = start;
		boolean tempEmpty = empty;

		@Override
		public boolean hasNext() {
			return !tempEmpty;
		}

		@Override
		public E next() {
			E tempElement = (E) arr[start];
			if ((start + 1) == arr.length) {
				start = 0;
			} else {
				start++;
			}
			if (start == end) {
				tempEmpty = true;
			}
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
		if (!full) {
			arr[end] = arg0;
			if (end == arr.length - 1) {
				end = 0;
			} else {
				end++;
			}
			if (start == end) {
				full = true;
			}
			if (empty) {
				empty = false;
			}
			return true;
		} else {
			return false;
		}

	}

	@Override
	public E peek() {
		// получает первый элемент очереди но не удаляет его
		if (!empty) {
			return (E) arr[start];
		} else {
			return null;
		}
	}

	@Override
	public E poll() {
		// // получает и удаляет первый элемент очереди
		if (!empty) {
			full = false;
			E tempElement = (E) arr[start];
			int temp = start;
			if ((start + 1) == arr.length) {
				arr[start] = null;
				start = 0;
			} else {
				arr[start] = null;
				start++;
			}
			if (start == end) {
				empty = true;
			}
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
		return Math.abs(end - start);
	}

	public boolean isEmpty() {
		return empty;
	}

	public boolean isFull() {
		return full;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		int tempStart = start;
		int tempEnd = end;
		for (E s : this) {
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
