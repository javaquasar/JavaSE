package com.javaquasar.java.core.chapter_13_Collections.practice.ownContainers.list.doubly_linked_list_1;

public class Link {
	public int iData;
	public Link next;
	public Link previous;

	public Link(int id) {
		iData = id;
	}

	public String toString() {
		return "{" + iData + "} ";
	}
}

/*String s1 = new String("Артур");
String s2 = s1;

array[10]

1(int a = 2) -> 4(int a = 5) -> 2(int a = 5)  ->  3(int a = 6)*/