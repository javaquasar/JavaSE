//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.01.19 at 05:45:53 PM EET 
//


package core.lecture3_06_XML.example.continent_DOM_vs_JAXB;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the buzov.lecture3_06.example.continent_DOM_vs_JAXB package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: buzov.lecture3_06.example.continent_DOM_vs_JAXB
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ContinentData }
     * 
     */
    public ContinentData createContinentData() {
        return new ContinentData();
    }

    /**
     * Create an instance of {@link ContinentData.CountriesData }
     * 
     */
    public ContinentData.CountriesData createContinentDataCountriesData() {
        return new ContinentData.CountriesData();
    }

    /**
     * Create an instance of {@link ContinentData.CountriesData.CountryData }
     * 
     */
    public ContinentData.CountriesData.CountryData createContinentDataCountriesDataCountryData() {
        return new ContinentData.CountriesData.CountryData();
    }

    /**
     * Create an instance of {@link ContinentData.CountriesData.CountryData.CapitalData }
     * 
     */
    public ContinentData.CountriesData.CountryData.CapitalData createContinentDataCountriesDataCountryDataCapitalData() {
        return new ContinentData.CountriesData.CountryData.CapitalData();
    }

}
