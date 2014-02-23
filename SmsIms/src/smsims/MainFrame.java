/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smsims;

import javax.comm.CommDriver;
import smsCore.GSMConnect;
import smsims.member.util.Registry;


/**
 *
 * @author Lasith
 */
public class MainFrame extends javax.swing.JFrame {
    
    MemberPanel memberPanel = new MemberPanel();
    SmsPanel smsPannel = new SmsPanel();

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        driverInitialize();
        Registry.setJl_progress(jl_progress);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jb_manageMembers = new javax.swing.JButton();
        jb_settings = new javax.swing.JButton();
        jb_manageSms = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jl_progress = new javax.swing.JLabel();
        jp_mainPannel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Holcim SMS Information System");
        setMinimumSize(new java.awt.Dimension(635, 510));
        setResizable(false);

        jb_manageMembers.setText("Manage Members");
        jb_manageMembers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_manageMembersActionPerformed(evt);
            }
        });

        jb_settings.setText("Manage Questions");

        jb_manageSms.setText("Manage SMS");
        jb_manageSms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_manageSmsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jb_manageMembers, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jb_manageSms, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jb_settings, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jl_progress, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jb_manageMembers, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_manageSms, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_settings, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_progress, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jp_mainPannel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jp_mainPannelMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/Holcim.gif"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 48)); // NOI18N
        jLabel2.setText("SMS Information System");

        javax.swing.GroupLayout jp_mainPannelLayout = new javax.swing.GroupLayout(jp_mainPannel);
        jp_mainPannel.setLayout(jp_mainPannelLayout);
        jp_mainPannelLayout.setHorizontalGroup(
            jp_mainPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_mainPannelLayout.createSequentialGroup()
                .addGroup(jp_mainPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_mainPannelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_mainPannelLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp_mainPannelLayout.setVerticalGroup(
            jp_mainPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_mainPannelLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jp_mainPannel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp_mainPannel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_manageMembersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_manageMembersActionPerformed
        memberPanel.setLocation(0, 00);
        memberPanel.setSize(1800, 1600);
        jp_mainPannel.removeAll();
        jp_mainPannel.add(memberPanel);
        jp_mainPannel.revalidate();
        jp_mainPannel.repaint();                             
    }//GEN-LAST:event_jb_manageMembersActionPerformed

    private void jp_mainPannelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp_mainPannelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jp_mainPannelMouseClicked

    private void jb_manageSmsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_manageSmsActionPerformed
        smsPannel.setLocation(0, 00);
        smsPannel.setSize(1800, 1600);
        jp_mainPannel.removeAll();
        jp_mainPannel.add(smsPannel);
        jp_mainPannel.revalidate();
        jp_mainPannel.repaint(); 
    }//GEN-LAST:event_jb_manageSmsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jb_manageMembers;
    private javax.swing.JButton jb_manageSms;
    private javax.swing.JButton jb_settings;
    private javax.swing.JLabel jl_progress;
    private javax.swing.JPanel jp_mainPannel;
    // End of variables declaration//GEN-END:variables

    private void driverInitialize() {
        
        String driverName = "com.sun.comm.Win32Driver";
        try 
        {
            CommDriver commdriver = (CommDriver) Class.forName(driverName).newInstance();
            commdriver.initialize();
        } 
        catch (Exception e2) 
        {
            System.out.println("Cannot initalize widows driver");
            e2.printStackTrace();
        }
        
        GSMConnect gsm = GSMConnect.getInstace();
        if (gsm.init()) 
        {
            try 
            {
                gsm.connect();
            } 
            catch (Exception e) 
            {
                System.out.println("Card Connection Unsuccessfull");
                e.printStackTrace();
            }
        }
        else
        {
            System.out.println("Can't Connect to the port");
        }
    }
}
