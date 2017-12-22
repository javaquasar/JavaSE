package core.lecture2_08_Enums_Embedded_classes_Exception.practice.task_6_05_min_function_inter;

public class Specific {

	public static double solve(double a, double b, double eps, Function func) {
		double temp = 0;
		if (a > b) {
			temp = b;
			b = a;
			a = temp;
		}
		temp = func.findMin(a);
		for (double i = a; a < b; a += eps) {
			if (temp > func.findMin(i)) {
				temp = func.findMin(i);
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		double x = solve(10, 50, 0.00005, new Function() {
			@Override
			public double findMin(double x) {
				return x * x + 2 * x - Math.cos(x) * x;
			}
		});
		System.out.println("Минимум функции " + x);
	}
}
