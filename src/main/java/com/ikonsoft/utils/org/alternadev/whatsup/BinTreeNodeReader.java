package com.ikonsoft.utils.org.alternadev.whatsup;
/*   2:    */ 
/*   3:    */ import java.util.ArrayList;
/*   4:    */ import java.util.HashMap;
/*   5:    */ import java.util.List;
/*   6:    */ import java.util.Map;
/*   7:    */ 
/*   8:    */ public class BinTreeNodeReader
/*   9:    */ {
/*  10:    */   private String[] dic;
/*  11:    */   private int[] input;
/*  12:    */   
/*  13:    */   public BinTreeNodeReader(String[] dic)
/*  14:    */   {
/*  15: 13 */     this.dic = dic;
/*  16:    */   }
/*  17:    */   
/*  18:    */   public ProtocolNode nextTree()
/*  19:    */     throws InvalidTokenException, IncompleteMessageException
/*  20:    */   {
/*  21: 18 */     return nextTree(null);
/*  22:    */   }
/*  23:    */   
/*  24:    */   public ProtocolNode nextTree(int[] input)
/*  25:    */     throws InvalidTokenException, IncompleteMessageException
/*  26:    */   {
/*  27: 23 */     if (input != null) {
/*  28: 24 */       this.input = input;
/*  29:    */     }
/*  30: 25 */     int stanzaSize = peekInt16();
/*  31: 26 */     if (stanzaSize > this.input.length) {
/*  32: 27 */       throw new IncompleteMessageException("Die Message war mal so mäßig incomplete et ita. (" + stanzaSize + ", " + this.input.length + ")", this.input);
/*  33:    */     }
/*  34: 31 */     readInt16();
/*  35: 32 */     if (stanzaSize > 0) {
/*  36: 33 */       return nextTreeInternal();
/*  37:    */     }
/*  38: 34 */     return null;
/*  39:    */   }
/*  40:    */   
/*  41:    */   protected String getToken(int token)
/*  42:    */     throws InvalidTokenException
/*  43:    */   {
/*  44: 38 */     if ((token >= 0) && (token < this.dic.length)) {
/*  45: 39 */       return this.dic[token];
/*  46:    */     }
/*  47: 40 */     throw new InvalidTokenException(token);
/*  48:    */   }
/*  49:    */   
/*  50:    */   protected String readString(int token)
/*  51:    */     throws InvalidTokenException
/*  52:    */   {
/*  53: 44 */     String ret = "";
/*  54: 45 */     if (token == -1) {
/*  55: 46 */       throw new InvalidTokenException(token);
/*  56:    */     }
/*  57: 48 */     if ((token > 4) && (token < 245)) {
/*  58: 49 */       ret = getToken(token);
/*  59:    */     }
/*  60: 50 */     if (token == 0)
/*  61:    */     {
/*  62: 51 */       ret = "";
/*  63:    */     }
/*  64: 52 */     else if (token == 252)
/*  65:    */     {
/*  66: 53 */       int size = readInt8();
/*  67: 54 */       ret = fillArray(size);
/*  68:    */     }
/*  69: 55 */     else if (token == 253)
/*  70:    */     {
/*  71: 56 */       int size = readInt24();
/*  72: 57 */       ret = fillArray(size);
/*  73:    */     }
/*  74: 58 */     else if (token == 254)
/*  75:    */     {
/*  76: 59 */       int size = readInt8();
/*  77: 60 */       ret = fillArray(size + 245);
/*  78:    */     }
/*  79: 61 */     else if (token == 250)
/*  80:    */     {
/*  81: 62 */       String user = readString(readInt8());
/*  82: 63 */       String server = readString(readInt8());
/*  83: 64 */       if ((user.length() > 0) && (server.length() > 0)) {
/*  84: 65 */         ret = user + "@" + server;
/*  85: 66 */       } else if (server.length() > 0) {
/*  86: 67 */         ret = server;
/*  87:    */       }
/*  88:    */     }
/*  89: 69 */     return ret;
/*  90:    */   }
/*  91:    */   
/*  92:    */   protected Map<String, String> readAttributes(int size)
/*  93:    */     throws InvalidTokenException
/*  94:    */   {
/*  95: 74 */     Map<String, String> map = new HashMap();
/*  96: 75 */     int attribCount = (size - 2 + size % 2) / 2;
/*  97: 76 */     for (int i = 0; i < attribCount; i++)
/*  98:    */     {
/*  99: 77 */       String key = readString(readInt8());
/* 100: 78 */       String value = readString(readInt8());
/* 101: 79 */       map.put(key, value);
/* 102:    */     }
/* 103: 81 */     return map;
/* 104:    */   }
/* 105:    */   
/* 106:    */   protected ProtocolNode nextTreeInternal()
/* 107:    */     throws InvalidTokenException
/* 108:    */   {
/* 109: 85 */     int token = readInt8();
/* 110: 86 */     int size = readListSize(token);
/* 111:    */     
/* 112: 88 */     token = readInt8();
/* 113: 89 */     if (token == 1) {
/* 114: 90 */       return new ProtocolNode("start", readAttributes(size), null, "");
/* 115:    */     }
/* 116: 93 */     if (token == 2) {
/* 117: 94 */       return null;
/* 118:    */     }
/* 119: 95 */     String tag = readString(token);
/* 120: 96 */     Map<String, String> attributes = readAttributes(size);
/* 121: 97 */     if (size % 2 == 1) {
/* 122: 98 */       return new ProtocolNode(tag, attributes, null, "");
/* 123:    */     }
/* 124: 99 */     token = readInt8();
/* 125:100 */     if (isListTag(token)) {
/* 126:101 */       return new ProtocolNode(tag, attributes, readList(token), "");
/* 127:    */     }
/* 128:102 */     return new ProtocolNode(tag, attributes, null, readString(token));
/* 129:    */   }
/* 130:    */   
/* 131:    */   protected boolean isListTag(int token)
/* 132:    */   {
/* 133:106 */     return (token == 248) || (token == 0) || (token == 259);
/* 134:    */   }
/* 135:    */   
/* 136:    */   protected List<ProtocolNode> readList(int token)
/* 137:    */     throws InvalidTokenException
/* 138:    */   {
/* 139:111 */     int size = readListSize(token);
/* 140:112 */     List<ProtocolNode> ret = new ArrayList();
/* 141:113 */     for (int i = 0; i < size; i++) {
/* 142:114 */       ret.add(nextTreeInternal());
/* 143:    */     }
/* 144:115 */     return ret;
/* 145:    */   }
/* 146:    */   
/* 147:    */   protected int readListSize(int token)
/* 148:    */     throws InvalidTokenException
/* 149:    */   {
/* 150:119 */     int size = 0;
/* 151:120 */     if (token == 248) {
/* 152:121 */       size = readInt8();
/* 153:122 */     } else if (token == 249) {
/* 154:123 */       size = readInt16();
/* 155:    */     } else {
/* 156:125 */       throw new InvalidTokenException(token);
/* 157:    */     }
/* 158:128 */     return size;
/* 159:    */   }
/* 160:    */   
/* 161:    */   protected int readInt24()
/* 162:    */   {
/* 163:132 */     int ret = 0;
/* 164:133 */     if (this.input.length >= 3)
/* 165:    */     {
/* 166:134 */       ret = this.input[0] << 16;
/* 167:135 */       ret += (this.input[1] << 8);
/* 168:136 */       ret += (this.input[2] << 0);
/* 169:    */       
/* 170:138 */       removeFromInput(3);
/* 171:    */     }
/* 172:140 */     return ret;
/* 173:    */   }
/* 174:    */   
/* 175:    */   private void removeFromInput(int num)
/* 176:    */   {
/* 177:144 */     int[] karl = new int[this.input.length - num];
/* 178:145 */     for (int i = num; i < this.input.length; i++) {
/* 179:146 */       karl[(i - num)] = this.input[i];
/* 180:    */     }
/* 181:147 */     this.input = karl;
/* 182:    */   }
/* 183:    */   
/* 184:    */   protected int peekInt16()
/* 185:    */   {
/* 186:151 */     int ret = 0;
/* 187:152 */     if (this.input.length >= 2)
/* 188:    */     {
/* 189:153 */       ret = this.input[0] << 8;
/* 190:154 */       ret += (this.input[1] << 0);
/* 191:    */     }
/* 192:157 */     return ret;
/* 193:    */   }
/* 194:    */   
/* 195:    */   protected int readInt16()
/* 196:    */   {
/* 197:161 */     int ret = peekInt16();
/* 198:162 */     if (ret > 0) {
/* 199:163 */       removeFromInput(2);
/* 200:    */     }
/* 201:165 */     return ret;
/* 202:    */   }
/* 203:    */   
/* 204:    */   protected int readInt8()
/* 205:    */   {
/* 206:169 */     int ret = 0;
/* 207:170 */     if (this.input.length >= 1)
/* 208:    */     {
/* 209:171 */       ret = this.input[0];
/* 210:172 */       removeFromInput(1);
/* 211:    */     }
/* 212:175 */     return ret;
/* 213:    */   }
/* 214:    */   
/* 215:    */   protected String fillArray(int len)
/* 216:    */   {
/* 217:179 */     String ret = "";
/* 218:180 */     if (this.input.length >= len)
/* 219:    */     {
/* 220:181 */       ret = new String(intToCharArray(this.input)).substring(0, len);
/* 221:182 */       removeFromInput(len);
/* 222:    */     }
/* 223:184 */     return ret;
/* 224:    */   }
/* 225:    */   
/* 226:    */   private char[] intToCharArray(int[] in)
/* 227:    */   {
/* 228:188 */     char[] peda = new char[in.length];
/* 229:189 */     for (int i = 0; i < in.length; i++) {
/* 230:190 */       peda[i] = ((char)in[i]);
/* 231:    */     }
/* 232:191 */     return peda;
/* 233:    */   }
/* 234:    */ }


/* Location:           C:\Users\mohamed\Desktop\final\AppSimulation\WEB-INF\classes\
 * Qualified Name:     org.alternadev.whatsup.BinTreeNodeReader
 * JD-Core Version:    0.7.0.1
 */