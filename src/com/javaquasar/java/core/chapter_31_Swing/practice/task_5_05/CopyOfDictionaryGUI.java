package com.javaquasar.java.core.chapter_31_Swing.practice.task_5_05;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class CopyOfDictionaryGUI extends JFrame implements ActionListener {

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
		new CopyOfDictionaryGUI("Dictionary").setVisible(true);
		
		// new Dictionary(fileDictionary).readFromFile(fileDictionary);

		// dictionary = Dictionary.getInstance(fileDictionary);
		// dictionary.readFromFile(); dictionary.add(" Horse ", " КонЬ ");
		// dictionary.writeToFile();

	}

	public CopyOfDictionaryGUI(String title) {
		super(title);
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
		getContentPane().add(buttonOpen, BorderLayout.NORTH);
		
		buttonFind = new JButton("Найти");
		// Определяем этот объект как обработчик событий:
		buttonFind.addActionListener(this);
		// Добавляем кнопку:
		getContentPane().add(buttonFind, BorderLayout.NORTH);
		
		buttonAdd = new JButton("Добавить");
		// Определяем этот объект как обработчик событий:
		buttonAdd.addActionListener(this);
		// Добавляем кнопку:
		getContentPane().add(buttonAdd, BorderLayout.NORTH);
		
		buttonDelete = new JButton("Удалить");
		// Определяем этот объект как обработчик событий:
		buttonDelete.addActionListener(this);
		// Добавляем кнопку:
		getContentPane().add(buttonDelete, BorderLayout.NORTH);
		
		//add(buttonOpen);
		buttonSave = new JButton("Сохранить словарь");
		// Определяем этот объект как обработчик событий:
		buttonSave.addActionListener(this);
		// Добавляем кнопку:
		getContentPane().add(buttonSave, BorderLayout.NORTH);
		//add(buttonSave);
		
		field1 = new JTextField(15);
		getContentPane().add(field1, BorderLayout.SOUTH);
		
		field2 = new JTextField(15);
		getContentPane().add(field2, BorderLayout.SOUTH);
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
				try {
					dictionary.readFromFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		// Событие сгенерировала кнопка buttonSave:
		else if (e.getSource() == buttonSave){
			if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				try {
					dictionary.writeToFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

	}
}
