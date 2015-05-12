package com.ikonsoft.utils;

import org.apache.commons.lang.time.DateUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Uuid {

	public static void main(String[] args) {

		for (int i = 0; i < 1; i++) {
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			// System.out.println("uuid = " + uuid+
			// "\t\t\tlength: "+uuid.length());
		}

		Date date_of_registration = new Date(); // Offer Date

		String Expiry_Date = "30 days from the date of registration";

		String CustomerName = "Full Customer Name";

		String Offer_Type = "Gift";

		String VoucherCode = "786 XXX XXX";

		Calendar cal = Calendar.getInstance();
		// Date afterOneMonthDate=new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Date today;

		SimpleDateFormat formatter;
		String pattern = " EEEE dd/M/yyyy";
		formatter = new SimpleDateFormat(pattern);

		today = new Date();
		String s_date_now = formatter.format(today);

		System.out.println(" \nToday  " + s_date_now);

		// System.out.println("\n_______________________" );
		// System.out.println(date );

		Date afterOneMonthDate = DateUtils.addMonths(today, 1);
		String s_afterOneMonthDate = formatter.format(afterOneMonthDate);
		System.out.println("\t" + s_afterOneMonthDate);

		StringBuilder system_to_customer = new StringBuilder();
		system_to_customer
				.append("<table class=MsoTableGrid border=1 cellspacing=0 cellpadding=0")
				.append("style='margin-left:-.25pt;border-collapse:collapse;border:none;mso-border-alt:")
				.append("solid windowtext .5pt;mso-yfti-tbllook:1184;mso-padding-alt:0in 5.4pt 0in 5.4pt'>")
				.append(" <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'> "
						+ "  ")
				.append("  <td width=200 valign=top style='width:150.25pt;border:solid windowtext 1.0pt;")
				.append("   border-right:none;mso-border-top-alt:solid windowtext "
						+ ".5pt;mso-border-left-alt:")
				.append(" solid windowtext .5pt;mso-border-bottom-alt:solid windowtext"
						+ " .5pt;padding:")
				.append("  0in 5.4pt 0in 5.4pt'>")
				.append(" <p class=MsoNormal style='margin-bottom:0in;margin-bottom:.0001pt;line-height:")
				.append(" normal'><span lang=EN-GB style='mso-fareast-language:EN-GB;mso-no-proof:yes'>"
						+ "&nbsp;</span></p>")
				.append(" <p class=MsoNormal style='margin-bottom:0in;margin-bottom:.0001pt;"
						+ "line-height:")
				.append("normal'><span style='mso-ansi-language:EN-US;mso-no-proof:yes'>"
						+ " ")
				.append(" <img width=168 height=41")
				.append(" src=\"http://perfect-technology.com/cs/img/logo.png\" v:shapes=\"Picture_x0020_1\">")
				.append(" </td> <td width=401 colspan=2 valign=top style='width:300.55pt;border:"
						+ "solid windowtext 1.0pt;")
				.append("border-left:none;mso-border-top-alt:solid windowtext .5pt;mso-border-bottom-alt:")
				.append(" solid windowtext .5pt;mso-border-right-alt:solid windowtext"
						+ " .5pt;padding:")
				.append(" 0in 5.4pt 0in 5.4pt'>")
				.append("<p class=MsoNoSpacing align=center style='text-align:center'><span")
				.append("  lang=EN-GB style='font-size:8.0pt'>&nbsp;</span>"
						+ "</p>")
				.append(" <p class=MsoNoSpacing align=center style='text-align:center'><i><span")
				.append(" lang=EN-GB style='font-size:8.0pt'>You MUST print the (Voucher(s)"
						+ " and bring")
				.append("  them with you.</span></i></p>")
				.append("   </td> </tr> <tr style='mso-yfti-irow:1'> <td width=200 rowspan=7 valign=top style='width:150.25pt;"
						+ "border:solid windowtext 1.0pt;")
				.append(" border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;")
				.append("  padding:0in 5.4pt 0in 5.4pt'>  <p class=MsoNormal align=center style='margin-bottom:0in;"
						+ "margin-bottom:.0001pt;")
				.append("text-align:center;line-height:normal'><span lang=EN-GB style='mso-fareast-language:")
				.append("  EN-GB;mso-no-proof:yes'" + ">&nbsp;</span></p>")
				.append("  <p class=MsoNormal align=center style='margin-bottom:0in;margin-bottom:.0001pt;")
				.append("  text-align:center;line-height:normal'><span lang=EN-GB "
						+ " style='mso-fareast-language:")
				.append("   EN-GB;mso-no-proof:yes'>UNIQE CODE</span></p>")
				.append(" </td>  <td width=401 colspan=2 valign=top style='width:300.55pt"
						+ ";border:none;")
				.append("  border-right:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;")
				.append("  mso-border-left-alt:solid windowtext"
						+ " .5pt;mso-border-top-alt:solid windowtext .5pt;")
				.append("   mso-border-left-alt:solid windowtext .5pt;mso-border-"
						+ "right-alt:solid windowtext .5pt;")
				.append("  background:#1F4E79;mso-background-themecolor:accent1;mso-background"
						+ "-themeshade:")
				.append(" 128;padding:0in 5.4pt 0in 5.4pt'>")
				.append(" <p class=MsoNormal align=center style='margin-bottom:0in;margin-bottom:"
						+ ".0001pt;")
				.append(" text-align:center;line-height:normal'><b><span lang=EN-GB style='font-size:")
				.append(" 8.0pt;color:white;mso-themecolor:background1'>PRINT ALL VOUCHER</span>"
						+ "<span")
				.append("  lang=EN-GB></span></b></p>  </td> </tr> <tr style='mso-yfti-irow:2'>")
				.append("  <td width=112 valign=top style='width:83.65pt;border:"
						+ "  none;border-top:solid windowtext 1.0pt;")
				.append("  mso-border-left-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;")
				.append(" mso-border-left-alt:solid"
						+ " windowtext .5pt;padding:0in 5.4pt 0in 5.4pt'>")
				.append("  <p class=MsoNormal style='margin-bottom:0in;margin-"
						+ "bottom:.0001pt;line-height:")
				.append("   normal'><b><span lang=EN-GB>Offer Date: </span></b></p>  </td>")
				.append("  <td width=289 valign=top style='width:216.9pt;border:none;border-"
						+ "right:solid windowtext 1.0pt;")
				.append("   mso-border-top-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;")
				.append("  mso-border-right-alt:solid windowtext"
						+ " .5pt;padding:0in 5.4pt 0in 5.4pt'>")
				.append(" <p class=MsoNormal style='margin-bottom:0in;margin-bottom:.0001pt;line-height:")
				.append("   normal'><i><span lang=EN-GB style='color:red'>("
						+ date_of_registration + " )</span></i></p>")
				.append("   </td> </tr> <tr style='mso-yfti-irow:3'>")
				.append("   <td width=112 valign=top style='width:83.65pt;border:"
						+ "none;mso-border-left-alt:")
				.append("   solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt'>")
				.append("  <p class=MsoNormal "
						+ "style='margin-bottom:0in;margin-bottom:.0001pt;line-height:")
				.append("  normal'><b><span lang=EN-GB>Expiry Date:</span>"
						+ "</b></p></td>")
				.append(" <td width=289 valign=top style='width:216.9pt;border:none;border-right:  solid   windowtext 1.0pt;")
				.append("   mso-border-right-alt:solid windowtext"
						+ " .5pt;padding:0in 5.4pt 0in 5.4pt'>")
				.append("   <p class=MsoNormal style='margin-bottom:0in;margin-bottom:.0001pt;line-height:")
				.append("   normal'><i><span lang=EN-GB "
						+ "style='color:red'>(" + Expiry_Date
						+ ")</span></i><span lang=EN-GB></span></p>")
				.append("   </td> </tr> <tr style='mso-yfti-irow:4'> <td width=112 valign=top"
						+ " style='width:83.65pt;border:none;mso-border-left-alt:")
				.append("  solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt'>")
				.append("   <p class=MsoNormal style='margin-bottom:0in;margin-bottom:.0001pt;line-height:")
				.append(" "
						+ " normal'><b><span lang=EN-GB>Name:</span></b></p>")
				.append("  </td> <td width=289 valign=top style='width:216.9pt;border:none;border-right:solid"
						+ " windowtext 1.0pt;")
				.append("   mso-border-right-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt'>")
				.append("   <p class=MsoNormal style="
						+ "'margin-bottom:0in;margin-bottom:.0001pt;line-height:")
				.append("  normal'><i><span lang=EN-GB style='color:red'>("
						+ CustomerName + ")" + "</span><span")
				.append("   lang=EN-GB></span></i></p></td></tr> <tr style='mso-yfti-irow:5'>")
				.append(" <td width=112 valign=top style='width:83.65pt;border:none;mso-border-left-alt:")
				.append("  solid windowtext .5pt;padding:0in"
						+ " 5.4pt 0in 5.4pt'>")
				.append(" <p class=MsoNormal style='margin-bottom:0in;margin-bottom:.0001pt;line-height:")
				.append("  normal'><b><span lang=EN-GB>"
						+ "Offer Type:</span></b></p>")
				.append("   </td><td width=289 valign=top style='width:216.9pt;border:none;border-right:solid windowtext 1.0pt;")
				.append("  mso-border-right-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt'>")
				.append("  <p class=MsoNormal"
						+ " style='margin-bottom:0in;margin-bottom:.0001pt;line-height:")
				.append("  normal'><i><span lang=EN-GB style='color:red'>( "
						+ Offer_Type
						+ ")</span><span lang=EN-GB></span></i></p>")
				.append(" </td></tr> <tr style='mso-yfti-irow:6'><td width=112 valign=top "
						+ "style='width:83.65pt;border:none;mso-border-left-alt:")
				.append("   solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt'>")
				.append(" "
						+ "  <p class=MsoNormal style='margin-bottom:0in;margin-bottom:.0001pt;line-height:")
				.append("   normal'><b><span lang=EN-GB>"
						+ "Voucher Code:</span></b></p>")
				.append("   </td>  <td width=289 valign=top style='width:216.9pt;border:none;border-right:solid windowtext 1.0pt;")
				.append(" "
						+ " mso-border-right-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt'>")
				.append("  <p class=MsoNormal style='margin-bottom:0in;margin-bottom:.0001pt;line-height:")
				.append("  normal'>" + "<i><span lang=EN-GB style='color:red'>"
						+ VoucherCode + " <span class=SpellE>XXX</span>")
				.append("  </span><span lang=EN-GB></span></i></p></td> </tr>"
						+ " <tr style='mso-yfti-irow:7'>")
				.append("  <td width=401 colspan=2 valign=top style='width:300.55pt;border-top:none;")
				.append("  border-left:none;border"
						+ "-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;")
				.append("  mso-border-left-alt:solid windowtext .5pt;mso-border-left-alt:solid"
						+ " windowtext .5pt;")
				.append("  mso-border-bottom-alt:solid windowtext .5pt;mso-border-right-alt:solid windowtext .5pt;")
				.append("  padding:0in 5.4pt 0in 5.4pt'>"
						+ "  <p class=MsoNormal style='margin-bottom:0in;margin-bottom:.0001pt;line-height:")
				.append("  normal'><span lang=EN-GB>&nbsp;</span></p></td>")
				.append(" </tr>"
						+ " <tr style='mso-yfti-irow:8'> <td width=601 colspan=3 valign=top style='width:450.8pt;border:solid windowtext 1.0pt;")
				.append("  border-top:none;mso-border"
						+ "-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt'> ")
				.append("  <p class=MsoNormal style='margin-bottom"
						+ ":0in;margin-bottom:.0001pt;line-height:")
				.append("  normal'><b><span lang=EN-GB>Ticket Redemption Instructions:</span></b>"
						+ "</p>")
				.append("  <p class=MsoNormal style='margin-bottom:0in;margin-bottom:.0001pt;text-align:")
				.append(" justify;line-height:normal'>"
						+ "<span lang=EN-GB style='font-size:8.0pt'>Validate")
				.append("   your email registration to activate your ticket. "
						+ "Please bring your National")
				.append("   ID card to receive your Gift offer in person. You may be asked to provide ")
				.append("   further information to complete"
						+ " your registration. Call 16478 at least 24 ")
				.append("   hours prior to the expiry date to re-validate your Voucher.<span  style='mso-spacerun:yes'> "
						+ " </span></span></p>")
				.append("  <p class=MsoNormal style='margin-bottom:0in;margin-bottom:.0001pt;text-align:")
				.append(" justify;line-height:normal'>"
						+ "<span lang=EN-GB style='font-size:8.0pt'>&nbsp;</span></p>")
				.append("   <p class=MsoNormal dir=RTL style='margin-bottom:0in;margin-bottom:.0001pt;")
				.append("   text" + "-align:justify;line-height:normal;")
				.append("   tab-stops:45.8pt 91.6pt 137.4pt 183.2pt 229.0pt 274.8pt 320.6pt 366.4pt 412.2pt "
						+ "458.0pt 503.8pt 549.6pt 595.4pt 641.2pt 687.0pt 732.8pt; background:white;direction:rtl;unicode-bidi:embed'>")
				.append("  <span lang=AR-SA  "
						+ "style='font-size:8.0pt;font-family:\"Arial\",sans-serif;mso-ascii-font-family:")
				.append("  Calibri;mso-ascii-theme-font:minor-latin;mso-hansi-font-family:"
						+ "Calibri;")
				.append("  mso-hansi-theme-font:minor-latin;mso-bidi-font-family:Arial;mso-bidi-theme-font:")
				.append("  minor-bidi'>"
						+ " &#1578;&#1581;&#1602;&#1602; &#1605;&#1606; &#1589;&#1581;&#1577;")
				.append(" &#1578;&#1587;&#1580;&#1610;&#1604;")
				.append("  &#1575" + ";&#1604;&#1576;&#1585;&#1610;&#1583;")
				.append("  &#1575;&#1604;&#1575;&#1604;&#1603;&#1578;&#1585;&#1608;&#1606;&#1610;")
				.append("   &#1575;&#1604;&#1582;&#1575;&#1589;"
						+ "&#1576;&#1603;")
				.append("  &#1604;&#1578;&#1601;&#1593;&#1610;&#1604; ")
				.append("   &#1575;&#1604;&#1578;&#1584;&#1603;&#1585;&#1577; .")
				.append("   &#1610;&#1585;&#1580;&#1609; &#1573;&#1581;"
						+ "&#1590;&#1575;&#1585;")
				.append("   &#1576;&#1591;&#1575;&#1602;&#1577; &#1575;&#1604;&#1585;&#1602;&#1605;")
				.append("   &#1575;&#1604;&#1602;&#1608;&#1605;&#1609;")
				.append(" " + "  &#1604;&#1578;&#1604;&#1602;&#1610;"
						+ " &#1607;&#1583;&#1610;&#1577;")
				.append("  &#1575;&#1604;&#1593;&#1585;&#1590; &#1575;&#1604;&#1582;&#1575;&#1589;")
				.append(" "
						+ " &#1576;&#1603; &#1588;&#1582;&#1589;&#1610;&#1575; . &#1602;&#1583;")
				.append("  &#1610;&#1591;&#1604;&#1576;"
						+ " &#1605;&#1606;&#1603;")
				.append("  &#1578;&#1602;&#1583;&#1610;&#1605;")
				.append("  &#1575;&#1604;&#1605;&#1586;&#1610;&#1583; &#1605;&#1606;")
				.append("  &#1575;&#1604;&#1605;&"
						+ "#1593;&#1604;&#1608;&#1605;&#1575;&#1578;")
				.append("  &#1604;&#1575;&#1587;&#1578;&#1603;&#1605;&#1575;&#1604;")
				.append("  &#1575;&#1604;&#1578;&#1587;&#1580;&#1610;&#1604;. &#1575;&#1578;&#1589;&#1604;")
				.append("  &#1576;&#1600; <span style='mso-spacerun:yes'> </span>16478 &#1602;&#1576;&#1604;")
				.append("  24 &#1587;&#1575;&#1593;&#1577; &#1593;&#1604;&#1609; &#1575;&#1604;&#1571;&#1602;&#1604;")
				.append("  &#1605;&#1606; &#1578;&#1575;&#1585;&#1610;&#1582; &#1575;&#1604;&#1575;&#1606;&#1578;&#1607;&#1575;&#1569;")
				.append("  &#1604;&#1604;&#1578;&#1580;&#1583;&#1610;&#1583;.</span><span lang=EN-GB dir=LTR style='font-size:8.0pt'></span></p>")
				.append("  <p class=MsoNormal style='margin-bottom:0in;margin-bottom:.0001pt;text-align:")
				.append("  justify;line-height:normal'><span lang=AR-SA dir=RTL style='font-size:8.0pt;")
				.append("   font-family:\"Arial\",sans-serif;mso-ascii-font-family:Calibri;mso-ascii-theme-font:")
				.append("   minor-latin;mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin;")
				.append("   mso-bidi-font-family:Arial;mso-bidi-theme-font:minor-bidi'>&nbsp;</span></p>")
				.append("  <p class=MsoNormal style='margin-bottom:0in;margin-bottom:.0001pt;text-align:")
				.append("  justify;line-height:normal'><span lang=EN-GB style='font-size:8.0pt'>&nbsp;</span></p>")
				.append("  </td> </tr> <tr style='mso-yfti-irow:9'>  <td width=601 colspan=3 valign=top style='width:450.8pt;border:solid windowtext 1.0pt;")
				.append("  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;")
				.append("  padding:0in 5.4pt 0in 5.4pt'>  <p class=MsoNormal style='margin-bottom:0in;margin-bottom:.0001pt;line-height:")
				.append("  normal'><b><span lang=EN-GB>Pick-Up Details:</span></b></p>")
				.append("  <p class=MsoNormal style='margin-bottom:0in;margin-bottom:.0001pt;line-height:")
				.append("  normal'><span class=SpellE><b><span lang=EN-GB style='font-size:8.0pt'>Citystars</span></b></span><span lang=EN-GB style='font-size:8.0pt'>  <i>(<span class=SpellE>Hilopolis</span>  Mall only)</i></span></p>")
				.append("  <p class=MsoNormal style='margin-bottom:0in;margin-bottom:.0001pt;line-height:")
				.append(" normal'><span lang=EN-GB style='font-size:8.0pt'>Customer Service"
						+ " <i>(Available at all KIOSK)</i></span></p>")
				.append("  <p class=MsoNormal style='margin-bottom:0in;margin-bottom:.0001pt;line-height:")
				.append("  normal'><span lang=EN-GB style='font-size:8.0pt'>2 Aly <span class=SpellE>Rashed St., Omar Ibn El- Khattab , Al  Manteqah ")
				.append("  Al  Oula , Nasr City, Cairo Governorate, Cairo, Egypt </p>")
				.append("  <p class=MsoNormal style='margin-bottom:0in;margin-bottom:.0001pt;line-height:")
				.append("  normal'><span lang=EN-GB>&nbsp;</span></p> </td> </tr> <tr style='mso-yfti-irow:10;mso-yfti-lastrow:yes'>")
				.append("  <td width=601 colspan=3 valign=top style='width:450.8pt;border:none;")
				.append("  mso-border"
						+ "-top-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt'>")
				.append("  <p class=MsoNormal align=right style"
						+ "='margin-bottom:0in;margin-bottom:.0001pt;")
				.append("  text-align:right;line"
						+ "-height:normal'><span lang=EN-GB style='font-size:8.0pt'>Powered by </span><span"
						+ " lang=EN-GB>")
				.append("  <a href='http://www.masrurgroup.com'><span style='font-size:8.0pt;color:#C00000'>IKONSOFT</span></a></span>")
				.append("  <span lang=EN-GB style='font-size:8.0pt'></span></p> </td> </tr></table></div>");
		// System.out.println(admin_to_customer.toString());
	}

}
