package com.ikonsoft.utils.Entities;
/*  2:   */ 
/*  3:   */ public class User
/*  4:   */ {
/*  5:   */   private String tel;
/*  6:   */   private String name;
/*  7:   */   private String password;
/*  8:   */   private String Email;
/*  9:   */   
/* 10:   */   public User(String tel, String name, String Email, String password)
/* 11:   */   {
/* 12:21 */     this.tel = tel;
/* 13:22 */     this.name = name;
/* 14:23 */     this.Email = Email;
/* 15:24 */     this.password = password;
/* 16:   */   }
/* 17:   */   
/* 18:   */   public void setTel(String tel)
/* 19:   */   {
/* 20:28 */     this.tel = tel;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public void setName(String name)
/* 24:   */   {
/* 25:32 */     this.name = name;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public String getTel()
/* 29:   */   {
/* 30:36 */     return this.tel;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public String getName()
/* 34:   */   {
/* 35:40 */     return this.name;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public String getPassword()
/* 39:   */   {
/* 40:44 */     return this.password;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public String getEmail()
/* 44:   */   {
/* 45:48 */     return this.Email;
/* 46:   */   }
/* 47:   */   
/* 48:   */   public void setPassword(String password)
/* 49:   */   {
/* 50:52 */     this.password = password;
/* 51:   */   }
/* 52:   */   
/* 53:   */   public void setEmail(String Email)
/* 54:   */   {
/* 55:56 */     this.Email = Email;
/* 56:   */   }
/* 57:   */ }


/* Location:           C:\Users\mohamed\Desktop\final\AppSimulation\WEB-INF\classes\
 * Qualified Name:     Entities.User
 * JD-Core Version:    0.7.0.1
 */