package final_work.gui;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import final_work.group.Group;
import final_work.group.Person;

public class MyTableModel implements TableModel {
	
	private Set<TableModelListener> listeners = new HashSet<TableModelListener>();
	
	Group group = null;
	
	public MyTableModel(Group group) {
		this.group = group;
	}

	@Override
	public int getRowCount() {
		return group.personsCount();
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "Lastname";
		case 1:
			return "Name";
		case 2:
			return "Patronymic";
		case 3:
			return "Birthday";
		case 4:
			return "Phone";
		case 5:
			return "Email";
		case 6:
			return "Skype";
		}
		return "";
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Person person = group.getPerson(rowIndex);
		switch (columnIndex) {
		case 0:
			return person.getLastname();
		case 1:
			return person.getName();
		case 2:
			return person.getPatronymic();
		case 3:
			return person.getBirthday();
		case 4:
			return person.getPhone();
		case 5:
			return person.getEmail();
		case 6:
			return person.getSkype();
		}
		return "";
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			group.getPerson(rowIndex).setLastname((String) aValue);
		case 1:
			group.getPerson(rowIndex).setName((String) aValue);
		case 2:
			group.getPerson(rowIndex).setPatronymic((String) aValue);
		case 3:
			group.getPerson(rowIndex).setBirthday((Calendar) aValue);
		case 4:
			group.getPerson(rowIndex).setPhone((String) aValue);
		case 5:
			group.getPerson(rowIndex).setEmail((String) aValue);
		case 6:
			group.getPerson(rowIndex).setSkype((String) aValue);
		}
		
	}

	@Override
	public void addTableModelListener(TableModelListener listener) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeTableModelListener(TableModelListener listener) {
		listeners.remove(listener);
	}

}
