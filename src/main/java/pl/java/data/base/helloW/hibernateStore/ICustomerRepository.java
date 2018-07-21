package pl.java.data.base.helloW.hibernateStore;

import java.util.List;
import java.util.Optional;

interface ICustomerRepository {
    void save(Customer customer);
    void update(Customer customer);
    Optional<Customer> findById(Integer id);
    void changeNameInCustomerWithId(String name, Integer id);
    void removeById(Integer id);
    void remove(Customer customer);
    List<Customer> findAll();
}
