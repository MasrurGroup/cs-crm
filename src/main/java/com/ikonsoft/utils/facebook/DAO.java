package com.ikonsoft.utils.facebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

	//-------------------------- Validate Admin Login-------------------------
	public static boolean validateAdmin(String user_name, String pass_word) {
		boolean status = false;
		Connection connection = null; 
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String url = "jdbc:mysql://localhost:3306/"; 
		String databaseName = "ikonsoftdb";
	    String driver = "com.mysql.jdbc.Driver"; 
	    String username = "root";
	    String password = "root"; 
	    
	    try { 
	    	 Class.forName(driver).newInstance(); 
	    	 connection = DriverManager.getConnection(url + databaseName, username, password);
	    	 preparedStatement=connection.prepareStatement("select * from admin where adminUsername=? and adminPassword=?");
	    	 
	    	 preparedStatement.setString(1, user_name);
	    	 preparedStatement.setString(2, pass_word);
	    	 
	    	 resultSet=preparedStatement.executeQuery();
	    	 status=resultSet.next();
	    	 
	    } catch (Exception e) {  
	    	System.out.println(e);
	    } finally {
	    	if (connection != null) {
	    		try { 
	    		connection.close();
	    		} catch (SQLException e) {
	    			e.printStackTrace();
	    		}
	    	}
	    	 if (preparedStatement != null) {
	    		 try { 
	    	 preparedStatement.close();
	    		 } catch (SQLException e) { 
	    			 e.printStackTrace(); 
	    		 }
	    	 }
	    	 if (resultSet != null) {
	    		 try{
	    	 resultSet.close();
	    		 } catch (SQLException e) { 
	    			 e.printStackTrace();
	    		 }
	    	 }
	    }
	    	
		return status;
	}
	
	
	//-------------------------- Register new user---------------------------------------
	
	public static boolean RegisterNewUser(String first_name,String last_name,String phone_number, String access_token) {
		boolean status = false;
		Connection connection = null; 
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String url = "jdbc:mysql://localhost:3306/"; 
		String databaseName = "citystars";
	    String driver = "com.mysql.jdbc.Driver"; 
	    String username = "root";
	    String password = "root";
	    
	    try { 
	    	 Class.forName(driver).newInstance(); 
	    	 connection = DriverManager.getConnection(url + databaseName, username, password);
	    	 preparedStatement=connection.prepareStatement("insert into users(userFirstName,userLastName,userPhone,userToken)values(?,?,?,?)");
	    	 
	    	 preparedStatement.setString(1, first_name);
	    	 preparedStatement.setString(2, last_name);
	    	 preparedStatement.setString(3, phone_number);
	    	 preparedStatement.setString(4, access_token);
	    	 
	    	 
	    	
	    	 int i=preparedStatement.executeUpdate();
	    	 
	    	 if(i != 0)
	    	 {
	    		 status=true;
	    	 }
	    	 
	    	 
	    } catch (Exception e) {  
	    	System.out.println(e);
	    } finally {
	    	if (connection != null) {
	    		try { 
	    		connection.close();
	    		} catch (SQLException e) {
	    			e.printStackTrace();
	    		}
	    	}
	    	 if (preparedStatement != null) {
	    		 try { 
	    	 preparedStatement.close();
	    		 } catch (SQLException e) { 
	    			 e.printStackTrace(); 
	    		 }
	    	 }
	    	 if (resultSet != null) {
	    		 try{
	    	 resultSet.close();
	    		 } catch (SQLException e) { 
	    			 e.printStackTrace();
	    		 }
	    	 }
	    }
	  
		return status;
	}
	
	
	
}
