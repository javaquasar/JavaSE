package core.lecture3_03_Own_containers.example;

public class SinglyLinkedList<E> {

	private class Node {
		E data;
		Node next;

		Node(E data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node first = null;
	private Node last = null;
	private int count = 0;

	public void add(E elem) {
		Node newNode = new Node(elem, null);
		if (last == null)
			first = newNode;
		else
			last.next = newNode;
		last = newNode;
		count++;
	}

	public void removeFirstOccurrence(E value) {
		// �������� ��������� ������ �������
		if (first != null && first.data.equals(value))
			first = first.next;
		else {
			Node link = first;
			while (link.next != null) {
				if (link.next.data.equals(value))
					link.next = link.next.next;
				if (link.next == null) {
					last = link;
					break; // ������� ��������� �������
				}
				link = link.next;
			}
		}
		count--;
	}

	public final int size() {
		return count;
	}

	@Override
	public String toString() {
		String s = "size = " + size() + "\n[";
		Node link = first;
		while (link != null) {
			s += link.data;
			link = link.next;
			if (link != null)
				s += ", ";
		}
		s += "]\n";
		return s;
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(list);
		// ������� ������� �������
		list.removeFirstOccurrence(3);
		System.out.println(list);
		// ������� ������ �������:
		list.removeFirstOccurrence(1);
		System.out.println(list);
		// ������� ��������� �������:
		list.removeFirstOccurrence(4);
		System.out.println(list);
	}
}
