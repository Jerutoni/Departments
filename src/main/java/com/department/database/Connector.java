package com.department.database;


import lombok.extern.log4j.Log4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Log4j
public class Connector {
    private static Connection connection = null;
    private static final String URL = "jdbc:h2:~/test;";
    private static final String LOG = "sa";
    private static final String PASS = "";
    private static final String DRIVER = "org.h2.Driver";

    private Connector() {
    }

    static Connection getConnection() throws SQLException {
        if (connection == null) {
            try {
                Class.forName(DRIVER);
            } catch (ClassNotFoundException e) {
                log.error("Connection eror " + e);
            }
            connection = DriverManager.getConnection(URL, LOG, PASS);
            return connection;
        } else {
            return connection;
        }
    }
}
