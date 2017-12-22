package core.lecture2.control1;

import java.math.BigDecimal;

public abstract class MatrixAbstract {

	public abstract int getSize();

	public abstract MatrixAbstract create(int size);

	public abstract Double getValue(int row, int col);

	public abstract void setValue(int row, int col, double value);

	public static BigDecimal roundNumber(double value, int digits) {
		BigDecimal num = new BigDecimal(value).setScale(digits, BigDecimal.ROUND_UP);
		return num;
	}

	public void initialize() {
		double temp = 0;
		for (int i = 0; i < getSize(); i++) {
			for (int j = 0; j < getSize(); j++) {
				temp = roundNumber(Math.random() * 100, 3).doubleValue();
				setValue(i, j, temp);
			}
		}
	}

	public void initializeZero() {
		for (int i = 0; i < getSize(); i++) {
			for (int j = 0; j < getSize(); j++) {
				setValue(i, j, 0);
			}
		}
	}

	public MatrixAbstract multiply(MatrixAbstract B) {
		if (getSize() != B.getSize()) {
			return null;
		}
		System.out.println("Matrixes C" + getSize() + "x" + getSize());
		System.out.println("Multiplication of matrixes A" + getSize() + "x" + getSize()
				+ " and B" + getSize() + "x" + getSize() + ".");
		double temp;
		MatrixAbstract C = create(getSize());
		for (int i = 0; i < getSize(); i++) {
			for (int j = 0; j < getSize(); j++) {
				temp = 0;
				for (int k = 0; k < getSize(); k++) {
					temp += (getValue(i, k) * B.getValue(k, j));
				}
				C.setValue(i, j, temp);
			}
		}
		return C;
	}

	public double getDeterminant() {
		double calcResult = 0.0;
		if (getSize() == 2) {
			calcResult = getValue(0, 0) * getValue(1, 1) - getValue(1, 0) * getValue(0, 1);
		} else {
			int koeff = 1;
			for (int i = 0; i < getSize(); i++) {
				if (i % 2 == 1) {
					koeff = -1;
				} else {
					koeff = 1;
				}
				calcResult += koeff * getValue(0, i) * getMinor(this, 0, i).getDeterminant();
			}
		}
		return calcResult;
	}

	private MatrixAbstract getMinor(MatrixAbstract mas, int row, int column) {
		int minorLength = mas.getSize() - 1;
		MatrixAbstract minor = create(minorLength);
		int dI = 0;
		int dJ = 0;
		for (int i = 0; i <= minorLength; i++) {
			dJ = 0;
			for (int j = 0; j <= minorLength; j++) {
				if (i == row) {
					dI = 1;
				} else {
					if (j == column) {
						dJ = 1;
					} else {
						minor.setValue(i - dI, j - dJ, mas.getValue(i, j));
					}
				}
			}
		}
		return minor;
	}

	public MatrixAbstract getInvert() {
		MatrixAbstract C = create(getSize());
		double determ = getDeterminant();
		double minor = 0;
		for (int i = 0; i < getSize(); i++) {
			for (int j = 0; j < getSize(); j++) {
				minor = getMinor(this, i, j).getDeterminant();
				C.setValue(j, i, (1 / determ) * Math.pow(-1, i + j) * minor);
			}
		}
		return C;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < getSize(); i++) {
			for (int j = 0; j < getSize(); j++) {
				stringBuilder.append( roundNumber(getValue(i, j), 6) + "\t");
			}
			stringBuilder.append("\n");
		}
		stringBuilder.append("---------------------------------");
		return stringBuilder.toString();
	}
}
