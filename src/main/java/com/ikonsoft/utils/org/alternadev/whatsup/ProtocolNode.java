/*   1:    */ package com.ikonsoft.utils.org.alternadev.whatsup;
/*  2:   */ 
/*  3:   */ import java.util.ArrayList;
/*  4:   */ import java.util.HashMap;
/*  5:   */ import java.util.List;
/*  6:   */ import java.util.Map;
/*  7:   */ import java.util.Map.Entry;
/*  8:   */ 
/*  9:   */ public class ProtocolNode
/* 10:   */ {
/* 11:   */   public String tag;
/* 12:   */   public Map<String, String> attributeHash;
/* 13:   */   public List<ProtocolNode> children;
/* 14:   */   public String data;
/* 15:   */   
/* 16:   */   public ProtocolNode(String tag, Map<String, String> attributeHash, List<ProtocolNode> children, String data)
/* 17:   */   {
/* 18:16 */     this.tag = tag;
/* 19:17 */     this.attributeHash = attributeHash;
/* 20:18 */     if (attributeHash == null) {
/* 21:19 */       this.attributeHash = new HashMap();
/* 22:   */     }
/* 23:20 */     this.children = children;
/* 24:21 */     if (children == null) {
/* 25:22 */       children = new ArrayList();
/* 26:   */     }
/* 27:23 */     this.data = data;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public String nodeString()
/* 31:   */   {
/* 32:27 */     return nodeString("");
/* 33:   */   }
/* 34:   */   
/* 35:   */   public String nodeString(String indent)
/* 36:   */   {
/* 37:31 */     String ret = "\n" + indent + "<" + this.tag;
/* 38:32 */     for (Map.Entry<String, String> entry : this.attributeHash.entrySet()) {
/* 39:33 */       ret = ret + " " + (String)entry.getKey() + "=\"" + (String)entry.getValue() + "\"";
/* 40:   */     }
/* 41:35 */     ret = ret + ">";
/* 42:36 */     if (this.data.length() > 0) {
/* 43:37 */       ret = ret + this.data;
/* 44:   */     }
/* 45:38 */     if ((this.children != null) && 
/* 46:39 */       (!this.children.isEmpty()))
/* 47:   */     {
/* 48:40 */       for (ProtocolNode child : this.children) {
/* 49:41 */         ret = ret + child.nodeString(new StringBuilder().append(indent).append("  ").toString());
/* 50:   */       }
/* 51:42 */       ret = ret + "\n" + indent;
/* 52:   */     }
/* 53:44 */     ret = ret + "</" + this.tag + ">";
/* 54:45 */     return ret;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public String getAttribute(String attribute)
/* 58:   */   {
/* 59:49 */     return (String)this.attributeHash.get(attribute);
/* 60:   */   }
/* 61:   */   
/* 62:   */   public ProtocolNode getChild(String tag)
/* 63:   */   {
/* 64:53 */     if (!this.children.isEmpty()) {
/* 65:54 */       for (ProtocolNode child : this.children) {
/* 66:55 */         if (child.tag.equals(tag)) {
/* 67:56 */           return child;
/* 68:   */         }
/* 69:   */       }
/* 70:   */     }
/* 71:59 */     return null;
/* 72:   */   }
/* 73:   */ }


/* Location:           C:\Users\mohamed\Desktop\final\AppSimulation\WEB-INF\classes\
 * Qualified Name:     org.alternadev.whatsup.ProtocolNode
 * JD-Core Version:    0.7.0.1
 */