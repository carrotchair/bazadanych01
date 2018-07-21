package pl.java.data.base.helloW.hibernateStore;

//import org.hibernate.envers.Audited;
import javax.persistence.*;

@Entity
@Table
public class Customer  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    //@Audited //podkreślało na czerwono, bo brakowało biblioteki -> w necie znaleźć i wkleić do pom.xml
    private String name;
    @Column
    private String surname;
    @Version
    private Long version;
    @ManyToOne(fetch = FetchType.LAZY) //zamiast lazy było eager
    @JoinColumn(name = "fk_store")
    private Store favoriteStore;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        if (id != null ? !id.equals(customer.id) : customer.id != null) return false;
        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
        if (surname != null ? !surname.equals(customer.surname) : customer.surname != null) return false;
        return version != null ? version.equals(customer.version) : customer.version == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Customer{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", version=").append(version);
        sb.append(", favoriteStore=").append(favoriteStore);
        sb.append('}');
        return sb.toString();
    }

    public Store getFavoriteStore() {
        return favoriteStore;
    }

    public void setFavoriteStore(Store store) {
        this.favoriteStore = store;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

}
