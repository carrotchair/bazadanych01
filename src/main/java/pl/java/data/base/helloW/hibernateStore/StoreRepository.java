package pl.java.data.base.helloW.hibernateStore;


import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class StoreRepository {
    public void save(Store store) {
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory()
                .openSession()) {
            transaction = session.beginTransaction();
            session.save(store);
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


    public void persist(Store store) {
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory()
                .openSession()) {
            transaction = session.beginTransaction();
            session.persist(store);
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

    public void update(Store store) {
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory()
                .openSession()) {
            transaction = session.beginTransaction();
            session.update(store);
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

    public Optional<Store> findById(Integer id) {
        Session session = SessionManager.getSessionFactory().openSession();
        Store customer = session.find(Store.class, id);
        session.close();
        return Optional.ofNullable(customer);
    }

    public void changeNameInCustomerWithId(String name, Integer id) {
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory()
                .openSession()) {
            transaction = session.beginTransaction();
            Store store = session.find(Store.class, id);
            if (store != null) {
                store.setName(name);
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

    public void removeById(Integer id) {

    }

    public void remove(Store customer) {

    }

    public List<Store> findAll() {
        return null;
    }
}