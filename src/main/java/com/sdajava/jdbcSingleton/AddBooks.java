package com.sdajava.jdbcSingleton;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.sdajava.jdbcSingleton.Connector.*;

/**
 * Created by Andrzej on 25.04.2017.
 */
public class AddBooks {

    public static void addBooks () {

        Connection connection = null;
        Statement statement = null;
        Scanner addBookScanner = new Scanner(System.in);
        Boolean addBookFlag = true;
        String title;
        String author;
        String isbn;
        String page_count;

        while (addBookFlag) {
            System.out.println("Podaj tytul");
            title = addBookScanner.nextLine();

            System.out.println("Podaj autora");
            author = addBookScanner.next();

            System.out.println("Podaj isbn");
            isbn = addBookScanner.next();

            System.out.println("Podaj tytul");
            page_count = addBookScanner.next();


            try {
                Class.forName(JDBC_DRIVER);

                System.out.println("Lacze sie z baza danych... \nUzupelniam dane... ");

                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                statement = connection.createStatement();

                String insert = "insert into books (title,author,isbn,page_count) values (?,?,?,?)";
                PreparedStatement preparedStatement1 = connection.prepareStatement(insert);
                preparedStatement1.setString(1, title);
                preparedStatement1.setString(2, author);
                preparedStatement1.setString(3, isbn);
                preparedStatement1.setString(3, page_count);
                preparedStatement1.executeUpdate();

                ResultSet resultSet = statement.executeQuery("select * from books");

                resultSet.close();
                statement.close();
                connection.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        addBookFlag = false;
    }
}

