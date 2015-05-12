package com.ikonsoft.mbeans.user.partner;

import com.ikonsoft.model.Campaign;
import com.ikonsoft.model.Offer;
import com.ikonsoft.model.Partner;
import com.ikonsoft.services.BudgetServiceImpl;
import com.ikonsoft.services.CampaignService;
import com.ikonsoft.services.email.SendHtmlEmailService;
import com.ikonsoft.user.customer.services.impl.CustomerServicesImpl;
import com.ikonsoft.utils.Constants;
import com.ikonsoft.utils.IkonDateUtils;
import com.ikonsoft.utils.JSFUtil;
import com.ikonsoft.utils.PropertiesCache;
import com.ikonsoft.utils.StringUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import java.util.Date;
import java.util.List;
import java.util.Map;


//import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import org.primefaces.event.FileUploadEvent;

@ManagedBean
@SessionScoped
public class CampaignBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Campaign campaign = new Campaign();
	CampaignService campaignService = new CampaignService();
	private List<String> channels;
	private String jesonList;
	private final String destination = PropertiesCache.getValue("destination");

	private String filepath = "";
	private String filename = "";

	public String clear(final String parentComponentId) {
		UIViewRoot view = FacesContext.getCurrentInstance().getViewRoot();
		UIComponent fc = view.findComponent(parentComponentId);
		if (null != fc) {
			List<UIComponent> components = fc.getChildren();
			for (UIComponent component : components) {
				if (component instanceof UIInput) {
					UIInput input = (UIInput) component;
					// JSF 1.1+
					// input.setSubmittedValue(null);
					// input.setValue(null);
					// input.setLocalValueSet(false);
					// input.setValid(true);
					// JSF 1.2+
					input.resetValue();
				}
			}
		}
		return null;
	}

	/*
	 * private void clear(){ this.requesterName=""; this.email="";
	 * this.filename=""; this.filepath=""; this.phone=""; this.busineessType="";
	 * this.offerType=""; this.projectName=""; this.launchDate=null;
	 * this.endDate=null; this.description=""; this.objective="";
	 * this.targetAudience=""; this.channels =null;
	 * 
	 * this.Languages=null;
	 * 
	 * }
	 */
	public void upload(FileUploadEvent event) {
		FacesMessage msg = new FacesMessage("Success! "
				+ event.getFile().getFileName() + " is uploaded.",
				" is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		filename = event.getFile().getFileName();
		filepath = destination + filename;
		// Do what you want with the file
		try {

			copyFile(event.getFile().getFileName(), event.getFile()
					.getInputstream());

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void copyFile(String fileName, InputStream in) {

		try {

			// write the inputStream to a FileOutputStream
			OutputStream out = new FileOutputStream(new File(destination
					+ fileName));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {

				out.write(bytes, 0, read);
			}

			in.close();

			out.flush();

			out.close();

			System.out.println("A new file created:" + filepath);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public String send() {
		StringBuilder body = new StringBuilder();
		body.append("\nRequester name:+requesterName");
		body.append("Sender email :" + campaign.getSenderEmail());
		body.append("\nPhone No:" + campaign.getPhoneNumber());
		body.append("\nBusiness type:" + campaign.getBusinessType());
		body.append("\nFile path :" + filepath);
		body.append("\nFile Name :" + filename);
		System.out.println("__________Start Sending_________________ ");

		System.out.println(body.toString());
		return "Home";

	}

	public void refresh() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		ViewHandler viewHandler = application.getViewHandler();
		UIViewRoot viewRoot = viewHandler.createView(context, context
				.getViewRoot().getViewId());
		context.setViewRoot(viewRoot);
		context.renderResponse(); // Optional
	}

	public String docampaign() {
		return "Home";
	}

	public String save(String parentComponentId)
			   throws UnsupportedEncodingException {
			  System.out
			    .println("__________Starting Saving Campaign Bean _________________ ");
			  Partner partner = (Partner) JSFUtil.getLoggedinUser();
			  System.out.println("Logged partner " + partner.getCompanyEmail());
			  System.out.println(" saveCampaign() _______ ");
			  // **************************************************************************
			  CustomerServicesImpl cs = new CustomerServicesImpl();
			  BudgetServiceImpl budgetService = new BudgetServiceImpl();

			  Map<String, Long> customerNos = cs.getNoOfCustomersWith(channels);

			  Map<String, Long> valuePerChannel = budgetService.getChannelRates();

			  System.out.println(budgetService.getBudget(channels, customerNos,
			    valuePerChannel));

			  campaign.setBudget(new Double(budgetService.getBudget(channels,
			    customerNos, valuePerChannel)));

			  campaign.setChannels(StringUtil.ListToString(channels));
			  // **********************************************
			  HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			  String targetAudience = (String) httpSession.getAttribute("queryStatement");
			  System.out.println(targetAudience);
			  campaign.setTargetAudience(targetAudience);
			  
			  int campaignId = campaignService.createCampaign(campaign);

			  StringBuilder body = new StringBuilder();
			  body.append("Campain Bean \nRequester name:"
			    + campaign.getRequesterName());
			  body.append("\nSender email :" + campaign.getSenderEmail());
			  body.append("\nPhone No:" + campaign.getPhoneNumber());
			  body.append("\nBusiness type:" + campaign.getBusinessType());
			  body.append("\nFile path :" + filepath);
			  body.append("\nFile Name :" + filename);
			  /*
			   * body.append("offer type :" + offerType); body.append("offer type :" +
			   * offerType);
			   */
			  System.out.println(body.toString());
			  System.out.println(channels.toString());

			  String subject = "Campaign / Offer Request Confirmation";
			  String to, cc, bcc;
			  to = cc = bcc = "";

			  /*SendHtmlEmailService.sendGroupEmail(campaign.getSenderEmail(), cc, bcc,
			    subject, Constants.getSystemsys2partner_camp_offer());
			  SendHtmlEmailService.sendGroupEmail(PropertiesCache
			    .getValue("BusinessUser"), cc, "", subject, Constants
			    .getSystemsys2businessUser_camp_offer(campaign
			      .getRequesterName()));*/
			  System.out.println(subject);

			  refresh();
			  clear(parentComponentId);
			  return "success";

			 }

	public String getFilepath() {
		return filepath;
	}

	
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}


	public String getFilename() {
		return filename;
	}

	/**
	 * @param filename
	 *            the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setCampaign(Campaign Campaign) {
		this.campaign = Campaign;
	}

	public Campaign getCampaign() {

		return campaign;
	}

	public List<String> getChannels() {
		return channels;
	}

	public void setChannels(List<String> channels) {
		this.channels = channels;
	}

	public String getJesonList() {
		return jesonList;
	}

	public void setJesonList(String jesonList) {
		this.jesonList = jesonList;
	}

}
