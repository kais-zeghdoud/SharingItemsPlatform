package rest.item.model;

public class Address {
    private final int streetNB;
    private final String streetName;
    private final int postalCode;
    private final String city;
    private final String country;

    public Address(int streetNB, String streetName, int postalCode, String city, String country){
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
