package com.javaquasar.java.core.chapter_11_String;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class StringBufferTest {

	public static void main(String[] args) {
		String s = "abc";
		StringBuffer sb = new StringBuffer(s);
		sb.append("d"); // abcd
		sb.setCharAt(0, 'f'); // fbcd
		sb.delete(1, 3); // fd
		sb.insert(1, "gh"); // fghd
		sb.replace(2, 3, "mn"); // fgmnd
		sb.reverse(); // dnmgf
		System.out.println(sb);
	}

}
