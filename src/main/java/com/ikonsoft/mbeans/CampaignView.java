package com.ikonsoft.mbeans;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.servlet.RequestDispatcher;

import com.ikonsoft.mbeans.user.test.ViewUtil;
import com.ikonsoft.model.Campaign;
import com.ikonsoft.model.User;
import com.ikonsoft.services.CampaignService;
import com.ikonsoft.services.ReportLaunch;
import com.ikonsoft.services.UserService;
import com.ikonsoft.services.email.SendHtmlEmailService;
import com.ikonsoft.utils.PropertiesCache;
import com.ikonsoft.utils.StringUtil;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.FacebookType;

@ManagedBean
@ViewScoped
public class CampaignView implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	private List<Campaign> campaigns;
	private List<Campaign> Approvedcampaigns;
	private boolean inactive;
    
    
    
    private Campaign selectedCampaign;
    private Campaign approvedselectedCampaign; 
  
    private CampaignService  campaignService =new CampaignService();
     
    @PostConstruct
    public void init() {
    	campaigns=campaignService.getNotApproved();
    	setApprovedcampaigns(campaignService.getApproved());
    }
 
    public String approve(Campaign campaign) {
    	int res=campaignService.approveCampaign(campaign);
    	if(res>0)
        	return "BusinessDashboard";
        	else
        		return "Home";
		
	}
    
  
    
    public void executeCampaign(Campaign campaign)
    {
    	
    	
    	System.out.println("campaign Executed = " + campaign.getId());
    	
    	UserService userService = new UserService();
    	  List<User> usersList = userService.getUsersBySQLquery(campaign
    	    .getTargetAudience());
    	  List<String> channels = StringUtil.StringToList(campaign.getChannels());
    	  for(User user : usersList){
    	   if (channels.contains("EMAIL")) {
    	    try {
    	    	SendHtmlEmailService.sendGroupEmail(user.getEmailId(), "", PropertiesCache.getValue("adminEmail"), "Please Response to our post ", ViewUtil.generateEmailMsg(campaign));
    	     System.out.println("EMAIL: "+ViewUtil.generateEmailMsg(campaign));
    	    } catch (UnsupportedEncodingException e) {
    	     // TODO Auto-generated catch block
    	     e.printStackTrace();
    	    }
    	    System.out.println("EMAIL: "+ViewUtil.generateEmailMsg(campaign));
    	   }
    	   if (channels.contains("FACEBOOK")) {
    	    //UserUtil.sendFaceBook(user, ViewUtil.generateFacebookMsg(campaign));
    	    System.out.println("FACEBOOK: "+ViewUtil.generateFacebookMsg(campaign));

    	   }
    	   if (channels.contains("WHATSAPP")) {
    	    //UserUtil.sendWhatsapp(user, ViewUtil.generateWhatsAppMsg(campaign));
    	    System.out.println("WHATSAPP: "+ViewUtil.generateWhatsAppMsg(campaign));

    	   }
    	   if (channels.contains("EMAGAZINE")) {
    	    System.out.println("EMAGAZINE: "+ViewUtil.generateEMagazinMsg(campaign));
    	   }
    	   if (channels.contains("SMS")) {
    	    System.out.println("SMS: "+ViewUtil.generateSMSMsg(campaign));
    	   }
    	  }
    }
    
    public String deleteCampaign(Campaign campaign)
    {
    	try{
    	campaignService.deleteCampaign(campaign);
    	
    	}catch(Exception ex)
    	{
    		
    	}
    	
    	System.out.println("campaign Deleted = " + campaign.getId());
    	return "SelectToExecute";	
    }
    
    public List<Campaign> getCampaigns() {
        return campaigns;
    }
 
    public void setService(CampaignService service) {
        this.campaignService = service;
        
    }
 
    public Campaign getSelectedCampaign() {
        return selectedCampaign;
    }
 
    public void setSelectedCampaign(Campaign selectedCampaign) {
        this.selectedCampaign = selectedCampaign;
    }

	public List<Campaign> getApprovedcampaigns() {
		return Approvedcampaigns;
	}

	public void setApprovedcampaigns(List<Campaign> approvedcampaigns) {
		Approvedcampaigns = approvedcampaigns;
	}

	public Campaign getApprovedselectedCampaign() {
		return approvedselectedCampaign;
	}

	public void setApprovedselectedCampaign(Campaign approvedselectedCampaign) {
		this.approvedselectedCampaign = approvedselectedCampaign;
	}

	public boolean isInactive() {
		return inactive;
	}

	public void setInactive(boolean inactive) {
		this.inactive = inactive;
	}
	
    
}
