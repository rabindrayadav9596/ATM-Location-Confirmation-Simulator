package com.jon.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	
	public static Connection getDbCon(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				return DriverManager.getConnection("jdbc:mysql://localhost:3306/atmlocation","root","");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
