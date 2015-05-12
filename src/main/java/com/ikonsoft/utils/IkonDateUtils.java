package com.ikonsoft.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

public class IkonDateUtils {
	
public static final String pattern = " EEEE dd/M/yyyy";	
public static final SimpleDateFormat formatter = new SimpleDateFormat(pattern);
 
 
 
public static Date getDate(String dateInString) {
	Date date=null;
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
	try {
		 
		date = formatter.parse(dateInString);
		System.out.println(date);
		System.out.println(formatter.format(date));
 
	} catch (ParseException e) {
		e.printStackTrace();
	}
	return date;
}
	
	public static String getToday() {

Date today = new Date();
String s_date_now = formatter.format(today);

System.out.println(" \nToday  " + s_date_now);

	return s_date_now;
}
	

public static String getNextMonth() {
	 
	Date afterOneMonthDate = DateUtils.addMonths(new Date(), 1);
	String s_afterOneMonthDate = formatter.format(afterOneMonthDate);
	System.out.println("\t"+s_afterOneMonthDate );
	return s_afterOneMonthDate;
}

	public static void main(String[] args) {

		getToday();
		getNextMonth();

	}

}
