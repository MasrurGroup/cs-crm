package com.ikonsoft.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
 
public class PropertiesCache {

	private final Properties configProp = new Properties();
    
	   private PropertiesCache()
	   {
	      //Private constructor to restrict new instances
		   try {
	      InputStream in = this.getClass().getClassLoader().getResourceAsStream("config.properties");
	      System.out.println("Read all properties from file");
	          configProp.load(in);
	          
	      } catch (IOException e) {
	          e.printStackTrace();
	      }
	   }
	 
	   public static void main (String args[]){
		   String key="adminEmail";
		   System.out.println(PropertiesCache.getInstance().getProperty(key));
		   
	   }
	   
	   public static String getValue(String key)
	   {
	     //Get individual properties
	     System.out.println(PropertiesCache.getInstance().getProperty(key));
	     return PropertiesCache.getInstance().getProperty(key);
	    
	   }
	    
	   
	   //Bill Pugh Solution for singleton pattern
	   private static class LazyHolder
	   {
	      private static final PropertiesCache INSTANCE = new PropertiesCache();
	   }
	 
	   public static PropertiesCache getInstance()
	   {
	      return LazyHolder.INSTANCE;
	   }
	    
	   public String getProperty(String key){
	      return configProp.getProperty(key);
	   }
	    
	   public Set<String> getAllPropertyNames(){
	      return configProp.stringPropertyNames();
	   }
	    
	   public boolean containsKey(String key){
	      return configProp.containsKey(key);
	   }
	}