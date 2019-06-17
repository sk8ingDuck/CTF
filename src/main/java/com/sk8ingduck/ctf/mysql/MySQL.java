package com.sk8ingduck.ctf.mysql;

import com.sk8ingduck.ctf.connection.Connection;
import com.sk8ingduck.ctf.connection.ConnectionPool;
import com.sk8ingduck.ctf.connection.Pool;

import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {

    private final Pool<Connection> connectionPool;
    private Connection connection;

    public MySQL(String host, String username, String password, String port) {
        connectionPool = new ConnectionPool(host, username, password, port);
    }

    public void setup(){
        try {
            connection = connectionPool.checkOut();

            Statement stmt = connection.createStatement();

            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS test");

            stmt.close();

            connectionPool.checkIn(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
