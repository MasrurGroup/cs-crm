package com.ikonsoft.utils;

public class Constants {
	
	public static enum CHANNELS {EMAIL, FACEBOOK , WHATSAPP,SMS, EMAGAZINE};

	public static String getSystemsys2partner_camp_offer() {
		
		StringBuilder sys2partner_camp_offer = new StringBuilder("Dear Partner,<br/>RE: Campaign / Offer Request ")
				.append("<p>Thank you for your campaign / offer request. Your request is currently being processed by your Account Manager and ")
				.append("therefore your campaign request can be edited by your Account Manager.<p>You may contact them directly from your dashboard ")
				.append("within 14 working days before submission approval.")
				.append("<p>Regards<p>System Admin");
		return sys2partner_camp_offer.toString();

	}
	
	public static String  getSystemsys2businessUser_camp_offer(String RequestorName ){
		StringBuilder sp = new StringBuilder("Dear Account Manager, ");
		sp.append("<p>RE: Campaign / Offer Request")
		.append("<p>You have recieved campaign / offer request from "+RequestorName+" which is currently " )
		.append("waiting for your approval in the Business User Dashboard.<p>Please make sure that all ")
		.append("budgets for the campaigns are approved before submitting the campaign to the mail automator.")
		.append("<p>Regards<p>System Admin");
		  
		return sp.toString();
		
	}
	
}
