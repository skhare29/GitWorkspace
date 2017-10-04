package com.sau.corejava.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryHandler {

	public static String getQuery() {
		StringBuffer query = new StringBuffer();

		// query.append("SELECT cus.customer_id, ");
		// query.append("       cus.first_name, ");
		// query.append("       cus.last_name, ");
		// query.append("       ad.address, ");
		// query.append("       cty.city, ");
		// query.append("       con.country ");
		// query.append("FROM   customer cus ");
		// query.append("       INNER JOIN address ad ");
		// query.append("               ON cus.address_id = ad.address_id ");
		// query.append("       INNER JOIN city cty ");
		// query.append("               ON ad.city_id = cty.city_id ");
		// query.append("       INNER JOIN country con ");
		// query.append("               ON cty.country_id = con.country_id ");

		query.append("SELECT id, first, last, age FROM Employees");

		return query.toString();
	}

	static public String getInsertQuery() {

		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO world.city ");
		query.append("            ( `name` , ");
		query.append("             `countrycode` , ");
		query.append("             `district` , ");
		query.append("             `population` ) ");
		query.append("VALUES      ( 'Saurabh', ");
		query.append("              'IN', ");
		query.append("              'Noida', ");
		query.append("              5000000)");
		
		return "INSERT INTO FORMS (FORM_KEY, FORM_NAME, FORM_DESC, FORM_DATA_TABLE, LOCKED) VALUES (2, 'Form1', 'test Form', 'xxx', 'N')";

		//return query.toString();
	}

	static public void executeQuery(String query) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {

			System.out.println("Getting Connection...");
			conn = ConnectionManager.getConnection();

			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			if (stmt.execute(query)) {
				rs = stmt.getResultSet();
				System.out.println("Inside ResultSet");

				// Extract data from result set
				while(rs.next()){
			         //Retrieve by column name
			         int id  = rs.getInt("id");
			         int age = rs.getInt("age");
			         String first = rs.getString("first");
			         String last = rs.getString("last");

			         //Display values
			         System.out.print("ID: " + id);
			         System.out.print(", Age: " + age);
			         System.out.print(", First: " + first);
			         System.out.println(", Last: " + last);
			      }
				
				rs.close();

			} else {
				stmt.getUpdateCount();
				System.out.println("Inside UpdateCount. " + stmt.getUpdateCount());
			}

			System.out.println(stmt.getClass().getName());

			// Clean-up environment
			stmt.close();
			conn.close();

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
	}

}
