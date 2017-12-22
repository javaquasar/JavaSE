package core.lecture2_07_OOP.practice.task_9_05_matrix_copy;

public class MatrixVector extends MatrixAbstract {

	private double[] matrix;
    private int size = 0;
    private String name = "";
    
    public static void main(String[] args) throws CloneNotSupportedException {
    	MatrixVector test = new MatrixVector(3, "test");
		
		test.setValue(0, 0, 1);
		test.setValue(0, 1, 2);
		test.setValue(0, 2, 3);

		test.setValue(1, 0, 4);
		test.setValue(1, 1, 5);
		test.setValue(1, 2, 6);

		test.setValue(2, 0, 7);
		test.setValue(2, 1, 8);
		test.setValue(2, 2, 9);
		
		Matrix testTable = new Matrix(3, "test");

		testTable.setValue(0, 0, 1);
		testTable.setValue(0, 1, 2);
		testTable.setValue(0, 2, 3);

		testTable.setValue(1, 0, 4);
		testTable.setValue(1, 1, 5);
		testTable.setValue(1, 2, 6);

		testTable.setValue(2, 0, 7);
		testTable.setValue(2, 1, 8);
		testTable.setValue(2, 2, 9);
		
		System.out.println("Сравнение обычной матрицы и векторной " + test.equals(testTable));
		
		System.out.println(test.toString());
		//System.out.println(test.getSize());
		//System.out.println("Определитель = " + test.getDeterminant());
		
		MatrixVector testClone = test.clone();
		System.out.println("Clon");
		System.out.println(testClone);
		System.out.println("Сравнение двух матриц " + test.equals(testClone));
		testClone.setValue(1, 1, 244);
		System.out.println(testClone);
		System.out.println("Сравнение двух матриц после изменения " + test.equals(testClone));
		
		MatrixAbstract A = new Matrix(3, "matrixA");
		A.initialize();
		System.out.println("Матрица А");
		System.out.println(A.toString());
		MatrixAbstract B = new Matrix(3, "matrixB");
		B.initialize();
		System.out.println("Матрица B");
		System.out.println(B.toString());
		MatrixAbstract C = (Matrix) A.multiply(B);
		System.out.println("Матрица C");
		System.out.println(C.toString());
		
		MatrixAbstract CInverte = (Matrix) C.getInvert();
		System.out.println("Матрица обратная от C");
		System.out.println(CInverte.toString());
		
		MatrixAbstract One = (Matrix) C.multiply(CInverte);
		System.out.println("Результат умножения матрица С на ей обратную");
		System.out.println(One.toString());
	}
    
    public MatrixVector(int size) {
    	this.size = size;
        matrix = new double[size*size];
    }
    
    public MatrixVector(int size, String name) {
    	this.size = size;
    	this.name = name;
        matrix = new double[size*size];
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
		return matrix[size*row + col];
	}

	@Override
	public void setValue(int row, int col, double value) {
		if ((row < 0) || (col < 0) || (row >= size)
				|| (col >= size)) {
			System.err.println("Выход за диапазон массива");
		}
		matrix[size*row + col] = value;
	}

	@Override
	public MatrixAbstract create(int size) {
		return new MatrixVector(size);
	}
	
	@Override
	public MatrixAbstract create(int size, String name) {
		return new MatrixVector(size, name);
	}
	
	@Override
	protected MatrixVector clone() throws CloneNotSupportedException {
		MatrixVector newClone = (MatrixVector) super.clone();
		newClone.matrix = matrix.clone();
		return newClone;
	}
}
