package com.javaquasar.java.core.chapter_16_IO_Stream.example.serializable;

import java.io.Serializable;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class Continent implements Serializable {
	private static final long serialVersionUID = 8433147861334322335L;
	private String name;
	private Country[] countries;

	public Continent(String name, Country... countries) {
		this.name = name;
		this.countries = countries;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country[] getCountries() {
		return countries;
	}

	public void setCountries(Country[] countries) {
		this.countries = countries;
	}

}
