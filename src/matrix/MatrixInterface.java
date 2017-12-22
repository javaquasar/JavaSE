package matrix;

public interface MatrixInterface {
	
	int getAmountOfRows();
	
	int getAmountOfCols();
	
	double getValue(int i, int j);
	
	void setValue(int i, int j, double value);
	
	void print();
	
	void initialize();

}
