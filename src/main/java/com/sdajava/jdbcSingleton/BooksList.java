package com.sdajava.jdbcSingleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Andrzej on 25.04.2017.
 */
public class BooksList {

    private static Connector connector;

    public static void showBooksList() {

        Connection connection = connector.INSTANCE.setConnection();

        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM books");

            while (resultSet.next()) {
                System.out.print(resultSet.getString("title") +
                        " " + resultSet.getString("author") +
                        " " + resultSet.getInt("page_count") +
                        " " + resultSet.getString("isbn") +
                        "\n");
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
