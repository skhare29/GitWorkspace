package com.sau.corejava.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDatabase {

	public static void main(String[] args) {

		QueryHandler.executeQuery(QueryHandler.getInsertQuery());

		System.out.println("Goodbye!");
	}
}
