package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementDemoTask {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/rohit";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "tiger";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option:");
        System.out.println("1. Insert data");
        System.out.println("2. Update data");
        System.out.println("3. Delete data");

        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        switch (option) {
            case 1:
                insertData(scanner);
                break;
            case 2:
                updateData(scanner);
                break;
            case 3:
                deleteData(scanner);
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    private static void insertData(Scanner scanner) {
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO EMP (Name, Address, City, Location, Mobile_No) VALUES (?, ?, ?, ?, ?)");

            System.out.println("Enter your name: ");
            String name = scanner.nextLine();
            System.out.println("Enter your address: ");
            String address = scanner.nextLine();
            System.out.println("Enter your city: ");
            String city = scanner.nextLine();
            System.out.println("Enter your location: ");
            String location = scanner.nextLine();
            System.out.println("Enter your mobile number: ");
            int mobileNumber = scanner.nextInt();

            statement.setString(1, name);
            statement.setString(2, address);
            statement.setString(3, city);
            statement.setString(4, location);
            statement.setInt(5, mobileNumber);

            statement.executeUpdate();

            System.out.println("Insert successful!");
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Other Exception: " + e.getMessage());
        }
    }

    private static void updateData(Scanner scanner) {
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE EMP SET Address = ?, City = ?, Location = ?, Mobile_No = ? WHERE Name = ?");

            System.out.println("Enter your name: ");
            String name = scanner.nextLine();
            System.out.println("Enter your address: ");
            String address = scanner.nextLine();
            System.out.println("Enter your city: ");
            String city = scanner.nextLine();
            System.out.println("Enter your location: ");
            String location = scanner.nextLine();
            System.out.println("Enter your mobile number: ");
            int mobileNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
            System.out.println("Modify which name? ");
            String modifyName = scanner.nextLine();

            statement.setString(1, address);
            statement.setString(2, city);
            statement.setString(3, location);
            statement.setInt(4, mobileNumber);
            statement.setString(5, modifyName);

            statement.executeUpdate();

            System.out.println("Update successful!");
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Other Exception: " + e.getMessage());
        }
    }

    private static void deleteData(Scanner scanner) {
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM EMP WHERE Name = ?");

            System.out.println("Enter the name to delete: ");
            String name = scanner.nextLine();

            statement.setString(1, name);

            statement.executeUpdate();

            System.out.println("Delete successful!");
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Other Exception: " + e.getMessage());
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}