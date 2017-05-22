package com.javaquasar.java.core.chapter_14_Enum.practice.planet;

/**
 * Created by Java Quasar on 16.05.17.
 */
public enum MoonOfMars {
	PHOBOS(9377),
	DEIMOS(23460);

	private double distance;

	private MoonOfMars(double distance) {
		this.distance = distance;
	}

	double getDistance() {
		return distance;
	}

	@Override
	public String toString() {
		return name() + ". " + distance + " km from Mars";
	}

}

