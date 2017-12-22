package com.javaquasar.java.core.chapter_31_Swing.practice.task_5_08;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.javaquasar.java.core.chapter_31_Swing.practice.task_5_08.group.Group;

public class GroupGUI extends JFrame implements ActionListener {

	private static String stringInfo = "Программа графического интерфейса пользователя, в которой осуществляется обработка данных о студентах группы.";

	private JLabel label;

	private String pathFromFile = null;
	private String pathToFile = null;
	private JFileChooser chooser = new JFileChooser();

	private Group group = null;

	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem openItem;
	private JMenuItem saveItem;
	private JMenuItem saveAsAllItem;
	private JMenuItem exitItem;

	private JMenu commandMenu;
	private JMenuItem findItem;
	private JMenuItem sortByYearItem;
	private JMenuItem sortByLastnameItem;
	private JMenuItem sortByNameItem;

	private JMenu helpMenu;
	private JMenuItem aboutItem;

	public static void main(String[] args) {
		// System.out.println("It is program My");
		GroupGUI frame = new GroupGUI("Group");
		// условие закрыти€ окна
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.show();

	}

	public GroupGUI(String title) {
		super(title);
		setSize(200, 200);

		chooser.setFileFilter(new MyFileFilter(".xml", ""));
		// Необходимо начинать поиск файлов из текущей папки проекта:
		chooser.setCurrentDirectory(new File("./file/"));
		setLayout(new FlowLayout());

		// создаем шрифт
		Font font = new Font("Verdana", Font.PLAIN, 11);

		menuBar = new JMenuBar();

		fileMenu = new JMenu("File");
		// устанавливаем шрифт
		fileMenu.setFont(font);

		/*
		 * JMenu newMenu = new JMenu("New"); newMenu.setFont(font);
		 * fileMenu.add(newMenu);
		 * 
		 * JMenuItem txtFileItem = new JMenuItem("Text file");
		 * txtFileItem.setFont(font); newMenu.add(txtFileItem);
		 * 
		 * JMenuItem imgFileItem = new JMenuItem("Image file");
		 * imgFileItem.setFont(font); newMenu.add(imgFileItem);
		 * 
		 * JMenuItem folderItem = new JMenuItem("Folder");
		 * folderItem.setFont(font); newMenu.add(folderItem);
		 */

		openItem = new JMenuItem("Open");
		openItem.setFont(font);
		fileMenu.add(openItem);
		openItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chooser.showOpenDialog(getParent()) == JFileChooser.APPROVE_OPTION) {
					pathFromFile = chooser.getSelectedFile().getPath();
					group = Group.deserialization(pathFromFile);
					saveItem.setEnabled(true);
					saveAsAllItem.setEnabled(true);
					findItem.setEnabled(true);
					sortByYearItem.setEnabled(true);
					sortByLastnameItem.setEnabled(true);
					sortByNameItem.setEnabled(true);
				}
			}
		});

		saveItem = new JMenuItem("Save");
		saveItem.setFont(font);
		fileMenu.add(saveItem);
		saveItem.setEnabled(false);
		saveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				group.serialization(pathFromFile);
			}
		});

		saveAsAllItem = new JMenuItem("Save as");
		saveAsAllItem.setFont(font);
		fileMenu.add(saveAsAllItem);
		saveAsAllItem.setEnabled(false);
		saveAsAllItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chooser.showSaveDialog(getParent()) == JFileChooser.APPROVE_OPTION) {
					pathToFile = chooser.getSelectedFile().getPath();
					group.serialization(pathToFile);
				}
			}
		});

		fileMenu.addSeparator();

		exitItem = new JMenuItem("Exit");
		exitItem.setFont(font);
		fileMenu.add(exitItem);

		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// меню с операциями
		commandMenu = new JMenu("Сommand");
		commandMenu.setFont(font);

		findItem = new JMenuItem("Find");
		findItem.setFont(font);
		commandMenu.add(findItem);
		findItem.setEnabled(false);
		findItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String reg = (String) JOptionPane.showInputDialog(getParent(), "Введите фамилию студента", "Customized Dialog", JOptionPane.PLAIN_MESSAGE);
				String result = group.findStudentsString(reg);
				if (result != null) {
					FrameSort frame = new FrameSort(50, 50, 300, 200, result, "найденный студенты");
				} else {
					JOptionPane.showMessageDialog(null, "Сутденты не найдены");
				}
			}
		});

		sortByYearItem = new JMenuItem("Sort by year");
		sortByYearItem.setFont(font);
		commandMenu.add(sortByYearItem);
		sortByYearItem.setEnabled(false);
		sortByYearItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				group.sortYearDown();
				FrameSort frame = new FrameSort(50, 50, 300, 200, group.toStringYear(), "По году");
				// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});

		sortByLastnameItem = new JMenuItem("Sort by lastname");
		sortByLastnameItem.setFont(font);
		commandMenu.add(sortByLastnameItem);
		sortByLastnameItem.setEnabled(false);
		sortByLastnameItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				group.sortSurnamesByAlphabet();
				;
				FrameSort frame = new FrameSort(50, 50, 300, 200, group.toString(), "По фамилии");
				// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});

		sortByNameItem = new JMenuItem("Sort by name");
		sortByNameItem.setFont(font);
		commandMenu.add(sortByNameItem);
		sortByNameItem.setEnabled(false);
		sortByNameItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				group.sortNamesByAlphabet();
				;
				FrameSort frame = new FrameSort(50, 50, 300, 200, group.toStringName(), "По имени");
				// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});

		// меню Help
		helpMenu = new JMenu("Help");
		helpMenu.setFont(font);

		aboutItem = new JMenuItem("About");
		aboutItem.setFont(font);
		helpMenu.add(aboutItem);
		aboutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameInfo frame = new FrameInfo(50, 50, 300, 200, stringInfo);
				// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});

		// прикручиваем к меню бару меню
		menuBar.add(fileMenu);
		menuBar.add(commandMenu);
		menuBar.add(helpMenu);

		// прикручиваем меню к окну
		setJMenuBar(menuBar);

		label = new JLabel("Привет!");
		label.setFont(font);
		JPanel panel = new JPanel();
		panel.add(label);
		Container pane = getContentPane();
		pane.add(panel, BorderLayout.SOUTH);

		setPreferredSize(new Dimension(270, 225));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exitItem) {
			System.exit(0);
		} /*
		 * else if (e.getSource() == buttons[0]) { answerButton(0); } else if
		 * (e.getSource() == buttons[1]) { answerButton(1); } else if
		 * (e.getSource() == buttons[2]) { answerButton(2); } else if
		 * (e.getSource() == buttons[3]) { answerButton(3); } else if
		 * (e.getSource() == buttons[4]) { answerButton(4); }
		 */
	}

	class MyAction extends AbstractAction {
		public MyAction(String name) {
			super(name);
		}

		public void actionPerformed(ActionEvent event) {
			label.setText("" + getValue(Action.NAME));
		}

	}

}
