package com.ikonsoft.utils.org.alternadev.whatsup;
/*  2:   */ 
/*  3:   */ import java.io.IOException;
/*  4:   */ import java.io.PrintStream;
/*  5:   */ import java.util.List;
/*  6:   */ 
/*  7:   */ public class App
/*  8:   */ {
/*  9:   */   static final String PHONE_NUMBER = "";
/* 10:   */   static final String IMEI = "";
/* 11:   */   static final String USERNAME = "";
/* 12:   */   
/* 13:   */   public static void main(String[] args)
/* 14:   */     throws IOException
/* 15:   */   {
/* 16:16 */     WhatsAPI api = new WhatsAPI("", "", "");
/* 17:17 */     api.connect();
/* 18:18 */     api.login();
/* 19:19 */     api.sendMessage(System.currentTimeMillis() + "-1", "", "Was geht los darein?!");
/* 20:   */     for (;;)
/* 21:   */     {
/* 22:23 */       api.pollMessages();
/* 23:24 */       List<ProtocolNode> list = api.getMessages();
/* 24:26 */       for (ProtocolNode msg : list) {
/* 25:27 */         System.out.println(msg.nodeString());
/* 26:   */       }
/* 27:   */     }
/* 28:   */   }
/* 29:   */ }


/* Location:           C:\Users\mohamed\Desktop\final\AppSimulation\WEB-INF\classes\
 * Qualified Name:     org.alternadev.whatsup.App
 * JD-Core Version:    0.7.0.1
 */