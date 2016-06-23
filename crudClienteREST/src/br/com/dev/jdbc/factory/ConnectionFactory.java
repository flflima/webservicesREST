package br.com.dev.jdbc.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private ConnectionFactory() {
		
	}

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(
					"jdbc:mysql://localhost/testwebservicerest", "root",
					"admin");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
