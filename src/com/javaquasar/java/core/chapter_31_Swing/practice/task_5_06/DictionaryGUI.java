package com.javaquasar.java.core.chapter_31_Swing.practice.task_5_06;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class DictionaryGUI extends JFrame implements ActionListener {

	private String pathToFile = null;
	private String answer = null;
	private int trueButton = 0;
	private static Dictionary dictionary = null;
	private JFileChooser chooser = new JFileChooser();
	private JButton buttonOpen;
	private JLabel buttonWord;
	private JLabel coment;
	private JButton[] buttons = new JButton[5];// { button1, button2, button3,
												// button4, button5 };

	public static void main(String[] args) {
		new DictionaryGUI("Dictionary").setVisible(true);
	}

	public DictionaryGUI(String title) {
		super(title);
		chooser.setFileFilter(new MyFileFilter(".txt", ""));
		// Необходимо закончить работу приложения, когда мы закроем главное
		// окно:
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		// Необходимо начинать поиск файлов из текущей папки проекта:
		chooser.setCurrentDirectory(new File("./file/"));
		setLayout(new FlowLayout());

		buttonOpen = new JButton("Загрузить словарь");
		// Определяем этот объект как обработчик событий:
		buttonOpen.addActionListener(this);
		// Добавляем кнопку:
		// getContentPane().add(buttonOpen, BorderLayout.NORTH);

		buttonWord = new JLabel("");
		// buttonWord.setEnabled(false);
		coment = new JLabel("Варианты");

		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton("");
			buttons[i].setEnabled(false);
			buttons[i].addActionListener(this);
		}

		Box box = Box.createVerticalBox();
		box.add(buttonOpen);
		box.add(Box.createVerticalStrut(10));
		box.add(buttonWord);
		box.add(Box.createVerticalStrut(10));
		box.add(coment);
		for (int i = 0; i < buttons.length; i++) {
			box.add(Box.createVerticalStrut(5));
			box.add(buttons[i]);
		}
		setContentPane(box);
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
				dictionary = Dictionary.getInstance(pathToFile, 100);
				try {
					dictionary.readFromFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				for (int i = 0; i < buttons.length; i++) {
					buttons[i].setEnabled(true);
				}
				randomWord();
			}
		} else if (e.getSource() == buttons[0]) {
			answerButton(0);
		} else if (e.getSource() == buttons[1]) {
			answerButton(1);
		} else if (e.getSource() == buttons[2]) {
			answerButton(2);
		} else if (e.getSource() == buttons[3]) {
			answerButton(3);
		} else if (e.getSource() == buttons[4]) {
			answerButton(4);
		}

	}

	public void randomWord() {
		buttonWord.setText(dictionary.getRandomKey());
		answer = dictionary.getValue(buttonWord.getText());
		buttons[getTrueButton()].setText(answer);
		String textButton = null;
		boolean work;
		for (int i = 0; i < 5; i++) {
			if (i != trueButton) {
				work = true;
				while (work) {
					textButton = dictionary.getRandomValue();
					if (answer != textButton) {
						buttons[i].setText(textButton);
						work = false;
					}
				}
			}
		}
	}

	private void setRandomButton() {
		trueButton = (int) (Math.random() * 4);
	}

	public int getTrueButton() {
		setRandomButton();
		return trueButton;
	}

	private void answerButton(int i) {
		if (trueButton == i) {
			JOptionPane.showMessageDialog(this, "Правильный ответ");
			randomWord();
		} else {
			JOptionPane.showMessageDialog(this, "Неверный ответ! Правильный ответ - " + answer);
			randomWord();
		}
	}
}
