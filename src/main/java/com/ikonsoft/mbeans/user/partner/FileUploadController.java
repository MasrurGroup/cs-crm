package com.ikonsoft.mbeans.user.partner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
 
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import com.ikonsoft.utils.PropertiesCache;
 

@ManagedBean(name = "fileUploadController")
@SessionScoped

public class FileUploadController {
    
    private String fileName;
    private String sender;
    private String subject;
    private String to ;
    private String body;
    private String filePath;

    private String destination = PropertiesCache.getValue("destination");

   
    public void upload(FileUploadEvent event) {
    	System.out.println("Start upload ()");
        FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        setFileName(event.getFile().getFileName());
       System.out.println("event.getFile().getFileName():"+event.getFile().getFileName());
// Do what you want with the file
        try {

            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void copyFile(String fileName, InputStream in) {

        try {
        	filePath= destination + fileName;
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

            System.out.println("New file created:"+filePath);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
  
    
    
    public String getFilepath() {
        return filePath;
    }

    /**
     * @param filepath the filepath to set
     */
    public void setFilepath(String filepath) {
        this.filePath = filepath;
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
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * @return the filename
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param filename the filename to set
     */
    public void setFileName(String filename) {
        this.fileName = filename;
    }
}
