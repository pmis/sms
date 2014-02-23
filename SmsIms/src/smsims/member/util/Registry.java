/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smsims.member.util;

/**
 * This class will store all the common properties to share.
 * There is only one instance for this class.
 * 
 * @author Lasith
 */
public class Registry {
    
    private static int sessionId;

    public static int getSessionId() {
        return sessionId;
    }

    public static void setSessionId(int sessionId) {
        Registry.sessionId = sessionId;
    }   
    
}
