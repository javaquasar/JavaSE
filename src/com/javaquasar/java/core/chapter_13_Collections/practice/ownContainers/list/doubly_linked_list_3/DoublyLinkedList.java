package com.javaquasar.java.core.chapter_13_Collections.practice.ownContainers.list.doubly_linked_list_3;

public class DoublyLinkedList {
	private class Node {
		String value;
		Node next, prev;

		public Node(String val, Node n, Node p) {
			value = val;
			next = n;
			prev = p;
		}

		Node(String val) {
			this(val, null, null);
		}
	}

	private Node first;
	private Node last;

	public DoublyLinkedList() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		int count = 0;
		Node p = first;
		while (p != null) {
			count++;
			p = p.next;
		}
		return count;
	}

	public void add(String e) {

		if (isEmpty()) {
			last = new Node(e);
			first = last;
		} else {
			last.next = new Node(e, null, last);
			last = last.next;
		}
	}

	public void add(int index, String e) {
		if (index < 0 || index > size()) {
			String message = String.valueOf(index);
			throw new IndexOutOfBoundsException(message);
		}
		if (index == 0) {
			Node p = first;
			first = new Node(e, p, null);
			if (p != null)
				p.prev = first;
			if (last == null)
				last = first;
			return;
		}
		Node pred = first;
		for (int k = 1; k <= index - 1; k++) {
			pred = pred.next;
		}
		Node succ = pred.next;
		Node middle = new Node(e, succ, pred);
		pred.next = middle;
		if (succ == null)
			last = middle;
		else
			succ.prev = middle;
	}

	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		Node p = first;
		while (p != null) {
			strBuilder.append(p.value + "\n");
			p = p.next;
		}
		return strBuilder.toString();
	}

	public String remove(int index) {
		if (index < 0 || index >= size()) {
			String message = String.valueOf(index);
			throw new IndexOutOfBoundsException(message);
		}
		Node target = first;
		for (int k = 1; k <= index; k++) {
			target = target.next;
		}
		String element = target.value;
		Node pred = target.prev;
		Node succ = target.next;
		if (pred == null)
			first = succ;
		else
			pred.next = succ;
		if (succ == null)
			last = pred;
		else
			succ.prev = pred;
		return element;
	}

	public boolean remove(String element) {
		if (isEmpty())
			return false;
		Node target = first;
		while (target != null && !element.equals(target.value))
			target = target.next;
		if (target == null)
			return false;
		Node pred = target.prev;
		Node succ = target.next;
		if (pred == null)
			first = succ;
		else
			pred.next = succ;
		if (succ == null)
			last = pred;
		else
			succ.prev = pred;
		return true;
	}

	public static void main(String[] args) {
		DoublyLinkedList list1 = new DoublyLinkedList();
		String[] array = { "a", "c", "e", "f" };
		for (int i = 0; i < array.length; i++) {
			list1.add(array[i]);
		}
		list1.add(1, "b");
		list1.add(3, "d");
		System.out.println(list1);

	}

}
