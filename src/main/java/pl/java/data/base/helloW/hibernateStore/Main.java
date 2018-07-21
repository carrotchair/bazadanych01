package pl.java.data.base.helloW.hibernateStore;

import java.util.Optional;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepository();
        Customer customer1 = new Customer();
        customer1.setSurname("pupa");
        customerRepository.save(customer1);
        Optional<Customer> byId = customerRepository.findById(1);
        if (byId.isPresent()) {
            Customer customer = byId.get();
            Store favoriteStore = customer.getFavoriteStore();
            Set<Customer> customers = favoriteStore.getCustomers();
            System.out.println(customers);
            System.out.println(customer);
        }
        AddressRepository addressRepository = new AddressRepository();
//        Customer customer = new Customer();
//        customer.setName("Bozenka");
//        customer.setSurname("Mostowiak");
//        Store store = new Store();
//        store.setId(3);
//        customer.setFavoriteStore(store);
//        customerRepository.save(customer);
//        StoreRepository storeRepository = new StoreRepository();
//        Store store = new Store();
//        store.setName("Biedronka");
//        store.setLocation("Paryz");
//        storeRepository.save(store);
//
//        Customer customer = new Customer();
//        customer.setName("Romcio");
//        customer.setSurname("Borowski");
//        customer.setFavoriteStore(store);
//        customerRepository.save(customer);

//         Customer byId = customerRepository.findById(1);
//        Integer save = customerRepository.save(byId);
//        customerRepository.update(byId);
    }
}