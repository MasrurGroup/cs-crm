package com.ikonsoft.mbeans.user.superuser;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.ikonsoft.model.User;
import com.ikonsoft.services.UserService;
import com.ikonsoft.utils.Groups;
import com.ikonsoft.utils.JSFUtil;
import com.ikonsoft.utils.StringUtil;

@ManagedBean
@RequestScoped
public class SuperUserLoginMB {
	private UserService userService = new UserService();
	private String email;
	private String password;
	
	public String doLogin() {
		System.out.println(getEmail());
		System.out.println(getPassword());
		System.out.println("superUserLoginMB()");
		if (StringUtil.isNull(getEmail()) || StringUtil.isNull(getPassword())) {
			System.out.println("error");
			return "Users_Login_SuperUser";
		}

		User user = userService.getUserByEmailId(getEmail());
		 		if (user==null ){
		 			JSFUtil.addErrorMsg("Please Register Or Enter Registered Account  !");
			return "Users_Login_SuperUser";
		}
		else if (user.getPassword().equals(getPassword())
				&& user.getAuthority().equals(Groups.SUPER_USER)) {
			return "Home";
		} else {
			JSFUtil.addErrorMsg("Please Register Or Enter Registered Account  !");
		}
		return "Users_Login_SuperUser";

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
