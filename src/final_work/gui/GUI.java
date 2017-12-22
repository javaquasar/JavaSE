package final_work.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.ScrollPane;
import java.awt.GridBagConstraints;

import javax.swing.JTable;

import java.awt.Insets;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JSeparator;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBox;
import java.awt.Canvas;

public class GUI {

	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmSaveAs;
	private JMenuItem mntmExit;
	private JMenu mnSort;
	private JMenu mnFind;
	private JMenu mnHelp;
	private JMenuItem mntmAbout;
	private JTable table;
	private JTable tableBody;
	private JSeparator separator;
	private JRadioButtonMenuItem rdbtnmntmSortByLastname;
	private JRadioButtonMenuItem rdbtnmntmSortByName;

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(getMenuBar());
		frame.getContentPane().add(getTableBody().getTableHeader(), BorderLayout.NORTH);
		frame.getContentPane().add(getTableBody(), BorderLayout.CENTER);
		
	}

	private JMenuBar getMenuBar() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnSort());
			menuBar.add(getMnFind());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmOpen());
			mnFile.add(getMntmSave());
			mnFile.add(getMntmSaveAs());
			mnFile.add(getSeparator());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}
	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
		}
		return mntmOpen;
	}
	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
		}
		return mntmSave;
	}
	private JMenuItem getMntmSaveAs() {
		if (mntmSaveAs == null) {
			mntmSaveAs = new JMenuItem("Save as");
		}
		return mntmSaveAs;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
		}
		return mntmExit;
	}
	private JMenu getMnSort() {
		if (mnSort == null) {
			mnSort = new JMenu("Sort");
			mnSort.add(getRdbtnmntmSortByLastname());
			mnSort.add(getRdbtnmntmSortByName());
		}
		return mnSort;
	}
	private JMenu getMnFind() {
		if (mnFind == null) {
			mnFind = new JMenu("Find");
		}
		return mnFind;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
		}
		return mntmAbout;
	}
	private JTable getTable() {
		Object [][] data = new Object[4][10]; 
		if (table == null) {
			table = new JTable(data, new Object[] {"", "y", "Сумма", "b"});
		}
		return table;
	}
	private JTable getTableBody() {
		Object [][] data = new Object[4][10]; 
		if (tableBody == null) {
			//tableBody.setModel(dataModel);
			tableBody = new JTable(data, new Object[] {"", "y", "Сумма", "b"});
		}
		return tableBody;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JRadioButtonMenuItem getRdbtnmntmSortByLastname() {
		if (rdbtnmntmSortByLastname == null) {
			rdbtnmntmSortByLastname = new JRadioButtonMenuItem("Sort by lastname");
		}
		return rdbtnmntmSortByLastname;
	}
	private JRadioButtonMenuItem getRdbtnmntmSortByName() {
		if (rdbtnmntmSortByName == null) {
			rdbtnmntmSortByName = new JRadioButtonMenuItem("Sort by name");
			
		}
		return rdbtnmntmSortByName;
	}
}
