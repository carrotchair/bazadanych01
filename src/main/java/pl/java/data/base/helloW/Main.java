package pl.java.data.base.helloW;

import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class Main {

    public static void main(String[] args) throws SQLException {
        //System.out.println("Hello");

        String url = "jdbc:mysql://localhost:3306/employees?serverTimezone=UTC"; //employees?serverTimezone=UTC
        String databaseUsername = "root";
        String databasePassword = "manoBATAI123";
        Properties properties = new Properties();
        properties.put("user", databaseUsername);
        properties.put("password", databasePassword);
        //Connection connection = DriverManager.getConnection(url, properties);
        //doSomethingWith(connection);
        //connection.close();
        try (Connection connection = DriverManager.getConnection(url, properties)) {
            //Tak pisaliśmy, gdy metody były tutaj
//            doSomethingWith(connection);
//            System.out.println(".................");
//            findOne(connection);
//            System.out.println(".................");
//            insertOne(connection);
            new AllMethods(connection).doSomethingWith();
            System.out.println(".................");
            new AllMethods(connection).findOne();
            //AllMethods.insertOne(connection);
            System.out.println(".................");
            new AllMethods(connection).insertOne();
            System.out.println(".................");
            new AllMethods(connection).editOne();
            System.out.println(".................");
            new AllMethods(connection).deleteOne();
            System.out.println(".................");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void readResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String column1 = resultSet.getString(1); //int, jeżeli int
            String column2 = resultSet.getString(2);
            //String column3 = resultSet.getString(3);
            //String column4 = resultSet.getString(4);
            String row = new StringJoiner(", ")
                    .add(String.valueOf(column1)).add(column2)
                    //.add(column3).add(column4)
                    .toString();
            System.out.println(row);
        }
        resultSet.close();
    }

}