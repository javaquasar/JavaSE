package com.javaquasar.java.core.chapter_16_IO_Stream.example.work_with_zip_continent;

import java.io.*;
import java.util.zip.*;

import com.javaquasar.java.core.chapter_16_IO_Stream.example.serializable.Continent;
import com.javaquasar.java.core.chapter_16_IO_Stream.example.serializable.Country;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class StoreToZip {

	public static void main(String[] args) {

		Continent continent = new Continent("Европа",
				new Country("Украина", 603700, 46314736),
				new Country("Франция", 547030, 61875822),
				new Country("Германия", 357022, 82310000));
		try (ZipOutputStream zOut = new ZipOutputStream(new FileOutputStream("./file/16/continent.zip"));
			 DataOutputStream out = new DataOutputStream(zOut)) {
			for (Country country : continent.getCountries()) {
				ZipEntry zipEntry = new ZipEntry(country.getName());
				zOut.putNextEntry(zipEntry);
				out.writeDouble(country.getArea());
				out.writeInt(country.getPopulation());
				zOut.closeEntry();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}