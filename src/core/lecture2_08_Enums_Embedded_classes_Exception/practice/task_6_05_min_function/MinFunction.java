package core.lecture2_08_Enums_Embedded_classes_Exception.practice.task_6_05_min_function;

public abstract class MinFunction {
	
	double a;
	double b;
	double eps;
	
	
	public MinFunction(double a, double b, double eps) {
		this.a = a;
		this.b = b;
		this.eps = eps;
	}

	abstract double findMin(double x);

	abstract double solve();
}
