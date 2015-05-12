package com.ikonsoft.mbeans.user.test;

import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.http.HttpSession;

import com.ikonsoft.mbeans.CampaignView;
import com.ikonsoft.mbeans.user.partner.CampaignBean;
import com.ikonsoft.model.User;
import com.ikonsoft.services.UserService;
import com.ikonsoft.utils.EncodeList;
import com.ikonsoft.utils.org.alternadev.whatsup.ProtocolNode;
import com.ikonsoft.utils.org.alternadev.whatsup.WhatsAPI;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.FacebookType;

@ManagedBean(name = "userBeanTest")
@ViewScoped
public class UserBeanTest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	private UserSearch userSearch = new UserSearch();
	private List<User> usersList = new ArrayList<User>();
	private Map<String, Integer> partnersMap = ViewUtil.getPartnersMap();
	private Map<String, Integer> countriesMap = ViewUtil.getCountriesMap();
	private Map<String, Integer> citiesMap = new TreeMap<String, Integer>();
	private Map<String, Integer> regionsMap = new TreeMap<String, Integer>();
	private Map<String, Integer>professionsMap = ViewUtil.getProfessionsMap();
	private Map<String, Integer>subProfessionsMap = new TreeMap<String, Integer>();
	private String age;
	@Inject
	private CampaignBean campbean = new CampaignBean();

	public UserSearch getUserSearch() {
		return userSearch;
	}

	public void setUserSearch(UserSearch userSearch) {
		this.userSearch = userSearch;
	}

	public List<User> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}

	public Map<String, Integer> getPartnersMap() {
		return partnersMap;
	}

	public void setPartnersMap(Map<String, Integer> partnersMap) {
		this.partnersMap = partnersMap;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Map<String, Integer> getCountriesMap() {
		return countriesMap;
	}

	public void setCountriesMap(Map<String, Integer> countriesMap) {
		this.countriesMap = countriesMap;
	}

	public Map<String, Integer> getCitiesMap() {
		return citiesMap;
	}

	public void setCitiesMap(Map<String, Integer> citiesMap) {
		this.citiesMap = citiesMap;
	}

	public Map<String, Integer> getRegionsMap() {
		return regionsMap;
	}

	public void setRegionsMap(Map<String, Integer> regionsMap) {
		this.regionsMap = regionsMap;
	}

	public void fillCitiesMap() {
		citiesMap = ViewUtil.getCitiesWithNullMap(userSearch.getCountryId());
	}

	public void fillRegionsMap() {
		regionsMap = ViewUtil.getRegionsWithNullMap(userSearch.getCityId());
	}
	
	public void fillSubProfessionsMap() {
		subProfessionsMap = ViewUtil.getSubProfessionMapWithNull(userSearch.getProfessionId());
	}

	public Map<String, Integer> getProfessionsMap() {
		return professionsMap;
	}

	public void setProfessionsMap(Map<String, Integer> professionsMap) {
		this.professionsMap = professionsMap;
	}

	public Map<String, Integer> getSubProfessionsMap() {
		return subProfessionsMap;
	}

	public void setSubProfessionsMap(Map<String, Integer> subProfessionsMap) {
		this.subProfessionsMap = subProfessionsMap;
	}

	public void encodeList(List<User> list)

	{
		campbean.setJesonList(EncodeList.convertToJson(list));

	}

	 public String createListBtnAction() {
		  getAgeRange();
		  usersList = userService.getUsersList(userSearch);
		  userSearch = new UserSearch();

		  System.out.println(usersList);
		  encodeList(usersList);
		  System.out.println("Jeson List Before Sent: "
		    + EncodeList.convertToJson(usersList));
		  try {
		   //sendFaceBook(usersList, "Hello From Bean");
		   // sendWhatsapp(usersList, "Hello From Bean");

		  } catch (Exception c) {
		   c.printStackTrace();
		  }
		  return "PartnerHome";
		 }
	 
	 public String createListBtnAction2() {
		  getAgeRange();
		  String query = userService.getUsersQueryStatement(userSearch);
		  System.out.println("Query: "+query);
		  userSearch = new UserSearch();
		  /*usersList = userService.getUsersBySQLquery(query);
		  System.out.println("List: "+usersList);*/
		  HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		  httpSession.setAttribute("queryStatement", query);
		  return "PartnerHome";
		 }
	public void sendWhatsapp(List<User> list, String msg) throws IOException {
		String PHONE_NUMBER = "";

		String IMEI = "";
		String USERNAME = "";
		for (int i = 0; i < list.size(); i++) {

			/* 16:16 */WhatsAPI api = new WhatsAPI("", "", list.get(i)
					.getWhatsapp());
			/* 17:17 */api.connect();
			/* 18:18 */api.login();
			api.sendMessage(System.currentTimeMillis() + "-1", "",
					"Was geht los darein?!");
			for (;;) {
				api.pollMessages();
				List<ProtocolNode> liste = api.getMessages();
				for (ProtocolNode msg1 : liste) {
					System.out.println(msg1.nodeString());

				}
			}
		}

	}

	public void getAgeRange() {
		if (!age.equals("All")) {
			
			SimpleDateFormat formate = new SimpleDateFormat(
				    "yyyy-MM-dd hh:mm:ss");
			String[] ages = age.split("-");
			String from = ages[0];
			String to = ages[1];
			Calendar currentcld = Calendar.getInstance();
			currentcld.setTime(new Date());
			int currentDate = currentcld.get(Calendar.YEAR);
			int fromYear = currentDate - Integer.parseInt(from);
			int toYear = currentDate - Integer.parseInt(to);
			Calendar fromcld = Calendar.getInstance();
			Calendar tocld = Calendar.getInstance();
			fromcld.set(Calendar.YEAR, fromYear);
			fromcld.set(Calendar.MONTH, 12);
			fromcld.set(Calendar.DAY_OF_MONTH, 1);
			tocld.set(Calendar.YEAR, toYear);
			tocld.set(Calendar.MONTH, 12);
			tocld.set(Calendar.DAY_OF_MONTH, 1);
			String fromDate = formate.format(fromcld.getTime());
			String toDate = formate.format(tocld.getTime());
			try {
				userSearch.setFromDate(formate.parse(toDate));
				userSearch.setToDate(formate.parse(fromDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
	}

	public void sendFaceBook(List<User> list, String msg) {
		List<User> checkedUsers = list;

		if (checkedUsers != null) {

			if (!msg.equals("")) {
				for (int i = 0; i < checkedUsers.size(); i++) {
					if (!checkedUsers.get(i).getFacebook().equals(null)) {
						// FacebookClient facebookClient = new
						// DefaultFacebookClient(checkedUsers.get(i).getUserToken(),
						// "349b3c745cad6643c025cae1800be30f",Version.VERSION_2_2);
						// FacebookType publishMessageResponse
						// =facebookClient.publish("me/feed",
						// FacebookType.class,Parameter.with("message", msg));
						ScriptEngineManager manager = new ScriptEngineManager();
						ScriptEngine engine = manager
								.getEngineByName("JavaScript");
						System.out.print("I'm inside JS !");
						String script = " FB.login(function(response) {"
								+ " if (response.authResponse) {"
								+ " console.log('Welcome!  Fetching your information.... ');"
								+ " FB.api('/me', function(response) {"
								+ "   console.log('Good to see you, ' + response.name + '.');"
								+ " });;"
								+ "} else {"
								+ "console.log('User cancelled login or did not fully authorize.');"
								+ "}" + "});";
						// evaluate script
						try {
							engine.eval(script);
						} catch (ScriptException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						// javax.script.Invocable is an optional interface.
						// Check whether your script engine implements or not!
						// Note that the JavaScript engine implements Invocable
						// interface.
						Invocable inv = (Invocable) engine;

						// invoke the global function named "hello"
						try {
							inv.invokeFunction("hello", "Scripting!!");
						} catch (NoSuchMethodException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ScriptException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			} else {

				System.out.print("ERROR : There is no message to be posted !");

			}
		} else {

			System.out
					.print("<p style=\"color:red\">ERROR : No users selected !</p>");
		}
	}

	public CampaignBean getCampbean() {
		return campbean;
	}

	public void setCampbean(CampaignBean campbean) {
		this.campbean = campbean;
	}
}
