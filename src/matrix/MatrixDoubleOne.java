package matrix;

public class MatrixDoubleOne extends MatrixAbstract {

    protected double[] array;// = new double[10][10];

    public MatrixDoubleOne(int i, int j) {
        super.rows = i;
        super.cols = j;
        array = new double[i * j];
        System.out.println("Создан обьект матрицы с DoubleOne");
    }

    @Override
    public double getValue(int i, int j) {
        int temp = cols * i + j;

        return array[temp];
    }

    @Override
    public void setValue(int i, int j, double value) {
        int temp = cols * i + j;
        array[temp] = value;
    }

}
