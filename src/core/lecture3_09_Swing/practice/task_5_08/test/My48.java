package core.lecture3_09_Swing.practice.task_5_08.test;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

//панель меню
public class My48 {
	public static void main(String[] args) {
		System.out.println("It is program My");
		MyFrame frame = new MyFrame();
		// условие закрыти€ окна
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.show();

	}

}

class MyFrame extends JFrame {
	private JLabel label;
	private JCheckBoxMenuItem barItem;
	private JCheckBoxMenuItem readonlyItem;
	private Action saveAction;
	private Action saveAsAction;
	private JPopupMenu popup, popup2;

	public MyFrame() {
		setTitle("Dart");
		setSize(200, 200);

		JMenu fileMenu = new JMenu(new MyAction("File"));
		fileMenu.setMnemonic('F');
		JMenuItem newItem = fileMenu.add(new MyAction("New"));
		JMenuItem openItem = fileMenu.add(new MyAction("Open"));
		// сокращение клавиш
		openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		fileMenu.addSeparator();
		saveAction = new MyAction("Save");
		JMenuItem saveItem = fileMenu.add(saveAction/* new MyAction("Save" */);
		//
		saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		saveAsAction = new MyAction("Save As");
		// ускор€юща€ клавиша
		saveAsAction.putValue(Action.MNEMONIC_KEY, new Integer('A'));
		JMenuItem saveAsItem = fileMenu.add(saveAsAction/*
														 * new
														 * MyAction("SaveAs")
														 */);

		fileMenu.addSeparator();
		JMenuItem exitItem = fileMenu.add(new AbstractAction("Exit") {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}

		});

		JMenu editMenu = new JMenu("Edit");
		Action cutAction = new MyAction("Cut");
		// задание иконки в меню
		cutAction.putValue(Action.SMALL_ICON, new ImageIcon("dartvejder.gif"));
		editMenu.add(cutAction);
		Action copyAction = new MyAction("Copy");
		copyAction.putValue(Action.SMALL_ICON, new ImageIcon("dartvejder.gif"));
		editMenu.add(copyAction);
		Action pasteAction = new MyAction("Paste");
		pasteAction.putValue(Action.SMALL_ICON, new ImageIcon("dartvejder.gif"));
		editMenu.add(pasteAction);
		// переключатели
		ButtonGroup group = new ButtonGroup();
		JRadioButtonMenuItem leftItem = new JRadioButtonMenuItem("Left");
		leftItem.setSelected(true);
		JRadioButtonMenuItem centerItem = new JRadioButtonMenuItem(new MyAction("Center"));
		JRadioButtonMenuItem rightItem = new JRadioButtonMenuItem("Right");
		group.add(leftItem);
		group.add(centerItem);
		group.add(rightItem);
		editMenu.addSeparator();
		JMenu alignMenu = new JMenu("Align");
		alignMenu.add(leftItem);
		alignMenu.add(centerItem);
		alignMenu.add(rightItem);
		editMenu.add(alignMenu);

		JMenu viewMenu = new JMenu("View");
		barItem = new JCheckBoxMenuItem("Status bar");
		viewMenu.add(barItem);
		readonlyItem = new JCheckBoxMenuItem("Read only");
		readonlyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				boolean b = !readonlyItem.isSelected();
				saveAction.setEnabled(b);
				saveAsAction.setEnabled(b);

			}
		});
		viewMenu.add(readonlyItem);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(viewMenu);
		label = new JLabel();
		JPanel panel = new JPanel();
		panel.add(label);
		Container pane = getContentPane();
		pane.add(panel, BorderLayout.SOUTH);

		// контекстное меню
		popup2 = new JPopupMenu();
		popup2.add(cutAction);
		// popup2.add(copyAction);
		popup2.add(pasteAction);
		popup2.add(saveAction);
		popup2.add(saveAsAction);
		label.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event) {
				if (event.isPopupTrigger())
					popup2.show(event.getComponent(), event.getX(), event.getY());
			}

			public void mouseReleased(MouseEvent event) {
				if (event.isPopupTrigger())
					popup2.show(event.getComponent(), event.getX(), event.getY());
			}
		});
		// контекстное меню
		popup = new JPopupMenu();
		popup.add(cutAction);
		popup.add(copyAction);
		popup.add(pasteAction);
		pane.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event) {
				if (event.isPopupTrigger())
					popup.show(event.getComponent(), event.getX(), event.getY());
			}

			public void mouseReleased(MouseEvent event) {
				if (event.isPopupTrigger())
					popup.show(event.getComponent(), event.getX(), event.getY());
			}
		});
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