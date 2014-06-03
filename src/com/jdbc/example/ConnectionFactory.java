package com.jdbc.example;

import java.sql.*;

public class ConnectionFactory {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://172.19.4.18/jdbc_test";
	
	static final String USER_NAME = "root";
	static final String PASSWORD = "root123";
	
	Connection connection = null;
	static ConnectionFactory instance = new ConnectionFactory();
	
	public static Connection getConnection(){
		
		if(instance.connection == null){
			try {
				Class.forName(JDBC_DRIVER);
				instance.connection=DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instance.connection;
	}
	
}
