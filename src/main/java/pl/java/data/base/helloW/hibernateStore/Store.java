package pl.java.data.base.helloW.hibernateStore;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String location;
    @OneToMany( mappedBy = "favoriteStore",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Set<Customer> customers = new HashSet<>();

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Store{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", location='").append(location).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Store)) return false;

        Store store = (Store) o;

        if (id != null ? !id.equals(store.id) : store.id != null) return false;
        if (name != null ? !name.equals(store.name) : store.name != null) return false;
        if (location != null ? !location.equals(store.location) : store.location != null) return false;
        return customers != null ? customers.equals(store.customers) : store.customers == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (customers != null ? customers.hashCode() : 0);
        return result;
    }
}
