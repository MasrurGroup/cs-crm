package com.ikonsoft.mbeans.user.partner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
 
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.ikonsoft.utils.PropertiesCache;


@ManagedBean
@ViewScoped
public class PartnerDbUploadMB implements Serializable  {

	 
	private static final long serialVersionUID = 1L;
		private String filename;
	    private String sender;
	    private String subject;
	    private String filepath;

	    private String destination = PropertiesCache.getValue("destination");
	    
	    private UploadedFile file;
	    
	    public UploadedFile getFile() {
	        return file;
	    }
	 
	    public void setFile(UploadedFile file) {
	        this.file = file;
	    }
	     
	 

	     public void send() {
	        filepath=destination+filename;
	        System.out.println("File path is:"+filepath);
	  
	     }
	    public void upload(FileUploadEvent event) {
	        FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        filename=event.getFile().getFileName();
	// Do what you want with the file
	        try {

	            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());

	        } catch (IOException e) {

	            e.printStackTrace();
	        }
	    }

	    public void copyFile(String fileName, InputStream in) {

	        try {

	        // write the inputStream to a FileOutputStream
	            OutputStream out = new FileOutputStream(new File(destination + fileName));

	            int read = 0;
	            byte[] bytes = new byte[1024];

	            while ((read = in.read(bytes)) != -1) {

	                out.write(bytes, 0, read);
	            }

	            in.close();

	            out.flush();

	            out.close();

	            System.out.println("New file Uploaded:"+filepath);
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	    }

	  
	    
	    
	    public String getFilepath() {
	        return filepath;
	    }

	    /**
	     * @param filepath the filepath to set
	     */
	    public void setFilepath(String filepath) {
	        this.filepath = filepath;
	    }

	    /**
	     * @return the sender
	     */
	    public String getSender() {
	        return sender;
	    }

	    /**
	     * @param sender the sender to set
	     */
	    public void setSender(String sender) {
	        this.sender = sender;
	    }

	    /**
	     * @return the subject
	     */
	    public String getSubject() {
	        return subject;
	    }

	    /**
	     * @param subject the subject to set
	     */
	    public void setSubject(String subject) {
	        this.subject = subject;
	    }
 
	    /**
	     * @return the filename
	     */
	    public String getFilename() {
	        return filename;
	    }

	    /**
	     * @param filename the filename to set
	     */
	    public void setFilename(String filename) {
	        this.filename = filename;
	    }
	}

