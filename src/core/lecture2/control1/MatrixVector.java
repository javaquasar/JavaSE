package core.lecture2.control1;

public class MatrixVector extends MatrixAbstract {

	private double[] matrix;
    private int size = 0;
    
    public static void main(String[] args) {
    	MatrixAbstract test = new MatrixVector(3);
		
		test.setValue(0, 0, 1);
		test.setValue(0, 1, 2);
		test.setValue(0, 2, 3);

		test.setValue(1, 0, 4);
		test.setValue(1, 1, 5);
		test.setValue(1, 2, 6);

		test.setValue(2, 0, 7);
		test.setValue(2, 1, 8);
		test.setValue(2, 2, 9);
		
		System.out.println(test.toString());
		System.out.println(test.getSize());
		System.out.println("Определитель = " + test.getDeterminant());
		
		MatrixAbstract A = new Matrix(3);
		A.initialize();
		System.out.println("Матрица А");
		System.out.println(A.toString());
		MatrixAbstract B = new Matrix(3);
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
}
