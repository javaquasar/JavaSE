package core.lecture2_07_OOP.practice.task_9_05_matrix_copy;

public class Matrix extends MatrixAbstract {

	private double[][] matrix;
	private int size = 0;
	private String name = "";

	public static void main(String[] args) throws CloneNotSupportedException {
		Matrix test = new Matrix(3, "test");

		test.setValue(0, 0, 1);
		test.setValue(0, 1, 2);
		test.setValue(0, 2, 3);

		test.setValue(1, 0, 4);
		test.setValue(1, 1, 5);
		test.setValue(1, 2, 6);

		test.setValue(2, 0, 7);
		test.setValue(2, 1, 8);
		test.setValue(2, 2, 9);
		
		MatrixAbstract testVector = new MatrixVector(3, "test");

		testVector.setValue(0, 0, 1);
		testVector.setValue(0, 1, 2);
		testVector.setValue(0, 2, 3);

		testVector.setValue(1, 0, 4);
		testVector.setValue(1, 1, 5);
		testVector.setValue(1, 2, 6);

		testVector.setValue(2, 0, 7);
		testVector.setValue(2, 1, 8);
		testVector.setValue(2, 2, 9);
		
		System.out.println("Сравнение обычной матрицы и векторной " + test.equals(testVector));

		System.out.println(test);
		//System.out.println(test.getSize());
		//System.out.println("Определитель = " + test.getDeterminant());
		
		Matrix testClone = test.clone();
		System.out.println("Clon");
		System.out.println(testClone);
		System.out.println("Сравнение двух матриц " + test.equals(testClone));
		testClone.setValue(1, 1, 244);
		System.out.println(testClone);
		System.out.println("Сравнение двух матриц после изменения " + test.equals(testClone));

		MatrixAbstract A = new Matrix(3, "matrixA");
		A.initialize();
		System.out.println(A.toString());
		MatrixAbstract B = new Matrix(3, "MatrixB");
		B.initialize();
		System.out.println(B.toString());
		MatrixAbstract C = A.multiply(B);
		System.out.println(C.toString());

		MatrixAbstract CInverte = C.getInvert();
		System.out.println("Матрица обратная от C");
		System.out.println(CInverte.toString());

		MatrixAbstract One = C.multiply(CInverte);
		System.out.println("Результат умножения матрица С на ей обратную");
		System.out.println(One.toString());
	}

	public Matrix(int size) {
		this.size = size;
		matrix = new double[size][size];
	}

	public Matrix(int size, String name) {
		this.size = size;
		this.name = name;
		matrix = new double[size][size];
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public Double getValue(int row, int col) {
		if ((row < 0) || (col < 0) || (row >= size) || (col >= size)) {
			return null;
		}
		return matrix[row][col];
	}

	@Override
	public void setValue(int row, int col, double value) {
		if ((row < 0) || (col < 0) || (row >= matrix.length)
				|| (col >= matrix[0].length)) {
			System.err.println("Выход за диапазон массива");
		}
		matrix[row][col] = value;
	}

	@Override
	public MatrixAbstract create(int size) {
		return new Matrix(size);
	}

	@Override
	public MatrixAbstract create(int size, String name) {
		return new Matrix(size, name);
	}


	@Override
	protected Matrix clone() throws CloneNotSupportedException {
		Matrix newClone = (Matrix) super.clone();
		newClone.matrix = matrix.clone();
			for (int j = 0; j < getSize(); j++) {
				newClone.matrix[j] = matrix[j].clone();
			}
		return newClone;
	}
	
	
	/*@Override
	protected MatrixAbstract clone() throws CloneNotSupportedException {
		Matrix newClone = (Matrix) super.clone();
		newClone.matrix = matrix.clone();
		for (int i = 0; i < getSize(); i++) {
			for (int j = 0; j < getSize(); j++) {
				newClone.setValue(i, j, getValue(i, j));
			}
		}
		return newClone;
	}*/

	
}
