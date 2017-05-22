package com.javaquasar.java.core.chapter_02_Primitive_Data_Types.char_type;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class Unicodes {

	public static void main(String[] args) {
		for (char c = 'А'; c <= 'я'; c++) {
			System.out.println(c + " " + (int) c);
		}

		for (char c = 'A'; c <= 'z'; c++) {
			System.out.println(c + " " + (int) c);
		}
	}

}
