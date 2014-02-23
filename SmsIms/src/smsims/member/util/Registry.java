/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smsims.member.util;

import javax.swing.JLabel;

/**
 * This class will store all the common properties to share.
 * There is only one instance for this class.
 * 
 * @author Lasith
 */
public class Registry {
    
    private static int sessionId;
    private static javax.swing.JLabel jl_progress;

    public static int getSessionId() {
        return sessionId;
    }

    public static void setSessionId(int sessionId) {
        Registry.sessionId = sessionId;
    }   

    public static JLabel getJl_progress() {
        return jl_progress;
    }

    public static void setJl_progress(JLabel jl_progress) {
        Registry.jl_progress = jl_progress;
    }
    
    
}
