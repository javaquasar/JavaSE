//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.01.19 at 05:45:53 PM EET 
//


package core.lecture3_06_XML.example.continent_DOM_vs_JAXB;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CountriesData">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CountryData" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="CapitalData">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="Name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="Name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="Area" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *                           &lt;attribute name="Population" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="Name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "countriesData"
})
@XmlRootElement(name = "ContinentData")
public class ContinentData {

    @XmlElement(name = "CountriesData", required = true)
    protected ContinentData.CountriesData countriesData;
    @XmlAttribute(name = "Name", required = true)
    protected String name;

    /**
     * Gets the value of the countriesData property.
     * 
     * @return
     *     possible object is
     *     {@link ContinentData.CountriesData }
     *     
     */
    public ContinentData.CountriesData getCountriesData() {
        return countriesData;
    }

    /**
     * Sets the value of the countriesData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContinentData.CountriesData }
     *     
     */
    public void setCountriesData(ContinentData.CountriesData value) {
        this.countriesData = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="CountryData" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="CapitalData">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="Name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="Name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="Area" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
     *                 &lt;attribute name="Population" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "countryData"
    })
    public static class CountriesData {

        @XmlElement(name = "CountryData", required = true)
        protected List<ContinentData.CountriesData.CountryData> countryData;

        /**
         * Gets the value of the countryData property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the countryData property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCountryData().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ContinentData.CountriesData.CountryData }
         * 
         * 
         */
        public List<ContinentData.CountriesData.CountryData> getCountryData() {
            if (countryData == null) {
                countryData = new ArrayList<ContinentData.CountriesData.CountryData>();
            }
            return this.countryData;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="CapitalData">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="Name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="Name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="Area" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
         *       &lt;attribute name="Population" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "capitalData"
        })
        public static class CountryData {

            @XmlElement(name = "CapitalData", required = true)
            protected ContinentData.CountriesData.CountryData.CapitalData capitalData;
            @XmlAttribute(name = "Name", required = true)
            protected String name;
            @XmlAttribute(name = "Area", required = true)
            @XmlSchemaType(name = "unsignedInt")
            protected long area;
            @XmlAttribute(name = "Population", required = true)
            @XmlSchemaType(name = "unsignedInt")
            protected long population;

            /**
             * Gets the value of the capitalData property.
             * 
             * @return
             *     possible object is
             *     {@link ContinentData.CountriesData.CountryData.CapitalData }
             *     
             */
            public ContinentData.CountriesData.CountryData.CapitalData getCapitalData() {
                return capitalData;
            }

            /**
             * Sets the value of the capitalData property.
             * 
             * @param value
             *     allowed object is
             *     {@link ContinentData.CountriesData.CountryData.CapitalData }
             *     
             */
            public void setCapitalData(ContinentData.CountriesData.CountryData.CapitalData value) {
                this.capitalData = value;
            }

            /**
             * Gets the value of the name property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Gets the value of the area property.
             * 
             */
            public long getArea() {
                return area;
            }

            /**
             * Sets the value of the area property.
             * 
             */
            public void setArea(long value) {
                this.area = value;
            }

            /**
             * Gets the value of the population property.
             * 
             */
            public long getPopulation() {
                return population;
            }

            /**
             * Sets the value of the population property.
             * 
             */
            public void setPopulation(long value) {
                this.population = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;attribute name="Name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class CapitalData {

                @XmlAttribute(name = "Name", required = true)
                protected String name;

                /**
                 * Gets the value of the name property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getName() {
                    return name;
                }

                /**
                 * Sets the value of the name property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setName(String value) {
                    this.name = value;
                }

            }

        }

    }

}