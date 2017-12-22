package com.javaquasar.java.core.chapter_31_Swing.practice.task_5_05;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class DictionaryGUI extends JFrame implements ActionListener {

	private String pathToFile = null;
	private static Dictionary dictionary = null;
	private JFileChooser chooser = new JFileChooser();
	private JButton buttonOpen;
	private JButton buttonSave;
	private JButton buttonFind;
	private JButton buttonAdd;
	private JButton buttonDelete;
	private JTextField field1, field2;

	public static void main(String[] args) {

		// String fileDictionary =
		// "./file/lecture_3_09_task_5_05_dictionary.txt";
		new DictionaryGUI("Dictionary").setVisible(true);

		// new Dictionary(fileDictionary).readFromFile(fileDictionary);

		// dictionary = Dictionary.getInstance(fileDictionary);
		// dictionary.readFromFile(); dictionary.add(" Horse ", " КонЬ ");
		// dictionary.writeToFile();

	}

	public DictionaryGUI(String title) {
		super(title);
		chooser.setFileFilter(new MyFileFilter(".txt",""));
		// Необходимо закончить работу приложения, когда мы закроем главное
		// окно:
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		// Необходимо начинать поиск файлов из текущей папки проекта:
		chooser.setCurrentDirectory(new File("."));
		setLayout(new FlowLayout());

		buttonOpen = new JButton("Загрузить словарь");
		// Определяем этот объект как обработчик событий:
		buttonOpen.addActionListener(this);
		// Добавляем кнопку:
		// getContentPane().add(buttonOpen, BorderLayout.NORTH);

		buttonFind = new JButton("Найти слово");
		buttonFind.setEnabled(false);
		// Определяем этот объект как обработчик событий:
		buttonFind.addActionListener(this);
		// Добавляем кнопку:
		// getContentPane().add(buttonFind, BorderLayout.NORTH);

		buttonAdd = new JButton("Добавить слово");
		buttonAdd.setEnabled(false);
		// Определяем этот объект как обработчик событий:
		buttonAdd.addActionListener(this);
		// Добавляем кнопку:
		// getContentPane().add(buttonAdd, BorderLayout.NORTH);

		buttonDelete = new JButton("Удалить слово");
		buttonDelete.setEnabled(false);
		// Определяем этот объект как обработчик событий:
		buttonDelete.addActionListener(this);
		// Добавляем кнопку:
		// getContentPane().add(buttonDelete, BorderLayout.NORTH);

		// add(buttonOpen);
		buttonSave = new JButton("Сохранить словарь");
		buttonSave.setEnabled(false);
		// Определяем этот объект как обработчик событий:
		buttonSave.addActionListener(this);
		// Добавляем кнопку:
		// getContentPane().add(buttonSave, BorderLayout.NORTH);
		// add(buttonSave);

		field1 = new JTextField(15);
		field1.setEnabled(false);
		field1.setText("Английское слово");
		// getContentPane().add(field1, BorderLayout.SOUTH);

		field2 = new JTextField(15);
		field2.setEnabled(false);
		field2.setText("Перевод");
		// getContentPane().add(field2, BorderLayout.SOUTH);

		Box box = Box.createVerticalBox();
		box.add(buttonOpen);
		box.add(Box.createVerticalStrut(10));
		box.add(buttonSave);
		box.add(Box.createVerticalStrut(10));
		box.add(buttonFind);
		box.add(Box.createVerticalStrut(10));
		box.add(buttonAdd);
		box.add(Box.createVerticalStrut(10));
		box.add(buttonDelete);
		box.add(Box.createVerticalStrut(10));
		box.add(field1);
		box.add(Box.createVerticalStrut(10));
		box.add(field2);
		setContentPane(box);

		// Приспосабливаем размеры главного окна:
		pack();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Событие сгенерировала кнопка buttonOpen:
		if (e.getSource() == buttonOpen) {
			if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				pathToFile = chooser.getSelectedFile().getPath();
				dictionary = Dictionary.getInstance(pathToFile);
				
				buttonSave.setEnabled(true);
				buttonFind.setEnabled(true);
				buttonAdd.setEnabled(true);
				buttonDelete.setEnabled(true);
				field1.setEnabled(true);
				
				field2.setEnabled(true);
				
				try {
					dictionary.readFromFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		// Событие сгенерировала кнопка buttonSave:
		else if (e.getSource() == buttonSave) {
			if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				try {
					dictionary.writeToFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		// Событие сгенерировала кнопка buttonFind:
		else if (e.getSource() == buttonFind) {
			if (field1.getText() != null) {
				if (dictionary.containsKey(field1.getText())) {
					field2.setText(dictionary.getValue(field1.getText()));
				} else {
					JOptionPane.showConfirmDialog(null, "Такое слова нет! Продолжить?");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Необходимо заполнить поле!");
			}
		}
		// Событие сгенерировала кнопка buttonAdd:
		else if (e.getSource() == buttonAdd) {
			if ((field1.getText() != null) && (field2.getText() != null)) {
				if (!dictionary.containsKey(field1.getText())) {
					dictionary.add(field1.getText(), field2.getText());
				} else {
					if (JOptionPane.showConfirmDialog(null, "Такое слово уже есть! Продолжить?") != JOptionPane.YES_OPTION) {
						dictionary.add(field1.getText(), field2.getText());
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Необходимо заполнить поля!");
			}
		}
		// Событие сгенерировала кнопка buttonDelete:
		else if (e.getSource() == buttonDelete) {
			if (field1.getText() != null) {
				if (dictionary.containsKey(field1.getText())) {
					dictionary.delete(field1.getText());
				} else {
					JOptionPane.showConfirmDialog(null, "Такое слова нет! Продолжить?");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Необходимо заполнить поле!");
			}
		}

	}
}
