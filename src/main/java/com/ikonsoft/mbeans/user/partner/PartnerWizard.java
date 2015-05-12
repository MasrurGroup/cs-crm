package com.ikonsoft.mbeans.user.partner;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;

import com.ikonsoft.model.Partner;
import com.ikonsoft.services.PartnerService;
import com.ikonsoft.services.email.SendHtmlEmailService;
import com.ikonsoft.utils.PropertiesCache;

@ManagedBean
@ViewScoped
public class PartnerWizard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Partner partner = new Partner();

	private boolean skip;

	public PartnerWizard() {
	}

	public String save() {
		
		FacesMessage msg = new FacesMessage("Please Wait checking our records and send mail", "Welcome :"
			+ getPartner().getCompanyName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		PartnerService partnerService = new PartnerService();
		partnerService.createPartner(partner);
		
		FacesMessage msgss = new FacesMessage("Successful", "Welcome :"
				+ getPartner().getCompanyName());
		System.out.println("New Partner Registered :"+partner.getCompanyEmail());
		try {
			SendHtmlEmailService.sendGroupEmail(partner.getCompanyEmail(), "", PropertiesCache.getValue("adminEmail"), "Partner Registration Successful", "<h2>Thank you for your request, welcom mr."+partner.getOfficername()+" from : "+partner.getCompanyName()+"  , your email address is "
					+ " : "+partner.getCompanyEmail()+"  Password Is: "+ partner.getPassword());
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		} 
		
		return "RegDone";
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public String onFlowProcess(FlowEvent event) {
		if (skip) {
			skip = false; // reset in case user goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

}