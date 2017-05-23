package com.javaquasar.java.core.chapter_31_Swing;

import java.awt.event.*;
import javax.swing.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class TextFieldsAndButton extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1562119581212356078L;
	private JButton button;
	private JTextField field1, field2, field3;

	public TextFieldsAndButton() {
		button = new JButton("Найти сумму"); // определяем в конструкторе
												// надпись на кнопке
		button.addActionListener(this); // добавляем данный объект в качестве
										// "слушателя"
		field1 = new JTextField(6); // определяем в конструкторе размер поля в
									// позициях
		field2 = new JTextField(6);
		field3 = new JTextField(6);
		setSize(100, 120); // размеры окна
		add(field1);
		add(field2);
		add(button);
		add(field3);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			int i = Integer.parseInt(field1.getText());
			int j = Integer.parseInt(field2.getText());
			int k = i + j;
			field3.setText(k + "");
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(this, "Неправильные данные!");
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Текстовые поля и кнопки");
		frame.add(new TextFieldsAndButton());
		frame.pack();
		frame.setVisible(true);
	}

}
