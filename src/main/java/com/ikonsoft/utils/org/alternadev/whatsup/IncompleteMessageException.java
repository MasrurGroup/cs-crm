/*   1:    */ package com.ikonsoft.utils.org.alternadev.whatsup;
/*  2:   */ 
/*  3:   */ public class IncompleteMessageException
/*  4:   */   extends Exception
/*  5:   */ {
/*  6:   */   private static final long serialVersionUID = 2646L;
/*  7:   */   private int[] data;
/*  8:   */   
/*  9:   */   public IncompleteMessageException(String message, int[] input)
/* 10:   */   {
/* 11:13 */     super(message);
/* 12:14 */     this.data = input;
/* 13:   */   }
/* 14:   */   
/* 15:   */   public int[] getData()
/* 16:   */   {
/* 17:18 */     return this.data;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public void setData(int[] data)
/* 21:   */   {
/* 22:22 */     this.data = data;
/* 23:   */   }
/* 24:   */ }


/* Location:           C:\Users\mohamed\Desktop\final\AppSimulation\WEB-INF\classes\
 * Qualified Name:     org.alternadev.whatsup.IncompleteMessageException
 * JD-Core Version:    0.7.0.1
 */