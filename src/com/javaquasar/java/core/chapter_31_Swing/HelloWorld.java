package com.javaquasar.java.core.chapter_31_Swing;

import javax.swing.*;

public class HelloWorld {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Привет");
		frame.getContentPane().add(new JLabel("Привет, мир!"));
		frame.pack();
		frame.setVisible(true);
	}

}
