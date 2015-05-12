package com.ikonsoft.mbeans.user.admin;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.ikonsoft.model.User;
import com.ikonsoft.services.UserService;
import com.ikonsoft.utils.Groups;
import com.ikonsoft.utils.JSFUtil;
import com.ikonsoft.utils.StringUtil;

@ManagedBean
@RequestScoped
public class AdminLoginMB {
	private UserService userService = new UserService();
	private String email;
	private String password;

	public String doLogin() {
		System.out.println(getEmail());
		System.out.println(getPassword());
		System.out.println("adminLoginMB()");
		if (StringUtil.isNull(getEmail()) || StringUtil.isNull(getPassword())) {
			System.out.println("error");
			return "DigitalMarketing_Login";
		}

		User user = userService.getUserByEmailId(getEmail());
		 		if (user==null ){
		 			JSFUtil.addErrorMsg("Please Register Or Enter Registered Account  !");
			return "DigitalMarketing_Login";
		}
		else if (user.getPassword().equals(getPassword())
				&& user.getAuthority().equals(Groups.ADMIN)) {
			return "DigitalMarketing";
		} else {
			JSFUtil.addErrorMsg("Please Register Or Enter Registered Account  !");
		}
		return "DigitalMarketing_Login";

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
