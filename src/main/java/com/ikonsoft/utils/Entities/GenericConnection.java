package com.ikonsoft.utils.Entities;
/*  2:   */ 
/*  3:   */ import java.sql.Connection;
/*  4:   */ import java.sql.DriverManager;
/*  5:   */ import java.sql.SQLException;
/*  6:   */ import java.util.logging.Level;
/*  7:   */ import java.util.logging.Logger;
/*  8:   */ 
/*  9:   */ public class GenericConnection
/* 10:   */ {
/* 11:19 */   private static String DBName = "citystars";
/* 12:20 */   private static String DBServer = "ofertasbooking.net";
/* 13:21 */   private static String DBPort = "3306";
/* 14:22 */   private static String DBUserName = "root";
/* 15:23 */   private static String DBPassword = "root";
/* 16:24 */   private static Connection DBConnection = null;
/* 17:25 */   private static String unicode = "?useUnicode=yes&characterEncoding=UTF-8";
/* 18:   */   
/* 19:   */   public static Connection getConnection()
/* 20:   */   {
/* 21:   */     try
/* 22:   */     {
/* 23:33 */       Class.forName("com.mysql.jdbc.Driver");
/* 24:34 */       String url = "jdbc:mysql://" + DBServer + ":" + DBPort + "/" + DBName;
/* 25:35 */       DBConnection = DriverManager.getConnection(url + unicode, DBUserName, DBPassword);
/* 26:   */     }
/* 27:   */     catch (SQLException ex)
/* 28:   */     {
/* 29:38 */       Logger.getLogger(GenericConnection.class.getName()).log(Level.SEVERE, null, ex);
/* 30:39 */       return null;
/* 31:   */     }
/* 32:   */     catch (ClassNotFoundException ex)
/* 33:   */     {
/* 34:41 */       Logger.getLogger(GenericConnection.class.getName()).log(Level.SEVERE, null, ex);
/* 35:42 */       return null;
/* 36:   */     }
/* 37:44 */     return DBConnection;
/* 38:   */   }
/* 39:   */ }



/* Location:           C:\Users\mohamed\Desktop\final\AppSimulation\WEB-INF\classes\

 * Qualified Name:     Entities.GenericConnection

 * JD-Core Version:    0.7.0.1

 */