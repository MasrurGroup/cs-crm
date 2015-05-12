package com.ikonsoft.mbeans.user.partner;

import java.io.UnsupportedEncodingException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.ikonsoft.model.Partner;
import com.ikonsoft.services.PartnerService;
import com.ikonsoft.services.email.SendAttachmentInEmail;
import com.ikonsoft.utils.JSFUtil;


@ManagedBean
@RequestScoped
public class PartnerRegisterView {
	 private Partner partner=new Partner();
	  
	    
	    public PartnerRegisterView(){
	    	
	    //	user.setBirthdate(new Date("1/1/1977"));
	    }

	    public void setPartner(Partner user) {
	        this.partner = user;
	    }

	    /**
	     * @return the partner
	     */
	    public Partner getPartner() {
	               
	              return partner;
	    }
	public String savePartner(){
	    PartnerService partnerService= new PartnerService();
	    
	   int userId= partnerService.createPartner(partner);
	   if (userId>0){
		   String subject= "CS registreation Successuful";
		   String body= "Thank you for registeration";
		   //sendMail(to, cc , bcc, subject, body, senderName, filepath, filename);
		   try {
			SendAttachmentInEmail.sendMail(partner.getCompanyEmail(),"","", subject,body,"CS Admin","","");
		} catch (UnsupportedEncodingException e) {
			 
			e.printStackTrace();
		}
		   return "RegDone";
	   }
	   JSFUtil.addErrorMsg("Cannot create user , email already exists");
	   System.out.println("UserAlreadyExists.xhtml");
	   return "UserAlreadyExists";
	}
}
