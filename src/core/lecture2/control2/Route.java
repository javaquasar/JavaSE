package core.lecture2.control2;


public class Route<T>{

	private T first;
	private T second;
	private double distance;
	private double time;

	public Route(T first, T second, double distance, double time)
			throws SameNodes, IncorrectParameters {
		if (first.equals(second)) {
			throw new SameNodes("Одинаковые узлы");
		}

		if (distance <= 0) {
			throw new IncorrectParameters("Дистанция <= 0");
		}

		if (time <= 0) {
			throw new IncorrectParameters("Время <= 0");
		}

		this.setFirst(first);
		this.setSecond(second);
		this.distance = distance;
		this.time = time;
	}

	public double getSpeed() {
		return distance / time;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) throws IncorrectParameters {
		if (distance <= 0) {
			throw new IncorrectParameters("Дистанция <= 0");
		} else {
			this.distance = distance;
		}
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) throws IncorrectParameters {
		if (time <= 0) {
			throw new IncorrectParameters("Время <= 0");
		} else {
			this.time = time;
		}
	}

	public T getFirst() {
		return first;
	}

	public void setFirst(T first) throws SameNodes {
		if (first.equals(second)) {
			throw new SameNodes("Одинаковые узлы");
		} else {
			this.first = first;
		}
	}

	public T getSecond() {
		return second;
	}

	public void setSecond(T second) throws SameNodes {
		if (first.equals(second)) {
			throw new SameNodes("Одинаковые узлы");
		} else {
			this.second = second;
		}
	}

	@Override
	public String toString() {
		return getFirst() + " - " + getSecond() + ": время - " + getTime() + ", расстояние - " + getDistance();
	}

	
	public static class IncorrectParameters extends Exception {

		public IncorrectParameters() {
			super();
		}

		public IncorrectParameters(String message) {
			super(message);
		}
	}

	public static class SameNodes extends Exception {

		public SameNodes() {
			super();
		}

		public SameNodes(String message) {
			super(message);
		}
	}
}
