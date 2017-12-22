package core.lecture2_07_OOP.practice.task_9_04_min_function;

public class SpecificEquationImplements implements InterfaceMinFunction {

	@Override
	public double findMin(double x) {
		return x * x + 2 * x - Math.cos(x) * x;
	}

	@Override
	public double solve(double a, double b, double eps) {
		double temp = 0;

		if (a > b) {
			temp = b;
			b = a;
			a = temp;
		}
		temp = findMin(a);
		for (double i = a; a < b; a += eps) {
			if (temp > findMin(i)) {
				temp = findMin(i);
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		SpecificEquationImplements se = new SpecificEquationImplements();
		System.out.println(se.solve(6, 3, 0.000001));
	}

}
