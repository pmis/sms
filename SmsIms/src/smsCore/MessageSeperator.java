/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smsCore;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thakshila
 */
public class MessageSeperator {
    
    private String message;
    
    public MessageSeperator(String message)
    {
        this.message = message;
        
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
                for (String me : messageResultArray)
                {
                    System.out.println("Result Array....."+me);
                }
                MessageResult messageResult = new MessageResult();
                messageResult.setIndex(messageResultArray[0]);
                messageResult.setMessageStatus(messageResultArray[1]);
                messageResult.setPhoneNumber(messageResultArray[2]);
                messageResult.setSenderDate(messageResultArray[4].substring(1));
                messageResult.setSmsContent(messageResultArray[5].substring(12));
                messageResulList.add(messageResult);
            }
            count ++;
        }
        
        return messageResulList;
    }

    
    
    
}
