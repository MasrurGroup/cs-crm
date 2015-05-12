package com.ikonsoft.utils;

import java.io.FileReader;
import java.util.List;

import com.ikonsoft.model.User;
import com.ikonsoft.services.UserService;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
	 
	public class CSVMappedToBean
	{
		static UserService userService = new UserService();
			
	   @SuppressWarnings({"rawtypes", "unchecked"})
	   public static void uploadCSV(String csvFilename, int partnerId) throws Exception
	   {
	      CsvToBean csv = new CsvToBean();
	       
	     //  csvFilename = "D:/Sample.csv"; //TO DO  Remove fixed path
	      CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
	       
	      //Set column mapping strategy
	      List list = csv.parse(setColumMapping(), csvReader);
	       
	      for (Object object : list) {
	          User customer = (User) object;
	          customer.setAuthority(Groups.CUSTOMER);
	          customer.setPartnerId(partnerId); //TO DO 
	          customer.setPassword("123");
	        int userId = userService.createUser(customer);
      		System.out.println("User added with ID: "+userId );
	          System.out.println(customer);
	      } 
	   }
	    
	   public static void main(String args[]){
	       try {
			uploadCSV("D:/Sample.csv" ,8);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	    }   
	   
	   @SuppressWarnings({"rawtypes", "unchecked"})
	   private static ColumnPositionMappingStrategy setColumMapping()
	   {
	      ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
	      strategy.setType(User.class);
	      String[] columns = new String[] {"emailId", "firstName", "lastName", "address", "phone"};
	      strategy.setColumnMapping(columns);
	      return strategy;
	   }
	}
	