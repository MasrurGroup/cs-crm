package com.ikonsoft.mbeans;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.ikonsoft.model.Campaign;
import com.ikonsoft.model.EmailChannel;
import com.ikonsoft.model.FacebookChannel;
import com.ikonsoft.model.Offer;
import com.ikonsoft.services.EmailChannelService;
import com.ikonsoft.services.FacebookChannelService;
import com.ikonsoft.services.OfferService;

@ManagedBean
@ViewScoped
public class EmailChannelBean implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EmailChannelService emailservice =new EmailChannelService();
	
	
public String updateSMTP(EmailChannel emailchannel)
{
if(emailservice.updateSMTP(emailchannel)>0)
return"ITDashboard";
else
{
	System.out.println("Error in Email Update SMTP");
	return "Home";
	}
}


public String updateUserName(EmailChannel emailchannel)
{
if(emailservice.updateUserName(emailchannel)>0)
return"ITDashboard";
else
{
	System.out.println("Error in Email Update UserName");
	return "Home";
	}
}

public String updatePassword(EmailChannel emailchannel)
{
if(emailservice.updatePassword(emailchannel)>0)
return"ITDashboard";
else
{
	System.out.println("Error in Email Update Password");
	return "Home";
	}
}

public String updatePort(EmailChannel emailchannel)
{
if(emailservice.updatePort(emailchannel)>0)
return"ITDashboard";
else
{
	System.out.println("Error in Email Update Port");
	return "Home";
	}
}

}