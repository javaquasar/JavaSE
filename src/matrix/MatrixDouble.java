package matrix;

public class MatrixDouble extends MatrixAbstract{
	
	public double[][] array = new double[10][];
	public int age = 10;
	public double age2 = 10;
	
	public static void main(String[] args) {
		MatrixDouble matrix = new MatrixDouble(10, 10);
		matrix.array[5][2] = 10;
		for (int i =0; i < 10; ++i) {
			for (int j =0; j < 10; ++j) {
				matrix.array[i][j] = matrix.array[i][j]*matrix.array[i][j];
			}
		}
		
		int a = 5;
		int b = 5;
		
		Integer aI = 5;
		Integer bI = 5;
		
		Integer cI = bI;
		
		if (a == b) {
			System.out.println("a == b");
		}
		
		if (aI == bI) {
			System.out.println("aI == bI");
		} else {
			System.out.println("aI != bI");
		}
		
		if (cI == bI) {
			System.out.println("cI == bI");
		}
		
		if (aI.equals(bI)) {
			System.out.println("aI.equals(bI)");
		}
		
		
		
		
		MatrixDouble[][] array = new MatrixDouble[10][10];
		
		for (int i =0; i < 10; ++i) {
			for (int j =0; j < 10; ++j) {
				array[i][j] = new MatrixDouble(i, j);
			}
		}
		
		double[][] arrayDouble = new double[10][];
		
		for (int i = 1; i <= 10; ++i) {
			arrayDouble[i] = new double[i];
		}
		
		int i2 = 0;
		int k = 0;
		for (int i = 0, f = 5; (i2 - 567 ) <= 10; i++, f++, k=i+f) {
			
		}
		
		int[][] integer = {{1,4,5,5,6,4,5,6,4,56,6,4},{2,5}};
		
		String[] words = {"ваgва", "ваeва", "вавiа"};
		for(String s : words) {
			System.out.print(s);
		}
		
		
		for (int i = 0; i < arrayDouble.length; ++i) {
			for (int j = 1; j <= arrayDouble[i].length; ++j) {
				System.out.print(arrayDouble[i][j] + " ");
			}
			System.out.println();
		}
		
		
		
		
	}
	
	public MatrixDouble() {		
		System.out.println("Создан обьект матрицы с Double");
	}
	
	public MatrixDouble(int i, int j) {
		super.rows = i;
		super.cols = j;
		array = new double[i][j];
		System.out.println("Создан обьект матрицы с Double");
	}

	@Override
	public double getValue(int i, int j) {
		return array[i][j];
	}

	@Override
	public void setValue(int i, int j, double value) {
		array[i][j] = value;
	}
	
}
