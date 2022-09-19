package com.java.maven.ParyrollService;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class DbConnection {

	private static DbConnection dbConnection;

	private Connection con;

	private DbConnection() {
		try {
			/**
			 * Check if MySQL JDBC driver class is loaded
			 */
			Class.forName("com.mysql.cj.jdbc.Driver");
			/**
			 * List the MySQL JDBC Drivers Registerd
			 */
			listDrivers();
			System.out.println("Connection established successfully.");
		} catch (ClassNotFoundException e) {
			System.out.println(
					"Driver class could not find, please add the mysql-connector.jar file.");
			e.printStackTrace();
		}
	}
	/**
	 * List the drivers being loaded
	 */
	public static DbConnection init() {
		if (dbConnection == null)
			dbConnection = new DbConnection();
		return dbConnection;
	}

	public Connection getConnection() {
		/**
		 * Set the DB URL to local host database you have created.
		 * Check the Username and Password set in MySQL
		 */
		String jdbcStr = "jdbc:mysql://localhost:3306/payroll_service";
		String userName = "root";
		String password = "mysql";
		try {
			con = DriverManager.getConnection(jdbcStr, userName, password);
		} catch (SQLException e) {
			System.out.println(
					"Database connection failed, check your configurations.");
			e.printStackTrace();
		}
		return con;
	}

	private void listDrivers() {
		Enumeration<Driver> drivers = DriverManager.getDrivers();
		while (drivers.hasMoreElements()) {
			Driver d = drivers.nextElement();
			System.out.println(d.getClass().getName());
		}
	}

}