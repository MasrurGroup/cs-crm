package com.ikonsoft.mbeans;

import java.io.Serializable;

import java.util.List;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;




import com.ikonsoft.model.Channel;
import com.ikonsoft.services.ChannelService;



@ManagedBean
public class ChannelView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Channel> channels;

	private Channel selectedChannel;

	private ChannelService ChannelService = new ChannelService();

	@PostConstruct
	public void init() {
		setChannels(ChannelService.getAll());

	}

	public String updateValue(Channel channel) {
		int res = ChannelService.updateChannel(channel);
		if (res > 0)
			return "ProjectBudgetAdjustment";
		else
			return "Home";

	}

	public void printReport() {

		/*String reportSource = "Cherry_1.jrxml";
		String reportDest = "Cherry_1.html";
		connect();
		Map mpDetailSp;

		try {
			mpDetailSp = new HashMap();

			
			 * JasperCompileManager.compileReport(reportSource);
			 * System.out.println("After Compile report"); JasperPrint
			 * jasperPrint = JasperFillManager.fillReport( reportSource,
			 * mpDetailSp, new JREmptyDataSource());
			 * System.out.println("After Fill report");
			 * JasperExportManager.exportReportToHtmlFile( jasperPrint,
			 * reportDest);
			 * System.out.println("After exportReportToHtmlFile report");
			 * JasperViewer.viewReport(jasperPrint);
			 * System.out.println("After viewReport report");
			 
			Connection objDbCon = null;
			objDbCon = connect();
			System.out.println("Connection Sucessfull");
			
			 * JRFileVirtualizer virtualizer = new JRFileVirtualizer(5000);
			 * JRAbstractLRUVirtualizer virtualizer = null; virtualizer = new
			 * JRFileVirtualizer(2, "D:\\tmp");
			 
			// mpDetailSp.put("@a_i_lang_Id",new Integer("1"));
			mpDetailSp.put("ctxt_user", new String("ususer"));
			mpDetailSp.put("ctxt_language", new Integer("1"));
			mpDetailSp.put("ctxt_service", new String("ser"));
			mpDetailSp.put("invoicenumber", new String("123"));
			mpDetailSp.put("guid", new String("1234"));
			mpDetailSp.put("ctxt_ouinstance", new Integer("216"));
			// mpDetailSp.put(JRParameter.REPORT_VIRTUALIZER, virtualizer);
			System.out.println("Before Run Report");
			JasperRunManager
					.runReportToPdfFile(
							"D:\\CityStars\\cs-crm\\src\\main\\webapp\\reports\\Citystars_customer.jasper",
							"D:\\output\\Citystars_customer.pdf", mpDetailSp,
							objDbCon);
			JasperRunManager
					.runReportToPdfFile(
							"D:\\CityStars\\cs-crm\\src\\main\\webapp\\reports\\Budget_Status_Report.jasper",
							"D:\\output\\Budget_Status_Report.pdf", mpDetailSp,
							objDbCon);
			JasperRunManager
					.runReportToPdfFile(
							"D:\\CityStars\\cs-crm\\src\\main\\webapp\\reports\\Campaign_Detailed_Report.jasper",
							"D:\\output\\Campaign_Detailed_Report.pdf",
							mpDetailSp, objDbCon);
			JasperRunManager
					.runReportToPdfFile(
							"D:\\CityStars\\cs-crm\\src\\main\\webapp\\reports\\Channel_Revenue_Report.jasper",
							"D:\\output\\Channel_Revenue_Report.pdf",
							mpDetailSp, objDbCon);
			// JasperRunManager.runReportToPdfFile("D:\\CityStars\\cs-crm\\src\\main\\webapp\\reports\\Customer_Profile_Report.jasper",
			// "D:\\output\\Customer_Profile_Report.pdf", mpDetailSp, objDbCon);
			JasperRunManager
					.runReportToPdfFile(
							"D:\\CityStars\\cs-crm\\src\\main\\webapp\\reports\\Partner_Registration_Report.jasper",
							"D:\\output\\Partner_Registration_Report.pdf",
							mpDetailSp, objDbCon);
			JasperRunManager
					.runReportToPdfFile(
							"D:\\CityStars\\cs-crm\\src\\main\\webapp\\reports\\Partner_Revenue_Report.jasper",
							"D:\\output\\Partner_Revenue_Report.pdf",
							mpDetailSp, objDbCon);
			JasperRunManager
					.runReportToPdfFile(
							"D:\\CityStars\\cs-crm\\src\\main\\webapp\\reports\\Shopper_Profiles.jasper",
							"D:\\output\\Shopper_Profiles.pdf", mpDetailSp,
							objDbCon);

			System.out.println("Aftre Run Report");
		}

		catch (JRException ex) {
			System.out.println("Inside JRException");
			ex.printStackTrace();
		} catch (java.lang.OutOfMemoryError e) {
			System.out.println("Inside OutOfMemoryError");
			try {

			} finally {
				
				 * System.out.println("Inside Finally"); String[] command = {
				 * "cmd.exe", "/C", "Start", "D:\\javafiles\\Test.bat" };
				 * Process child = Runtime.getRuntime().exec(command);
				 
			}
		} catch (Exception e) {
			System.out.println("Inside Exception");
			// e.printStackTrace();
			System.out.println("EXCEPTION MESSAGE : " + e.toString());
			throw e;

		}

	}

	public static Connection connect() {
		Connection connection = null;
		System.out
				.println("-------- MySQL JDBC Connection Testing ------------");

		try {
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("MySQL JDBC Driver Registered!");
			connection = null;

			try {
				connection = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/citystars",
								"root", "root");

			} catch (SQLException e) {
				System.out.println("Connection Failed! Check output console");
				e.printStackTrace();
				return connection;
			}

			if (connection != null) {
				System.out
						.println("You made it, take control your database now!");
			} else {
				System.out.println("Failed to make connection!");
			}
			return connection;
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return connection;
		}*/
	}

	public String updateTimeStamp(Channel channel) {
		int res = ChannelService.updateChannelTimeStamp(channel);
		if (res > 0)
			return "ProjectBudgetAdjustment";
		else
			return "Home";

	}

	public String updateValidFrom(Channel channel) {
		int res = ChannelService.updateChannelValidFrom(channel);
		if (res > 0)
			return "ProjectBudgetAdjustment";
		else
			return "Home";

	}

	public String updateExpiryDate(Channel channel) {
		int res = ChannelService.updateChannelExpiryDate(channel);
		if (res > 0)
			return "ProjectBudgetAdjustment";
		else
			return "Home";

	}

	public String updateName(Channel channel) {
		int res = ChannelService.updateChannelName(channel);
		if (res > 0)
			return "ProjectBudgetAdjustment";
		else
			return "Home";

	}

	public void executeChannel(Channel Channel) {
		System.out.println("Channel Executed = " + Channel.getChannelId());
	}

	public void setService(ChannelService service) {
		this.ChannelService = service;

	}

	public Channel getSelectedChannel() {
		return selectedChannel;
	}

	public void setSelectedChannel(Channel selectedChannel) {
		this.selectedChannel = selectedChannel;
	}

	public List<Channel> getChannels() {
		return channels;
	}

	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}

}
