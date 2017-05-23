package com.javaquasar.java.core.chapter_31_Swing;

import java.awt.event.*;
import javax.swing.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class ButtonTest {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Привет");
		frame.getContentPane().setLayout(null);
		JButton jButton = new JButton("Нажми меня!");
		jButton.setBounds(30, 20, 150, 30);
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Привет!");
			}
		});
		frame.getContentPane().add(jButton);
		frame.setBounds(100, 100, 210, 100);
		frame.setVisible(true);
	}
}
