package matrix;

public class MatrixFabric {
	
	public static MatrixInterface getObjectOfMatrix(int i, int j, MatrixType type) {
		
		switch(type) {
			case DOUBLE: return new MatrixDouble(i, j);
			case DOUBLE_ARRAY: return new MatrixDoubleArray(i, j);
                        case DOUBLE_ONE: return new MatrixDoubleOne(i,j);
			default: return null;			
		}
		
	}

}
