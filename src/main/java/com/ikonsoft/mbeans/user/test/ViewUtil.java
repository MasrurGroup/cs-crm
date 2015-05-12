package com.ikonsoft.mbeans.user.test;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.ikonsoft.model.Campaign;
import com.ikonsoft.model.City;
import com.ikonsoft.model.Country;
import com.ikonsoft.model.Offer;
import com.ikonsoft.model.Partner;
import com.ikonsoft.model.Profession;
import com.ikonsoft.model.Region;
import com.ikonsoft.model.SubProfession;
import com.ikonsoft.services.CityService;
import com.ikonsoft.services.CountryService;
import com.ikonsoft.services.PartnerService;
import com.ikonsoft.services.ProfessionService;
import com.ikonsoft.services.RegionService;
import com.ikonsoft.services.SubProfessionService;

public class ViewUtil {

	public static Map<String, Integer> getPartnersMap() {
		Map<String, Integer> partnersMap = new TreeMap<String, Integer>();
		partnersMap.put("All", -1);
		PartnerService partnerService = new PartnerService();
		List<Partner> partnersList = partnerService.getAllPartners();
		for (Partner partner : partnersList) {
			partnersMap.put(partner.getBusinesstype(), partner.getId());
		}
		return partnersMap;

	}

	public static Map<String, Integer> getCountriesMap() {
		System.out.println("getCountriesMap method begins");
		Map<String, Integer> countriessMap = new TreeMap<String, Integer>();
		countriessMap.put("-", -1);
		CountryService countryService = new CountryService();
		List<Country> countriessList = countryService.getAllCountries();
		System.out.println("List: " + countriessList);
		for (Country Country : countriessList) {
			countriessMap.put(Country.getName(), Country.getId());
			System.out.println(Country);
		}
		return countriessMap;
	}

	public static Map<String, Integer> getCitiesMap(int countryId) {
		Map<String, Integer> citiesMap = new TreeMap<String, Integer>();
		citiesMap.put("-", -1);
		CityService cityService = new CityService();
		List<City> citiesList = cityService.getAllCities(countryId);
		for (City city : citiesList) {
			citiesMap.put(city.getName(), city.getId());
		}
		return citiesMap;
	}

	public static Map<String, Integer> getCitiesWithNullMap(int countryId) {
		Map<String, Integer> citiesMap = new TreeMap<String, Integer>();
		citiesMap.put("-", -1);
		CityService cityService = new CityService();
		List<City> citiesList = cityService.getAllCities(countryId);
		for (City city : citiesList) {
			citiesMap.put(city.getName(), city.getId());
		}
		return citiesMap;
	}

	public static Map<String, Integer> getRegionsMap(int cityId) {
		Map<String, Integer> regionsMap = new TreeMap<String, Integer>();
		RegionService regionService = new RegionService();
		regionsMap.put("-", -1);
		List<Region> regionsList = regionService.getAllRegions(cityId);
		for (Region region : regionsList) {
			regionsMap.put(region.getName(), region.getId());
		}
		return regionsMap;
	}

	public static Map<String, Integer> getRegionsWithNullMap(int cityId) {
		Map<String, Integer> regionsMap = new TreeMap<String, Integer>();
		regionsMap.put("All", -1);
		RegionService regionService = new RegionService();
		List<Region> regionsList = regionService.getAllRegions(cityId);
		for (Region region : regionsList) {
			regionsMap.put(region.getName(), region.getId());
		}
		return regionsMap;
	}
	
	public static Map<String, Integer>getProfessionsMap(){
		Map<String, Integer>professionsMap = new TreeMap<String, Integer>();
		professionsMap.put("-", -1);
		ProfessionService professionService = new ProfessionService();
		List<Profession>professionsList = professionService.getAllProfessions();
		for (Profession profession : professionsList) {
			professionsMap.put(profession.getName(), profession.getId());
		}
		return professionsMap;
	}
	public static Map<String, Integer>getSubProfessionMap(int professionId){
		Map<String, Integer>subProfessionsMap = new TreeMap<String, Integer>();
		subProfessionsMap.put("-", -1);
		SubProfessionService subProfessionService = new SubProfessionService();
		List<SubProfession>subProfessionsList = subProfessionService.getAllSubProfessions(professionId);
		for (SubProfession subProfession : subProfessionsList) {
			subProfessionsMap.put(subProfession.getName(), subProfession.getId());
		}
		return subProfessionsMap;
	}
	public static Map<String, Integer>getSubProfessionMapWithNull(int professionId){
		Map<String, Integer>subProfessionsMap = new TreeMap<String, Integer>();
		subProfessionsMap.put("All", -1);
		SubProfessionService subProfessionService = new SubProfessionService();
		List<SubProfession>subProfessionsList = subProfessionService.getAllSubProfessions(professionId);
		for (SubProfession subProfession : subProfessionsList) {
			subProfessionsMap.put(subProfession.getName(), subProfession.getId());
		}
		return subProfessionsMap;
	}
	
	public static String generateFacebookMsg(Offer offer) {
		  String msg = "";
		  if (offer != null) {
		   msg = "<br>" + offer.getDescription() + "</br>" + "<br>"
		     + offer.getObjective()+ "</br>";
		  }
		  return msg;
		 }

		 public static String generateEmailMsg(Offer offer) {
		  String msg = "";
		  if (offer != null) {
		   msg = "<br>" + offer.getDescription() + "</br>" + "<br>"
		     + offer.getObjective()+ "</br>";
		  }
		  return msg;
		 }

		 public static String generateWhatsAppMsg(Offer offer) {
		  String msg = "";
		  if (offer != null) {
		   msg = "<br>" + offer.getDescription() + "</br>" + "<br>"
		     + offer.getObjective()+ "</br>";
		  }
		  return msg;
		 }

		 public static String generateEMagazinMsg(Offer offer) {
		  String msg = "";
		  if (offer != null) {
		   msg = "<br>" + offer.getDescription() + "</br>" + "<br>"
		     + offer.getObjective()+ "</br>";
		  }
		  return msg;
		 }

		 public static String generateSMSMsg(Offer offer) {
		  String msg = "";
		  if (offer != null) {
		   msg = "<br>" + offer.getDescription() + "</br>" + "<br>"
		     + offer.getObjective()+ "</br>";
		  }
		  return msg;
		 }
		 public static String generateFacebookMsg(Campaign campaign) {
		  String msg = "";
		  if (campaign != null) {
		   msg = "<br>" + campaign.getCampaignDescription() + "</br>" + "<br>"
		     + campaign.getCampaignObjectives() + "</br>";
		  }
		  return msg;
		 }
		 
		 public static String generateEmailMsg(Campaign campaign) {
			  String msg = "";
			  if (campaign != null) {
			   msg = "<br>" + campaign.getCampaignDescription() + "</br>" + "<br>"
			     + campaign.getCampaignObjectives() + "</br>";
			  }
			  return msg;
			 }
		 public static String generateWhatsAppMsg(Campaign campaign) {
			  String msg = "";
			  if (campaign != null) {
			   msg = "<br>" + campaign.getCampaignDescription() + "</br>" + "<br>"
			     + campaign.getCampaignObjectives() + "</br>";
			  }
			  return msg;
			 }
		 
		 public static String generateEMagazinMsg(Campaign campaign) {
			  String msg = "";
			  if (campaign != null) {
			   msg = "<br>" + campaign.getCampaignDescription() + "</br>" + "<br>"
			     + campaign.getCampaignObjectives() + "</br>";
			  }
			  return msg;
			 }
		 
		 public static String generateSMSMsg(Campaign campaign) {
			  String msg = "";
			  if (campaign != null) {
			   msg = "<br>" + campaign.getCampaignDescription() + "</br>" + "<br>"
			     + campaign.getCampaignObjectives() + "</br>";
			  }
			  return msg;
			 }
		
}
