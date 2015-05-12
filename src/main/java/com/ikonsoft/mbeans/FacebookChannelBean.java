package com.ikonsoft.mbeans;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ikonsoft.model.Campaign;
import com.ikonsoft.model.FacebookChannel;
import com.ikonsoft.model.Offer;
import com.ikonsoft.services.FacebookChannelService;
import com.ikonsoft.services.OfferService;
import com.ikonsoft.utils.HibernateUtil;

@ManagedBean
@ViewScoped
public class FacebookChannelBean implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FacebookChannelService facebookservice =new FacebookChannelService();
	
	private FacebookChannel facebook;
public String updateAppid(FacebookChannel facebookmodel)
{
if(facebookservice.updateAppID(facebookmodel)>0)
return"ITDashboard";
else
{
	System.out.println("Error in FaceBook Update Appid");
	return "Home";
	}
}

public String updateSecritCode(FacebookChannel facebookmodel)
{
if(facebookservice.updateAppSecrit(facebookmodel)>0)
return"ITDashboard";
else
{
	System.out.println("Error in FaceBook Update Appid");
	return "Home";
	}
}

public FacebookChannel getFacebook() {
	return facebook;
}

public void setFacebook(FacebookChannel facebook) {
	this.facebook = facebook;
}



}