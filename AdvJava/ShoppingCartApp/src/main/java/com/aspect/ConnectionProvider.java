package com.aspect;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionProvider {

    public static Connection provideConnection() {
        try {
            Properties prop = new Properties();
            InputStream in = ConnectionProvider.class.getResourceAsStream("/dbconfig.properties");
            prop.load(in);

            String cname = prop.getProperty("classname");
            String url = prop.getProperty("url");
            String user = prop.getProperty("username");
            String pass = prop.getProperty("password");

            Class.forName(cname);
            Connection con = DriverManager.getConnection(url, user, pass);
            return con;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
