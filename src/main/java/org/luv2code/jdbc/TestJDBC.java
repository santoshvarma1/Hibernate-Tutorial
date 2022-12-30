package org.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main( String[] args ){
        String jdbcurl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String user = "hbstudent";
        String pass = "hbstudent";
        try{
            System.out.println("Connecting to database:" +jdbcurl);
            Connection myconn= DriverManager.getConnection(jdbcurl, user, pass);
            System.out.println("connection successfull");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
