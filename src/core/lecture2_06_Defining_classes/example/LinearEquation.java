package core.lecture2_06_Defining_classes.example;

public class LinearEquation {
	private double a, b, x;

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getX() {
		return x;
	}

	public boolean solve() {
		if (a == 0)
			return false;
		x = -b / a;
		return true;
	}

	public static void main(String[] args) {
		LinearEquation e = new LinearEquation();
		e.setA(1);
		e.setB(-2);
		if (e.solve())
			System.out.println("x = " + e.getX());
		else
			System.out.println("Нет решений!");
		e.setA(0);
		e.setB(4);
		if (e.solve())
			System.out.println("x = " + e.getX());
		else
			System.out.println("Нет решений!");
	}
}
