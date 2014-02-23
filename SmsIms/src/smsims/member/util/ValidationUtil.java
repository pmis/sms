/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smsims.member.util;

import java.awt.Component;
import java.util.List;
import javax.swing.JOptionPane;
import smsims.db.DbOperation;
import smsims.om.Member;

/**
 *
 * @author Lasith
 */
public class ValidationUtil {
    
    /**
     * Validate fields for member
     * 
     * @param member
     * @param component
     * @param isUpdate
     * @return
     * @throws Exception 
     */
    public static boolean validateFields(Member member, Component component, boolean isUpdate) throws Exception {
        boolean isSuccess = true;
        DbOperation dbOperation = new DbOperation();
        
        if (member.getEmpCode() == null || member.getEmpCode().equals("")) {            
            javax.swing.JOptionPane.showMessageDialog(component, "Please enter Empoyee code", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (member.getName() == null || member.getName().equals("")) {            
            javax.swing.JOptionPane.showMessageDialog(component, "Please enter name", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!validateTpNumber(member.getTpNumber(), component)) {
            return false;
        }
        if (member.getDepartment() == null || member.getDepartment().equals("")) {            
            javax.swing.JOptionPane.showMessageDialog(component, "Please enter department", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        //We shouldn't allow to insert same emp code twise (ony when inserting)
        if (!isUpdate) {
            List<Member> members = dbOperation.getMembersByEmployeeCode(member.getEmpCode());
            if (!members.isEmpty()) {            
                javax.swing.JOptionPane.showMessageDialog(component, "Member with the given emp code is exsits", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }            
        }
        return isSuccess;
    }
    
    public static boolean validateTpNumber(String tpNumber, Component component) {
        boolean isSuccess = true;
        try{
            Integer.parseInt(tpNumber);
        } catch (NumberFormatException e) {
            isSuccess = false;
        }
        if (tpNumber.length() != 9){
            isSuccess = false;
        }
        if (!isSuccess) {            
            javax.swing.JOptionPane.showMessageDialog(component, "Please enter valid phone number with 9 digits", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return isSuccess;
    }
}
