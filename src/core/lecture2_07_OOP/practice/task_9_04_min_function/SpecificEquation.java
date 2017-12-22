package core.lecture2_07_OOP.practice.task_9_04_min_function;

public class SpecificEquation extends AbstractMinFunction {
	
	double findMin(double x){
		return x*x + 2*x - Math.cos(x)*x;
	}

	public static void main(String[] args){
		SpecificEquation se = new SpecificEquation();
		System.out.println(se.solve(6, 3, 0.000001));
	}
}
