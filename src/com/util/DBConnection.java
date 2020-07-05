package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static String userName = "nloiqzwxsyjjjt";
	private static String password = "537784be0dadd88c07545d9ce135f61990cb1384d80735c761ad4ad2221972b1";
	private static String connectionURL = "jdbc:postgresql://ec2-3-91-139-25.compute-1.amazonaws.com:5432/d3jqo6j9ofb1?sslmode=require";
	private static String driverClass = "org.postgresql.Driver";

	public static Connection getDBConnection() {

		Connection conn = null;

		try {
			Class.forName(driverClass);

			conn = DriverManager.getConnection(connectionURL, userName, password);

			if (conn != null) {

				System.out.println("connected to db..");
			} else {

				System.out.println("connected to db..");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;

	}

	public static void main(String[] args) {

		DBConnection.getDBConnection();
	}

}
