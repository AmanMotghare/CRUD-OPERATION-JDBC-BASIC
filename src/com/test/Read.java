package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Read {
	
	private static final String Select_Query = "SELECT * FROM EMP ";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//1. Register The Driver. 
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Registerd.");
		
		//2. Build Connections. 
		String url="jdbc:mysql://localhost:3306/employees";
		String username="root";
		String password="abc123";
		Connection con = DriverManager.getConnection(url,username,password);
		System.out.println("Connections Established.");
		
		//3.Create Statement
		
		PreparedStatement ps = con.prepareStatement(Select_Query);
		
		//4.Execute Update
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			
			System.out.println(rs.getInt(1)+ " " + rs.getString(2));
			
		}
		
		//5.Close Connection
		
		con.close();
		System.out.println("Connections Closed.");
		
	}
}
