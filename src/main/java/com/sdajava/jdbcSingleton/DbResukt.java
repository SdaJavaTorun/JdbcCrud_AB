package com.sdajava.jdbcSingleton;

import java.sql.*;

/**
 * Created by Andrzej on 24.04.2017.
 */
public class DbResukt {

    private static Connector connector;

    public void result() {

        Connection connection = connector.INSTANCE.setConnection();

    try {

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM books WHERE id=3");

        while (resultSet.next()) {
            System.out.println(
                    resultSet.getString("author") + " | |  " +
                    resultSet.getString("title") + " | |  " +
                    resultSet.getInt("page_count"));
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
        catch (SQLException ex){
            ex.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

