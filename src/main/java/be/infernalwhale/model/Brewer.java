package be.infernalwhale.model;

public class Brewer {
    private Integer id;
    private String name;
    private String address;
    private Integer zipcode;
    private String city;
    private Integer turnover;

    public Brewer(Integer id, String name, String address, Integer zipcode, String city, Integer turnover) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.turnover = turnover;
    }

    public Brewer(Brewer brewer) {
        this.id = brewer.id;
        this.name = brewer.name;
        this.address = brewer.address;
        this.zipcode = brewer.zipcode;
        this.city = brewer.city;
        this.turnover = brewer.turnover;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getTurnover() {
        return turnover;
    }

    public void setTurnover(Integer turnover) {
        this.turnover = turnover;
    }
}
