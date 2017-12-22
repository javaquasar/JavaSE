package com.javaquasar.java.core.chapter_20_Thread.practice.task_7_01;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ThreadSynchronization {

	private static double sum = 0;
	private static double product;
	private static Thread t1, t2;
	private static ArrayList<Double> mas;
	private StringTokenizer stringTokenizer;

	private JFrame frame;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton button;
	private JLabel labelSum;
	private JLabel labelSumValue;
	private JLabel labelProduct;
	private JLabel labelProductValue;
	private JLabel label;
	private JLabel labelSumValueAverage;
	private JLabel labelProductValueAverage;
	private JScrollPane scrollPane_1;
	private JTextArea textArea_1;
	private JLabel label_1;
	private JLabel label_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThreadSynchronization window = new ThreadSynchronization();
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
	public ThreadSynchronization() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getButton());
		frame.getContentPane().add(getLabelSum());
		frame.getContentPane().add(getLabelSumValue());
		frame.getContentPane().add(getLabelProduct());
		frame.getContentPane().add(getLabelProductValue());
		frame.getContentPane().add(getLabel());
		frame.getContentPane().add(getLabelSumValueAverage());
		frame.getContentPane().add(getLabelProductValueAverage());
		frame.getContentPane().add(getScrollPane_1());
		frame.getContentPane().add(getLabel_1());
		frame.getContentPane().add(getLabel_2());
		frame.setResizable(false); 
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 64, 117, 310);
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}

	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}

	private JButton getButton() {
		if (button == null) {
			button = new JButton("Посчитать");
			button.setBounds(6, 5, 117, 29);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					stringTokenizer = new StringTokenizer(getTextArea().getText());
					mas = new ArrayList<>();
					getTextArea_1().setText("");
					String s = null;
						while (stringTokenizer.hasMoreTokens()) {
							s = stringTokenizer.nextToken();
							try {
							mas.add(Double.parseDouble(s));
							} catch (NumberFormatException e1) {
								JOptionPane.showMessageDialog(null, "Ошибка ввода данных: " + s, "Ошибка", JOptionPane.ERROR_MESSAGE);
							}
						}
						//System.out.println(mas.toString());
						t1 = new Thread(new FirstThread());
						t2 = new Thread(new SecondThread());
						t2.start();
						t1.start();
				}
			});
		}
		return button;
	}

	private JLabel getLabelSum() {
		if (labelSum == null) {
			labelSum = new JLabel("Сумма:");
			labelSum.setHorizontalAlignment(SwingConstants.RIGHT);
			labelSum.setBounds(193, 48, 45, 16);
		}
		return labelSum;
	}

	private JLabel getLabelSumValue() {
		if (labelSumValue == null) {
			labelSumValue = new JLabel("");
			labelSumValue.setForeground(Color.BLUE);
			labelSumValue.setHorizontalAlignment(SwingConstants.LEFT);
			labelSumValue.setBounds(250, 48, 61, 16);
		}
		return labelSumValue;
	}

	private JLabel getLabelProduct() {
		if (labelProduct == null) {
			labelProduct = new JLabel("Произведение:");
			labelProduct.setHorizontalAlignment(SwingConstants.RIGHT);
			labelProduct.setBounds(135, 76, 103, 16);
		}
		return labelProduct;
	}

	private JLabel getLabelProductValue() {
		if (labelProductValue == null) {
			labelProductValue = new JLabel("");
			labelProductValue.setForeground(Color.BLUE);
			labelProductValue.setHorizontalAlignment(SwingConstants.LEFT);
			labelProductValue.setBounds(250, 76, 61, 16);
		}
		return labelProductValue;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Среднее");
			label.setForeground(Color.BLACK);
			label.setBounds(333, 10, 61, 16);
		}
		return label;
	}

	private JLabel getLabelSumValueAverage() {
		if (labelSumValueAverage == null) {
			labelSumValueAverage = new JLabel("");
			labelSumValueAverage.setForeground(Color.RED);
			labelSumValueAverage.setHorizontalAlignment(SwingConstants.LEFT);
			labelSumValueAverage.setBounds(333, 48, 61, 16);
		}
		return labelSumValueAverage;
	}

	private JLabel getLabelProductValueAverage() {
		if (labelProductValueAverage == null) {
			labelProductValueAverage = new JLabel("");
			labelProductValueAverage.setForeground(Color.RED);
			labelProductValueAverage.setHorizontalAlignment(SwingConstants.LEFT);
			labelProductValueAverage.setBounds(333, 76, 61, 16);
		}
		return labelProductValueAverage;
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(135, 124, 259, 250);
			scrollPane_1.setViewportView(getTextArea_1());
		}
		return scrollPane_1;
	}

	private JTextArea getTextArea_1() {
		if (textArea_1 == null) {
			textArea_1 = new JTextArea();
		}
		return textArea_1;
	}

	class FirstThread implements Runnable {
		@Override
		public void run() {
			print("Поток First запущен.\n");
			if (mas.size() != 0) {
				product = mas.get(0);
				for(int i = 1; i < mas.size(); i++) {
					product *= mas.get(i);
				}
			}		
			getLabelProductValue().setText("" + product);
			print("Поток First заврешен.\n");
		}
	}

	class SecondThread implements Runnable {
		@Override
		public void run() {
			try {
				print("Поток Second запущен.\n");
				for(double s : mas) {
					sum += s;
				}
				getLabelSumValue().setText("" + sum);
				print("Основная работа потока Second завершена.\n");
				t1.join();
				getLabelSumValueAverage().setText("" + sum/mas.size());
				getLabelProductValueAverage().setText("" + product/mas.size());
				print("Поток Second заврешен.\n");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private synchronized void print(String s) {
		getTextArea_1().append(s + "\n");
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("Область ввода");
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			label_1.setBounds(6, 45, 117, 16);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("Область вывода");
			label_2.setHorizontalAlignment(SwingConstants.CENTER);
			label_2.setBounds(135, 104, 259, 16);
		}
		return label_2;
	}
}
