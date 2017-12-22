package com.javaquasar.java.core.chapter_08_Look_at_Classes_and_Objects.example;

public class Country {
	private String name;
	private double area;
	private Census[] censuses;

	public Country(String name, double area, Census[] censuses) {
		super();
		// TODO Auto-generated constructor stub
		this.name = name;
		this.area = area;
		this.censuses = censuses;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public Census[] getCensuses() {
		return censuses;
	}

	public void setCensuses(Census[] censuses) {
		this.censuses = censuses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double density(int year) {
		for (int i = 0; i < censuses.length; i++) {
			if (year == censuses[i].getYear())
				return censuses[i].getPopulation() / area;
		}
		return 0;
	}

	public int maxYear() {
		Census census = censuses[0];
		for (int i = 1; i < censuses.length; i++) {
			if (census.getPopulation() < censuses[i].getPopulation())
				census = censuses[i];
		}
		return census.getYear();
	}

	public void findWord(String word) {
	    System.out.println("Слово " + word + ":");
	    for (Census census : censuses)
	      if (census.containsWord(word))
	        System.out.println("Перепись " + census.getYear() + 
	                           " года. Комментарий:" + census.getComments());
	  }

	public static void main(String[] args) {
		Census[] censuses = {
				new Census(1959, 41869000, "Первая послевоенная перепись"),
				new Census(1970, 47126500, "Нас стало больше"),
				new Census(1979, 49754600, "Просто перепись"),
				new Census(1989, 51706700, "Последняя советская перепись"),
				new Census(2001, 48475100,
						"Первая перепись в независимой Украине") };
		Country country = new Country("Украина", 603628, censuses);
		System.out.println("Плотность населения в 1979 году: "
				+ country.density(1979));
		System.out.println("Год с наибольшим населением: " + country.maxYear());
		country.findWord("перепись");
	}
}