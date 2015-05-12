package com.ikonsoft.utils.org.alternadev.whatsup;
/*  2:   */ 
/*  3:   */ public class Base64
/*  4:   */ {
/*  5: 4 */   private static final char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
/*  6: 5 */     .toCharArray();
/*  7: 6 */   private static int[] toInt = new int['1'];
/*  8:   */   
/*  9:   */   static
/* 10:   */   {
/* 11: 9 */     for (int i = 0; i < ALPHABET.length; i++) {
/* 12:10 */       toInt[ALPHABET[i]] = i;
/* 13:   */     }
/* 14:   */   }
/* 15:   */   
/* 16:   */   public static String encode(String string)
/* 17:   */   {
/* 18:22 */     byte[] buf = string.getBytes();
/* 19:23 */     int size = buf.length;
/* 20:24 */     char[] ar = new char[(size + 2) / 3 * 4];
/* 21:25 */     int a = 0;
/* 22:26 */     int i = 0;
/* 23:27 */     while (i < size)
/* 24:   */     {
/* 25:28 */       byte b0 = buf[(i++)];
/* 26:29 */       byte b1 = i < size ? buf[(i++)] : 0;
/* 27:30 */       byte b2 = i < size ? buf[(i++)] : 0;
/* 28:   */       
/* 29:32 */       int mask = 63;
/* 30:33 */       ar[(a++)] = ALPHABET[(b0 >> 2 & mask)];
/* 31:34 */       ar[(a++)] = ALPHABET[((b0 << 4 | (b1 & 0xFF) >> 4) & mask)];
/* 32:35 */       ar[(a++)] = ALPHABET[((b1 << 2 | (b2 & 0xFF) >> 6) & mask)];
/* 33:36 */       ar[(a++)] = ALPHABET[(b2 & mask)];
/* 34:   */     }
/* 35:38 */     switch (size % 3)
/* 36:   */     {
/* 37:   */     case 1: 
/* 38:40 */       ar[(--a)] = '=';
/* 39:   */     case 2: 
/* 40:42 */       ar[(--a)] = '=';
/* 41:   */     }
/* 42:44 */     return new String(ar);
/* 43:   */   }
/* 44:   */   
/* 45:   */   public static String decode(String base64)
/* 46:   */   {
/* 47:55 */     int delta = base64.endsWith("=") ? 1 : base64.endsWith("==") ? 2 : 0;
/* 48:56 */     byte[] buffer = new byte[base64.length() * 3 / 4 - delta];
/* 49:57 */     int mask = 255;
/* 50:58 */     int index = 0;
/* 51:59 */     for (int i = 0; i < base64.length(); i += 4)
/* 52:   */     {
/* 53:60 */       int c0 = toInt[base64.charAt(i)];
/* 54:61 */       int c1 = toInt[base64.charAt(i + 1)];
/* 55:62 */       buffer[(index++)] = ((byte)((c0 << 2 | c1 >> 4) & mask));
/* 56:63 */       if (index >= buffer.length) {
/* 57:64 */         return new String(buffer);
/* 58:   */       }
/* 59:66 */       int c2 = toInt[base64.charAt(i + 2)];
/* 60:67 */       buffer[(index++)] = ((byte)((c1 << 4 | c2 >> 2) & mask));
/* 61:68 */       if (index >= buffer.length) {
/* 62:69 */         return new String(buffer);
/* 63:   */       }
/* 64:71 */       int c3 = toInt[base64.charAt(i + 3)];
/* 65:72 */       buffer[(index++)] = ((byte)((c2 << 6 | c3) & mask));
/* 66:   */     }
/* 67:74 */     return new String(buffer);
/* 68:   */   }
/* 69:   */ }


/* Location:           C:\Users\mohamed\Desktop\final\AppSimulation\WEB-INF\classes\
 * Qualified Name:     org.alternadev.whatsup.Base64
 * JD-Core Version:    0.7.0.1
 */