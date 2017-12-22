package core.lecture2.control3;

import java.util.ArrayList;

public interface JaggedArray<T> {

	T getElement(int row, int col) throws IncorrectParameters;
	
	void addLine();
	
	void addElement(int numberLine, T object) throws IncorrectParameters;
	
	int getRowsCout();
	
	int getSizeLine(int numberLine) throws IncorrectParameters;	
	
	void printMyArray();
	
	public static class IncorrectParameters extends Exception {
	
		private static int row;
		private static int col;
		
		public IncorrectParameters() {
			super();
		}

		public IncorrectParameters(int row, int col) {
			super("Error in row = " + row + " col = " + col + "!");
			this.setRow(row);
			this.setCol(col);
		}

		public static int getRow() {
			return row;
		}

		public void setRow(int row) {
			IncorrectParameters.row = row;
		}

		public static int getCol() {
			return col;
		}

		public void setCol(int col) {
			IncorrectParameters.col = col;
		}
	}
	
}
