//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.01.19 at 07:06:08 PM EET 
//


package com.javaquasar.java.core.chapter_18_XML.practice.task_5_03;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the buzov.lecture3_06.practice.task_5_03 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: buzov.lecture3_06.practice.task_5_03
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CountryData }
     * 
     */
    public CountryData createCountryData() {
        return new CountryData();
    }

    /**
     * Create an instance of {@link CountryData.СitiesData }
     * 
     */
    public CountryData.СitiesData createCountryDataСitiesData() {
        return new CountryData.СitiesData();
    }

    /**
     * Create an instance of {@link CountryData.СitiesData.CityData }
     * 
     */
    public CountryData.СitiesData.CityData createCountryDataСitiesDataCityData() {
        return new CountryData.СitiesData.CityData();
    }

    /**
     * Create an instance of {@link CountryData.СitiesData.CityData.MayorData }
     * 
     */
    public CountryData.СitiesData.CityData.MayorData createCountryDataСitiesDataCityDataMayorData() {
        return new CountryData.СitiesData.CityData.MayorData();
    }

}
