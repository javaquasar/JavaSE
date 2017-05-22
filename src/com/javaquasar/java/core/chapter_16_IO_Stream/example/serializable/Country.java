package com.javaquasar.java.core.chapter_16_IO_Stream.example.serializable;

import java.io.Serializable;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class Country implements Serializable {
	private static final long serialVersionUID = -6755942443306500892L;
	private String name;
	private double area;
	private int population;

	public Country(String name, double area, int population) {
		this.name = name;
		this.area = area;
		this.population = population;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

}
