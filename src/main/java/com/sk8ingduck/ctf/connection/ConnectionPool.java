package com.sk8ingduck.ctf.connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool extends AbstractPool<Connection> {

    private String host;
    private String username;
    private String password;
    private String port;

    public ConnectionPool(String host, String username, String password, String port) {
        this.host = host;
        this.username = username;
        this.password = password;
        this.port = port;
    }

    @Override
    public Connection create() {
        try {
            java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/", username, password);
            return new Connection(this, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}