package com.ikonsoft.utils.Entities;
/*  2:   */ 
/*  3:   */ import com.mysql.jdbc.Connection;
/*  4:   */ import com.mysql.jdbc.PreparedStatement;
/*  5:   */ import java.sql.ResultSet;
/*  6:   */ import java.sql.SQLException;
/*  7:   */ import java.util.ArrayList;
/*  8:   */ import java.util.logging.Level;
/*  9:   */ import java.util.logging.Logger;
/* 10:   */ 
/* 11:   */ public class UserDBConnection
/* 12:   */ {
/* 13:   */   public boolean AddUser(User user)
/* 14:   */   {
/* 15:25 */     Connection Con = (Connection)GenericConnection.getConnection();
/* 16:   */     try
/* 17:   */     {
/* 18:28 */       PreparedStatement Statment = (PreparedStatement)Con.prepareStatement("INSERT INTO whatsapp_accounts (name,phone, email, password) VALUES (?, ?,?,?)");
/* 19:   */       
/* 20:30 */       Statment.setString(1, user.getName());
/* 21:31 */       Statment.setString(2, user.getTel());
/* 22:32 */       Statment.setString(3, user.getEmail());
/* 23:33 */       Statment.setString(4, user.getPassword());
/* 24:34 */       int res = Statment.executeUpdate();
/* 25:35 */       if (res != 1) {
/* 26:36 */         return false;
/* 27:   */       }
/* 28:   */     }
/* 29:   */     catch (SQLException ex)
/* 30:   */     {
/* 31:39 */       Logger.getLogger(UserDBConnection.class.getName()).log(Level.SEVERE, null, ex);
/* 32:40 */       return false;
/* 33:   */     }
/* 34:   */     PreparedStatement Statment;
/* 35:42 */     return true;
/* 36:   */   }
/* 13:   */   public boolean UpdatAdmin(User user)
/* 14:   */   {
/* 15:25 */     Connection Con = (Connection)GenericConnection.getConnection();
/* 16:   */     try
/* 17:   */     {
/* 18:28 */       PreparedStatement Statment = (PreparedStatement)Con.prepareStatement("update whatsapp_admin set tel=?,password=?");
/* 19:   */       
/* 21:31 */       Statment.setString(1, user.getTel());
/* 23:33 */       Statment.setString(2, user.getPassword());
/* 24:34 */       int res = Statment.executeUpdate();
/* 25:35 */       if (res != 1) {
/* 26:36 */         return false;
/* 27:   */       }
/* 28:   */     }
/* 29:   */     catch (SQLException ex)
/* 30:   */     {
/* 31:39 */       Logger.getLogger(UserDBConnection.class.getName()).log(Level.SEVERE, null, ex);
/* 32:40 */       return false;
/* 33:   */     }
/* 34:   */     PreparedStatement Statment;
/* 35:42 */     return true;
/* 36:   */   }

/* 37:   */   
/* 38:   */   public ArrayList<User> GetAllRegisteredUsers()
/* 39:   */   {
/* 40:46 */     Connection Con = (Connection)GenericConnection.getConnection();
/* 41:47 */     ArrayList<User> users = new ArrayList();
/* 42:   */     try
/* 43:   */     {
/* 44:50 */       PreparedStatement Statment = (PreparedStatement)Con.prepareStatement("SELECT * FROM whatsapp_accounts");
/* 45:51 */       ResultSet res = Statment.executeQuery();
/* 46:52 */       while (res.next())
/* 47:   */       {
/* 48:53 */         User user = new User(res.getString("name"), res.getString("phone"), res.getString("email"), res.getString("password"));
/* 49:54 */         users.add(user);
/* 50:   */       }
/* 51:   */     }
/* 52:   */     catch (SQLException ex)
/* 53:   */     {
/* 54:57 */       Logger.getLogger(UserDBConnection.class.getName()).log(Level.SEVERE, null, ex);
/* 55:58 */       return null;
/* 56:   */     }
/* 57:   */     PreparedStatement Statment;
/* 58:60 */     return users;
/* 59:   */   }
/* 38:   */   public ArrayList<User> GetAdmin()
/* 39:   */   {
/* 40:46 */     Connection Con = (Connection)GenericConnection.getConnection();
/* 41:47 */     ArrayList<User> users = new ArrayList();
/* 42:   */     try
/* 43:   */     {
/* 44:50 */       PreparedStatement Statment = (PreparedStatement)Con.prepareStatement("SELECT * FROM whatsapp_admin");
/* 45:51 */       ResultSet res = Statment.executeQuery();
/* 46:52 */       while (res.next())
/* 47:   */       {
/* 48:53 */         User user = new User("", res.getString("tel"), "", res.getString("password"));
/* 50:   */      /* 49:54 */         users.add(user);


}
/* 51:   */     }
/* 52:   */     catch (SQLException ex)
/* 53:   */     {
/* 54:57 */       Logger.getLogger(UserDBConnection.class.getName()).log(Level.SEVERE, null, ex);
/* 55:58 */       return null;
/* 56:   */     }
/* 57:   */     PreparedStatement Statment;
/* 58:60 */     return users;
/* 59:   */   }

/* 60:   */ }



/* Location:           C:\Users\mohamed\Desktop\final\AppSimulation\WEB-INF\classes\

 * Qualified Name:     Entities.UserDBConnection

 * JD-Core Version:    0.7.0.1

 */