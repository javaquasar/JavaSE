package core.lecture3_09_Swing.practice.task_5_06;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import java.awt.GridBagConstraints;

import javax.swing.JButton;

import java.awt.Insets;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.Dimension;

public class GUI implements ActionListener{
	
	private String pathToFile = null;
	private String answer = null;
	private int trueButton = 0;
	private static Dictionary dictionary = null;
	private JFileChooser chooser = new JFileChooser();
	private JButton[] buttons = new JButton[5];
	
	private int countRightAnswer = 0;
	private int countFalseAnswer = 0;
	private int countAnswer = 0;

	private JFrame frame;
	private JPanel panelWord;
	private JLabel labelWord;
	private JPanel panel;
	private JLabel label;
	private JButton button0;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JPanel panelProgres;
	private JProgressBar progressBar;
	private JPanel panelProgresOld;
	private JProgressBar progressBarOld;
	private JButton buttonOpen;
	private JButton buttonSave;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Событие сгенерировала кнопка buttonOpen:
		if (e.getSource() == buttonOpen) {
			if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
				pathToFile = chooser.getSelectedFile().getPath();
				dictionary = Dictionary.getInstance(pathToFile, 50);
				try {
					dictionary.readFromFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				for (int i = 0; i < buttons.length; i++) {
					buttons[i].setEnabled(true);
				}
				countRightAnswer = 0;
				countFalseAnswer = 0;
				countAnswer = 0;
				getProgressBarOld().setValue(dictionary.getProgress());
				getProgressBar().setValue(100);
				randomWord();
			}
		}else if (e.getSource() == buttonSave) {
			try {
				dictionary.writeToFile();
			} catch (IOException e1) {
				e1.printStackTrace();
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		buttons[0] = getButton0();
		buttons[1] = getButton1();
		buttons[2] = getButton2();
		buttons[3] = getButton3();
		buttons[4] = getButton4();
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].addActionListener(this);
		}
		chooser.setFileFilter(new MyFileFilter(".txt", ""));
		chooser.setCurrentDirectory(new File("./file/"));
		frame = new JFrame();
		frame.setBounds(500, 500, 180, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{50, 50, 0};
		gridBagLayout.rowHeights = new int[]{30, 30, 30, 0, 0, 0, 0, 0, 0, 30, 30, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		GridBagConstraints gbc_buttonOpen = new GridBagConstraints();
		gbc_buttonOpen.gridwidth = 2;
		gbc_buttonOpen.fill = GridBagConstraints.HORIZONTAL;
		gbc_buttonOpen.insets = new Insets(5, 5, 5, 5);
		gbc_buttonOpen.gridx = 0;
		gbc_buttonOpen.gridy = 0;
		frame.getContentPane().add(getButtonOpen(), gbc_buttonOpen);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.gridwidth = 2;
		gbc_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_button.insets = new Insets(5, 5, 5, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 1;
		frame.getContentPane().add(getButtonSave(), gbc_button);
		GridBagConstraints gbc_panelWord = new GridBagConstraints();
		gbc_panelWord.gridwidth = 2;
		gbc_panelWord.insets = new Insets(5, 5, 5, 5);
		gbc_panelWord.fill = GridBagConstraints.BOTH;
		gbc_panelWord.gridx = 0;
		gbc_panelWord.gridy = 2;
		frame.getContentPane().add(getPanelWord(), gbc_panelWord);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(5, 5, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		frame.getContentPane().add(getPanel(), gbc_panel);
		GridBagConstraints gbc_button0 = new GridBagConstraints();
		gbc_button0.gridwidth = 2;
		gbc_button0.fill = GridBagConstraints.HORIZONTAL;
		gbc_button0.insets = new Insets(0, 2, 0, 2);
		gbc_button0.gridx = 0;
		gbc_button0.gridy = 4;
		frame.getContentPane().add(getButton0(), gbc_button0);
		GridBagConstraints gbc_button1 = new GridBagConstraints();
		gbc_button1.gridwidth = 2;
		gbc_button1.fill = GridBagConstraints.HORIZONTAL;
		gbc_button1.insets = new Insets(0, 2, 0, 2);
		gbc_button1.gridx = 0;
		gbc_button1.gridy = 5;
		frame.getContentPane().add(getButton1(), gbc_button1);
		GridBagConstraints gbc_button2 = new GridBagConstraints();
		gbc_button2.gridwidth = 2;
		gbc_button2.fill = GridBagConstraints.HORIZONTAL;
		gbc_button2.insets = new Insets(0, 2, 0, 2);
		gbc_button2.gridx = 0;
		gbc_button2.gridy = 6;
		frame.getContentPane().add(getButton2(), gbc_button2);
		GridBagConstraints gbc_button3 = new GridBagConstraints();
		gbc_button3.gridwidth = 2;
		gbc_button3.fill = GridBagConstraints.HORIZONTAL;
		gbc_button3.insets = new Insets(0, 2, 0, 2);
		gbc_button3.gridx = 0;
		gbc_button3.gridy = 7;
		frame.getContentPane().add(getButton3(), gbc_button3);
		GridBagConstraints gbc_button4 = new GridBagConstraints();
		gbc_button4.gridwidth = 2;
		gbc_button4.insets = new Insets(0, 2, 0, 2);
		gbc_button4.fill = GridBagConstraints.HORIZONTAL;
		gbc_button4.gridx = 0;
		gbc_button4.gridy = 8;
		frame.getContentPane().add(getButton4(), gbc_button4);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(2, 2, 2, 2);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 9;
		frame.getContentPane().add(getLblNewLabel(), gbc_lblNewLabel);
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 5, 0, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 10;
		frame.getContentPane().add(getLabel_1(), gbc_label_1);
		GridBagConstraints gbc_panelProgres = new GridBagConstraints();
		gbc_panelProgres.insets = new Insets(0, 5, 0, 5);
		gbc_panelProgres.fill = GridBagConstraints.BOTH;
		gbc_panelProgres.gridx = 1;
		gbc_panelProgres.gridy = 10;
		frame.getContentPane().add(getPanelProgres(), gbc_panelProgres);
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 5, 0, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 11;
		frame.getContentPane().add(getLabel_2(), gbc_label_2);
		GridBagConstraints gbc_panelProgresOld = new GridBagConstraints();
		gbc_panelProgresOld.insets = new Insets(0, 5, 0, 5);
		gbc_panelProgresOld.fill = GridBagConstraints.BOTH;
		gbc_panelProgresOld.gridx = 1;
		gbc_panelProgresOld.gridy = 11;
		frame.getContentPane().add(getPanelProgresOld(), gbc_panelProgresOld);
	}
	private JPanel getPanelWord() {
		if (panelWord == null) {
			panelWord = new JPanel();
			panelWord.setForeground(Color.RED);
			panelWord.add(getLabelWord());
		}
		return panelWord;
	}
	private JLabel getLabelWord() {
		if (labelWord == null) {
			labelWord = new JLabel("");
		}
		return labelWord;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getLabel());
		}
		return panel;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Варианты:");
		}
		return label;
	}
	private JButton getButton0() {
		if (button0 == null) {
			button0 = new JButton("");
			button0.setEnabled(false);
		}
		return button0;
	}
	private JButton getButton1() {
		if (button1 == null) {
			button1 = new JButton("");
			button1.setEnabled(false);
		}
		return button1;
	}
	private JButton getButton2() {
		if (button2 == null) {
			button2 = new JButton("");
			button2.setEnabled(false);
		}
		return button2;
	}
	private JButton getButton3() {
		if (button3 == null) {
			button3 = new JButton("");
			button3.setEnabled(false);
		}
		return button3;
	}
	private JButton getButton4() {
		if (button4 == null) {
			button4 = new JButton("");
			button4.setEnabled(false);
		}
		return button4;
	}
	private JPanel getPanelProgres() {
		if (panelProgres == null) {
			panelProgres = new JPanel();
			panelProgres.add(getProgressBar());
		}
		return panelProgres;
	}
	private JProgressBar getProgressBar() {
		if (progressBar == null) {
			progressBar = new JProgressBar();
			progressBar.setPreferredSize(new Dimension(60, 20));
			progressBar.setStringPainted(true);
		}
		return progressBar;
	}
	private JPanel getPanelProgresOld() {
		if (panelProgresOld == null) {
			panelProgresOld = new JPanel();
			panelProgresOld.add(getProgressBarOld());
		}
		return panelProgresOld;
	}
	private JProgressBar getProgressBarOld() {
		if (progressBarOld == null) {
			progressBarOld = new JProgressBar();
			progressBarOld.setPreferredSize(new Dimension(60, 20));
			progressBarOld.setStringPainted(true);
			progressBarOld.setToolTipText("");
		}
		return progressBarOld;
	}
	private JButton getButtonOpen() {
		if (buttonOpen == null) {
			buttonOpen = new JButton("Открыть словарь");
			buttonOpen.setForeground(Color.BLUE);
			buttonOpen.addActionListener(this);
		}
		return buttonOpen;
	}
	private JButton getButtonSave() {
		if (buttonSave == null) {
			buttonSave = new JButton("Сохранить");
			buttonSave.setForeground(Color.BLUE);
			buttonSave.addActionListener(this);
		}
		return buttonSave;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("Текущий:");
			label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("Старый:");
		}
		return label_2;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Прогресс");
		}
		return lblNewLabel;
	}
	
	public void randomWord() {
		getLabelWord().setText(dictionary.getRandomKey());
		answer = dictionary.getValue(getLabelWord().getText());
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
			JOptionPane.showMessageDialog(frame, "Правильный ответ");
			randomWord();
			countRightAnswer++;
			countAnswer++;
			getProgressBar().setValue(setProgressBar());
			dictionary.setProgress(setProgressBar());
		} else {
			JOptionPane.showMessageDialog(frame, "Неверный ответ! Правильный ответ - " + answer);
			randomWord();
			countFalseAnswer++;
			countAnswer++;
			getProgressBar().setValue(setProgressBar());
			dictionary.setProgress(setProgressBar());
		}
	}
	
	private int setProgressBar() {
		//System.out.println((countRightAnswer*100)/countAnswer);
		return (countRightAnswer*100)/countAnswer;
	}
}
