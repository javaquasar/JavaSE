package matrix;

public class MatrixMultiplay {

    public static MatrixInterface multiplay(MatrixInterface matrixA, MatrixInterface matrixB) {
        int rowsA = matrixA.getAmountOfRows();
        int colsA = matrixA.getAmountOfCols();
        int rowsB = matrixB.getAmountOfRows();
        int colsB = matrixB.getAmountOfCols();
        MatrixDouble matrixC = null;
        
        if(rowsA != colsB) {
        	return matrixC;
        }
        
        double temp = 0;
        if (colsA == rowsB) {
            matrixC = new MatrixDouble(colsA, rowsB);
            for (int i = 0; i < rowsA; ++i) {
                for (int j = 0; j < colsB; ++j) {
                    for (int k = 0; k < colsA; ++k) {
                        temp += matrixA.getValue(i, k) * matrixB.getValue(k, j);   
                    }
                    matrixC.setValue(i, j, temp);
                    temp = 0;
                }
            }
            
        }
        return matrixC;
    }
}