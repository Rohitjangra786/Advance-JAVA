package com;

import java.sql.SQLException;
import java.sql.DriverManager;
import org.postgresql.Driver;

public class FirstStep {
	public static void main(String[] args) {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
		} catch (SQLException e) {
			e.printStackTrace();
		
        }
	}
}
