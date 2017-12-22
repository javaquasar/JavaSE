package core.lecture3_10_Thread.example;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class PrimeApp2 {

	private JFrame frame;
	private JPanel panelTop;
	private JLabel labelTo;
	private JTextField textFieldTo;
	private JButton buttonStart;
	private JButton buttonPause;
	private JButton buttonStop;
	private JButton buttonResume;
	private JPanel panelBottom;
	private JProgressBar progressBar;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	private NumbersThread thread;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimeApp2 window = new PrimeApp2();
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
	public PrimeApp2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Простые числа");
		frame.setBounds(100, 100, 515, 302);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(getPanelTop(), BorderLayout.NORTH);
		frame.getContentPane().add(getPanelBottom(), BorderLayout.SOUTH);
		frame.getContentPane().add(getScrollPane(), BorderLayout.CENTER);

	}

	private JPanel getPanelTop() {
		if (panelTop == null) {
			panelTop = new JPanel();
			panelTop.add(getLabelTo());
			panelTop.add(getTextFieldTo());
			panelTop.add(getButtonStart());
			panelTop.add(getButtonPause());
			panelTop.add(getButtonResume());
			panelTop.add(getButtonStop());
		}
		return panelTop;
	}

	private JLabel getLabelTo() {
		if (labelTo == null) {
			labelTo = new JLabel("До:");
			labelTo.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return labelTo;
	}

	private JTextField getTextFieldTo() {
		if (textFieldTo == null) {
			textFieldTo = new JTextField();
			textFieldTo.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldTo.setColumns(5);
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
						thread = new NumbersThread(Integer.parseInt(getTextFieldTo().getText()));
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

	private JPanel getPanelBottom() {
		if (panelBottom == null) {
			panelBottom = new JPanel();
			panelBottom.add(getProgressBar());
		}
		return panelBottom;
	}

	private JProgressBar getProgressBar() {
		if (progressBar == null) {
			progressBar = new JProgressBar();
			progressBar.setStringPainted(true);
		}
		return progressBar;
	}

	private JScrollPane getScrollPane() {
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
		private int to = 10000;
		boolean paused = false;

		private NumbersThread(int to) {
			this.to = to;
		}

		@Override
		public void run() {
			for (int i = 2; i <= to; i++) {
				try {
					sleep(5);
					while (paused) {
						sleep(5);
					}
				} catch (Exception ex) {
					break;
				}
				int k = 0;
				for (int j = 2; j <= Math.sqrt(i); j++) {
					if (i % j == 0) {
						k++;
					}
				}
				if (k == 0) {
					number = i;
					try {
						EventQueue.invokeAndWait(new Runnable() {
							public void run() {
								getTextArea().append(" " + number + "\n");
								getProgressBar().setValue((number * 100) / to);
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
}
