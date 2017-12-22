package core.lecture2.control2;

public class Station {

	String name = "";
	int numberOfTrains = 0;

	public Station(String name, int numberOfTrains) {
		this.name = name;
		this.numberOfTrains = numberOfTrains;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfTrains() {
		return numberOfTrains;
	}

	public void setNumberOfTrains(int numberOfTrains) {
		this.numberOfTrains = numberOfTrains;
	}
	
	@Override
	public String toString() {
		return getName();
	}

}
