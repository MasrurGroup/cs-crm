/*   1:    */ package com.ikonsoft.utils.org.alternadev.whatsup;
/*   2:    */ 
/*   3:    */ import java.io.BufferedOutputStream;
/*   4:    */ import java.io.IOException;
/*   5:    */ import java.io.InputStream;
/*   6:    */ import java.io.PrintStream;
/*   7:    */ import java.math.BigInteger;
/*   8:    */ import java.net.Socket;
/*   9:    */ import java.net.UnknownHostException;
/*  10:    */ import java.security.MessageDigest;
/*  11:    */ import java.security.NoSuchAlgorithmException;
/*  12:    */ import java.util.ArrayList;
/*  13:    */ import java.util.HashMap;
/*  14:    */ import java.util.List;
/*  15:    */ import java.util.Map;
/*  16:    */ import java.util.UUID;
/*  17:    */ 
/*  18:    */ public class WhatsAPI
/*  19:    */ {
/*  20:    */   private String phoneNumber;
/*  21:    */   private String imei;
/*  22:    */   private String name;
/*  23: 20 */   private String whatsAppHost = "bin-short.whatsapp.net";
/*  24: 21 */   private String whatsAppServer = "s.whatsapp.net";
/*  25: 22 */   private String whatsAppRealm = "s.whatsapp.net";
/*  26: 23 */   private String whatsAppDigest = "xmpp/s.whatsapp.net";
/*  27: 24 */   private String device = "iPhone";
/*  28: 25 */   private String whatsAppVer = "2.8.2";
/*  29: 26 */   private int port = 5222;
/*  30:    */   private int[] incompleteMessage;
/*  31: 31 */   private String disconnectedStatus = "disconnected";
/*  32: 32 */   private String connectedStatus = "connected";
/*  33:    */   private String loginStatus;
/*  34:    */   private Map<String, String> accountInfo;
/*  35:    */   private List<ProtocolNode> messageQueue;
/*  36:    */   private Map<String, String> challenge;
/*  37:    */   private Socket socket;
/*  38:    */   private BinTreeNodeReader reader;
/*  39:    */   private BinTreeNodeWriter writer;
/*  40:    */   
/*  41:    */   public WhatsAPI(String number, String imei, String name)
/*  42:    */   {
/*  43: 45 */    /* Decode.init();
  44: 46      this.reader = new BinTreeNodeReader(Decode.getDictionary());
  45: 47      this.writer = new BinTreeNodeWriter(Decode.getDictionary());*/
/*  46: 48 */     this.phoneNumber = number;
/*  47: 49 */     this.imei = imei;
/*  48: 50 */     this.name = name;
/*  49: 51 */     this.challenge = new HashMap();
/*  50: 52 */     this.messageQueue = new ArrayList();
/*  51: 53 */     this.loginStatus = this.disconnectedStatus;
/*  52:    */   }
/*  53:    */   
/*  54:    */   protected ProtocolNode addFeatures()
/*  55:    */   {
/*  56: 57 */     ProtocolNode child = new ProtocolNode("receipt_acks", null, null, "");
/*  57: 58 */     List<ProtocolNode> children = new ArrayList();
/*  58: 59 */     children.add(child);
/*  59: 60 */     ProtocolNode parent = new ProtocolNode("stream:features", null, children, "");
/*  60:    */     
/*  61: 62 */     return parent;
/*  62:    */   }
/*  63:    */   
/*  64:    */   protected ProtocolNode addAuth()
/*  65:    */   {
/*  66: 66 */     Map<String, String> auth = new HashMap();
/*  67: 67 */     auth.put("mechanism", "DIGEST-MD5-1");
/*  68:    */     
/*  69: 69 */     auth.put("xmlns", "urn:ietf:params:xml:ns:xmpp-sasl");
/*  70: 70 */     return new ProtocolNode("auth", auth, null, "");
/*  71:    */   }
/*  72:    */   
/*  73:    */   public String encryptPassword()
/*  74:    */   {
/*  75: 74 */     if (this.imei.indexOf(":") > -1)
/*  76:    */     {
/*  77: 75 */       this.imei = this.imei.toUpperCase();
/*  78: 76 */       return md5(this.imei + this.imei);
/*  79:    */     }
/*  80: 79 */     return md5(reverse(this.imei));
/*  81:    */   }
/*  82:    */   
/*  83:    */   private String reverse(String imei2)
/*  84:    */   {
/*  85: 84 */     return new StringBuffer(imei2).reverse().toString();
/*  86:    */   }
/*  87:    */   
/*  88:    */   private String md5(String s)
/*  89:    */   {
/*  90: 88 */     MessageDigest m = null;
/*  91:    */     try
/*  92:    */     {
/*  93: 90 */       m = MessageDigest.getInstance("MD5");
/*  94:    */     }
/*  95:    */     catch (NoSuchAlgorithmException e)
/*  96:    */     {
/*  97: 93 */       e.printStackTrace();
/*  98:    */     }
/*  99: 95 */     m.reset();
/* 100: 96 */     m.update(s.getBytes());
/* 101: 97 */     byte[] digest = m.digest();
/* 102: 98 */     BigInteger bigInt = new BigInteger(1, digest);
/* 103: 99 */     String hashtext = bigInt.toString(16);
/* 104:100 */     while (hashtext.length() < 32) {
/* 105:101 */       hashtext = "0" + hashtext;
/* 106:    */     }
/* 107:103 */     return hashtext;
/* 108:    */   }
/* 109:    */   
/* 110:    */   protected String authenticate(String nonce)
/* 111:    */   {
/* 112:107 */     String NC = "00000001";
/* 113:108 */     String qop = "auth";
/* 114:109 */     String cnonce = randomUUID();
/* 115:    */     
/* 116:111 */     String data1 = this.phoneNumber;
/* 117:112 */     data1 = data1 + ":";
/* 118:113 */     data1 = data1 + this.whatsAppServer;
/* 119:114 */     data1 = data1 + ":";
/* 120:115 */     data1 = data1 + encryptPassword();
/* 121:    */     
/* 122:117 */     String data2 = md5(data1);
/* 123:118 */     data2 = data2 + ":";
/* 124:119 */     data2 = data2 + nonce;
/* 125:120 */     data2 = data2 + ":";
/* 126:121 */     data2 = data2 + cnonce;
/* 127:    */     
/* 128:123 */     String data3 = "AUTHENTICATE:";
/* 129:124 */     data3 = data3 + this.whatsAppDigest;
/* 130:    */     
/* 131:126 */     String data4 = md5(data2);
/* 132:127 */     data4 = data4 + ":";
/* 133:128 */     data4 = data4 + nonce;
/* 134:129 */     data4 = data4 + ":";
/* 135:130 */     data4 = data4 + NC;
/* 136:131 */     data4 = data4 + ":";
/* 137:132 */     data4 = data4 + cnonce;
/* 138:133 */     data4 = data4 + ":";
/* 139:134 */     data4 = data4 + qop;
/* 140:135 */     data4 = data4 + ":";
/* 141:136 */     data4 = data4 + md5(data3);
/* 142:    */     
/* 143:138 */     String data5 = md5(data4);
/* 144:    */     
/* 145:    */ 
/* 146:141 */     String response = String.format("username=\"%s\",realm=\"%s\",nonce=\"%s\",cnonce=\"%s\",nc=%s,qop=%s,digest-uri=\"%s\",response=%s,charset=utf-8", new Object[] { this.phoneNumber, this.whatsAppRealm, nonce, cnonce, NC, qop, this.whatsAppDigest, data5 });
/* 147:    */     
/* 148:    */ 
/* 149:144 */     return response;
/* 150:    */   }
/* 151:    */   
/* 152:    */   protected ProtocolNode addAuthResponse()
/* 153:    */   {
/* 154:148 */     String nonce = (String)this.challenge.get("nonce");
/* 155:149 */     String resp = authenticate(nonce);
/* 156:150 */     Map<String, String> map = new HashMap();
/* 157:151 */     map.put("xmlns", "urn:ietf:params:xml:ns:xmpp-sasl");
/* 158:    */     
/* 159:153 */     ProtocolNode node = new ProtocolNode("response", map, null, Base64.encode(resp));
/* 160:154 */     return node;
/* 161:    */   }
/* 162:    */   
/* 163:    */   protected void sendData(String in)
/* 164:    */   {
/* 165:    */     try
/* 166:    */     {
/* 167:160 */       BufferedOutputStream out = new BufferedOutputStream(this.socket.getOutputStream());
/* 168:161 */       out.write(in.getBytes());
/* 169:    */       
/* 170:163 */       out.flush();
/* 171:    */     }
/* 172:    */     catch (IOException e)
/* 173:    */     {
/* 174:166 */       e.printStackTrace();
/* 175:    */     }
/* 176:    */   }
/* 177:    */   
/* 178:    */   protected void sendNode(ProtocolNode node)
/* 179:    */   {
/* 180:171 */     System.out.println(node.nodeString("msg sent successfully to whatsApp "));
/* 181:172 */     sendData(this.writer.write(node));
/* 182:    */   }
/* 183:    */   
/* 184:    */   protected int[] readData()
/* 185:    */   {
/* 186:    */     try
/* 187:    */     {
/* 188:179 */       byte[] input = new byte[1024];
/* 189:180 */       this.socket.getInputStream().read(input);
/* 190:181 */       int[] ret = new int[input.length];
/* 191:182 */       for (int i = 0; i < input.length; i++) {
/* 192:183 */         ret[i] = unsignedToBytes(input[i]);
/* 193:    */       }
/* 194:184 */       return ret;
/* 195:    */     }
/* 196:    */     catch (IOException e)
/* 197:    */     {
/* 198:188 */       e.printStackTrace();
/* 199:    */     }
/* 200:191 */     return null;
/* 201:    */   }
/* 202:    */   
/* 203:    */   public static int unsignedToBytes(byte a)
/* 204:    */   {
/* 205:195 */     int b = a & 0xFF;
/* 206:196 */     return b;
/* 207:    */   }
/* 208:    */   
/* 209:    */   protected void processChallenge(ProtocolNode node)
/* 210:    */   {
/* 211:200 */     String challenge = Base64.decode(node.data);
/* 212:201 */     String[] strs = challenge.split(",");
/* 213:202 */     for (String s : strs)
/* 214:    */     {
/* 215:203 */       String[] k = s.split("=");
/* 216:204 */       this.challenge.put(k[0], k[1].replace("\"", ""));
/* 217:    */     }
/* 218:    */   }
/* 219:    */   
/* 220:    */   protected void sendMessageReceived(ProtocolNode msg)
/* 221:    */   {
/* 222:209 */     ProtocolNode reqNode = msg.getChild("request");
/* 223:210 */     if (reqNode != null)
/* 224:    */     {
/* 225:211 */       String xmlns = reqNode.getAttribute("xmlns");
/* 226:212 */       if (xmlns.equals("urn:xmpp:receipts"))
/* 227:    */       {
/* 228:213 */         Map<String, String> recHash = new HashMap();
/* 229:214 */         recHash.put("xmlns", "urn:xmpp:receipts");
/* 230:215 */         ProtocolNode recNode = new ProtocolNode("received", recHash, null, "");
/* 231:    */         
/* 232:217 */         Map<String, String> msgHash = new HashMap();
/* 233:218 */         msgHash.put("to", msg.getAttribute("from"));
/* 234:219 */         msgHash.put("type", "chat");
/* 235:220 */         msgHash.put("id", msg.getAttribute("id"));
/* 236:221 */         List<ProtocolNode> children = new ArrayList();
/* 237:222 */         children.add(recNode);
/* 238:223 */         ProtocolNode messageNode = new ProtocolNode("message", msgHash, children, "");
/* 239:    */         
/* 240:225 */         sendNode(messageNode);
/* 241:    */       }
/* 242:    */     }
/* 243:    */   }
/* 244:    */   
/* 245:    */   protected void processInboundData(int[] data)
/* 246:    */   {
/* 247:    */     try
/* 248:    */     {
/* 249:232 */       ProtocolNode node = this.reader.nextTree(data);
/* 250:234 */       while (node != null)
/* 251:    */       {
/* 252:235 */         System.out.println(node.nodeString("rx  "));
/* 253:236 */         if (node.tag.equals("challenge"))
/* 254:    */         {
/* 255:237 */           processChallenge(node);
/* 256:    */         }
/* 257:238 */         else if (node.tag.equals("success"))
/* 258:    */         {
/* 259:239 */           this.loginStatus = this.connectedStatus;
/* 260:240 */           this.accountInfo = new HashMap();
/* 261:241 */           this.accountInfo.put("status", node.getAttribute("status"));
/* 262:242 */           this.accountInfo.put("kind", node.getAttribute("kind"));
/* 263:243 */           this.accountInfo.put("creation", node.getAttribute("creation"));
/* 264:244 */           this.accountInfo.put("expiration", node
/* 265:245 */             .getAttribute("expiration"));
/* 266:    */         }
/* 267:247 */         if (node.tag.equals("message"))
/* 268:    */         {
/* 269:248 */           this.messageQueue.add(node);
/* 270:249 */           sendMessageReceived(node);
/* 271:    */         }
/* 272:251 */         if ((node.tag.equals("iq")) && 
/* 273:252 */           (((String)node.attributeHash.get("type")).equals("get")) && 
/* 274:253 */           (((ProtocolNode)node.children.get(0)).tag.equals("ping"))) {
/* 275:254 */           pong((String)node.attributeHash.get("id"));
/* 276:    */         }
/* 277:256 */         node = this.reader.nextTree();
/* 278:    */       }
/* 279:    */     }
/* 280:    */     catch (IncompleteMessageException e)
/* 281:    */     {
/* 282:259 */       this.incompleteMessage = e.getData();
/* 283:260 */       e.printStackTrace();
/* 284:    */     }
/* 285:    */     catch (InvalidTokenException e)
/* 286:    */     {
/* 287:262 */       e.printStackTrace();
/* 288:    */     }
/* 289:    */   }
/* 290:    */   
/* 291:    */   public Map<String, String> accountInfo()
/* 292:    */   {
/* 293:268 */     return this.accountInfo;
/* 294:    */   }
/* 295:    */   
/* 296:    */   public void connect()
/* 297:    */     throws UnknownHostException, IOException
/* 298:    */   {
/* 299:272 */     this.socket = new Socket(this.whatsAppHost, this.port);
/* 300:    */   }
/* 301:    */   
/* 302:    */   public void login()
/* 303:    */   {
/* 304:276 */     String res = this.device + "-" + this.whatsAppVer + "-" + this.port;
/* 305:277 */     String data = this.writer.startStream(this.whatsAppServer, res);
/* 306:278 */     ProtocolNode feat = addFeatures();
/* 307:279 */     ProtocolNode auth = addAuth();
/* 308:280 */     sendData(data);
/* 309:281 */     sendNode(feat);
/* 310:282 */     sendNode(auth);
/* 311:283 */     int[] s = readData();
/* 312:    */     
/* 313:285 */     processInboundData(s);
/* 314:286 */     ProtocolNode data2 = addAuthResponse();
/* 315:287 */     sendNode(data2);
/* 316:288 */     int i = 0;
/* 317:    */     do
/* 318:    */     {
/* 319:290 */       processInboundData(readData());
/* 320:291 */     } while ((i++ < 100) && 
/* 321:292 */       (this.loginStatus.equals(this.disconnectedStatus)));
/* 322:    */   }
/* 323:    */   
/* 324:    */   public void pollMessages()
/* 325:    */   {
/* 326:296 */     processInboundData(readData());
/* 327:    */   }
/* 328:    */   
/* 329:    */   public List<ProtocolNode> getMessages()
/* 330:    */   {
/* 331:300 */     List<ProtocolNode> ret = new ArrayList();
/* 332:301 */     ret.addAll(this.messageQueue);
/* 333:302 */     this.messageQueue.clear();
/* 334:303 */     return ret;
/* 335:    */   }
/* 336:    */   
/* 337:    */   protected void sendMessageNode(String msgid, String to, ProtocolNode node)
/* 338:    */   {
/* 339:308 */     ProtocolNode serverNode = new ProtocolNode("server", null, null, "");
/* 340:    */     
/* 341:310 */     Map<String, String> xHash = new HashMap();
/* 342:311 */     xHash.put("xmlns", "jabber:x:event");
/* 343:312 */     List<ProtocolNode> nodes = new ArrayList();
/* 344:313 */     nodes.add(serverNode);
/* 345:314 */     ProtocolNode xNode = new ProtocolNode("x", xHash, nodes, "");
/* 346:    */     
/* 347:316 */     Map<String, String> msgHash = new HashMap();
/* 348:317 */     msgHash.put("to", to + "@" + this.whatsAppServer);
/* 349:318 */     msgHash.put("type", "chat");
/* 350:319 */     msgHash.put("id", msgid);
/* 351:320 */     List<ProtocolNode> list = new ArrayList();
/* 352:321 */     list.add(xNode);
/* 353:322 */     list.add(node);
/* 354:323 */     ProtocolNode messageNode = new ProtocolNode("message", msgHash, list, "");
/* 355:    */     
/* 356:325 */     sendNode(messageNode);
/* 357:    */   }
/* 358:    */   
/* 359:    */   public void sendMessage(String msgid, String to, String txt)
/* 360:    */   {
/* 361:329 */     ProtocolNode bodyNode = new ProtocolNode("body", null, null, txt);
/* 362:330 */     sendMessageNode(msgid, to, bodyNode);
/* 363:    */   }
/* 364:    */   
/* 365:    */   public void sendMessageImage(String msgid, String to, String url, String file, String size, String icon)
/* 366:    */   {
/* 367:335 */     Map<String, String> map = new HashMap();
/* 368:336 */     map.put("xmlns", "urn:xmpp:whatsapp:mms");
/* 369:337 */     map.put("type", "image");
/* 370:338 */     map.put("url", url);
/* 371:339 */     map.put("file", file);
/* 372:340 */     map.put("size", size);
/* 373:    */     
/* 374:342 */     ProtocolNode mediaNode = new ProtocolNode("media", map, null, icon);
/* 375:343 */     sendMessageNode(msgid, to, mediaNode);
/* 376:    */   }
/* 377:    */   
/* 378:    */   public void pong(String msgid)
/* 379:    */   {
/* 380:347 */     Map<String, String> map = new HashMap();
/* 381:348 */     map.put("to", this.whatsAppServer);
/* 382:349 */     map.put("id", msgid);
/* 383:350 */     map.put("type", "result");
/* 384:351 */     sendNode(new ProtocolNode("iq", map, null, ""));
/* 385:    */   }
/* 386:    */   
/* 387:    */   private String randomUUID()
/* 388:    */   {
/* 389:355 */     UUID karl = UUID.randomUUID();
/* 390:356 */     return karl.toString();
/* 391:    */   }
/* 392:    */ }


/* Location:           C:\Users\mohamed\Desktop\final\AppSimulation\WEB-INF\classes\
 * Qualified Name:     org.alternadev.whatsup.WhatsAPI
 * JD-Core Version:    0.7.0.1
 */