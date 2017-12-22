package core.lecture2_07_OOP.practice.task_9_02_array_of_points;

public class TwoDimensionsArrayOfPoints extends AbstractArrayOfPoints {
	
	private double[][] axy = {};

	public static void main(String[] args) {
		new TwoDimensionsArrayOfPoints().test();
	}
	
	@Override
	public void setPoint(int i, double x, double y) {
		double[] arr = { x, y };
		if (i < count()) {
			axy[i] = arr;
		}
	}

	@Override
	public double getX(int i) {
		return axy[i][0];
	}

	@Override
	public double getY(int i) {
		return axy[i][1];
	}

	@Override
	public int count() {
		return axy.length;
	}

	@Override
	public void addPoint(double x, double y) {
		double[][] axy1 = new double[axy.length + 1][2];
		System.arraycopy(axy, 0, axy1, 0, axy.length);
		axy1[axy.length][0] = x;
		axy1[axy.length][1] = y;
		axy = axy1;
	}

	@Override
	public void removeLast() {
		if (count() == 0) {
			return;
		}
		double[][] axy1 = new double[axy.length - 1][2];
		System.arraycopy(axy, 0, axy1, 0, axy1.length);
		axy = axy1;
	}

}
