package com.ikonsoft.mbeans;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.ikonsoft.mbeans.user.test.ViewUtil;
import com.ikonsoft.model.Campaign;
import com.ikonsoft.model.Offer;
import com.ikonsoft.model.User;
import com.ikonsoft.services.OfferService;
import com.ikonsoft.services.UserService;
import com.ikonsoft.services.email.SendHtmlEmailService;
import com.ikonsoft.utils.PropertiesCache;
import com.ikonsoft.utils.StringUtil;

@ManagedBean
@ViewScoped
public class OfferView implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	private List<Offer> offers;
	private List<Offer> approvedoffers;
    
    
    private Offer selectedOffer;
    private Offer approvedselectedOffer;
     
  
    private OfferService  offerService =new OfferService();
     
    @PostConstruct
    public void init() {
    	offers=offerService.getNotApproved();
    	approvedoffers=offerService.getApproved();
    	
    }
 
    
    public List<Offer> getOffers() {
        return offers;
    }
 
    public void executeOffer(Offer offer)
    {
     UserService userService = new UserService();
  List<User> usersList = userService.getUsersBySQLquery(offer
    .getTargetAudience());
  System.out.println("TargetAudience: "+offer.getTargetAudience());
  List<String> channels = StringUtil.StringToList(offer.getChannels());
  System.out.println(usersList);
  for(User user : usersList){
   if (channels.contains("EMAIL")) {
    try {
    	SendHtmlEmailService.sendGroupEmail(user.getEmailId(), "", PropertiesCache.getValue("adminEmail"), "Please Response to our post", ViewUtil.generateEmailMsg(offer));
     System.out.println("EMAIL: "+ViewUtil.generateEmailMsg(offer));
    } catch (UnsupportedEncodingException e) {
     // TODO Auto-generated catch block
     e.printStackTrace();
    }
    System.out.println("EMAIL: "+ViewUtil.generateEmailMsg(offer));
   }
   if (channels.contains("FACEBOOK")) {
    //UserUtil.sendFaceBook(user, ViewUtil.generateFacebookMsg(campaign));
    System.out.println("FACEBOOK: "+ViewUtil.generateFacebookMsg(offer));

   }
   if (channels.contains("WHATSAPP")) {
    //UserUtil.sendWhatsapp(user, ViewUtil.generateWhatsAppMsg(campaign));
    System.out.println("WHATSAPP: "+ViewUtil.generateWhatsAppMsg(offer));

   }
   if (channels.contains("EMAGAZINE")) {
    System.out.println("EMAGAZINE: "+ViewUtil.generateEMagazinMsg(offer));
   }
   if (channels.contains("SMS")) {
    System.out.println("SMS: "+ViewUtil.generateSMSMsg(offer));
   }
  }
    }
    
    public String deleteOffer(Offer offer)
    {
    	try{
        	offerService.deleteOffer(offer);
        	
        	}catch(Exception ex)
        	{
        		
        	}
        	
    	System.out.println("offer deleted = " + offer.getId());
        	return "SelectToExecute";	
    	
    }
    
    
    public void setService(OfferService service) {
        this.offerService = service;
        
    }
 
    public Offer getSelectedOffer() {
        return selectedOffer;
    }
 
    public void setSelectedOffer(Offer selectedOffer) {
        this.selectedOffer = selectedOffer;
    }

	public Offer getApprovedselectedOffer() {
		return approvedselectedOffer;
	}

	public void setApprovedselectedOffer(Offer approvedselectedOffer) {
		this.approvedselectedOffer = approvedselectedOffer;
	}

	public List<Offer> getApprovedoffers() {
		return approvedoffers;
	}

	public void setApprovedoffers(List<Offer> approvedoffers) {
		this.approvedoffers = approvedoffers;
	}
	public String approve(Offer offer) {
    	int res=offerService.approveOffer(offer);
    	if(res>0)
    	return "BusinessDashboard";
    	else
    		return "Home";
		
	}
}
