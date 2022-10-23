package rest.item.model;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Address {
	private final String streetNB;
    private final String streetName;
    private final String postalCode;
    private final String city;
    private final String country;

    public Address(String streetNB, String streetName, String postalCode, String city, String country){
        this.streetNB = streetNB;
        this.streetName = streetName;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public String toString(){
        return streetNB + " " + streetName + " " + postalCode + " " + city + " " + country;}

    public String getCity() {return city;}
}
