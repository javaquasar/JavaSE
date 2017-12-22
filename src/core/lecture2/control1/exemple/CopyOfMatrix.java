package core.lecture2.control1.exemple;

import java.math.BigDecimal;

import core.lecture2.control1.MatrixAbstract;

public class CopyOfMatrix /*extends MatrixAbstract*/ {

	/*//private int size = 0;

	public double[][] matrix;

	public static void main(String[] args) { // просто тест написанного:
		CopyOfMatrix test = new CopyOfMatrix(3);
		
		test.setValue(0, 0, 1);
		test.setValue(0, 1, 2);
		test.setValue(0, 2, 3);

		test.setValue(1, 0, 4);
		test.setValue(1, 1, 5);
		test.setValue(1, 2, 6);

		test.setValue(2, 0, 7);
		test.setValue(2, 1, 8);
		test.setValue(2, 2, 9);

		
		test.print();

		System.out.println("Определитель = " + test.getDeterminant());
		
		CopyOfMatrix A = new CopyOfMatrix(3);
		A.initialize();
		System.out.println("Матрица А");
		A.print();
		CopyOfMatrix B = new CopyOfMatrix(3);
		B.initialize();
		System.out.println("Матрица B");
		B.print();
		CopyOfMatrix C = A.multiply(B);
		System.out.println("Матрица C");
		C.print();
		
		CopyOfMatrix CInverte = C.getInvert();
		System.out.println("Матрица обратная от C");
		CInverte.print();
		
		CopyOfMatrix One = C.multiply(CInverte);
		System.out.println("Ре");
		One.print();
	}

	public CopyOfMatrix(int size) {
		super(size);
		matrix = new double[size][size];
	}
	


	@Override
	public int getSize() {
		return size;
	}

	public Double getValue(int row, int col) {
		if ((row < 0) || (col < 0) || (row >= size) || (col >= size)) {
			return null;
		}
		return matrix[row][col];
	}

	public void setValue(int row, int col, double value) {
		if ((row < 0) || (col < 0) || (row >= matrix.length)
				|| (col >= matrix[0].length)) {
			System.err.println("Выход за диапазон массива");
			;
		}
		matrix[row][col] = value;
	}

	public static BigDecimal roundNumber(double value, int digits) {
		BigDecimal num = new BigDecimal(value).setScale(digits,
				BigDecimal.ROUND_UP);
		return num;
	}

	public void initialize() {
		double temp = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				temp = roundNumber(Math.random() * 100, 3).doubleValue();
				matrix[i][j] = temp;
			}
		}
	}

	public CopyOfMatrix multiply(CopyOfMatrix B) {
		if (size != B.getSize()) {
			return null;
		}
		System.out.println("Matrixes C" + size + "x" + size);
		System.out.println("Multiplication of matrixes A" + size + "x" + size
				+ " and B" + size + "x" + size + ".");
		double temp;
		CopyOfMatrix C = new CopyOfMatrix(size);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				temp = 0;
				for (int k = 0; k < size; k++) {
					temp += (getValue(i, k) * B.getValue(k, j));
				}
				C.setValue(i, j, temp);
			}
		}
		return C;
	}

	// получаем определитель
	public double getDeterminant() {
		return calculateMatrix(matrix);
	}

	// рекурсивная функция - вычисляет значение определителя. Если на входе
	// определитель 2х2 - просто вычисляем (крест-на-крест), иначе раскладываем
	// на миноры. Для каждого минора вычисляем ЕГО определитель, рекурсивно
	// вызывая ту же функцию..
	private double calculateMatrix(double[][] mas) {
		double calcResult = 0.0;
		if (mas.length == 2) {
			calcResult = mas[0][0] * mas[1][1] - mas[1][0]
					* mas[0][1];
		} else {
			int koeff = 1;
			for (int i = 0; i < mas.length; i++) {
				if (i % 2 == 1) { // я решил не возводить в степень, а просто
									// поставить условие - это быстрее. Т.к. я
									// раскладываю всегда по первой (читай -
									// "нулевой") строке, то фактически я
									// проверяю на четность значение i+0.
					koeff = -1;
				} else {
					koeff = 1;
				}
				;
				// собственно разложение:
				calcResult += koeff * mas[0][i]
						* this.calculateMatrix(this.getMinor(mas, 0, i));
			}
		}

		// возвращаем ответ
		return calcResult;
	}

	// функция, к-я возвращает нужный нам минор. На входе - определитель, из
	// к-го надо достать минор и номера строк-столбцов, к-е надо вычеркнуть.
	private double[][] getMinor(double[][] mas, int row, int column) {
        int minorLength = mas.length-1;
        double[][] minor = new double[minorLength][minorLength];
        int dI=0;//эти переменные для того, чтобы "пропускать" ненужные нам строку и столбец
        int dJ=0;
        for(int i=0; i<=minorLength; i++){
            dJ=0;
            for(int j=0; j<=minorLength; j++){
                if(i==row){
                    dI=1;
                }
                else{
                    if(j==column){
                        dJ=1;
                    }
                    else{
                        minor[i-dI][j-dJ] = mas[i][j];
                    }
                }
            }
        }
        
        return minor;
	}
	
	public CopyOfMatrix getInvert () {		
		CopyOfMatrix C = new CopyOfMatrix(size);		
		double determ = getDeterminant();	
		double minor = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				minor = calculateMatrix(getMinor(matrix, i, j));
				C.setValue(j, i, (1/determ)*Math.pow(-1, i+j)*minor);
			}
		}				
		return C;
	}

	@Override
	public void print() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.printf("%10.3f ", matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println("---------------------------------");
		//System.out.println(Arrays.deepToString(matrix));
	}

	@Override
	public MatrixAbstract create(int size) {
		// TODO Auto-generated method stub
		return null;
	}
*/
}
