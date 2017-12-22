package core.lecture2_07_OOP.practice.task_9_02_array_of_points;

public class OneDimensionalArrayOfPoints extends AbstractArrayOfPoints {

	private double[] axy = {};


	public static void main(String[] args) {
		new OneDimensionalArrayOfPoints().test();
	}
	
	@Override
	public void setPoint(int i, double x, double y) {
		if (i < count()) {
			axy[i * 2] = x;
			axy[i * 2 + 1] = y;
		}
	}

	@Override
	public double getX(int i) {
		return axy[i * 2];
	}

	@Override
	public double getY(int i) {
		return axy[i * 2 + 1];
	}

	@Override
	public int count() {
		return axy.length / 2;
	}

	@Override
	public void addPoint(double x, double y) {
		double[] axy1 = new double[axy.length + 2];
		System.arraycopy(axy, 0, axy1, 0, axy.length);
		axy1[axy.length] = x;
		axy1[axy.length + 1] = y;
		axy = axy1;
	}

	@Override
	public void removeLast() {
		if (count() == 0) {
			return;
		}
		double[] axy1 = new double[axy.length - 2];
		System.arraycopy(axy, 0, axy1, 0, axy1.length);
		axy = axy1;
	}

	@Override
	public void sortByX() {
		for (int barrier = 0; barrier < count() - 1; barrier++) {
			for (int index = barrier + 1; index < count(); index++) {
				if (getX(barrier) > getX(index)) {
					double tmpx = getX(index);
					double tmpy = getY(index);
					setPoint(index, getX(barrier), getY(barrier));
					setPoint(barrier, tmpx, tmpy);
				}
			}
		}
	}

}
