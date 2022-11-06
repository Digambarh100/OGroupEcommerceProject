package com.velocity.project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	static Connection connection;
	
	public static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String user="root";
			String password="root";
			String url="jdbc:mysql://localhost:3306/ecommerce";
			
			connection=DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

}
