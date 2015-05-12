package com.ikonsoft.utils;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

public class SegmentsData {
	
	
	 private List<SelectItem> ageCategories;
	 private List<SelectItem> locationCategories;    
	 private List<SelectItem> professionCategories;    
 

	 private SegmentsData(){
		// ageCategories = new ArrayList<SelectItem>();
	        SelectItemGroup age = new SelectItemGroup("Age");
	        SelectItemGroup location = new SelectItemGroup("Location");
	        SelectItemGroup profession = new SelectItemGroup("Proffesion");
	        
	        SelectItemGroup all = new SelectItemGroup("ALL");
	        SelectItemGroup children = new SelectItemGroup("Children , 0-16");
	        SelectItemGroup teenagers = new SelectItemGroup("Teenagers, 16-18");
	        SelectItemGroup students = new SelectItemGroup("Students , 18-28");
	        SelectItemGroup youngAdults = new SelectItemGroup("Young Adults , 28 - 40");
	        SelectItemGroup matureAdults = new SelectItemGroup("Mature Adults , 40 - 60");
	        SelectItemGroup retired = new SelectItemGroup("Retired , 60 - 100");
	        
       
	        SelectItemGroup group21 = new SelectItemGroup("Group 2.1");
	         
	       
	        
	        age.setSelectItems(new SelectItem[]{all, children,teenagers,students,youngAdults,matureAdults,retired});
	         
	        SelectItem option121 = new SelectItem("Option 1.2.1", "Option 1.2.1");
	        SelectItem option122 = new SelectItem("Option 1.2.2", "Option 1.2.2");
	        SelectItem option123 = new SelectItem("Option 1.2.3", "Option 1.2.3");
	      //  group12.setSelectItems(new SelectItem[]{option121, option122, option123});
			System.out.println(age.toString());
	         
	   /*     SelectItem option211 = new SelectItem("Option 2.1.1", "Option 2.1.1");
	        group21.setSelectItems(new SelectItem[]{option211});
	         
	        group1.setSelectItems(new SelectItem[]{group11, group12});
	        group2.setSelectItems(new SelectItem[]{group21});
	        group3.setSelectItems(new SelectItem[]{option31, option32, option33, option34});
	        group4.setSelectItems(new SelectItem[]{option41});
	         
	        categories.add(group1);
	        categories.add(group2);
	        categories.add(group3);
	        categories.add(group4);
	        */
	    }
	         

		public static void main(String[] args) {
			 
			SegmentsData sd = new SegmentsData();
			//System.out.println(sd.ageCategories.toString());
		}
 
	 
	 
	 public List<SelectItem> getLocationCategories() {
		return locationCategories;
	}


	public void setLocationCategories(List<SelectItem> locationCategories) {
		this.locationCategories = locationCategories;
	}


	public List<SelectItem> getProfessionCategories() {
		return professionCategories;
	}


	public void setProfessionCategories(List<SelectItem> professionCategories) {
		this.professionCategories = professionCategories;
	}



	public List<SelectItem> getAgeCategories() {
		return ageCategories;
	}


	public void setAgeCategories(List<SelectItem> ageCategories) {
		this.ageCategories = ageCategories;
	}

}
