package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl="jdbc:mysql://127.0.0.1:3306/databae?serverTimezone=UTC";
        String user="root";
        String pass="Endomorf123*";

        try {
            System.out.println("Connecting to databse: "+jdbcUrl);
            Connection connection= DriverManager.getConnection(jdbcUrl,user,pass);
            System.out.println("Connection suceessful");


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
