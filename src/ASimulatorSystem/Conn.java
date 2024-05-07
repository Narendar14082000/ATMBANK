package ASimulatorSystem;

import java.sql.*;  

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("config.properties"));

            String url = prop.getProperty("db.url");
            String username = prop.getProperty("db.username");
            String password = prop.getProperty("db.password");

            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(url, username, password);
            s = c.createStatement();
        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}

