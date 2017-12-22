package core.lecture2.control3;

import java.util.ArrayList;

public class ContainerArray<T> implements JaggedArray<T> {

	private ArrayList<T> array = new ArrayList<>();
	private ArrayList<Integer> sizeLine = new ArrayList<>();
	private boolean work = false;
	
	
	public Object getArray() {
		return (Object) array;
	}

	@Override
	public T getElement(int row, int col) throws IncorrectParameters {
		
		if ((row >= getRowsCout()) || (row < 0)  || (!work)) {
			throw new JaggedArray.IncorrectParameters(row, col);
		}
		if ((col >= getSizeLine(row)) || (col < 0)) {
			throw new JaggedArray.IncorrectParameters(row, col);
		}
		int number = 0;
		for(int i = 0; i < row; i++) {
			number += sizeLine.get(i);
		}
		number += col;
		return array.get(number);
	}
	@Override
	public void addLine() {
		work = true;
		sizeLine.add(0);
	}

	@Override
	public void addElement(int numberLine, T object) throws IncorrectParameters {		
		if ((numberLine >= getRowsCout()) || (numberLine < 0) || (!work)) {
			throw new JaggedArray.IncorrectParameters(numberLine, 0);
		}
		
		//System.out.println("size0" + sizeLine.get(0));
		int number = 0;
		for(int i = 0; i < numberLine; i++) {
			number += sizeLine.get(i);
		}
		number += sizeLine.get(numberLine);
		//System.out.println("number" + number);
		array.add(number, object);
		sizeLine.set(numberLine, sizeLine.get(numberLine)+1);
	}

	@Override
	public int getRowsCout() {
		return sizeLine.size();
	}

	@Override
	public int getSizeLine(int numberLine) throws IncorrectParameters {
		if ((numberLine >= getRowsCout()) || (numberLine < 0) || (!work)) {
			throw new JaggedArray.IncorrectParameters(numberLine, 0);
		}
		return sizeLine.get(numberLine);
	}

	@Override
	public void printMyArray() {
		int number = 0;
		for (int i = 0; i < sizeLine.size(); i++) {
			//System.out.println("i = " + i);
			for(int j = 0; j < sizeLine.get(i); j++) {
				number = 0;
				for(int k = 0; k < i; k++) {
					number += sizeLine.get(k);
				}
				number += j;
				System.out.print(array.get(number) + " ");
			}
			System.out.println();
		}
	}

}