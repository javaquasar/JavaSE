package com.javaquasar.java.core.chapter_28_Reflection;

import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
class One {

	void one() {
		System.out.println("one");
	}

}

public class NewInstance {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			String name = new Scanner(System.in).next();
			//String name = "NewInstance.One";
			Object o = Class.forName(name).newInstance();
			if (o instanceof One)
				((One) o).one();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
