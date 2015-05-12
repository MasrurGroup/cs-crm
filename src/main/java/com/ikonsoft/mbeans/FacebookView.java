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
import com.ikonsoft.services.CampaignService;
import com.ikonsoft.services.FacebookChannelService;
import com.ikonsoft.services.ReportLaunch;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.FacebookType;

@ManagedBean
@ViewScoped
public class FacebookView implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	private List<FacebookChannel> facebook;
	
    
    
    private FacebookChannelService  facebookService =new FacebookChannelService();
     
    @PostConstruct
    public void init() {
    	setFacebook(facebookService.getAll());
    	
    }

	public List<FacebookChannel> getFacebook() {
		return facebook;
	}

	public void setFacebook(List<FacebookChannel> facebook) {
		this.facebook = facebook;
	}
 
        
}
