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

public class FrameSort extends JFrame {

	private JLabel label;
	private JTextArea text;
	private JScrollPane scrollPane;
	private static String info = null;
	private String title = null;

	public static void main(String[] args) {
		FrameSort frame = new FrameSort(50, 50, 300, 200, info, "Info");
		// условие закрыти€ окна
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.show();
	}

	public FrameSort(int x, int y, int w, int h, String info, String title) {
		this.info = info;
		this.title = title;
		// setSize задает размер окна
		// setSize(300,200);
		// setLocation задает положение окна на экране относительно верхнего
		// левого угла
		// setLocation(x,y);
		// setBounds задает размер окнаи его положение на экране
		// setBounds=setSize+setLocation
		// setBounds(x,y,300,200);
		// ѕолучение размера экрана компа
		setTitle(this.title);

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
		text.setText(info);
		scrollPane = new JScrollPane(text);
		pane.add(scrollPane);
		//pane.add(text);

		setVisible(true);
	}

}
