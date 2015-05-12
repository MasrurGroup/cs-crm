package com.ikonsoft.mbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.servlet.RequestDispatcher;

import com.ikonsoft.mbeans.user.test.UserSearch;
import com.ikonsoft.model.Campaign;
import com.ikonsoft.model.FacebookChannel;
import com.ikonsoft.model.User;
import com.ikonsoft.model.WhatsAppChannel;
import com.ikonsoft.services.CampaignService;
import com.ikonsoft.services.FacebookChannelService;
import com.ikonsoft.services.ReportLaunch;
import com.ikonsoft.services.UserService;
import com.ikonsoft.services.WhatsAppChannelService;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.FacebookType;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class UserView implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	private List<User> Users;
	 private List<User> filteredusers;
    
    
    private UserService  userservice =new UserService();
     
    @PostConstruct
    public void init() {
    	setUsers(userservice.getUsersList(new UserSearch()));
    	
    }

    public boolean filterByPrice(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if(filterText == null||filterText.equals("")) {
            return true;
        }
         
        if(value == null) {
            return false;
        }
         
        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
    }

	public List<User> getUsers() {
		return Users;
	}

	public void setUsers(List<User> users) {
		Users = users;
	}

	public List<User> getFilteredusers() {
		return filteredusers;
	}

	public void setFilteredusers(List<User> filteredusers) {
		this.filteredusers = filteredusers;
	}

	
 
        
}
