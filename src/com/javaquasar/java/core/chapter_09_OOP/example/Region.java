package com.javaquasar.java.core.chapter_09_OOP.example;

//Иерархия классов
class Region {
	private String name;
	private double area;

	public Region(String name, double area) {
		this.name = name;
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public double getArea() {
		return area;
	}

	@Override
	public String toString() {
		return getClass().getName() + ": \t" + name + ".   \tТерритория "
				+ area + " кв.км.";
	}
}

class PopulatedRegion extends Region {
	private int population;

	public PopulatedRegion(String name, double area, int population) {
		super(name, area);
		this.population = population;
	}

	public int getPopulation() {
		return population;
	}

	public int density() {
		return (int) (population / getArea());
	}

	@Override
	public String toString() {
		return super.toString() + "    \tНаселение " + population
				+ " чел.\tПлотность населеня " + density() + " чел/кв.км.";
	}
}

class Country extends PopulatedRegion {
	private String capital;

	public Country(String name, double area, int population, String capital) {
		super(name, area, population);
		this.capital = capital;
	}

	public String getCapital() {
		return capital;
	}

	@Override
	public String toString() {
		return super.toString() + "\tСтолица " + capital;
	}
}

class City extends PopulatedRegion {
	private int boroughs; // Количество районов

	public City(String name, double area, int population, int boroughs) {
		super(name, area, population);
		this.boroughs = boroughs;
	}

	public int getBoroughs() {
		return boroughs;
	}

	@Override
	public String toString() {
		return super.toString() + "\tРайонов - " + boroughs;
	}
}

class Island extends PopulatedRegion {
	private String sea;

	public Island(String name, double area, int population, String sea) {
		super(name, area, population);
		this.sea = sea;
	}

	public String getSea() {
		return sea;
	}

	@Override
	public String toString() {
		return super.toString() + "\tМоре - " + sea;
	}

}

/*public class Regions {

	public static void main(String[] args) {
		Region[] a = new Region[4];
		a[0] = new City("Киев", 839, 2679000, 10);
		a[1] = new Country("Украина", 603700, 46294000, "Киев");
		a[2] = new City("Харьков", 310, 1461000, 9);
		a[3] = new Island("Змеиный", 0.2, 30, "Черное");
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i]);
	}
}

public class RegionsTest {

	public static void main(String[] args) {
		Country c = new Country("Украина", 603700, 46294000, "Киев");
		System.out.println(c.getName());
		System.out.println(c.getArea());
		System.out.println(c.getPopulation());
		System.out.println(c.density());
		System.out.println(c.getCapital());
	}

}*/
