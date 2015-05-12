package com.ikonsoft.mbeans;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.ikonsoft.model.Campaign;
import com.ikonsoft.model.FacebookChannel;
import com.ikonsoft.model.Offer;
import com.ikonsoft.model.WhatsAppChannel;
import com.ikonsoft.services.FacebookChannelService;
import com.ikonsoft.services.OfferService;
import com.ikonsoft.services.WhatsAppChannelService;

@ManagedBean
@ViewScoped
public class WhatsAppChannelBean implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private WhatsAppChannelService whatsappservice=new WhatsAppChannelService();
	
	
public String updatePhoneNumber(WhatsAppChannel whatsappmodel)
{
if(whatsappservice.updatePhoneNumber(whatsappmodel)>0)
return"ITDashboard";
else
{
	System.out.println("Error in FaceBook Update Phone Number");
	return "Home";
	}
}

public String updatePassword(WhatsAppChannel whatsappmodel)
{
if(whatsappservice.updatePassword(whatsappmodel)>0)
return"ITDashboard";
else
{
	System.out.println("Error in FaceBook Update Password");
	return "Home";
	}
}


}