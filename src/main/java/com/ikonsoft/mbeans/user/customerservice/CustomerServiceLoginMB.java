package com.ikonsoft.mbeans.user.customerservice;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.ikonsoft.model.User;
import com.ikonsoft.services.UserService;
import com.ikonsoft.utils.Groups;
import com.ikonsoft.utils.JSFUtil;
import com.ikonsoft.utils.StringUtil;

@ManagedBean
@RequestScoped
public class CustomerServiceLoginMB {
	private UserService userService = new UserService();
	private String email;
	private String password;

	public String doLogin() {
		System.out.println(getEmail());
		System.out.println(getPassword());
		System.out.println("customerServiceLoginMB()");
		if (StringUtil.isNull(getEmail()) || StringUtil.isNull(getPassword())) {
			System.out.println("error");
			return "Admin";
		}

		User user = userService.getUserByEmailId(getEmail());
		 		if (user==null ){
		 			JSFUtil.addErrorMsg("Please Register Or Enter Registered Account  !");
			return "Admin";
		}
		else if (user.getPassword().equals(getPassword())
				&& user.getAuthority().equals(Groups.CUSTOMER_SERVICE)) {
			return "CustomerProfile";
		} else {
			JSFUtil.addErrorMsg("Please Register Or Enter Registered Account  !");
		}
		return "Admin";

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

}
