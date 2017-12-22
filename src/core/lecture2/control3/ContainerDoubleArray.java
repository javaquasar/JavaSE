package core.lecture2.control3;

import java.util.ArrayList;

public class ContainerDoubleArray<T> implements JaggedArray<T> {

	private ArrayList<ArrayList<T>> array = new ArrayList<ArrayList<T>>();
	
	
	public Object getArray() {
		return (Object) array;
	}

	@Override
	public T getElement(int row, int col) throws IncorrectParameters {
		if ((row >= getRowsCout()) || (row < 0)) {
			throw new JaggedArray.IncorrectParameters(row, col);
		}
		if ((col >= getSizeLine(row)) || (col < 0)) {
			throw new JaggedArray.IncorrectParameters(row, col);
		}
		return array.get(row).get(col);
	}
	@Override
	public void addLine() {
		array.add(new ArrayList<T>());
	}

	@Override
	public void addElement(int numberLine, T object) throws IncorrectParameters {		
		if ((numberLine >= getRowsCout()) || (numberLine < 0)) {
			throw new JaggedArray.IncorrectParameters(numberLine, 0);
		}
		array.get(numberLine).add(object);
	}

	@Override
	public int getRowsCout() {
		return array.size();
	}

	@Override
	public int getSizeLine(int numberLine) throws IncorrectParameters {
		if ((numberLine >= getRowsCout()) || (numberLine < 0)) {
			throw new JaggedArray.IncorrectParameters(numberLine, 0);
		}
		return array.get(numberLine).size();
	}

	@Override
	public void printMyArray() {
		for (int i = 0; i < array.size(); i++) {
			for (int j = 0; j < array.get(i).size(); j++) {
				System.out.print(array.get(i).get(j) + " ");
			}
			System.out.println();
		}

	}

}