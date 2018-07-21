package pl.java.data.base.helloW.hibernateStore;

import javax.persistence.*;

@Entity
@Table
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String street;
    @Column
    private Integer houseNumber;
    @Column
    private String city;
    @Version
    private Long version;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_store")

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Address address = (Address) o;

        if (id != null ? !id.equals(address.id) : address.id != null) return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        if (houseNumber != null ? !houseNumber.equals(address.houseNumber) : address.houseNumber != null) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        return version != null ? version.equals(address.version) : address.version == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (houseNumber != null ? houseNumber.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Address{");
        sb.append("id=").append(id);
        sb.append(", street='").append(street).append('\'');
        sb.append(", houseNumber='").append(houseNumber).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", version=").append(version);
        //sb.append(", favoriteStore=").append(favoriteStore);
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber() { this.houseNumber = houseNumber; }

    public String getCity() {
        return city;
    }

    public void setCity(String surname) {
        this.city = surname;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

}
