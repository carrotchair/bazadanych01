package pl.java.data.base.helloW.hibernateStore;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringCostumerRepository extends CrudRepository<Customer, Integer> {
    Customer findByNameEqualsAndSurname(String name, String surname);
}
