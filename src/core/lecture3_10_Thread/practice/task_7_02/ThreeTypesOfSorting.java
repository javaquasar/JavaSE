package core.lecture3_10_Thread.practice.task_7_02;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ThreeTypesOfSorting {

	private boolean paused = false;

	private ThreadBubble threadBubble;
	private ThreadBubbleBest threadBubbleBest;
	private ThreadSelect threadSelect;
	private ThreadQuick threadQuick;
	private ThreadСreation threadСreation;
	private static ArrayList<Double> mas;
	private StringTokenizer stringTokenizer;

	private JFrame frame;
	private JPanel panel;
	private JButton buttonStart;
	private JButton buttonPause;
	private JButton buttonResume;
	private JButton buttonStop;
	private JLabel labelInput;
	private JLabel labelBubble;
	private JLabel labelSelection;
	private JLabel labelQuick;
	private JScrollPane scrollPaneInput;
	private JScrollPane scrollPaneBubble;
	private JScrollPane scrollPaneSelection;
	private JScrollPane scrollPaneQuick;
	private JLabel labelTimeBubble;
	private JLabel labelTimeSelection;
	private JLabel labelTimeQuick;
	private JTextArea textAreaInput;
	private JTextArea textAreaBubble;
	private JTextArea textAreaSelection;
	private JTextArea textAreaQuick;
	private JPanel panelRandom;
	private JButton buttonGeneration;
	private JTextField textFieldCount;
	private JButton btnNewButtoncСeaning;
	private JLabel labelCount;
	private JLabel labelFrom;
	private JTextField textFieldFrom;
	private JLabel labelTo;
	private JTextField textFieldTo;
	private JLabel labelBubbleBest;
	private JScrollPane scrollPaneBubbleBest;
	private JTextArea textAreaBubbleBest;
	private JLabel labelTimeBubbleBest;
	private JLabel labelTimeInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThreeTypesOfSorting window = new ThreeTypesOfSorting();
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
	public ThreeTypesOfSorting() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Сортировки");
		frame.setBounds(100, 100, 700, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 140, 140, 140, 140, 140, 0 };
		gridBagLayout.rowHeights = new int[] { 30, 30, 30, 0, 30, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 5;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(getPanel(), gbc_panel);
		GridBagConstraints gbc_panelRandom = new GridBagConstraints();
		gbc_panelRandom.gridwidth = 5;
		gbc_panelRandom.insets = new Insets(0, 0, 5, 0);
		gbc_panelRandom.fill = GridBagConstraints.BOTH;
		gbc_panelRandom.gridx = 0;
		gbc_panelRandom.gridy = 1;
		frame.getContentPane().add(getPanelRandom(), gbc_panelRandom);
		GridBagConstraints gbc_labelInput = new GridBagConstraints();
		gbc_labelInput.insets = new Insets(0, 0, 5, 5);
		gbc_labelInput.gridx = 0;
		gbc_labelInput.gridy = 2;
		frame.getContentPane().add(getLabelInput(), gbc_labelInput);
		GridBagConstraints gbc_labelBubble = new GridBagConstraints();
		gbc_labelBubble.insets = new Insets(0, 0, 5, 5);
		gbc_labelBubble.gridx = 1;
		gbc_labelBubble.gridy = 2;
		frame.getContentPane().add(getLabelBubble(), gbc_labelBubble);
		GridBagConstraints gbc_labelBubbleBest = new GridBagConstraints();
		gbc_labelBubbleBest.insets = new Insets(0, 0, 5, 5);
		gbc_labelBubbleBest.gridx = 2;
		gbc_labelBubbleBest.gridy = 2;
		frame.getContentPane().add(getLabelBubbleBest(), gbc_labelBubbleBest);
		GridBagConstraints gbc_labelSelection = new GridBagConstraints();
		gbc_labelSelection.insets = new Insets(0, 0, 5, 5);
		gbc_labelSelection.gridx = 3;
		gbc_labelSelection.gridy = 2;
		frame.getContentPane().add(getLabelSelection(), gbc_labelSelection);
		GridBagConstraints gbc_labelQuick = new GridBagConstraints();
		gbc_labelQuick.insets = new Insets(0, 0, 5, 0);
		gbc_labelQuick.gridx = 4;
		gbc_labelQuick.gridy = 2;
		frame.getContentPane().add(getLabelQuick(), gbc_labelQuick);
		GridBagConstraints gbc_scrollPaneInput = new GridBagConstraints();
		gbc_scrollPaneInput.insets = new Insets(0, 5, 5, 5);
		gbc_scrollPaneInput.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneInput.gridx = 0;
		gbc_scrollPaneInput.gridy = 3;
		frame.getContentPane().add(getScrollPaneInput(), gbc_scrollPaneInput);
		GridBagConstraints gbc_scrollPaneBubble = new GridBagConstraints();
		gbc_scrollPaneBubble.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneBubble.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneBubble.gridx = 1;
		gbc_scrollPaneBubble.gridy = 3;
		frame.getContentPane().add(getScrollPaneBubble(), gbc_scrollPaneBubble);
		GridBagConstraints gbc_scrollPaneBubbleBest = new GridBagConstraints();
		gbc_scrollPaneBubbleBest.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneBubbleBest.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneBubbleBest.gridx = 2;
		gbc_scrollPaneBubbleBest.gridy = 3;
		frame.getContentPane().add(getScrollPaneBubbleBest(), gbc_scrollPaneBubbleBest);
		GridBagConstraints gbc_scrollPaneSelection = new GridBagConstraints();
		gbc_scrollPaneSelection.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneSelection.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneSelection.gridx = 3;
		gbc_scrollPaneSelection.gridy = 3;
		frame.getContentPane().add(getScrollPaneSelection(), gbc_scrollPaneSelection);
		GridBagConstraints gbc_scrollPaneQuick = new GridBagConstraints();
		gbc_scrollPaneQuick.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneQuick.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneQuick.gridx = 4;
		gbc_scrollPaneQuick.gridy = 3;
		frame.getContentPane().add(getScrollPaneQuick(), gbc_scrollPaneQuick);
		GridBagConstraints gbc_labelTimeInput = new GridBagConstraints();
		gbc_labelTimeInput.insets = new Insets(0, 0, 5, 5);
		gbc_labelTimeInput.gridx = 0;
		gbc_labelTimeInput.gridy = 4;
		frame.getContentPane().add(getLabelTimeInput(), gbc_labelTimeInput);
		GridBagConstraints gbc_labelTimeBubble = new GridBagConstraints();
		gbc_labelTimeBubble.insets = new Insets(0, 0, 5, 5);
		gbc_labelTimeBubble.gridx = 1;
		gbc_labelTimeBubble.gridy = 4;
		frame.getContentPane().add(getLabelTimeBubble(), gbc_labelTimeBubble);
		GridBagConstraints gbc_labelTimeBubbleBest = new GridBagConstraints();
		gbc_labelTimeBubbleBest.insets = new Insets(0, 0, 5, 5);
		gbc_labelTimeBubbleBest.gridx = 2;
		gbc_labelTimeBubbleBest.gridy = 4;
		frame.getContentPane().add(getLabelTimeBubbleBest(), gbc_labelTimeBubbleBest);
		GridBagConstraints gbc_labelTimeSelection = new GridBagConstraints();
		gbc_labelTimeSelection.insets = new Insets(0, 0, 5, 5);
		gbc_labelTimeSelection.gridx = 3;
		gbc_labelTimeSelection.gridy = 4;
		frame.getContentPane().add(getLabelTimeSelection(), gbc_labelTimeSelection);
		GridBagConstraints gbc_labelTimeQuick = new GridBagConstraints();
		gbc_labelTimeQuick.insets = new Insets(0, 0, 5, 0);
		gbc_labelTimeQuick.gridx = 4;
		gbc_labelTimeQuick.gridy = 4;
		frame.getContentPane().add(getLabelTimeQuick(), gbc_labelTimeQuick);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getButtonStart());
			panel.add(getButtonPause());
			panel.add(getButtonResume());
			panel.add(getButtonStop());
		}
		return panel;
	}

	private JButton getButtonStart() {
		if (buttonStart == null) {
			buttonStart = new JButton("Сортировать");
			buttonStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					stringTokenizer = new StringTokenizer(getTextAreaInput().getText());
					mas = new ArrayList<>();
					String s = null;
					while (stringTokenizer.hasMoreTokens()) {
						s = stringTokenizer.nextToken();
						try {
							mas.add(Double.parseDouble(s));
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Ошибка ввода данных: " + s, "Ошибка", JOptionPane.ERROR_MESSAGE);
						}
					}
					// System.out.println(mas);
					double[] array = convertArray(mas);
					getButtonStart().setEnabled(false);
					getButtonPause().setEnabled(true);
					getButtonResume().setEnabled(false);
					getButtonStop().setEnabled(true);
					end();
					MainThread mainThread = new MainThread(array);
					mainThread.start();

				}
			});
		}
		return buttonStart;
	}

	private JButton getButtonPause() {
		if (buttonPause == null) {
			buttonPause = new JButton("Пауза");
			buttonPause.setEnabled(false);
			buttonPause.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					paused = true;
					getButtonPause().setEnabled(false);
					getButtonResume().setEnabled(true);
				}
			});
		}
		return buttonPause;
	}

	private JButton getButtonResume() {
		if (buttonResume == null) {
			buttonResume = new JButton("Продолжить");
			buttonResume.setEnabled(false);
			buttonResume.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					paused = false;
					getButtonPause().setEnabled(true);
					getButtonResume().setEnabled(false);
				}
			});
		}
		return buttonResume;
	}

	private JButton getButtonStop() {
		if (buttonStop == null) {
			buttonStop = new JButton("Стоп");
			buttonStop.setEnabled(false);
			buttonStop.setEnabled(false);
			buttonStop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					threadBubble.interrupt();
					threadBubbleBest.interrupt();
					threadSelect.interrupt();
					threadQuick.interrupt();
					threadСreation.interrupt();
				}
			});
		}
		return buttonStop;
	}

	private JLabel getLabelInput() {
		if (labelInput == null) {
			labelInput = new JLabel("Ввод массива");
		}
		return labelInput;
	}

	private JLabel getLabelBubble() {
		if (labelBubble == null) {
			labelBubble = new JLabel("Пузырьковая");
		}
		return labelBubble;
	}

	private JLabel getLabelBubbleBest() {
		if (labelBubbleBest == null) {
			labelBubbleBest = new JLabel("Пузырьковая 2");
		}
		return labelBubbleBest;
	}

	private JLabel getLabelSelection() {
		if (labelSelection == null) {
			labelSelection = new JLabel("Выбором");
		}
		return labelSelection;
	}

	private JLabel getLabelQuick() {
		if (labelQuick == null) {
			labelQuick = new JLabel("Быстрая");
		}
		return labelQuick;
	}

	private JScrollPane getScrollPaneInput() {
		if (scrollPaneInput == null) {
			scrollPaneInput = new JScrollPane();
			scrollPaneInput.setViewportView(getTextAreaInput());
		}
		return scrollPaneInput;
	}

	private JScrollPane getScrollPaneBubble() {
		if (scrollPaneBubble == null) {
			scrollPaneBubble = new JScrollPane();
			scrollPaneBubble.setViewportView(getTextAreaBubble());
		}
		return scrollPaneBubble;
	}

	private JScrollPane getScrollPaneBubbleBest() {
		if (scrollPaneBubbleBest == null) {
			scrollPaneBubbleBest = new JScrollPane();
			scrollPaneBubbleBest.setViewportView(getTextAreaBubbleBest());
		}
		return scrollPaneBubbleBest;
	}

	private JScrollPane getScrollPaneSelection() {
		if (scrollPaneSelection == null) {
			scrollPaneSelection = new JScrollPane();
			scrollPaneSelection.setViewportView(getTextAreaSelection());
		}
		return scrollPaneSelection;
	}

	private JScrollPane getScrollPaneQuick() {
		if (scrollPaneQuick == null) {
			scrollPaneQuick = new JScrollPane();
			scrollPaneQuick.setViewportView(getTextAreaQuick());
		}
		return scrollPaneQuick;
	}

	private JLabel getLabelTimeBubble() {
		if (labelTimeBubble == null) {
			labelTimeBubble = new JLabel("");
			labelTimeBubble.setForeground(Color.RED);
		}
		return labelTimeBubble;
	}

	private JLabel getLabelTimeBubbleBest() {
		if (labelTimeBubbleBest == null) {
			labelTimeBubbleBest = new JLabel("");
			labelTimeBubbleBest.setForeground(Color.RED);
		}
		return labelTimeBubbleBest;
	}

	private JLabel getLabelTimeSelection() {
		if (labelTimeSelection == null) {
			labelTimeSelection = new JLabel("");
			labelTimeSelection.setForeground(Color.RED);
		}
		return labelTimeSelection;
	}

	private JLabel getLabelTimeQuick() {
		if (labelTimeQuick == null) {
			labelTimeQuick = new JLabel("");
			labelTimeQuick.setForeground(Color.RED);
		}
		return labelTimeQuick;
	}

	private JTextArea getTextAreaInput() {
		if (textAreaInput == null) {
			textAreaInput = new JTextArea();
		}
		return textAreaInput;
	}

	private JTextArea getTextAreaBubble() {
		if (textAreaBubble == null) {
			textAreaBubble = new JTextArea();
		}
		return textAreaBubble;
	}

	private JTextArea getTextAreaBubbleBest() {
		if (textAreaBubbleBest == null) {
			textAreaBubbleBest = new JTextArea();
		}
		return textAreaBubbleBest;
	}

	private JTextArea getTextAreaSelection() {
		if (textAreaSelection == null) {
			textAreaSelection = new JTextArea();
		}
		return textAreaSelection;
	}

	private JTextArea getTextAreaQuick() {
		if (textAreaQuick == null) {
			textAreaQuick = new JTextArea();
		}
		return textAreaQuick;
	}

	private JPanel getPanelRandom() {
		if (panelRandom == null) {
			panelRandom = new JPanel();
			panelRandom.add(getButtonGeneration());
			panelRandom.add(getLabelCount());
			panelRandom.add(getTextFieldCount());
			panelRandom.add(getLabelFrom());
			panelRandom.add(getTextFieldFrom());
			panelRandom.add(getLabelTo());
			panelRandom.add(getTextFieldTo());
			panelRandom.add(getBtnNewButtoncСeaning());
		}
		return panelRandom;
	}

	private JButton getButtonGeneration() {
		if (buttonGeneration == null) {
			buttonGeneration = new JButton("Создать");
			buttonGeneration.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getTextAreaInput().setText("");
					getLabelTimeInput().setText("");
					int count = 0;
					int max = 0;
					int min = 0;
					try {
						count = Integer.parseInt(getTextFieldCount().getText());
						max = Integer.parseInt(getTextFieldTo().getText());
						min = Integer.parseInt(getTextFieldFrom().getText());
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Ошибка ввода данных", "Ошибка", JOptionPane.ERROR_MESSAGE);
					}
					if ((count < 0) || (min > max)) {
						JOptionPane.showMessageDialog(null, "Ошибка ввода данных", "Ошибка", JOptionPane.ERROR_MESSAGE);
					} else {
						threadСreation = new ThreadСreation(count, max, min);//makeRandomDouble(count, max, min, 3);
						threadСreation.start();
					}
				}
			});
		}
		return buttonGeneration;
	}

	private JTextField getTextFieldCount() {
		if (textFieldCount == null) {
			textFieldCount = new JTextField();
			textFieldCount.setText("100");
			textFieldCount.setColumns(5);
		}
		return textFieldCount;
	}

	private JButton getBtnNewButtoncСeaning() {
		if (btnNewButtoncСeaning == null) {
			btnNewButtoncСeaning = new JButton("Очистить");
			btnNewButtoncСeaning.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getTextAreaInput().setText("");
				}
			});
		}
		return btnNewButtoncСeaning;
	}

	private JLabel getLabelCount() {
		if (labelCount == null) {
			labelCount = new JLabel("Кол-во:");
		}
		return labelCount;
	}

	private JLabel getLabelFrom() {
		if (labelFrom == null) {
			labelFrom = new JLabel("От:");
		}
		return labelFrom;
	}

	private JTextField getTextFieldFrom() {
		if (textFieldFrom == null) {
			textFieldFrom = new JTextField();
			textFieldFrom.setText("0");
			textFieldFrom.setColumns(5);
		}
		return textFieldFrom;
	}

	private JLabel getLabelTo() {
		if (labelTo == null) {
			labelTo = new JLabel("До:");
		}
		return labelTo;
	}

	private JTextField getTextFieldTo() {
		if (textFieldTo == null) {
			textFieldTo = new JTextField();
			textFieldTo.setText("1000");
			textFieldTo.setColumns(5);
		}
		return textFieldTo;
	}

	class ThreadСreation extends Thread {

		int number = 0;
		int maxNumber = 0;
		int minNumber = 0;
		
		public ThreadСreation(int number, int maxNumber, int minNumber) {
			this.number = number;
			this.maxNumber = maxNumber;
			this.minNumber = minNumber;
		}
		
		@Override
		public void run() {
			long startTime = System.currentTimeMillis();
			makeRandomDouble(number, maxNumber, minNumber, 3);
			long timeSpent = System.currentTimeMillis() - startTime;
			getLabelTimeInput().setText("" + timeSpent + " мс.");
		}

		public BigDecimal roundNumber(double value, int digits) {
			// we approximate the transferred number "value" with accuracy
			// "digits"
			BigDecimal num = new BigDecimal(value).setScale(digits, BigDecimal.ROUND_UP);
			return num;
		}

		public void makeRandomDouble(int number, int maxNumber, int minNumber, int accuracy) {
			for (int i = 0; i < number; i++) {
				getTextAreaInput().append("" + roundNumber(Math.random() * maxNumber - minNumber, accuracy) + "\n");
			}

		}
	}

	class MainThread extends Thread {

		double[] arr;

		private MainThread(double[] arr) {
			this.arr = arr;
		}

		@Override
		public void run() {
			threadBubble = new ThreadBubble(arr.clone());
			threadBubbleBest = new ThreadBubbleBest(arr.clone());
			threadSelect = new ThreadSelect(arr.clone());
			threadQuick = new ThreadQuick(arr.clone());

			try {

				threadQuick.start();
				threadQuick.join();
				threadSelect.start();
				threadSelect.join();
				threadBubble.start();
				threadBubble.join();
				threadBubbleBest.start();
				threadBubbleBest.join();
				// threadQuick.join();
				// threadSelect.join();
				// threadBubble.join();
				// threadBubbleBest.join();
				arr = null;
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					getButtonStart().setEnabled(true);
					getButtonPause().setEnabled(false);
					getButtonResume().setEnabled(false);
					getButtonStop().setEnabled(false);
					arr = null;
				}
			});
		}
	}

	class ThreadBubble extends Thread {
		// bubbleSort
		double[] arr;

		private ThreadBubble(double[] arr) {
			this.arr = arr;
		}

		@Override
		public void run() {
			long startTime = System.currentTimeMillis();
			double tmp = 0;
			for (int i = arr.length - 1; i > 0; i--) {
				try {
					// sleep(5);
					while (paused) {
						sleep(5);
					}
				} catch (Exception ex) {
					break;
				}
				for (int j = 0; j < i; j++) {
					if (arr[j] > arr[j + 1]) {
						tmp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = tmp;
					}
				}
			}
			long timeSpent = System.currentTimeMillis() - startTime;
			getLabelTimeBubble().setText("" + timeSpent + " мс.");
			print(arr, 1);
			arr = null;

		}
	}

	class ThreadBubbleBest extends Thread {
		// bubbleSort
		double[] arr;

		private ThreadBubbleBest(double[] arr) {
			this.arr = arr;
		}

		@Override
		public void run() {
			long startTime = System.currentTimeMillis();
			double tmp = 0;
			boolean p = true;// есть перестановка?
			int k = 1;// Номер просмотра
			while (p) {
				p = false;
				for (int j = 0; j < arr.length - k; j++) {
					try {
						// sleep(5);
						while (paused) {
							sleep(5);
						}
					} catch (Exception ex) {
						break;
					}
					if (arr[j] > arr[j + 1]) {
						tmp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = tmp;
						p = true;
					}
				}
				k++;
			}
			long timeSpent = System.currentTimeMillis() - startTime;
			getLabelTimeBubbleBest().setText("" + timeSpent + " мс.");
			print(arr, 2);
			arr = null;
		}
	}

	class ThreadSelect extends Thread {

		double[] arr;

		private ThreadSelect(double[] arr) {
			this.arr = arr;
		}

		@Override
		public void run() {
			long startTime = System.currentTimeMillis();// считываем текущее
														// время
			double tmp = 0;
			for (int i = 0; i < arr.length; i++) {
				try {
					// sleep(5);
					while (paused) {
						sleep(5);
					}
				} catch (Exception ex) {
					break;
				}
				/*
				 * Предполагаем, что первый элемент (в каждом подмножестве
				 * элементов) является минимальным
				 */
				double min = arr[i];
				int min_i = i;
				/*
				 * В оставшейся части подмножества ищем элемент, который меньше
				 * предположенного минимума
				 */
				for (int j = i + 1; j < arr.length; j++) {
					// Если находим, запоминаем его индекс
					if (arr[j] < min) {
						min = arr[j];
						min_i = j;
					}
				}
				/*
				 * Если нашелся элемент, меньший, чем на текущей позиции, меняем
				 * их местами
				 */
				if (i != min_i) {
					tmp = arr[i];
					arr[i] = arr[min_i];
					arr[min_i] = tmp;
				}
			}
			long timeSpent = System.currentTimeMillis() - startTime;
			getLabelTimeSelection().setText("" + timeSpent + " мс.");
			print(arr, 3);
			arr = null;
		}
	}

	class ThreadQuick extends Thread {

		double[] arr;

		private ThreadQuick(double[] arr) {
			this.arr = arr;
		}

		@Override
		public void run() {
			long startTime = System.currentTimeMillis();
			quickSort(arr, 0, arr.length - 1);
			long timeSpent = System.currentTimeMillis() - startTime;
			getLabelTimeQuick().setText("" + timeSpent + " мс.");
			print(arr, 4);
			arr = null;
		}

		public int partition(double[] array, int start, int end) {
			int marker = start;
			for (int i = start; i <= end; i++) {
				if (array[i] <= array[end]) {
					double temp = array[marker]; // swap
					array[marker] = array[i];
					array[i] = temp;
					marker += 1;
				}
			}
			return marker - 1;
		}

		public void quickSort(double[] arr, int start, int end) {

			if (start >= end) {
				return;
			}
			int pivot = partition(arr, start, end);
			quickSort(arr, start, pivot - 1);
			quickSort(arr, pivot + 1, end);
		}
	}

	private synchronized void print(double[] mas, int n) {
		switch (n) {
		case 1:
			for (double i : mas) {
				getTextAreaBubble().append("" + i + "\n");
			}
			break;
		case 2:
			for (double i : mas) {
				getTextAreaBubbleBest().append("" + i + "\n");
			}
			break;
		case 3:
			for (double i : mas) {
				getTextAreaSelection().append("" + i + "\n");
			}
			break;
		case 4:
			for (double i : mas) {
				getTextAreaQuick().append("" + i + "\n");
			}
			break;
		}
	}

	private double[] convertArray(ArrayList<Double> mas) {
		double[] arr = new double[mas.size()];
		for (int i = 0; i < mas.size(); i++) {
			arr[i] = mas.get(i);
		}
		return arr;

	}

	private synchronized void end() {
		getLabelTimeBubble().setText("");
		getLabelTimeBubbleBest().setText("");
		getLabelTimeSelection().setText("");
		getLabelTimeQuick().setText("");
		getTextAreaBubble().setText("");
		getTextAreaBubbleBest().setText("");
		getTextAreaSelection().setText("");
		getTextAreaQuick().setText("");
	}

	private JLabel getLabelTimeInput() {
		if (labelTimeInput == null) {
			labelTimeInput = new JLabel("");
			labelTimeInput.setForeground(Color.RED);
		}
		return labelTimeInput;
	}
}
