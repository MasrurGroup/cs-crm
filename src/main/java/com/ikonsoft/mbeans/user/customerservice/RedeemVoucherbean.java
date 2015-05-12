package com.ikonsoft.mbeans.user.customerservice;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ikonsoft.model.User;
import com.ikonsoft.services.UserService;

@ManagedBean
@SessionScoped
public class RedeemVoucherbean implements Serializable {

	private String email;
	private String nationalId;
	private String giftType;
	private User user;
	private String name;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public String getGiftType() {
		return giftType;
	}

	public void setGiftType(String giftType) {
		this.giftType = giftType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void printButtonAction() {
		System.out.println("printButtonAction method started");
		UserService userService = new UserService();
		user = userService.getUserByNationalIdAndEmail(nationalId, email);
		if(user!=null){
			System.out.println("User Id = "+user.getUserId());
			name = user.getFirstName()+" "+user.getLastName();
			user.setAcessToken("User gift issued");
			userService.updateAccessTokenUser(user);
		}
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("RedeemVaoutcher.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
