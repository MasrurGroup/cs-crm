package com.ikonsoft.mbeans.user.business;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import com.ikonsoft.model.User;
import com.ikonsoft.segments.ISegmentService;
import com.ikonsoft.services.ReportLaunch;
import com.ikonsoft.services.UserService;
import com.ikonsoft.utils.Groups;
import com.ikonsoft.utils.JSFUtil;
import com.ikonsoft.utils.StringUtil;

@ManagedBean
@RequestScoped
public class BusinessUserLoginMB {
	private UserService userService = new UserService();
	private String email;
	private String password;
	private String authority;
	public String doLogin() {
		System.out.println(getEmail());
		System.out.println(getPassword());
		System.out.println(getAuthority());
		System.out.println("businessUserLoginMB()");
		if (StringUtil.isNull(email ) || StringUtil.isNull(password )) {
			System.out.println("error");
			return "Users_Login_Business";
		}

		User user = userService.getUserByEmailId(email);
		if (user == null) {
			JSFUtil.addErrorMsg("Please Register Or Enter Registered Account  !");
			return "Users_Login_Business";
		} else if (user.getPassword().equals(password)
				&& user.getAuthority().equals(Groups.BUSINESS_USER)) {
			return "BusinessDashboard";
		}
		else if (user.getPassword().equals(password)
				&& user.getAuthority().equals(Groups.ADMIN)) {
			return "AdminDashboard";
		}
		else if (user.getPassword().equals(password)
				&& user.getAuthority().equals(Groups.CUSTOMER_SERVICE)) {
			return "CustomerServiceDashboard";
		}
		else if (user.getPassword().equals(password)
				&& user.getAuthority().equals(Groups.IT_SUPPORT)) {
			return "ITDashboard";
		}
		else if (user.getPassword().equals(password)
				&& user.getAuthority().equals(Groups.SUPER_USER)) {
			return "SuperUserDashboard";
		}
		else {
			JSFUtil.addErrorMsg("Please Register Or Enter Registered Account  !");
		}
		return "Users_Login_Business";

	}
	


	public String test()
	{
		/*String [] args={};
		ReportLaunch.main(args);*/
		return "PartnerHome";
	}
	
	public List<User>  getAudiance()
	{
		ISegmentService iseg=new ISegmentService();
		return iseg.executeQry();
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



	public String getAuthority() {
		return authority;
	}



	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
