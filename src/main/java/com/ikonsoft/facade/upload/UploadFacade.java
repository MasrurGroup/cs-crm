package com.ikonsoft.facade.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;

import com.ikonsoft.utils.CSVMappedToBean;
import com.ikonsoft.utils.ExcelUtils;

public class UploadFacade {
	
	
	public static void batchUpload(String filePath, int partnerId) {

		String ext = FilenameUtils.getExtension(filePath);

		switch (ext) {
		case ("txt"):
			try {
				CSVMappedToBean.uploadCSV(filePath, partnerId);break;
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("success txt");
			break;

		case ("xlsx"):
			ExcelUtils.readExcelCustomerData(filePath, partnerId);
			System.out.println("xlsx success");
			break;
			
		case ("xls"):
			ExcelUtils.readExcelCustomerData(filePath, partnerId);
			System.out.println("xls  success");
			break;
			
		case ("csv"):
			try {
				CSVMappedToBean.uploadCSV(filePath, partnerId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("success csv");
			break;
			
			
		case ("CSV"):
			try {
				CSVMappedToBean.uploadCSV(filePath, partnerId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("success CSV");
			break;
			
		default:
			System.out.println("Not Supported file type");
		}

	}// BATCHUPLOAD
	
	
	
	
	
	
	
	
	
	
	
	/*
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
	   */
	 
	    
	    
	
	
	
}// CLASS
