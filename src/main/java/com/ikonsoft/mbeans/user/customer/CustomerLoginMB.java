package com.ikonsoft.mbeans.user.customer;

import java.io.Serializable;

import com.ikonsoft.utils.Groups;
import com.ikonsoft.utils.JSFUtil;
import com.ikonsoft.model.Channel;
import com.ikonsoft.model.User;
import com.ikonsoft.services.UserService;
import com.ikonsoft.utils.StringUtil;

import javax.faces.bean.ManagedBean;
 
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@ManagedBean(name="customerLoginMB")
@SessionScoped
public class CustomerLoginMB implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	private String email="";
	private String password="";
	private User customer ;

	public String doLogin() {
		System.out.println(getEmail());
		System.out.println(getPassword());
		System.out.println("customerLoginMB.doLogin()");
		if (StringUtil.isNull(getEmail()) || StringUtil.isNull(getPassword())) {
			System.out.println("error");
			return "CustomerLogin";
		}
	customer =userService.getUserByEmailId(email);
		 
		if (customer ==null ){
			JSFUtil.addErrorMsg("Please Register Or Enter Registered Account  !");
			return "CustomerLogin";
		}
		else if (customer.getPassword().equals(password)&& customer.getAuthority().equals(Groups.CUSTOMER)) {
			return "CustomerProfile";
		} else {
			JSFUtil.addErrorMsg("Please Register Or Enter Registered Account  !");
		}
		return "CustomerLogin";

	}
	public String updateAddress(User user) {
		int res = userService.updateAddress(user);
		if (res > 0)
			return "CustomerProfile";
		else
			return "CustomerLogin";

	}
	
	public String updateFirstName(User user) {
		int res = userService.updateFirstName(user);
		if (res > 0)
			return "CustomerProfile";
		else
			return "CustomerLogin";

	}
	public String updateLastName(User user) {
		int res = userService.updateLastName(user);
		if (res > 0)
			return "CustomerProfile";
		else
			return "CustomerLogin";

	}
	
	public String updateNID(User user) {
		int res = userService.updateNID(user);
		if (res > 0)
			return "CustomerProfile";
		else
			return "CustomerLogin";

	}
	public String updateProfession(User user) {
		int res = userService.updateProfession(user);
		if (res > 0)
			return "CustomerProfile";
		else
			return "CustomerLogin";

	}
	
	public String updatephone(User user) {
		int res = userService.updateProfession(user);
		if (res > 0)
			return "CustomerProfile";
		else
			return "CustomerLogin";

	}
	public String updateMstatus(User user) {
		int res = userService.updateMstatus(user);
		if (res > 0)
			return "CustomerProfile";
		else
			return "CustomerLogin";

	}	

	public String updateDOB(User user) {
		int res = userService.updateDOB(user);
		if (res > 0)
			return "CustomerProfile";
		else
			return "CustomerLogin";

	}
	public String updateFriendName(User user) {
		int res = userService.updateFriendName(user);
		if (res > 0)
			return "CustomerProfile";
		else
			return "CustomerLogin";

	}
	public String updateFriendEmail(User user) {
		int res = userService.updateFriendEmail(user);
		if (res > 0)
			return "CustomerProfile";
		else
			return "CustomerLogin";

	}
	public String updateEmail(User user) {
		int res = userService.updateEmail(user);
		if (res > 0)
			return "CustomerProfile";
		else
			return "CustomerLogin";

	}
	

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	 
	 
}
