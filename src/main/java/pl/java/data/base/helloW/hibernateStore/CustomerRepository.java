package pl.java.data.base.helloW.hibernateStore;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CustomerRepository implements ICustomerRepository {
    public void save(Customer customer) {
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory()
                .openSession()) {
            transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
            transaction = null;
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }


    public void persist(Customer customer) {
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory()
                .openSession()) {
            transaction = session.beginTransaction();
            session.persist(customer);
            transaction.commit();
            transaction = null;
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void update(Customer customer) {
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory()
                .openSession()) {
            transaction = session.beginTransaction();
            session.update(customer);
            transaction.commit();
            transaction = null;
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public Optional<Customer> findById(Integer id) {
        Session session = SessionManager.getSessionFactory().openSession();
        Customer customer = session.find(Customer.class, id);
        session.close();
        return Optional.ofNullable(customer);
    }

    @Override
    public void changeNameInCustomerWithId(String name, Integer id) {
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory()
                .openSession()) {
            transaction = session.beginTransaction();
            Customer customer = session.find(Customer.class, id);
            if (customer != null) {
                customer.setName(name);
            }
            transaction.commit();
            transaction = null;
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public List<Customer> findByAddressCity (String city) {
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory()
                .openSession()) {
            transaction = session.beginTransaction();
            Query<Customer> query = session.createQuery("select c from Customer c where c.address.city = :cityName",
                    Customer.class);
            query.setParameter("cityName", city);
            List<Customer> list = query.list();
            transaction.commit();
            transaction = null;
            return list;
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return Collections.emptyList();
    }

    @Override
    public void removeById(Integer id) {

    }

    @Override
    public void remove(Customer customer) {

    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

}
