package core.lecture2.control1.exemple;

public class MatrixCalculation {
	/** Creates a new instance of MatrixCalculation */
    public MatrixCalculation() { //конструктор класса - я его не использовал, но можно тут сделать заполнение матрицы и т.п..
    }
    
    //рекурсивная функция - вычисляет значение определителя. Если на входе определитель 2х2 - просто вычисляем (крест-на-крест), иначе раскладываем на миноры. Для каждого минора вычисляем ЕГО определитель, рекурсивно вызывая ту же функцию..
    public double CalculateMatrix(double[][] matrix){
        double calcResult=0.0;
        if (matrix.length==2){
            calcResult=matrix[0][0]*matrix[1][1]-matrix[1][0]*matrix[0][1];
        }
        else{
            int koeff=1;
            for(int i=0; i<matrix.length; i++){
                if(i%2==1){  //я решил не возводить в степень, а просто поставить условие - это быстрее. Т.к. я раскладываю всегда по первой (читай - "нулевой") строке, то фактически я проверяю на четность значение i+0.
                    koeff=-1;
                }
                else{
                    koeff=1;
                };
      //собственно разложение:                
                calcResult += koeff*matrix[0][i]*this.CalculateMatrix(this.GetMinor(matrix,0,i)); 
            }
        }
        
    //возвращаем ответ
        return calcResult;
    }
    
    //функция, к-я возвращает нужный нам минор. На входе - определитель, из к-го надо достать минор и номера строк-столбцов, к-е надо вычеркнуть.
    private double[][] GetMinor(double[][] matrix, int row, int column){
        int minorLength = matrix.length-1;
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
                        minor[i-dI][j-dJ] = matrix[i][j];
                    }
                }
            }
        }
        
        return minor;
        
    }
    
    /**
    * @param args the command line arguments
    */
    public static void main(String[] args) { //просто тест написанного:
        double[][] test = new double[3][3];
        
    //совершенно произвольная матрица - просто для этих чисел я предварительно вычислил результат вручную - чтоб проверить.
        test[0][0]=1;
        test[0][1]=2;
        test[0][2]=3;
        
        test[1][0]=4;
        test[1][1]=5;
        test[1][2]=7;
        
        test[2][0]=8;
        test[2][1]=3;
        test[2][2]=0;
        
        MatrixCalculation mc = new MatrixCalculation();
        double Result = mc.CalculateMatrix(test);
        System.out.println(Result);
        return;
    }
}
