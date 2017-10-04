package com.sau.corejava.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConnectionManager {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String DB_URL = "jdbc:sqlserver://20.198.158.32:1433;DatabaseName=CID_Tables";

	// Database credentials
	static final String USER = "PIJ_APP";
	static final String PASS = "Pcx6vnqa$";

	public static Connection getConnection() {
		Connection conn;

		try {
			// Load and Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// Open a connection
			System.out.println("Connecting to database...");

			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return conn;
	}

}
