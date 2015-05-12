package com.ikonsoft.mbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.servlet.RequestDispatcher;

import com.ikonsoft.model.Campaign;
import com.ikonsoft.model.FacebookChannel;
import com.ikonsoft.model.User;
import com.ikonsoft.model.WhatsAppChannel;
import com.ikonsoft.services.CampaignService;
import com.ikonsoft.services.FacebookChannelService;
import com.ikonsoft.services.ReportLaunch;
import com.ikonsoft.services.WhatsAppChannelService;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.FacebookType;

@ManagedBean
@ViewScoped
public class WhatsAppView implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	private List<WhatsAppChannel> WhatsApps;
	
    
    
    private WhatsAppChannelService  whatsappService =new WhatsAppChannelService();
     
    @PostConstruct
    public void init() {
    	setWhatsApps(whatsappService.getAll());
    	
    }

	public List<WhatsAppChannel> getWhatsApps() {
		return WhatsApps;
	}

	public void setWhatsApps(List<WhatsAppChannel> whatsApp) {
		WhatsApps = whatsApp;
	}

	
 
        
}
