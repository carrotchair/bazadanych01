package pl.java.data.base.helloW.hibernateStore;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Optional;

public abstract class GenericRepository<T, ID> {

    public void save(T entity) {
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory()
                .openSession()) {
            transaction = session.beginTransaction();
            session.save(entity);
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

    public void update(T entity) {
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory()
                .openSession()) {
            transaction = session.beginTransaction();
            session.update(entity);
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

    public Optional<T> findById(ID id) {
        Session session = SessionManager.getSessionFactory().openSession();
        T ent = session.find(getClazz(), id);
        session.close();
        return Optional.ofNullable(ent);
    }

    abstract Class<T> getClazz();

}
