/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ikonsoft.utils;

import java.util.ArrayList;
import java.util.List;

  
  
public class StringUtil {
    public static boolean isNull (String input)
    {
        return input.equals("") |input==null ;
        
    }
     public static boolean hasValue (String input)
    {
      return !(input.equals("") |input==null);
        
    }
     
     public static String ListToString (List<String> inputList){
    	 if (inputList== null ) return "";
    	 String data="" ;
    	 for (String s : inputList)
    	 {
    		 
    	     data += s  + ";";
    	 }

    	
    	 return data;
     }
     
     public static List<String> StringToList(String inputString){
         List<String>strings = new ArrayList<String>();
         if(inputString!=null&&!inputString.trim().isEmpty()){
          String[]stringArray = inputString.split(";");
          for (int i = 0; i < stringArray.length; i++) {
       strings.add(stringArray[i]);
      }
         }
         return strings;
        }
   
     
}
