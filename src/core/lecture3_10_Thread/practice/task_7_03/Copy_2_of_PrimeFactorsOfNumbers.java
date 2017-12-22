package core.lecture3_10_Thread.practice.task_7_03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class Copy_2_of_PrimeFactorsOfNumbers {

	private static int from;
	private static int to;
	private NumbersThread thread;

	private JFrame frame;
	private JLabel labelTextFrom;
	private JLabel labelTextTo;
	private JTextField textFieldFrom;
	private JTextField textFieldTo;
	private JButton buttonStart;
	private JButton buttonStop;
	private JButton buttonPause;
	private JButton buttonResume;
	private JPanel panel;
	private JProgressBar progressBar;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Copy_2_of_PrimeFactorsOfNumbers window = new Copy_2_of_PrimeFactorsOfNumbers();
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
	public Copy_2_of_PrimeFactorsOfNumbers() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		frame.setBounds(100, 100, 425, 305);
		frame.setMinimumSize(new Dimension(380, 304));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 50, 50, 50, 50, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 30, 30, 16, 0, 30, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);
		GridBagConstraints gbc_buttonStart = new GridBagConstraints();
		gbc_buttonStart.fill = GridBagConstraints.BOTH;
		gbc_buttonStart.insets = new Insets(0, 0, 5, 5);
		gbc_buttonStart.gridx = 1;
		gbc_buttonStart.gridy = 0;
		frame.getContentPane().add(getButtonStart(), gbc_buttonStart);
		GridBagConstraints gbc_buttonPause = new GridBagConstraints();
		gbc_buttonPause.fill = GridBagConstraints.BOTH;
		gbc_buttonPause.insets = new Insets(0, 0, 5, 5);
		gbc_buttonPause.gridx = 2;
		gbc_buttonPause.gridy = 0;
		frame.getContentPane().add(getButtonPause(), gbc_buttonPause);
		GridBagConstraints gbc_buttonResume = new GridBagConstraints();
		gbc_buttonResume.fill = GridBagConstraints.VERTICAL;
		gbc_buttonResume.insets = new Insets(0, 0, 5, 5);
		gbc_buttonResume.gridx = 3;
		gbc_buttonResume.gridy = 0;
		frame.getContentPane().add(getButtonResume(), gbc_buttonResume);
		GridBagConstraints gbc_buttonStop = new GridBagConstraints();
		gbc_buttonStop.fill = GridBagConstraints.VERTICAL;
		gbc_buttonStop.insets = new Insets(0, 0, 5, 5);
		gbc_buttonStop.gridx = 4;
		gbc_buttonStop.gridy = 0;
		frame.getContentPane().add(getButtonStop(), gbc_buttonStop);
		GridBagConstraints gbc_labelTextFrom = new GridBagConstraints();
		gbc_labelTextFrom.fill = GridBagConstraints.BOTH;
		gbc_labelTextFrom.insets = new Insets(0, 0, 5, 5);
		gbc_labelTextFrom.gridx = 1;
		gbc_labelTextFrom.gridy = 1;
		frame.getContentPane().add(getLabelTextFrom(), gbc_labelTextFrom);
		GridBagConstraints gbc_textFieldFrom = new GridBagConstraints();
		gbc_textFieldFrom.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldFrom.fill = GridBagConstraints.BOTH;
		gbc_textFieldFrom.gridx = 2;
		gbc_textFieldFrom.gridy = 1;
		frame.getContentPane().add(getTextFieldFrom(), gbc_textFieldFrom);
		GridBagConstraints gbc_labelTextTo = new GridBagConstraints();
		gbc_labelTextTo.fill = GridBagConstraints.BOTH;
		gbc_labelTextTo.insets = new Insets(0, 0, 5, 5);
		gbc_labelTextTo.gridx = 1;
		gbc_labelTextTo.gridy = 2;
		frame.getContentPane().add(getLabelTextTo(), gbc_labelTextTo);
		GridBagConstraints gbc_textFieldTo = new GridBagConstraints();
		gbc_textFieldTo.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTo.fill = GridBagConstraints.BOTH;
		gbc_textFieldTo.gridx = 2;
		gbc_textFieldTo.gridy = 2;
		frame.getContentPane().add(getTextFieldTo(), gbc_textFieldTo);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 6;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		frame.getContentPane().add(getScrollPane_1(), gbc_scrollPane);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 6;
		gbc_panel.insets = new Insets(5, 5, 0, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		frame.getContentPane().add(getPanel(), gbc_panel);
	}

	private JLabel getLabelTextFrom() {
		if (labelTextFrom == null) {
			labelTextFrom = new JLabel("От:");
			labelTextFrom.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return labelTextFrom;
	}

	private JLabel getLabelTextTo() {
		if (labelTextTo == null) {
			labelTextTo = new JLabel("До:");
			labelTextTo.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return labelTextTo;
	}

	private JTextField getTextFieldFrom() {
		if (textFieldFrom == null) {
			textFieldFrom = new JTextField();
			textFieldFrom.setColumns(1);
			textFieldFrom.setText("0");
		}
		return textFieldFrom;
	}

	private JTextField getTextFieldTo() {
		if (textFieldTo == null) {
			textFieldTo = new JTextField();
			textFieldTo.setColumns(1);
			textFieldTo.setText("100");
		}
		return textFieldTo;
	}

	private JButton getButtonStart() {
		if (buttonStart == null) {
			buttonStart = new JButton("Старт");
			buttonStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						getTextArea().setText("");
						from = Integer.parseInt(getTextFieldFrom().getText());
						to = Integer.parseInt(getTextFieldTo().getText());
						thread = new NumbersThread(from, to);
						getButtonStart().setEnabled(false);
						getButtonPause().setEnabled(true);
						getButtonResume().setEnabled(false);
						getButtonStop().setEnabled(true);
						thread.start();
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Ошибка ввода данных", "Ошибка", JOptionPane.ERROR_MESSAGE);
					}
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
					thread.paused = true;
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
					thread.paused = false;
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
			buttonStop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					thread.interrupt();
				}
			});
		}
		return buttonStop;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getProgressBar());
		}
		return panel;
	}

	private JProgressBar getProgressBar() {
		if (progressBar == null) {
			progressBar = new JProgressBar();
			progressBar.setStringPainted(true);
		}
		return progressBar;
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
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

	private class NumbersThread extends Thread {
		private int number;
		private int from = 0;
		private int to = 0;
		boolean paused = false;

		private NumbersThread(int from, int to) {

			if (from > to) {
				this.from = to;
				this.to = from;
			} else {
				this.from = from;
				this.to = to;
			}
		}

		@Override
		public void run() {
			for (int i = from; i <= to; i++) {
				try {
					sleep(5);
					while (paused) {
						sleep(5);
					}
				} catch (Exception ex) {
					break;
				}
				if (!checkNumber(i)) {
					number = i;
					try {
						EventQueue.invokeAndWait(new Runnable() {
							public void run() {
								getTextArea().append(" " + number + " - простое число \n");
								getProgressBar().setValue((number * 100) / to);
							}
						});
					} catch (Exception e) {
					}
				} else {
					number = i;
					try {
						EventQueue.invokeAndWait(new Runnable() {
							public void run() {
								getTextArea().append(" " + number + " простые множители: ");
								for (int j = 2; j <= number; j++) {
									if (number % j == 0) {
										getTextArea().append("" + j + " - ");
										number /= j;
										j = 1; // после этого j будет проинкрементировано в теле for-a
									}
								}
								getTextArea().append("" + number);
								getTextArea().append("\n");
								//getProgressBar().setValue((number * 100) / to);
							}
						});
					} catch (Exception e) {
					}
				}
			}
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					getButtonStart().setEnabled(true);
					getButtonPause().setEnabled(false);
					getButtonResume().setEnabled(false);
					getButtonStop().setEnabled(false);
					getProgressBar().setValue(getProgressBar().getMaximum());
				}
			});
		}
	}

	private boolean checkNumber(int number) {

		for (int j = 2; j <= Math.sqrt(number); j++) {
			if (number % j == 0) {
				return true;
			}
		}

		return false;

	}

	private int checkNumberInt(int number) {
		for (int j = 2; j <= Math.sqrt(number); j++) {
			if (number % j == 0) {
				return number / j;
			}
		}
		return number;
	}

}
