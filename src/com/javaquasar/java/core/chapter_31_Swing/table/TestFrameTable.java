package com.javaquasar.java.core.chapter_31_Swing.table;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class TestFrameTable extends JFrame implements ActionListener {

	static int i = 0;
	JTable table;

	public TestFrameTable() {

		super("Тестовое окно");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ArrayList<MyBean> beans = new ArrayList<MyBean>();

		for (int i = 0; i < 30; i++) {
			beans.add(new MyBean("Имя " + i, "Размер " + i, "Описание " + i));
		}

		TableModel model = new MyTableModel(beans);
		table = new JTable(model);

		getContentPane().add(new JScrollPane(table));

		setPreferredSize(new Dimension(260, 220));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	 @Override
	  public void actionPerformed(ActionEvent e) {
	    try {
	      table.editCellAt(0, 0); // устанавливаем редактор таблицы в исходное состояние
	      /*for (int i = 0; i < data.length; i++) {
	        int x = Integer.parseInt((String) data[i][0]);
	        int y = Integer.parseInt((String) data[i][1]);
	        int z = x + y;
	        data[i][2] = z + "";
	      }*/
	      repaint(); // перерисовываем окно после обновления данных
	    }
	    catch (NumberFormatException e1) {
	      JOptionPane.showMessageDialog(this, "Неправильные данные!");
	    }
	  }

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame.setDefaultLookAndFeelDecorated(true);
				new TestFrameTable();
			}
		});
	}

	public class MyTableModel implements TableModel {

		private Set<TableModelListener> listeners = new HashSet<TableModelListener>();

		private List<MyBean> beans;

		public MyTableModel(List<MyBean> beans) {
			this.beans = beans;
		}

		public void addTableModelListener(TableModelListener listener) {
			listeners.add(listener);
		}

		public Class<?> getColumnClass(int columnIndex) {
			return String.class;
		}

		public int getColumnCount() {
			return 3;
		}

		public String getColumnName(int columnIndex) {
			switch (columnIndex) {
			case 0:
				return "Имя";
			case 1:
				return "Размер";
			case 2:
				return "Описание";
			}
			return "";
		}

		public int getRowCount() {
			return beans.size();
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			MyBean bean = beans.get(rowIndex);
			switch (columnIndex) {
			case 0:
				return bean.getName();
			case 1:
				return bean.getSize();
			case 2:
				return bean.getDescription();
			}
			return "";
		}

		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}

		public void removeTableModelListener(TableModelListener listener) {
			listeners.remove(listener);
		}

		public void setValueAt(Object value, int rowIndex, int columnIndex) {

		}

	}

	public class MyBean {

		private String name;
		private String size;
		private String description;

		public MyBean(String name, String size, String description) {
			this.setName(name);
			this.setSize(size);
			this.setDescription(description);
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setSize(String size) {
			this.size = size;
		}

		public String getSize() {
			return size;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getDescription() {
			return description;
		}
	}
}
