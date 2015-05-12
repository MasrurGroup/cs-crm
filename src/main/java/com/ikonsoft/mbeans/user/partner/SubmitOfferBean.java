/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ikonsoft.mbeans.user.partner;

import com.ikonsoft.facade.upload.UploadFacade;
import com.ikonsoft.model.Offer;
import com.ikonsoft.services.BudgetServiceImpl;
import com.ikonsoft.services.CampaignService;
import com.ikonsoft.services.OfferService;
import com.ikonsoft.services.email.SendAttachmentInEmail;
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
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import org.primefaces.event.FileUploadEvent;

@ManagedBean
@RequestScoped
public class SubmitOfferBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Offer offer = new Offer();

	private final String destination = PropertiesCache.getValue("destination");
	private String filePath = "";
	private String fileName = "";
	private List<String> channels;

	public String clear1(final String parentComponentId) {
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

	public String print() throws UnsupportedEncodingException {
		  OfferService offerService = new OfferService();
		  offer.setChannels(StringUtil.ListToString(channels));

		  // **************************************************************************
		  CustomerServicesImpl cs = new CustomerServicesImpl();
		  BudgetServiceImpl budgetService = new BudgetServiceImpl();

		  Map<String, Long> customerNos = cs.getNoOfCustomersWith(channels);

		  Map<String, Long> valuePerChannel = budgetService.getChannelRates();

		  System.out.println(budgetService.getBudget(channels, customerNos,valuePerChannel));

		  offer.setBudget(new Double(budgetService.getBudget(channels,
		    customerNos, valuePerChannel)));

		  offer.setChannels(StringUtil.ListToString(channels));
		  // **********************************************
		  HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		  String targetAudience = (String) httpSession.getAttribute("queryStatement");
		  System.out.println(targetAudience);
		  offer.setTargetAudience(targetAudience);
		  offerService.createOffer(offer);
		  // sendMail(to, cc , bcc, subject, body, senderName, filepath,filename);

		  // SendHtmlEmailService.sendGroupEmail(Offer.getSenderEmail(),"", "",
		  // "subject","Body");
		  String subject = "Campaign / Offer Request Confirmation";
		  String to, cc, bcc;
		  to = cc = bcc = "";

		  SendHtmlEmailService.sendGroupEmail(offer.getSenderEmail(), cc, bcc,
		    subject, Constants.getSystemsys2partner_camp_offer());
		  SendHtmlEmailService
		    .sendGroupEmail(PropertiesCache.getValue("BusinessUser"), cc,
		      "", subject, Constants
		        .getSystemsys2businessUser_camp_offer(offer
		          .getRequesterName()));

		  StringBuilder body = new StringBuilder();
		  body.append("\nRequester name:").append(getOffer().getRequesterName())
		    .append("\nSender email :").append(getOffer().getSenderEmail())
		    .append("\nFile path :").append(filePath)
		    .append("\nFile Name :").append(fileName);

		  System.out.println("__________Starting Printing_________________ ");

		  System.out.println("Data  :\n" + body.toString());

		  // clear();
		  return "CampaignCreatedSuccessfully";
		 }
	public void upload(FileUploadEvent event) {
		System.out.println("Start upload ()");
		FacesMessage msg = new FacesMessage("Success! ", event.getFile()
				.getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		setFileName(event.getFile().getFileName());
		System.out.println("event.getFile().getFileName():"
				+ event.getFile().getFileName());
		// Do what you want with the file
		try {

			copyFile(event.getFile().getFileName(), event.getFile()
					.getInputstream());
			UploadFacade.batchUpload(filePath, 1);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void copyFile(String fileName, InputStream in) {

		try {
			filePath = destination + fileName;
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

			System.out.println("New file created:" + filePath);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilepath(String filepath) {
		this.filePath = filepath;
	}

	public String getFilename() {
		return fileName;
	}

	public void setFileName(String filename) {
		this.fileName = filename;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public List<String> getChannels() {
		return channels;
	}

	public void setChannels(List<String> channels) {
		this.channels = channels;
	}

}
