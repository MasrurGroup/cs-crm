package com.ikonsoft.utils.org.alternadev.whatsup;
/*   2:    */ 
/*   3:    */ import java.util.HashMap;
/*   4:    */ import java.util.List;
/*   5:    */ import java.util.Map;
/*   6:    */ import java.util.Map.Entry;
/*   7:    */ 
/*   8:    */ public class BinTreeNodeWriter
/*   9:    */ {
/*  10:  7 */   private String output = "";
/*  11:    */   private Map<String, Integer> tokenMap;
/*  12:    */   
/*  13:    */   public BinTreeNodeWriter(String[] dic)
/*  14:    */   {
/*  15: 11 */     this.tokenMap = new HashMap();
/*  16: 12 */     for (int i = 0; i < dic.length; i++) {
/*  17: 13 */       if ((dic[i] != null) && 
/*  18: 14 */         (!dic[i].isEmpty())) {
/*  19: 15 */         this.tokenMap.put(dic[i], Integer.valueOf(i));
/*  20:    */       }
/*  21:    */     }
/*  22:    */   }
/*  23:    */   
/*  24:    */   public String startStream(String domain, String resource)
/*  25:    */   {
/*  26: 19 */     Map<String, String> attributes = new HashMap();
/*  27: 20 */     this.output = "WA";
/*  28: 21 */     this.output += "";
/*  29:    */     
/*  30: 23 */     attributes.put("to", domain);
/*  31: 24 */     attributes.put("resource", resource);
/*  32: 25 */     writeListStart(attributes.size() * 2 + 1);
/*  33:    */     
/*  34: 27 */     this.output += "\001";
/*  35: 28 */     writeAttributes(attributes);
/*  36: 29 */     String ret = this.output;
/*  37: 30 */     this.output = "";
/*  38:    */     
/*  39: 32 */     return ret;
/*  40:    */   }
/*  41:    */   
/*  42:    */   public String write(ProtocolNode node)
/*  43:    */   {
/*  44: 37 */     if (node == null) {
/*  45: 38 */       this.output += "";
/*  46:    */     } else {
/*  47: 40 */       writeInternal(node);
/*  48:    */     }
/*  49: 41 */     return flushBuffer();
/*  50:    */   }
/*  51:    */   
/*  52:    */   private void writeInternal(ProtocolNode node)
/*  53:    */   {
/*  54: 45 */     int len = 1;
/*  55: 46 */     if (node.attributeHash != null) {
/*  56: 47 */       len += node.attributeHash.size() * 2;
/*  57:    */     }
/*  58: 48 */     if ((node.children != null) && (node.children.size() > 0)) {
/*  59: 49 */       len++;
/*  60:    */     }
/*  61: 50 */     if (node.data.length() > 0) {
/*  62: 51 */       len++;
/*  63:    */     }
/*  64: 52 */     writeListStart(len);
/*  65: 53 */     writeString(node.tag);
/*  66: 54 */     writeAttributes(node.attributeHash);
/*  67: 55 */     if (node.data.length() > 0) {
/*  68: 56 */       writeBytes(node.data);
/*  69:    */     }
/*  70: 57 */     if ((node.children != null) && (node.children.size() > 0))
/*  71:    */     {
/*  72: 58 */       writeListStart(node.children.size());
/*  73: 59 */       for (ProtocolNode node1 : node.children) {
/*  74: 60 */         writeInternal(node1);
/*  75:    */       }
/*  76:    */     }
/*  77:    */   }
/*  78:    */   
/*  79:    */   private String flushBuffer()
/*  80:    */   {
/*  81: 66 */     int size = this.output.length();
/*  82: 67 */     String ret = writeInt16(size);
/*  83: 68 */     ret = ret + this.output;
/*  84: 69 */     this.output = "";
/*  85: 70 */     return ret;
/*  86:    */   }
/*  87:    */   
/*  88:    */   private void writeToken(int token)
/*  89:    */   {
/*  90: 74 */     if (token < 245) {
/*  91: 75 */       this.output += (char)token;
/*  92: 76 */     } else if (token <= 500) {
/*  93: 77 */       this.output = (this.output + "þ" + (char)(token - 245));
/*  94:    */     }
/*  95:    */   }
/*  96:    */   
/*  97:    */   private void writeJid(String user, String server)
/*  98:    */   {
/*  99: 81 */     this.output += "ú";
/* 100: 82 */     if (user.length() > 0) {
/* 101: 83 */       writeString(user);
/* 102:    */     } else {
/* 103: 85 */       writeToken(0);
/* 104:    */     }
/* 105: 86 */     writeString(server);
/* 106:    */   }
/* 107:    */   
/* 108:    */   private void writeInt8(int v)
/* 109:    */   {
/* 110: 90 */     this.output += (char)v;
/* 111:    */   }
/* 112:    */   
/* 113:    */   private String writeInt16(int v)
/* 114:    */   {
/* 115: 94 */     String ret = "";
/* 116: 95 */     ret = ret + (char)((v & 0xFF00) >> 8);
/* 117: 96 */     ret = ret + (char)((v & 0xFF) >> 0);
/* 118: 97 */     return ret;
/* 119:    */   }
/* 120:    */   
/* 121:    */   private void writeInt24(int v)
/* 122:    */   {
/* 123:101 */     this.output += (char)((v & 0xFF0000) >> 16);
/* 124:102 */     this.output += (char)((v & 0xFF00) >> 8);
/* 125:103 */     this.output += (char)((v & 0xFF) >> 0);
/* 126:    */   }
/* 127:    */   
/* 128:    */   private void writeBytes(String bytes)
/* 129:    */   {
/* 130:107 */     int len = bytes.length();
/* 131:108 */     if (len >= 256)
/* 132:    */     {
/* 133:109 */       this.output += "ý";
/* 134:110 */       writeInt24(len);
/* 135:    */     }
/* 136:    */     else
/* 137:    */     {
/* 138:112 */       this.output += "ü";
/* 139:113 */       writeInt8(len);
/* 140:    */     }
/* 141:115 */     this.output += bytes;
/* 142:    */   }
/* 143:    */   
/* 144:    */   private void writeString(String tag)
/* 145:    */   {
/* 146:119 */     if (this.tokenMap.get(tag) != null)
/* 147:    */     {
/* 148:120 */       Integer key = (Integer)this.tokenMap.get(tag);
/* 149:121 */       writeToken(key.intValue());
/* 150:    */     }
/* 151:    */     else
/* 152:    */     {
/* 153:123 */       int index = tag.indexOf('@');
/* 154:124 */       if (index >= 0)
/* 155:    */       {
/* 156:125 */         String server = tag.substring(index + 1);
/* 157:126 */         String user = tag.substring(0, index);
/* 158:127 */         writeJid(user, server);
/* 159:    */       }
/* 160:    */       else
/* 161:    */       {
/* 162:129 */         writeBytes(tag);
/* 163:    */       }
/* 164:    */     }
/* 165:    */   }
/* 166:    */   
/* 167:    */   private void writeAttributes(Map<String, String> attributes)
/* 168:    */   {
/* 169:134 */     if (attributes.size() > 0) {
/* 170:135 */       for (Map.Entry<String, String> entry : attributes.entrySet())
/* 171:    */       {
/* 172:136 */         writeString((String)entry.getKey());
/* 173:137 */         writeString((String)entry.getValue());
/* 174:    */       }
/* 175:    */     }
/* 176:    */   }
/* 177:    */   
/* 178:    */   private void writeListStart(int len)
/* 179:    */   {
/* 180:143 */     if (len == 0) {
/* 181:144 */       this.output += "";
/* 182:145 */     } else if (len < 256) {
/* 183:146 */       this.output = (this.output + "ø" + (char)len);
/* 184:    */     } else {
/* 185:148 */       this.output = (this.output + "ù" + (char)len);
/* 186:    */     }
/* 187:    */   }
/* 188:    */ }


/* Location:           C:\Users\mohamed\Desktop\final\AppSimulation\WEB-INF\classes\
 * Qualified Name:     org.alternadev.whatsup.BinTreeNodeWriter
 * JD-Core Version:    0.7.0.1
 */