package com.javaquasar.java.core.chapter_31_Swing.example;

import javax.swing.JOptionPane;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class DialogsDemo {

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Необходимо ввести число!");
		
		
		do {
			double a = 0;
			try {
				a = Double.parseDouble(JOptionPane.showInputDialog("Введите действительное число"));
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Необходимо ввести число!");
			}
			if (a == 0)
				JOptionPane.showMessageDialog(null, "Неправильное значение!");
			else
				JOptionPane.showMessageDialog(null, "Обратная величина: " + 1 / a);
			if (JOptionPane.showConfirmDialog(null, "Продолжить?") != JOptionPane.YES_OPTION)
				break;
		} while (true);
	}

}
