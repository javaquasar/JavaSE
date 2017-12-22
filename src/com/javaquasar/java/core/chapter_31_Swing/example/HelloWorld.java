package com.javaquasar.java.core.chapter_31_Swing.example;

import javax.swing.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class HelloWorld {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Привет");
		frame.getContentPane().add(new JLabel("Привет, мир!"));
		frame.pack();
		frame.setVisible(true);
	}

}
