package core.lecture2.control1.exemple;

import java.io.Serializable;

public interface MatrixInter{

    int getColsCount();

    int getRowsCount();

    int getSize();

    Object getArray();

    int getStepRow();

    double getValue(int row, int col);
    
    void setValue(int row, int col, double value);

    void print();

    void read(String path);

    void write(String path);

    void initialize();

    MatrixInter multiply(MatrixInter matrix);

    MatrixInter multiplyThread(MatrixInter matrix);
    
    int getId();

    void setId(int id);
}
