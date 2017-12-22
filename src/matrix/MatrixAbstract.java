package matrix;

import java.math.BigDecimal;

public abstract class MatrixAbstract implements MatrixInterface {

	protected int rows = 0;
	protected int cols = 0;

	@Override
	public int getAmountOfRows() {
		return rows;
	}

	@Override
	public int getAmountOfCols() {
		return cols;
	}

	@Override
	public void print() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.format("%.3f", getValue(i, j));
				System.out.print("    ");
			}
			System.out.println();
		}
	}

	@Override
	public void initialize() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				setValue(i, j, Math.random() * 20 - 10);
			}
		}
	}

	public static BigDecimal roundNumber(double value, int digits) {
		// we approximate the transferred number "value" with accuracy "digits"
		BigDecimal num = new BigDecimal("" + value).setScale(digits, BigDecimal.ROUND_HALF_UP);
		return num;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == this) {
			return true;
		}

		/* obj ссылается на null */

		if (obj == null) {
			return false;
		}

		/* Удостоверимся, что ссылки имеют тот же самый тип */

		/*
		 * if (!(getClass() == obj.getClass())) { return false; }
		 */
		
		MatrixInterface matrixB;
		
		if (!(obj instanceof MatrixInterface)) {
			return false;
		} else {
			matrixB = (MatrixInterface) obj;
		}

		int rowsB = matrixB.getAmountOfRows();
		int colsB = matrixB.getAmountOfCols();
		boolean c = true;

		if (colsB != cols || rows != rowsB) {
			c = false;
			System.out.println("Матрицы не одинакового размера");
		} else {
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < colsB; j++) {
					if (getValue(i, j) != matrixB.getValue(i, j)) {
						return false;
					}
				}
			}
		}
		return c;
	}

	public static boolean equels(MatrixInterface matrixA, MatrixInterface matrixB) {
		int rowsA = matrixA.getAmountOfRows();
		int colsA = matrixA.getAmountOfCols();
		int rowsB = matrixB.getAmountOfRows();
		int colsB = matrixB.getAmountOfCols();
		boolean c = true;

		if (colsB != colsA || rowsA != rowsB) {
			c = false;
			System.out.println("Матрицы не одинакового размера");
		} else {
			for (int i = 0; i < rowsA; i++) {
				for (int j = 0; j < colsB; j++) {
					if (matrixA.getValue(i, j) != matrixB.getValue(i, j)) {
						return false;
					}
				}
			}
		}
		return c;
	}
}
