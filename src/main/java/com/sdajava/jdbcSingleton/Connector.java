package com.sdajava.jdbcSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrzej on 24.04.2017.
 */

public enum Connector {
    INSTANCE;

    public static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
    public static final String DB_URL
            ="jdbc:mysql://localhost/ksiegarnia?" +
            "useSSL=false&useJDBCCompliantTimezoneShift=" +
            "true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USER="root";
    public static final String PASSWORD="Sapkowski18+";


    public static Connection setConnection ()    {
        Connection connection = null;


        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Lacze z baza danych...");

            connection = DriverManager.getConnection
                    (DB_URL, USER, PASSWORD);


        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}






