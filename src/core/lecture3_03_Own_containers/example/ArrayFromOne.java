package core.lecture3_03_Own_containers.example;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

@SuppressWarnings("unchecked")
public class ArrayFromOne<E> extends AbstractList<E> {
	ArrayList<Object> arr = new ArrayList<>();

	@Override
	public E get(int index) {
		return (E) arr.get(index - 1);
	}

	@Override
	public int size() {
		return arr.size();
	}

	@Override
	public void add(int index, E element) {
		arr.add(index - 1, element);
	}

	@Override
	public boolean add(E e) {
		return arr.add(e);
	}

	@Override
	public E set(int index, E element) {
		return (E) arr.set(index - 1, element);
	}

	@Override
	public E remove(int index) {
		return (E) arr.remove(index - 1);
	}

	@Override
	public int indexOf(Object o) {
		return arr.indexOf(o) + 1;
	}

	@Override
	public int lastIndexOf(Object o) {
		return arr.lastIndexOf(o) + 1;
	}

	@Override
	public Iterator<E> iterator() {
		return (Iterator<E>) arr.iterator();
	}

	public static void main(String[] args) {
		ArrayFromOne<Integer> a = new ArrayFromOne<>();
		a.add(1);
		a.add(2);
		System.out.println(a.get(1) + " " + a.get(2)); // 1 2
		System.out.println(a.indexOf(2)); // 2
		a.set(1, 3);
		for (Integer k : a)
			System.out.print(k + " "); // 3 2
		System.out.println();
		a.remove(2);
		System.out.println(a); // [3]
		a.addAll(Arrays.asList(new Integer[] { 4, 5 }));
		System.out.println(a.get(3)); // 5
	}

}
