package com;

import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedStatementDemo {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/rohit";
            String user = "postgres";
            String pwd = "tiger";
            
            Connection connection = DriverManager.getConnection(url, user, pwd);
            
            PreparedStatement p = connection.prepareStatement("Insert into EMP values(?,?,?,?,?);");

            Scanner scanner = new Scanner(System.in);
                
                System.out.println("Your Name is : ");
                p.setString(1, scanner.nextLine());
                System.out.println("Your Adress is : ");
                p.setString(2, scanner.nextLine());
                System.out.println("Your City is : ");
                p.setString(3, scanner.nextLine());
                System.out.println("Your Location is : ");
                p.setString(4, scanner.nextLine());
                System.out.println("Your Mobile-No. is : ");
                p.setInt(5, scanner.nextInt());
            
            p.execute();
            System.out.println("Done");
        
        } 
        catch (SQLException e) {
            System.out.println("SQL Exception");
        }
        catch (Exception e) {
            System.out.println("Other Exception");
        }
    }
}



// Create a method for the different class and differernt methods for the todays task 