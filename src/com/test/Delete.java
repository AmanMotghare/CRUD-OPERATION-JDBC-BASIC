package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
	
	private static final String Delete_Query = "DELETE FROM EMP WHERE EID = ?";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter Employee ID to Delete : ");
		int Id = Integer.parseInt(scan.nextLine());
		
		
		//1.Register the Driver 

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Registerd.");
		
		//2.Create Connection
		
		String url="jdbc:mysql://localhost:3306/employees";
		String username="root";
		String password="abc123";
		
		Connection con = DriverManager.getConnection(url,username,password);
		System.out.println("Connection Established.");
		
		//3.Create Statement
		
		PreparedStatement ps = con.prepareStatement(Delete_Query);
		ps.setInt(1, Id);
		
		//4.Execute query.
		
		int count = ps.executeUpdate();
		
		if(count>0){
			System.out.println("Record is Deleted.");
		}
		else{
			System.out.println("Record is not Deleted.");
		}
		
//		System.out.println(count);
		
		//5.Close Connection.
		
		con.close();
		System.out.println("Connection Closed.");
		
	}
}
