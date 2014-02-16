/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smsCore;

/**
 *
 * @author Thakshila
 */
public class MessageResult {
    
    
   private String index = "";

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSenderDate() {
        return senderDate;
    }

    public void setSenderDate(String senderDate) {
        this.senderDate = senderDate;
    }

    public String getSmsContent() {
        return smsContent;
    }

    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent;
    }
   private String messageStatus = "";
   private String phoneNumber = "";
   private String senderDate = "";
   private String smsContent = "";

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append(index+"\n");
        sb.append(phoneNumber+"\n");
        sb.append(smsContent+"\n");
        sb.append(senderDate+"\n");
        
        return sb.toString();
        
    }
   
   
   
    
}
