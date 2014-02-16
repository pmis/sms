/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smsims.om;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Thakshila
 */
@Entity
@Table(name = "message_result")
public class MessageResult {
    
   @Id @GeneratedValue
   private Integer id;
       
   private String messageIndex = ""; 
   
   private String messageStatus = "";
   
   private String phoneNumber = "";
   
   private String senderDate = "";
   
   private String smsContent = "";
   
   private String sessionId = "";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIndex() {
        return messageIndex;
    }

    public void setIndex(String index) {
        this.messageIndex = index;
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

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }


    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append(messageIndex+"\n");
        sb.append(phoneNumber+"\n");
        sb.append(smsContent+"\n");
        sb.append(senderDate+"\n");
        
        return sb.toString();
        
    }
   
   
   
    
}
