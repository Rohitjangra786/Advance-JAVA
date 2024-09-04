package com;

import java.sql.*;
import java.util.Scanner;

public class CreateTable {
    public static void main(String[] args) {
        // Create a table 5 columns
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc::postgresql//localhost:5432/rohit";
            String user = "postgres";
            String pwd = "tiger";
            
            Scanner s= new Scanner(System.in);
            Connection connection = DriverManager.getConnection(url, user, pwd);
            PreparedStatement p = connection.prepareStatement("CREATE TABLE ? (? varchar(255));");

            p.setString(1, s.nextLine());
            p.setString(2, s.nextLine());
            


            p.execute();
            System.out.println("Table Creation Done");
        
        } 
        catch (SQLException e) {
            System.out.println("SQL Exception");
        }
        catch (Exception e) {
            System.out.println("Other Exception");
        }
    }
}
