//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.04.18 at 10:48:20 AM IST 
//


package bankloansoapwebservice.web.bank.soap;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the bankloansoapwebservice.web.bank.soap package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: bankloansoapwebservice.web.bank.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateNewLoanResponse }
     * 
     */
    public CreateNewLoanResponse createCreateNewLoanResponse() {
        return new CreateNewLoanResponse();
    }

    /**
     * Create an instance of {@link ServiceStatus }
     * 
     */
    public ServiceStatus createServiceStatus() {
        return new ServiceStatus();
    }

    /**
     * Create an instance of {@link LoanScheme }
     * 
     */
    public LoanScheme createLoanScheme() {
        return new LoanScheme();
    }

    /**
     * Create an instance of {@link CreateNewLoanRequest }
     * 
     */
    public CreateNewLoanRequest createCreateNewLoanRequest() {
        return new CreateNewLoanRequest();
    }

}