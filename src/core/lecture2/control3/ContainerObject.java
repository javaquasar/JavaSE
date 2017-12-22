package core.lecture2.control3;

public class ContainerObject<T> implements JaggedArray<T> {
	
	private Object[][] arr = new Object[0][0];

	@Override
	public T getElement(int row, int col) throws IncorrectParameters {	
		if ((row >= getRowsCout()) || (row < 0)) {
			throw new JaggedArray.IncorrectParameters(row, col);
		}
		if ((col >= getSizeLine(row)) || (col < 0)) {
			throw new JaggedArray.IncorrectParameters(row, col);
		}
		return (T) arr[row][col];
	}

	@Override
	public void addLine() {
		//System.out.println(arr.length+1);
		Object[][] temp = new Object[arr.length+1][0];
		for(int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		arr = temp;
	}

	@Override
	public void addElement(int numberLine, T object) throws IncorrectParameters {	
		if ((numberLine >= getRowsCout()) || (numberLine < 0)) {
			throw new JaggedArray.IncorrectParameters(numberLine, 0);
		}
		int sizeLine = arr[numberLine].length;
		Object[] temp = new Object[sizeLine+1];
		for(int i = 0; i < sizeLine; i++) {
			temp[i] = arr[numberLine][i];
		}
		temp[sizeLine] = object;
		arr[numberLine] = temp;
	}

	@Override
	public int getRowsCout() {
		return arr.length;
	}

	@Override
	public int getSizeLine(int numberLine) throws IncorrectParameters {
		if ((numberLine >= getRowsCout()) || (numberLine < 0)) {
			throw new JaggedArray.IncorrectParameters(numberLine, 0);
		}
		return arr[numberLine].length;
	}

	@Override
	public void printMyArray() {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}