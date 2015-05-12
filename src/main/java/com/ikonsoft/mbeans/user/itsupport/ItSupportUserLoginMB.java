package com.ikonsoft.mbeans.user.itsupport;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.ikonsoft.model.User;
import com.ikonsoft.services.UserService;
import com.ikonsoft.utils.Groups;
import com.ikonsoft.utils.JSFUtil;
import com.ikonsoft.utils.StringUtil;

@ManagedBean
@RequestScoped
public class ItSupportUserLoginMB {
	private UserService userService = new UserService();
	private String email;
	private String password;
	
	public String doLogin() {
		System.out.println(getEmail());
		System.out.println(getPassword());
		System.out.println("itSupportUserLoginMB()");
		if (StringUtil.isNull(getEmail()) || StringUtil.isNull(getPassword())) {
			System.out.println("error");
			return "Users_Login_ITSupport";
		}

		User user = userService.getUserByEmailId(getEmail());
		 		if (user==null ){
		 			JSFUtil.addErrorMsg("Please Register Or Enter Registered Account  !");
			return "Users_Login_ITSupport";
		}
		else if (user.getPassword().equals(getPassword())
				&& user.getAuthority().equals(Groups.IT_SUPPORT)) {
			return "Home";
		} else {
			JSFUtil.addErrorMsg("Please Register Or Enter Registered Account  !");
		}
		return "Users_Login_ITSupport";

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
