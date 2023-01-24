package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {
	
	private static final String Update_Query = "UPDATE EMP SET ENAME = ? WHERE EID = ?";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter Employee ID : ");
		int Id = Integer.parseInt(scan.nextLine());
		
		System.out.print("Enter Updated Name of an Employee : ");
		String Name = scan.nextLine();
		
		
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
		
		PreparedStatement ps = con.prepareStatement(Update_Query);
		ps.setString(1, Name);
		ps.setInt(2, Id);
		
		//4.Execute query.
		
		int count = ps.executeUpdate();
		
		if(count>0){
			System.out.println("Record is Updated.");
		}
		else{
			System.out.println("Record is not Updated.");
		}
		
//		System.out.println(count);
		
		//5.Close Connection.
		
		con.close();
		System.out.println("Connection Closed.");
		
	}

}
