package com.ikonsoft.utils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class SecurityController {

    //Some attributes...


    public String redirectBusinessUser() {
        String role = (String) FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("userRole");
        //Checks if user is logged
        if (role == null) {         
            // Please login
            //Add message to authentification
            return "login.xhtml";           
        } else if (role != null) {
            if (!role.toString().equalsIgnoreCase("BUSINESS_USER")) {
                // Buyer not authorized
                return "main.xhtml";
            }
        }       
        return null;
    }

}