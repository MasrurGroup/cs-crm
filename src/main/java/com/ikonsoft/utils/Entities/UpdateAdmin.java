package com.ikonsoft.utils.Entities;
/*  2:   */ 

/*  3:   */ import java.io.IOException;
/*  4:   */ import java.io.PrintWriter;
/*  5:   */ import java.util.ArrayList;
/*  6:   */ import javax.servlet.ServletException;
/*  8:   */ import javax.servlet.http.HttpServlet;
/*  9:   */ import javax.servlet.http.HttpServletRequest;
/* 10:   */ import javax.servlet.http.HttpServletResponse;
/* 12:   */ 
/* 14:   */ public class UpdateAdmin
/* 15:   */   extends HttpServlet
/* 16:   */ {
/* 17:   */   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
/* 18:   */     throws ServletException, IOException
/* 19:   */   {
/* 20:37 */     response.setContentType("text/html;charset=UTF-8");
/* 21:38 */     PrintWriter out = response.getWriter();Throwable localThrowable3 = null;
/* 22:   */     try
/* 23:   */     {
    /* 27:43 */
   // WhatsAPI api = new WhatsAPI("201000420956", "UUVgbqVZV+/PnLUQS4dz3XU4NCY=", "mohamed saad");
 //api.connect();
/* 29:45 */      // api.login();
/* 32:48 */       //  api.sendMessage("1", "966535089179" , "hello");

/*Intent sendIntent = new Intent(Intent.ACTION_CALL,
          Uri.parse("tel:(+2)1000420956"));
            sendIntent.putExtra(Intent.EXTRA_TEXT, "text to send"); 
            sendIntent.setType("text/plain"); //Remove only below line startActivity(sendIntent);*/
//Replace with this line:
  /*boolean isWhatsappInstalled = whatsappInstalledOrNot("com.whatsapp");
     //   if (isWhatsappInstalled) {
            Uri uri = Uri.parse("smsto:" + "966535089179");
            Intent sendIntent = new Intent(Intent.ACTION_SENDTO, uri);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Hai Good Morning");
            sendIntent.setType("text/plain");
            sendIntent.setPackage("com.whatsapp");
            startActivity(sendIntent);
      /*  } else {
           
            Uri uri = Uri.parse("market://details?id=com.whatsapp");
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(goToMarket);

        }*/

    //sendWhatsAppMessageTo();
/* 24:40 */       User user = new User(request.getParameter("Tel"),"", "", request.getParameter("password"));
/* 25:41 */       UserDBConnection db = new UserDBConnection();
/* 26:42 */       db.UpdatAdmin(user);
/* 27:43 */     
/* 30:46 */      ArrayList<User> users = db.GetAllRegisteredUsers();
String phones="";
/* 31:47 */       for (User i : users) {
    //phones+=i.getTel();
/* 33:   */       }

/* 34:   */     }
/* 35:   */     catch (Throwable localThrowable1)
/* 36:   */     {
/* 38:38 */       localThrowable3 = localThrowable1;throw localThrowable1;/* 39:   */     }
/* 40:   */     finally
/* 41:   */     {
/* 42:50 */       if (out != null) {
/* 43:50 */         if (localThrowable3 != null) {
/* 44:   */           try
/* 45:   */           {
    out.print("admin update");
/* 46:50 */             out.close();
/* 47:   */           }
/* 48:   */           catch (Throwable localThrowable2)
/* 49:   */           {
/* 50:50 */             localThrowable3.addSuppressed(localThrowable2);
/* 51:   */           }
/* 52:   */         } else {
/* 53:50 */           out.close();
/* 54:   */         }
/* 55:   */       }
/* 56:   */     }

/* 57:   */   }
/* 58:   */   
/* 59:   */   protected void doGet(HttpServletRequest request, HttpServletResponse response)
/* 60:   */     throws ServletException, IOException
/* 61:   */   {
/* 62:65 */     processRequest(request, response);
/* 63:   */   }
/* 64:   */   
/* 65:   */   protected void doPost(HttpServletRequest request, HttpServletResponse response)
/* 66:   */     throws ServletException, IOException
/* 67:   */   {
/* 68:79 */     processRequest(request, response);
/* 69:   */   }
/* 70:   */   
/* 71:   */   public String getServletInfo()
/* 72:   */   {
/* 73:89 */     return "Short description";
/* 74:   */   }
public void sendWhatsAppMessageTo() {
/*Intent sendIntent = new Intent(android.content.Intent.ACTION_CALL, Uri.parse("tel:+21090834888"));
sendIntent.setAction(Intent.ACTION_SEND);
sendIntent.putExtra(Intent.EXTRA_TEXT, "لو وصلتك الرساالة دى كلمنى عشان اتاكد ان البرنامج شغال .");
sendIntent.setType("text/plain");
sendIntent.setPackage("com.whatsapp");

startActivity(sendIntent);
    
    

    Uri uri = Uri.parse("smsto:" + "201000420956");
            Intent sendIntent = new Intent(Intent.ACTION_SENDTO, uri);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Hai Good Morning");
            sendIntent.setType("text/plain");
            sendIntent.setPackage("com.whatsapp");
            startActivity(Intent.createChooser(sendIntent, ""));*/
      /*Uri uri = Uri.parse("smsto:" + "201000420956");
    Intent i = new Intent(Intent.ACTION_SENDTO, uri);
    i.setAction(Intent.ACTION_SEND);
i.putExtra(Intent.EXTRA_TEXT, "لو وصلتك الرساالة دى كلمنى عشان اتاكد ان البرنامج شغال .");
    i.setPackage("com.whatsapp");  
    startActivity(Intent.createChooser(i, ""));*/

}

 }



/* Location:           C:\Users\mohamed\Desktop\final\AppSimulation\WEB-INF\classes\

 * Qualified Name:     Entities.AddNewUSer

 * JD-Core Version:    0.7.0.1

 */