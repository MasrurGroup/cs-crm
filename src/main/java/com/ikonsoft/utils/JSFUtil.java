
package com.ikonsoft.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.ikonsoft.model.User;

public final class JSFUtil {
	
	
	public static void setLoggedinUser(Object user)
	{
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		session.setAttribute("LOGIN_USER", user);
		System.out.println("Partner with id:"+user.toString()+" added to the session");
	}
	
	
	public static Object getLoggedinUser()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		return  session.getAttribute("LOGIN_USER");
	}
	
	public static void addInfoMsg(String componentId, String msg) {
		FacesContext.getCurrentInstance().addMessage(componentId, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	}
	
	public static void addInfoMsg(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	}
	
	public static void addErrorMsg(String componentId, String msg) {
		FacesContext.getCurrentInstance().addMessage(componentId, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
	}
	
	public static void addErrorMsg(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
                FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}
        
        public static Object getRequest() {
            return FacesContext.getCurrentInstance().getExternalContext().getRequest();
        }
}


