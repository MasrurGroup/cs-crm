package com.ikonsoft.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

@ManagedBean
@SessionScoped
public class MultiSelectView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4626235484729037096L;
	private List<SelectItem> location;
	private List<SelectItem> profession;
	private String selectedLocation;
	private String selectedProfession;

	@PostConstruct
	public void init() {
		 initLocation();
		 initProfession();
	}
	
	private void initProfession() {
		profession = new ArrayList<SelectItem>();
		SelectItemGroup group1 = new SelectItemGroup("Self-Employed");
		SelectItemGroup group2 = new SelectItemGroup("Employed");
		SelectItemGroup group3 = new SelectItemGroup("Student");
		SelectItemGroup group4 = new SelectItemGroup("Unemployed");
	 
		SelectItem option11 = new SelectItem("Trader");
		SelectItem option12 = new SelectItem("Company");
		SelectItem option13 = new SelectItem("Freelancer");
		SelectItem option14 = new SelectItem("Consultancy");
		SelectItem option15 = new SelectItem("Social Enterprise");
		SelectItem option16 = new SelectItem("NGO");
		group1.setSelectItems(new SelectItem[] { option11, option12, option13,option14, option15, option16 });
		SelectItemGroup group21 = new SelectItemGroup("Academic");
		SelectItemGroup group22 = new SelectItemGroup("Cultural");
		SelectItemGroup group28 = new SelectItemGroup("Medical");
		SelectItemGroup group23 = new SelectItemGroup("Industry");
		SelectItemGroup group24 = new SelectItemGroup("Transport");
		SelectItemGroup group25 = new SelectItemGroup("Technology");
		SelectItemGroup group26 = new SelectItemGroup("Public services");
		SelectItemGroup group27 = new SelectItemGroup("Science");
	 
 
		group2.setSelectItems(new SelectItem[] { new SelectItem("Heliopolis"),
				new SelectItem("Ain Shams"), new SelectItem("El-Zaitoon") });

		group2.setSelectItems(new SelectItem[] {group21, group22, group23, group24,group25, group26,group28, group27 });

		group21.setSelectItems(new SelectItem[] {// academic
				new SelectItem("Trainer"), new SelectItem("Professors"),new SelectItem("Teachers")
				});
        //Cultural
		group22.setSelectItems(new SelectItem[] { new SelectItem("Imam"),new SelectItem("Clergy"),
				new SelectItem("Philosophers") });
//Medical
		group4.setSelectItems(new SelectItem[] { new SelectItem("Children"),
				new SelectItem("Housewife"), new SelectItem("Retired")  });
	  // industry
		group23.setSelectItems(new SelectItem[] { new SelectItem("Accountants"),
		new SelectItem("Actuaries"), new SelectItem("Train Operator"), 
		new SelectItem("Air Hostess"), new SelectItem("Air Traffic Controllers")
		,new SelectItem("Aircraft pilots"),new SelectItem("Sea Captains") });
		//Transport
		group24.setSelectItems(new SelectItem[] { new SelectItem("Taxi Driver"),
				new SelectItem("Bus Driver"), new SelectItem("Agriculturists"), 
				new SelectItem("Architects"), new SelectItem("Economists"),new SelectItem("Engineers"),
				new SelectItem("Interpreters"), new SelectItem("Lawyers, Advocates"),new SelectItem("Judge"),
				new SelectItem("Journalist"), new SelectItem("Librarians"),new SelectItem("Statisticians"),
				new SelectItem("Surveyors"), new SelectItem("Urban Planners"),
				});
		// Technology
		group25.setSelectItems(new SelectItem[] { new SelectItem("Programmers"),new SelectItem("Network Admin"),
				new SelectItem("Web developers"), new SelectItem("Designers"),new SelectItem("Software Project Manager"), 
				new SelectItem("Graphic designers"), new SelectItem("Web designers") ,
				});
		// Medical 
		group28.setSelectItems(new SelectItem[] { 
				new SelectItem("Chiropractors"),new SelectItem("Dentists"), new SelectItem("Midwives"),
				new SelectItem("Nurses"), new SelectItem("Occupational therapists"),  new SelectItem("Veterinarians"),
				new SelectItem("Optometrists"),new SelectItem("Pathologists"), new SelectItem("Pharmacists"),
				new SelectItem("Physical therapists"),new SelectItem("Physicians"), new SelectItem("Psychologists"),
				new SelectItem("Speech-language"),new SelectItem("Audiologists"), new SelectItem("Surgeons"),
		});
	  
		SelectItemGroup group31 = new SelectItemGroup ("School");
		group31.setSelectItems(new SelectItem[] { new SelectItem("ICGSE"),new SelectItem("Secondary School") });
		 

		SelectItemGroup group32 = new SelectItemGroup ("College");
		group32.setSelectItems(new SelectItem[]{new SelectItem("Under Graduate Diploma"),
						 new SelectItem("Specialist Course"),new SelectItem("Post Graduate Diploma")} );
		SelectItemGroup group33 = new SelectItemGroup("State University");
		
		group33.setSelectItems(new SelectItem[] {
				new SelectItem("Cairo University"),
				new SelectItem("Ain Shams University"),
				new SelectItem("Alexanderia University"),
				new SelectItem("Al-Azhar University"),
				new SelectItem("Helwan University"),
				new SelectItem("Fayoum University"),
				new SelectItem("Kafrelsheikh University"),
				new SelectItem("Mansoura University"),
				new SelectItem("Military Technical College"),
				new SelectItem("Minufiya University"),

				new SelectItem("Sadat Academy for Management Sciences"),
				new SelectItem("Sohag University"),
				new SelectItem("Banha University"),
				new SelectItem("Al-Azhar University"),
				new SelectItem(
						"University of Science and Technology at Zewail City"),
				new SelectItem("Tanta University"), 
				new SelectItem("Port Said University"),
				new SelectItem("Tanta University"),
				new SelectItem("Aswan University"),

		});
		
		SelectItemGroup group34 = new SelectItemGroup("Private University");
		group34.setSelectItems(new SelectItem[] {
				new SelectItem("American University in Cairo"),
				new SelectItem("Arab Academy for Science and Technology and Maritime Transport"),
				new SelectItem("Arab Open University"),
				new SelectItem("Ahram Canadian University"),
				new SelectItem("MTI University"),
				new SelectItem("British University in Egypt"),
				new SelectItem("Canadian International College"),
				new SelectItem("Delta University for Science and Technology"),
				new SelectItem("Egyptian e-Learning University"),
				new SelectItem("Egyptian Russian University"),

				new SelectItem("Cairo Private Technology Institute"),
				new SelectItem("El Asher University"),
				new SelectItem("6th of October University"),
				new SelectItem("El Shorouk Academy"),
				new SelectItem("Future Academy"),
				new SelectItem("Misr International University"),
				new SelectItem("Sadat Academy for Management Sciences"),
					});
		group3.setSelectItems(new SelectItem[] {group31,group32,group33 ,group34 });
 

		profession.add(group1);
		profession.add(group2);
		profession.add(group3);
		profession.add(group4);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	private void initLocation() {
		location = new ArrayList<SelectItem>();
		SelectItemGroup group1 = new SelectItemGroup("Outside Egypt");
		SelectItemGroup group2 = new SelectItemGroup("Cairo");
		SelectItemGroup group3 = new SelectItemGroup("Giza");
		SelectItemGroup group4 = new SelectItemGroup("Qaliobia");
		SelectItemGroup group5 = new SelectItemGroup("Alexanderia");
		SelectItemGroup group6 = new SelectItemGroup("Gharbia");
		SelectItemGroup group7 = new SelectItemGroup("Beni Suef");
		SelectItemGroup group8 = new SelectItemGroup("Monufia");

		SelectItem option11 = new SelectItem("USA");
		SelectItem option12 = new SelectItem("UK");
		SelectItem option13 = new SelectItem("KSA");
		SelectItem option14 = new SelectItem("Kuwait");
		SelectItem option15 = new SelectItem("Qatar");
		SelectItem option16 = new SelectItem("Turkey");
		group1.setSelectItems(new SelectItem[] { option11, option12, option13,
				option14, option15, option16 });
		SelectItemGroup group21 = new SelectItemGroup("New Cairo");
		SelectItemGroup group22 = new SelectItemGroup("Cairo");

		group2.setSelectItems(new SelectItem[] { new SelectItem("Heliopolis"),
				new SelectItem("Ain Shams"), new SelectItem("El-Zaitoon") });

		group2.setSelectItems(new SelectItem[] { group22, group21 });

		group21.setSelectItems(new SelectItem[] {
				new SelectItem("5th District"), new SelectItem("Area 2"),
				new SelectItem("Area 3"), new SelectItem("Area4"),
				new SelectItem("Area 5"), new SelectItem("Area6") });

		group22.setSelectItems(new SelectItem[] { new SelectItem("Heliopolis"),
				new SelectItem("Ain Shams"), new SelectItem("Maadi"),
				new SelectItem("El-Zaitoon"), new SelectItem("Abbasia"),
				new SelectItem("Al-Marg"), new SelectItem("Zamalek"),
				new SelectItem("Naser City"), new SelectItem("Misr Al Qadima"),
				new SelectItem("Boulaq"), new SelectItem("Bab-Al-Louq") });

		group4.setSelectItems(new SelectItem[] { new SelectItem("Q41"),
				new SelectItem("Q42"), new SelectItem("Q43"),
				new SelectItem("Q44"), new SelectItem("Q45"),
				new SelectItem("q46") });

		group5.setSelectItems(new SelectItem[] { new SelectItem("Alex1"),
				new SelectItem("Alex2"), new SelectItem("Alex3"),
				new SelectItem("Alex4"), new SelectItem("Alex5"),
				new SelectItem("Alex6") });

		group6.setSelectItems(new SelectItem[] { new SelectItem("Gharbia1"),
				new SelectItem("Gharbia2"), new SelectItem("Gharbia3"),
				new SelectItem("Gharbia4"), new SelectItem("Gharbia5"),
				new SelectItem("Gharbia6") });

		group7.setSelectItems(new SelectItem[] { new SelectItem("Beni Suef1"),
				new SelectItem("Beni Suef2"), new SelectItem("Beni Suef3"),
				new SelectItem("Beni Suef4"), new SelectItem("Beni Suef5"),
				new SelectItem("Beni Suef6") });

		group8.setSelectItems(new SelectItem[] { new SelectItem("Monufia1"),
				new SelectItem("Monufia2"), new SelectItem("Monufia3"),
				new SelectItem("Monufia4"), new SelectItem("Monufia5"),
				new SelectItem("Monufia6") });

		SelectItem option31 = new SelectItem("Dokki");
		SelectItem option32 = new SelectItem("Mohandeseen");
		SelectItem option33 = new SelectItem("Giza");
		SelectItem option34 = new SelectItem("Faysal");
		SelectItem option35 = new SelectItem("Haram");
		SelectItem option36 = new SelectItem("Imbaba");
		SelectItem option37 = new SelectItem("Agouza");
		SelectItem option38 = new SelectItem("El Warraq");

		group3.setSelectItems(new SelectItem[] { new SelectItem("New Giza"),
				new SelectItem("Palm Hills"), new SelectItem("Dream Land"),
				new SelectItem("Shaikh Zayed"), new SelectItem("Palm Hills"),
				new SelectItem("Dream Land"), option31, option32, option33,
				option34, option35, option36, option37, option38,
				new SelectItem("6th October") });

	 

		location.add(group1);
		location.add(group2);
		location.add(group3);
		location.add(group4);
		location.add(group5);
		location.add(group6);
		location.add(group7);
		location.add(group8);
	}

	
	public List<SelectItem> getLocation() {
		
		return location;
		
	}
 
	public void setLocation(List<SelectItem> location) {
		this.location = location;
	}
 
	public List<SelectItem> getProfession() {
		return profession;
	}

 	public void setProfession(List<SelectItem> profession) {
		this.profession = profession;
	}
 
	public String getSelectedLocation() {
		return selectedLocation;
	}
 
	public void setSelectedLocation(String selectedLocation) {
		this.selectedLocation = selectedLocation;
	}

	 
	public String getSelectedProfession() {
		return selectedProfession;
	}

 
	public void setSelectedProfession(String selectedProfession) {
		this.selectedProfession = selectedProfession;
	}
 
}
