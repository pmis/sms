/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smsCore;

import smsims.om.MessageResult;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thakshila
 */
public class MessageSeperator {
    
    private String message;
    private String sessionId;
    
    public MessageSeperator(String message,String sessionId)
    {
        this.message = message;
        this.sessionId = sessionId;
        
    }

   
    public List<MessageResult> getSeperatedMessage()
    {
        String messageArray[] = message.split("\\+CMGL:") ;
        List <MessageResult> messageResulList = new ArrayList<MessageResult>();
        
        int count=0;
        for (String aMessage : messageArray)
        {
            if (count !=0 ){
                
                String messageResultArray [] = aMessage.split(",");
                String phoneNum = messageResultArray[2].substring(1, messageResultArray[2].length()-1);
                boolean correctPhoneNum = phoneNumValidation(phoneNum);
                if (messageResultArray.length >= 6 && correctPhoneNum)
                {
                    MessageResult messageResult = new MessageResult();
                    messageResult.setSessionId(sessionId);
                    messageResult.setIndex(messageResultArray[0]);
                    messageResult.setMessageStatus(messageResultArray[1]);
                    messageResult.setPhoneNumber(phoneNum);
                    messageResult.setSenderDate(messageResultArray[4].substring(1));
                    String smsContent = messageResultArray[5].substring(12).trim();
                    if (smsContent.endsWith("OK"))
                    {
                        messageResult.setSmsContent(smsContent.substring(0,smsContent.length()-2));
                    }
                    else
                    {
                        messageResult.setSmsContent(smsContent);
                    }
                    messageResulList.add(messageResult); 
                    System.out.println("Added Successfully \n "+messageResult.toString());
                }
                
            }
            count ++;
        }
        
        return messageResulList;
    }

    private boolean phoneNumValidation(String phoneNum) {
        
        if (phoneNum.startsWith("+94") && phoneNum.length() == 12 )
        {
             return true;
        }
        else if (phoneNum.startsWith("0") && phoneNum.length() == 10) 
        {
             return true;
        }
        else
        {
            return false;
        }
    }

    
    
    
}
