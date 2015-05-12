package com.ikonsoft.mbeans.user.partner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.ikonsoft.model.Partner;
import com.ikonsoft.model.User;
import com.ikonsoft.services.PartnerService;
import com.ikonsoft.utils.JSFUtil;
import com.ikonsoft.utils.PropertiesCache;
import com.ikonsoft.utils.StringUtil;

@ManagedBean
@SessionScoped
public class PartnerLoginMB implements Serializable   {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PartnerService partnerService = new PartnerService();
	private String email;
	private String password;
	private Partner partner;
	public String doForward() {
		return "PartnerRegister";
	}

	public String doLogin() {
		System.out.println("______PartnerLoginMB()__________");
		System.out.println(email );
		System.out.println(password );
	
		if (StringUtil.isNull(email ) || StringUtil.isNull(password )) {
			System.out.println("error");
			return "Partner";
		}

		partner = partnerService.getPartnerByEmailId(email );
		if (partner == null) {
			JSFUtil.addErrorMsg("Please Register Or Enter Registered Account  !");
			return "PartnerLogin";
		} else if (partner.getPassword().equals(password)) {
			System.out.println("success");
			JSFUtil.setLoggedinUser(partner);
			return "success";
		} else {
			JSFUtil.addErrorMsg("Please Register Or Enter Registered Account  !");
			// return "Partner";
		}
		return "Partner";
	}
	public void downloadFile(String file1) {
		System.out.println("In downlaod");
		String dest = PropertiesCache.getValue("destination");

	    File file = new File(dest+file1);
	    HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();  

	    response.setHeader("Content-Disposition", "attachment;filename="+file1);  
	    response.setContentLength((int) file.length());  
	    ServletOutputStream out = null;  
	    try {  
	        FileInputStream input = new FileInputStream(file);  
	        byte[] buffer = new byte[1024];  
	        out = response.getOutputStream();  
	        int i = 0;  
	        while ((i = input.read(buffer)) != -1) {  
	            out.write(buffer);  
	            out.flush();  
	        }  
	        FacesContext.getCurrentInstance().getResponseComplete();  
	    } catch (IOException err) {  
	        err.printStackTrace();  
	    } finally {  
	        try {  
	            if (out != null) {  
	                out.close();  
	            }  
	        } catch (IOException err) {  
	            err.printStackTrace();  
	        }  
	    }  

	}
	public String updateName(Partner partner) {
		int res = partnerService.updateName(partner);
		if (res > 0)
			return "PartnerHome";
		else
			return "PartnerLogin";

	}

	public String updateAddress(Partner partner) {
		int res = partnerService.updateAddress(partner);
		if (res > 0)
			return "PartnerHome";
		else
			return "PartnerLogin";

	}

	public String updateBusinessType(Partner partner) {
		int res = partnerService.updateBusinessType(partner);
		if (res > 0)
			return "PartnerHome";
		else
			return "PartnerLogin";

	}

	public String updateRegNum(Partner partner) {
		int res = partnerService.updateRegNum(partner);
		if (res > 0)
			return "PartnerHome";
		else
			return "PartnerLogin";

	}
	public String updateTelephone(Partner partner) {
		int res = partnerService.updateTelephone(partner);
		if (res > 0)
			return "PartnerHome";
		else
			return "PartnerLogin";

	}
	public String updateFormation(Partner partner) {
		int res = partnerService.updateFormation(partner);
		if (res > 0)
			return "PartnerHome";
		else
			return "PartnerLogin";

	}	
	
	public String updateOfficerName(Partner partner) {
		int res = partnerService.updateOfficerName(partner);
		if (res > 0)
			return "PartnerHome";
		else
			return "PartnerLogin";

	}	
	public String updateEmail(Partner partner) {
		int res = partnerService.updateEmail(partner);
		if (res > 0)
			return "PartnerHome";
		else
			return "PartnerLogin";

	}	
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Partner getPartner()
	{
		return partner;
	}
	
	public void setPartner(Partner partner)
	
	{
		this.partner=partner;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
