package pl.java.data.base.helloW;

import java.sql.*;

import static pl.java.data.base.helloW.Main.readResultSet;

public class AllMethods {
    private final Connection connection;
    //private final po to żeby nam nie nadpisało
    //alt + Enter i tworzymy konstruktor

    public AllMethods(Connection connection) {
        this.connection = connection;
    }

    public void doSomethingWith() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from departments");
            readResultSet(resultSet);
        }
    }

    public void findOne() throws SQLException {
        String dept_no = "d009";
        String dept_name = "Customer Service";
        String query = "SELECT * FROM departments WHERE dept_no = ? AND dept_name = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            //byłoby setInt gdyby to ył int
            statement.setString(1, dept_no); //1 - pierwszy znak zapytania, który podmieniamy
            statement.setString(2, dept_name); //2 - drugi znak zapytania
            boolean execute = statement.execute();
            if (execute) {
                ResultSet resultSet = statement.getResultSet();
                readResultSet(resultSet);
            }
        }
    }

    public void insertOne() throws SQLException {
        String dept_no = "d012";
        String dept_name = "Wydział Przemka";
        String query = "insert into departments values(?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, dept_no);
            statement.setString(2, dept_name);
            boolean execute = statement.execute();
            if (execute) {
                ResultSet resultSet = statement.getResultSet();
                readResultSet(resultSet);
            }
            System.out.println("Element dodany. Congrats.");
        }
    }

    public void editOne() throws SQLException {
        String dept_name = "Wydział Przemka aaa aaa";
        String dept_no = "d012";
        String query = "update departments set dept_name = ? where dept_no = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, dept_name);
            statement.setString(2, dept_no);
            boolean execute = statement.execute();
            if (execute) {
                ResultSet resultSet = statement.getResultSet();
                readResultSet(resultSet);
            }
            System.out.println("Dane zostały zmienione. Congrats.");
        }
    }

    public void deleteOne() throws SQLException {
        String dept_no = "d012";
        String query = "delete from departments where dept_no = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, dept_no);
            boolean execute = statement.execute();
            if (execute) {
                ResultSet resultSet = statement.getResultSet();
                readResultSet(resultSet);
            }
            System.out.println("Element został usunięty. Congrats.");
        }
    }
}
