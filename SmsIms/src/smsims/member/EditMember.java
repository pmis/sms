/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smsims.member;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import smsims.db.DbOperation;
import smsims.om.Member;

/**
 *
 * @author Lasith
 */
public class EditMember extends javax.swing.JPanel {

    /**
     * Creates new form EditMember
     */
    public EditMember() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtf_searchEmpCode = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable_members = new javax.swing.JTable();
        jb_searchEmpCode = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtf_memberName = new javax.swing.JTextField();
        jtf_memberTpNumber = new javax.swing.JTextField();
        jtf_memberDepartment = new javax.swing.JTextField();
        jb_updateMember = new javax.swing.JButton();
        jb_deleteMember = new javax.swing.JButton();
        jb_disableMember = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jtf_searchName = new javax.swing.JTextField();
        jb_searchName = new javax.swing.JButton();

        jLabel1.setText("Emp Code");

        jtable_members.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Department", "Enable"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtable_members.setMinimumSize(new java.awt.Dimension(1950, 64));
        jtable_members.setPreferredSize(new java.awt.Dimension(1255, 64));
        jScrollPane1.setViewportView(jtable_members);
        if (jtable_members.getColumnModel().getColumnCount() > 0) {
            jtable_members.getColumnModel().getColumn(0).setMinWidth(30);
            jtable_members.getColumnModel().getColumn(0).setPreferredWidth(30);
            jtable_members.getColumnModel().getColumn(0).setMaxWidth(30);
            jtable_members.getColumnModel().getColumn(2).setMinWidth(100);
            jtable_members.getColumnModel().getColumn(2).setPreferredWidth(100);
            jtable_members.getColumnModel().getColumn(2).setMaxWidth(100);
            jtable_members.getColumnModel().getColumn(3).setMinWidth(50);
            jtable_members.getColumnModel().getColumn(3).setPreferredWidth(50);
            jtable_members.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        jb_searchEmpCode.setText("Search");
        jb_searchEmpCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_searchEmpCodeActionPerformed(evt);
            }
        });

        jLabel2.setText("Name");

        jLabel3.setText("Tp Number");

        jLabel4.setText("Department");

        jb_updateMember.setText("Update");

        jb_deleteMember.setText("Delete");

        jb_disableMember.setText("Disable");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtf_memberName)
                    .addComponent(jtf_memberTpNumber)
                    .addComponent(jtf_memberDepartment, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jb_updateMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_disableMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_deleteMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 218, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtf_memberName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_updateMember))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtf_memberTpNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_disableMember))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_memberDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jb_deleteMember))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jLabel5.setText("Name");

        jb_searchName.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_searchEmpCode, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jb_searchEmpCode)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtf_searchName, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jb_searchName))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtf_searchEmpCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_searchEmpCode)
                    .addComponent(jLabel5)
                    .addComponent(jtf_searchName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_searchName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(38, 38, 38))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jb_searchEmpCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_searchEmpCodeActionPerformed
        String searchCode = jtf_searchEmpCode.getText();
        if (jtf_searchEmpCode.getText() == null || jtf_searchEmpCode.getText().equals("")) {            
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter name or part of it to search", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }        
        DbOperation dbOperation = new DbOperation();
        List<Member> members = dbOperation.getMembers(searchCode);
        DefaultTableModel tableColumnModel = (DefaultTableModel)jtable_members.getModel();
        String data[] = new String[5];
        int i = 0;
        
        for (Member member : members){
            data[0] = member.getId().toString();
            data[1] = member.getName();
            data[2] = member.getDepartment();
            tableColumnModel.insertRow(i, data);
            i++;
        }
    }//GEN-LAST:event_jb_searchEmpCodeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_deleteMember;
    private javax.swing.JButton jb_disableMember;
    private javax.swing.JButton jb_searchEmpCode;
    private javax.swing.JButton jb_searchName;
    private javax.swing.JButton jb_updateMember;
    private javax.swing.JTable jtable_members;
    private javax.swing.JTextField jtf_memberDepartment;
    private javax.swing.JTextField jtf_memberName;
    private javax.swing.JTextField jtf_memberTpNumber;
    private javax.swing.JTextField jtf_searchEmpCode;
    private javax.swing.JTextField jtf_searchName;
    // End of variables declaration//GEN-END:variables
}
