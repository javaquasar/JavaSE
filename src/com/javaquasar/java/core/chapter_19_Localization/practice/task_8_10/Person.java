package com.javaquasar.java.core.chapter_19_Localization.practice.task_8_10;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.text.*;

public class Person {

	private String name;
	private String surname;
	private String country;
	private String language;

	private Date date;
	private Locale locale;
	private SimpleDateFormat formatter;
	private DateFormatSymbols symbols;
	private static String[] oddMonthAbbreviations = new String[] { "Ja", "Fe", "Mh", "Ap", "My", "Jn", "Jy", "Au", "Se", "Oc", "No", "De" };

	public Person(String name, String surname, Country country, Language language, Date date) {
		super();
		this.name = name;
		this.surname = surname;
		this.country = country.getCountry();
		this.language = language.getLanguage();

		this.date = date;
	
		this.locale = new Locale(language.getAcronym(), country.getAcronym());
		this.symbols = new DateFormatSymbols(locale);
		symbols.setShortMonths(oddMonthAbbreviations);
		this.formatter = new SimpleDateFormat("'▼' d '▼' MMMM '▼' yyyy '▼'", symbols);
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(name);
		stringBuilder.append(" ");
		stringBuilder.append(surname);
		stringBuilder.append(" ");
		stringBuilder.append(country);
		stringBuilder.append(" ");
		stringBuilder.append(language);
		stringBuilder.append(" дата ");
		stringBuilder.append(formatter.format(date));
		return stringBuilder.toString();
	}
}
