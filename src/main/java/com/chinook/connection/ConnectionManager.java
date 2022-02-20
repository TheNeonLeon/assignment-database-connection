package com.chinook.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    //connection url
    static final String URL = "jdbc:sqlite:src/main/resources/Chinook_Sqlite.sqlite";
    static private ConnectionManager instance;
    private Connection connection;

    //singleton pattern. There can only be one instance of this.
    public static ConnectionManager getInstance(){
        if(instance == null){
            instance = new ConnectionManager();

        }
        return instance;
    }

    //manage connection object
    private ConnectionManager(){
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
