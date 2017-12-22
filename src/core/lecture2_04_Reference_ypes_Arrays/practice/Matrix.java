package core.lecture2_04_Reference_ypes_Arrays.practice;

import java.math.BigDecimal;

public class Matrix {
	public static void main(String[] args) {
		double[][] matrixA = makeRandomMatrix(9, 10);
		print(matrixA);
		System.out.println("-----------------");
		double[][] matrixB = makeRandomMatrix(10, 7);
		print(matrixB);
		System.out.println("-----------------");
		double[][] matrixC = multiply(matrixA, matrixB);
		print(matrixC);
		
	}
	
	public static void print(double[][] A) {
        int aRows = A.length;
        int aCols = A[0].length;
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < aCols; j++) {
                System.out.printf("%8.3f ", A[i][j]);
            }
            System.out.println();
        }
    }
	
	public static BigDecimal roundNumber(double value, int digits) {
        //we approximate the transferred number "value" with accuracy "digits"          
        BigDecimal num = new BigDecimal(value).setScale(digits, BigDecimal.ROUND_UP);
        return num;
    }
	
	public static double[][] makeRandomMatrix(int rows, int cols) {
      
		double[][] matrix = new double[rows][cols];
        double temp = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // fill with random values
                temp = roundNumber(Math.random() * 100, 3).doubleValue();
                matrix[i][j] = temp;       
            }
        }
        
        return matrix;

    }
	
	public static double[][] multiply(double[][] A, double[][] B) {
        int aRows = A.length;
        int aCols = A[0].length;
        int bRows = B.length;
        int bCols = B[0].length;
        if (aCols != bRows) {
            throw new ArithmeticException ("Illegal matrix dimensions.");
        }
        System.out.println("Matrixes C" + aRows + "x" + bCols);
        System.out.println("Multiplication of matrixes A" + aRows
                + "x" + aCols + " and B" + bRows
                + "x" + bCols + ".");
        long startTime = System.currentTimeMillis();

        double[][] C = new double[aRows][bCols];
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bCols; j++) {
                for (int k = 0; k < aCols; k++) {
                    C[i][j] += (A[i][k] * B[k][j]);
                }
            }
        }
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        System.out.println("Multiplication of matrixes lasted " + time + " ms.");
        return C;
    }
}
