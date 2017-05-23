package com.javaquasar.java.core.chapter_31_Swing;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class SumWriter extends JFrame implements ActionListener {
	private JFileChooser chooser = new JFileChooser();
	private JButton buttonOpen;
	private JButton buttonSave;
	private double a, b;

	public SumWriter(String title) {
		super(title);
		// Необходимо закончить работу приложения, когда мы закроем главное
		// окно:
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		// Необходимо начинать поиск файлов из текущей папки проекта:
		chooser.setCurrentDirectory(new File("."));
		setLayout(new FlowLayout());
		buttonOpen = new JButton("Загрузить данные");
		// Определяем этот объект как обработчик событий:
		buttonOpen.addActionListener(this);
		// Добавляем кнопку:
		add(buttonOpen);
		buttonSave = new JButton("Сохранить сумму");
		// Определяем этот объект как обработчик событий:
		buttonSave.addActionListener(this);
		// Добавляем кнопку:
		add(buttonSave);
		// Приспосабливаем размеры главного окна:
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Событие сгенерировала кнопка buttonOpen:
		if (e.getSource() == buttonOpen) {
			if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				readFromFile(chooser.getSelectedFile().getPath());
			}
		}
		// Событие сгенерировала кнопка buttonSave:
		else {
			if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				writeToFile(chooser.getSelectedFile().getPath());
			}
		}
	}

	private void readFromFile(String fileName) {
		try {
			FileReader reader = new FileReader(fileName);
			Scanner scanner = new Scanner(reader);
			try {
				a = scanner.nextDouble();
				b = scanner.nextDouble();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Неправильный формат файла!", "Ошибка", JOptionPane.ERROR_MESSAGE);
			} finally {
				reader.close();
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ошибка чтения из файла!", "Ошибка", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void writeToFile(String fileName) {
		// Проверяем наличие файла:
		if (new File(fileName).exists()) {
			if (JOptionPane.showConfirmDialog(null, "Файл существует. Переписать?") != JOptionPane.YES_OPTION)
				return;
		}
		try {
			PrintWriter out = new PrintWriter(new FileWriter(fileName));
			out.println(a + b);
			out.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Нельзя создать файл!", "Ошибка", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String[] args) {
		// Создаем и показываем главное окно:
		new SumWriter("Сумма").setVisible(true);
	}

}
