package core.lecture3_09_Swing.practice.task_5_08;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FrameInfo extends JFrame {

	private JLabel label;
	private JTextArea text;
	private JScrollPane scrollPane;
	private static String info = "Программа графического интерфейса пользователя, в которой осуществляется обработка данных о студентах группы.";
	
	public static void main(String[] args) {
		FrameInfo frame = new FrameInfo(50, 50, 300, 200, info);
		// условие закрыти€ окна
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.show();
	}

	public FrameInfo(int x, int y, int w, int h, String info) {
		this.info = info;
		
		// setSize задает размер окна
		// setSize(300,200);
		// setLocation задает положение окна на экране относительно верхнего
		// левого угла
		// setLocation(x,y);
		// setBounds задает размер окнаи его положение на экране
		// setBounds=setSize+setLocation
		// setBounds(x,y,300,200);
		// ѕолучение размера экрана компа
		setTitle("Info");

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int lx = screenSize.width;
		int ly = screenSize.height;
		setBounds(x * lx / 100 - w / 2, y * ly / 100 - h / 2, 300, 200);

		Container pane = getContentPane();

		/*
		 * JPanel panel = new JPanel(); pane.add(panel);
		 */

		/*label = new JLabel(s); Font font = new Font("Verdana", Font.PLAIN,
		 * 11); label.setFont(font); panel.add(label);
		 */

		text = new JTextArea();
		/*Graphics g = label.getGraphics();
		FontMetrics fm = g.getFontMetrics();
		int width = fm.stringWidth(s);
		System.out.println(" Ширина текста"+ width);*/
		text.setText(formatInWidthNew(info, (int) w/7));
		//System.out.println(formatInWidthNew(info, 50));
		// /scrollPane = new JScrollPane(text);
		// pane.add(scrollPane);
		pane.add(text);

		setVisible(true);
	}

	public static String formatInWidthNew(String string, int width) {
		String[] words = string.split("\\s+");
		StringBuilder stringBuilderFirst = new StringBuilder();
		StringBuilder stringBuilder = new StringBuilder();
		int myWidthSpace = 0;
		boolean work = true;
		boolean workFor = true;
		for (String word : words) {
			myWidthSpace += word.length() + 1;
			if (myWidthSpace > width) {
				// удаляем пробел в конце
				stringBuilderFirst.deleteCharAt(stringBuilderFirst.length() - 1);
				// переводим строку
				stringBuilderFirst.append("\n");
				while ((stringBuilderFirst.length() < width) && (word.length() < width) && work) {
					for (int i = 0; i < stringBuilderFirst.length(); i++) {
						if ((stringBuilderFirst.length() < width) && (stringBuilderFirst.charAt(i) == ' ') && (stringBuilderFirst.charAt(i + 1) != ' ')) {
							stringBuilderFirst.insert(i + 1, " ");
							i++;
							workFor = false;
						}
					}

					if (workFor) {
						work = false;
					}

				}
				work = true;
				stringBuilder.append(stringBuilderFirst);
				// очищаем массив
				stringBuilderFirst = new StringBuilder();
				// заносим слово в массив
				stringBuilderFirst.append(word + " ");
				myWidthSpace = word.length() + 1;
			} else {
				stringBuilderFirst.append(word + " ");
			}
		}
		stringBuilder.append(stringBuilderFirst);
		return stringBuilder.toString();
	}
}
