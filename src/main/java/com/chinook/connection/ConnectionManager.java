package com.chinook.connection;

import com.chinook.dataaccess.models.Customer;

import java.sql.*;
import java.util.ArrayList;

public class ConnectionManager {
    //connection url
    static final String URL = "jdbc:sqlite:src/main/resources/Chinook_Sqlite.sqlite";
    static private ConnectionManager instance;
    private Connection connection;

    //put customer object in arraylist
    public ArrayList<Customer> selectAllCustomers(){
        ArrayList<Customer> customers = new ArrayList<Customer>();

        try{
            connection = DriverManager.getConnection(URL);

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT CustomerId,FirstName,LastName," +
                    "Phone,Email FROM customer");

            ResultSet  resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                customers.add(new Customer(
                        resultSet.getString("customerId"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("phone"),
                        resultSet.getString("email")

                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    //singleton pattern. There can only be one instance of this.
    public static ConnectionManager getInstance(){
        if(instance == null){
            instance = new ConnectionManager();

        }
        return instance;
    }

    //manage connection object
    public ConnectionManager(){
        try {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            System.exit(-1);
        }
    }

    public Connection getConnection(){
        return connection;
    }

}