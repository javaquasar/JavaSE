package com.javaquasar.java.core.chapter_09_OOP.embedded_classes;

public class BaseTest {
	static void showBase(Base b) {
		b.show();
	}

	public static void main(String[] args) {
		showBase(new Base(10) {
			void show() {
				System.out.println(k);
			}
		});
	}

}