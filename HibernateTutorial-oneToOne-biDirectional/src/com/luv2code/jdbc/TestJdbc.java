package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
        String user = "hbstudent";
        String password = "hbstudent";

        try {
            System.out.println("Connecting to DB: " + jdbcUrl);

            Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);

            System.out.println("Success");
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }
}