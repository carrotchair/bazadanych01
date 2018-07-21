package pl.java.data.base.helloW.hibernate;

//import com.mysql.cj.Session;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        org.hibernate.Session session = SessionManager.getSessionFactory().openSession();
        session.beginTransaction();
        Departments departments = new Departments();
        departments.setId("d014");
        departments.setDept_name("Wydzial programistow");
        session.persist(departments);
        session.getTransaction().commit();
        session.close();

    }
}
