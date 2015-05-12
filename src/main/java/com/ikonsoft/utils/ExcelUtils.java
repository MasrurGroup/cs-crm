package com.ikonsoft.utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ikonsoft.model.User;
import com.ikonsoft.services.UserService;



public class ExcelUtils {
	static UserService userService = new UserService();
	  public static List<User> readExcelCustomerData(String fileName, int partnerId) {
	        List<User> customersList = new ArrayList<User>();
	        User customer = new User();
	        try {
	            //Create the input stream from the xlsx/xls file
	            FileInputStream fis = new FileInputStream(fileName);
	             
	            //Create Workbook instance for xlsx/xls file input stream
	            Workbook workbook = null;
	            if(fileName.toLowerCase().endsWith("xlsx")){
	                workbook = new XSSFWorkbook(fis);
	            }else if(fileName.toLowerCase().endsWith("xls")){
	                workbook = new HSSFWorkbook(fis);
	            }
	             
	            //Get the number of sheets in the xlsx file
	            int numberOfSheets = workbook.getNumberOfSheets();
	             
	            //loop through each of the sheets
	            for(int i=0; i < numberOfSheets; i++){
	                 
	                //Get the nth sheet from the workbook
	                Sheet sheet = workbook.getSheetAt(i);
	                 
	                //every sheet has rows, iterate over them
	                Iterator<Row> rowIterator = sheet.iterator();
	                while (rowIterator.hasNext()) 
	                {
	                    //Get the row object
	                    Row row = rowIterator.next();
	                    
	                    //Every row has columns, get the column iterator and iterate over them
	                    Iterator<Cell> cellIterator = row.cellIterator();
	                      
	                    while (cellIterator.hasNext()) 
	                    {
	                        //Get the Cell object
	                     Cell cell = cellIterator.next();
	                     System.out.println(cell.toString());
	                     
	                   //  if (StringUtil.hasValue(cell.toString()))      
	                     if (cell.toString().equalsIgnoreCase("emailId"))  break;
	                    if ( cell.toString().equalsIgnoreCase("End")) 
	                    	return customersList;
	                    while (!cell.toString().equalsIgnoreCase("End")) {
	                    	
	             System.out.println("cell :"+cell.toString());
	                   if (StringUtil.hasValue(cell.toString())) 
	                	   customer.setEmailId( cell.toString());
	                   		cell = cellIterator.next();
	                   if (StringUtil.hasValue(cell.toString()))    
	                	   customer.setFacebook(cell.toString());
	                   		cell = cellIterator.next();
	                   
	                   if (StringUtil.hasValue(cell.toString())) 
	                	   	customer.setBirthdate(IkonDateUtils.getDate(cell.toString()));
	                   		cell = cellIterator.next();
	                   		
	                   if (StringUtil.hasValue(cell.toString()))
	                	   	customer.setNationalId(cell.toString());
	                   		cell = cellIterator.next();
	                   		
	                   if (StringUtil.hasValue(cell.toString()))
	                	   	customer.setFirstName(cell.toString());
	                   		cell = cellIterator.next();
	                   		
	                   if (StringUtil.hasValue(cell.toString()))
	                	   	customer.setLastName(cell.toString());
	                   		cell = cellIterator.next();
	                   		
	                   if (StringUtil.hasValue(cell.toString()))
	                	   	customer.setStreet(cell.toString());
	                   		cell = cellIterator.next();
	                   		
	                   if (StringUtil.hasValue(cell.toString())) 
	                	   	customer.setProfession(cell.toString());
	                   		cell = cellIterator.next();
	                   		
	                   if (StringUtil.hasValue(cell.toString()))
	                	   	customer.setMartialStatus(cell.toString());
	                   		cell = cellIterator.next();
	                   		
	                   if (StringUtil.hasValue(cell.toString()))
	                	   	customer.setGender(cell.toString());
	                   		cell = cellIterator.next();
	                 
	                   if (StringUtil.hasValue(cell.toString()))
	                	   	customer.setNumberOfChildren(Short.parseShort(cell.toString()));
	                   		cell = cellIterator.next();
	                   		
	                   if (StringUtil.hasValue(cell.toString()))
	                	   	customer.setPhone(cell.toString());
	                   customer.setAuthority(Groups.CUSTOMER);    
	                   		customersList.add(customer);
	                   	//complete required fields
	                   		customer.setPassword("123");		
	                   		customer.setAuthority(Groups.CUSTOMER);
	                   		customer.setPartnerId(partnerId);
	                		int userId = userService.createUser(customer);
	                		System.out.println("User added with ID: "+userId );
	                   		break;
	                    }// end of while
	               
	                    } //end of cell iterator
	               
	                   
	                
	                }  //end of rows iterator
	                 
	                 
	            } //end of sheets for loop
	             
	            //close file input stream
	            fis.close();
	             
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	         
	        return customersList;
	    }
	 
	    public static void main(String args[]){
	        List<User> list = readExcelCustomerData("D:/Sample.xlsx",5);
	        System.out.println("User List\n"+list.toString()+ "\n");
	    }
	 
	}