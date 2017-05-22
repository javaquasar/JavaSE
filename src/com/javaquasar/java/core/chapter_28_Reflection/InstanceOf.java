package com.javaquasar.java.core.chapter_28_Reflection;

import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
class First {

	void first() {
		System.out.println("First");
	}

}

class Second {

	void second() {
		System.out.println("Second");
	}

}

public class InstanceOf {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			Object o;
			int n = new Scanner(System.in).nextInt();
			switch (n) {
			case 1:
				o = new First();
				break;
			case 2:
				o = new Second();
				break;
			default:
				return;
			}
			if (o instanceof First)
				((First) o).first();
			if (o instanceof Second)
				((Second) o).second();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
