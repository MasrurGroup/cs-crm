/*   1:    */ package com.ikonsoft.utils.org.alternadev.whatsup;
/*  2:   */ 
/*  3:   */ public class InvalidTokenException
/*  4:   */   extends Exception
/*  5:   */ {
/*  6:   */   private static final long serialVersionUID = 2646L;
/*  7:   */   
/*  8:   */   public InvalidTokenException(int token)
/*  9:   */   {
/* 10:12 */     super("The token " + token + " is invalid!");
/* 11:   */   }
/* 12:   */ }


/* Location:           C:\Users\mohamed\Desktop\final\AppSimulation\WEB-INF\classes\
 * Qualified Name:     org.alternadev.whatsup.InvalidTokenException
 * JD-Core Version:    0.7.0.1
 */