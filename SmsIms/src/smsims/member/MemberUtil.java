/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smsims.member;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import smsims.om.Member;

/**
 *
 * @author Lasith
 */
public class MemberUtil {

    public static void loadMemberIntoTable(List<Member> members, JTable jtable_members) {        
        DefaultTableModel tableColumnModel = (DefaultTableModel)jtable_members.getModel();
        String data[] = new String[8];
        tableColumnModel.setRowCount(0);
            
        int i = 0;
        for (Member member : members){
            data[0] = member.getEmpCode();
            data[1] = member.getName();
            data[2] = member.getTpNumber();
            data[3] = member.getDepartment();
            data[4] = member.getSite();
            data[5] = member.getMgtLevel();
            data[6] = member.getStatus();
            data[7] = member.getId().toString();
            tableColumnModel.insertRow(i, data);
            i++;
        }
    }
}
