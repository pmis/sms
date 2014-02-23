/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smsims;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.comm.CommDriver;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import smsCore.GSMConnect;
import smsims.om.MessageResult;
import smsCore.MessageSeperator;
import smsims.db.DbOperation;

/**
 *
 * @author Lasith.Chandrasekara
 */
public class SmsPanel extends javax.swing.JPanel implements DocumentListener{

    /**
     * Creates new form SmsPanel
     */
    public SmsPanel() {
        initComponents();
        smsText.getDocument().addDocumentListener(this);
        messageSendingStausLabel.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        smsText = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jc_department = new javax.swing.JComboBox();
        jc_site = new javax.swing.JComboBox();
        jb_send = new javax.swing.JButton();
        jb_clear = new javax.swing.JButton();
        responce_required_checkbox = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jc_mgtLevel = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        messagCountText = new javax.swing.JTextField();
        messageSendingStausLabel = new javax.swing.JLabel();
        jb_export_result = new javax.swing.JButton();

        smsText.setColumns(20);
        smsText.setRows(5);
        jScrollPane1.setViewportView(smsText);

        jLabel1.setText("Message");

        jLabel2.setText("Department");

        jLabel3.setText("Site");

        jc_department.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All Departments", "Geo-Cycle", "HR" }));

        jc_site.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All Sites", "CMB", "Galle" }));

        jb_send.setText("Send SMS");
        jb_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_sendActionPerformed(evt);
            }
        });

        jb_clear.setText("Clear");
        jb_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_clearActionPerformed(evt);
            }
        });

        responce_required_checkbox.setText("Require Response");

        jLabel4.setText("Mgt Level");

        jc_mgtLevel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All Levels", "FML", "SML", "TML" }));

        jLabel5.setText("Character Count");

        messagCountText.setEditable(false);

        jb_export_result.setText("Export results");
        jb_export_result.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_export_resultActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(responce_required_checkbox)
                                .addGap(185, 185, 185)
                                .addComponent(jb_export_result, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jc_site, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(messagCountText, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jc_department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jb_send)
                                        .addGap(57, 57, 57)
                                        .addComponent(jb_clear)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jc_mgtLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(messageSendingStausLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(messagCountText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jc_department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jc_mgtLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jc_site, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(responce_required_checkbox)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jb_send)
                            .addComponent(jb_clear)))
                    .addComponent(jb_export_result, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(messageSendingStausLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jb_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_sendActionPerformed
        //log creating part....
        try 
        {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            Calendar cal = Calendar.getInstance();
            out = new BufferedWriter(new FileWriter("logs\\smslog--" + dateFormat.format(cal.getTime()) + ".txt"));
            out.write("--------------------------------------------------------------Date and Time(" + dateFormat.format(cal.getTime()) + ") --------------------------------------------------------------");
            out.newLine();
            out.newLine();
            out.newLine();
            out.newLine();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            try 
            {
                out.write(errors.toString());
                out.newLine();
            } 
            catch (IOException ex) 
            {
                e.printStackTrace();
            }
            System.out.println("Cannot find the log file location");
        }

        sendSms();       
        boolean responseRequired = responce_required_checkbox.isSelected();       
        if(responseRequired)
        {
            readSms();
        }
        try 
        {
            out.close();
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jb_sendActionPerformed

    private void jb_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_clearActionPerformed
   
        smsText.setText("");
    }//GEN-LAST:event_jb_clearActionPerformed

    private File getSaveLocation()
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);  
        int result = chooser.showSaveDialog(this);
        if (result == chooser.APPROVE_OPTION) 
        { 
            return chooser.getSelectedFile();
        } 
        else 
        {
            return null;
        }
    }
    
    private void jb_export_resultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_export_resultActionPerformed
        
       
        PrintWriter file = null;
        try 
        {   
            File fileDirectory = getSaveLocation();
            if (fileDirectory != null)
            {   
                file = new PrintWriter(new File(fileDirectory,"sms_response.csv"));
            }
        } 
        catch (FileNotFoundException ex) 
        {
            ex.printStackTrace();
        }
        if (file != null)
        {
            DbOperation db = new DbOperation();
            List<MessageResult> sessionMessageResults = db.getSessionMessageResults("001");
        
            for (MessageResult msgResult : sessionMessageResults)
            {
                file.write(msgResult.printCSV());
            }
        
            file.close();   
        }
    }//GEN-LAST:event_jb_export_resultActionPerformed
   
    private void sendSms() {
       //sms sending part...
        try 
        {   
            if (smsText.getText().length() != 0)
            {
//                String messageStatusSting ="<html><FONT COLOR=RED><B>Message Sending ..... </B></FONT></html>";
//                messageSendingStausLabel.setText(messageStatusSting);
//                messageSendingStausLabel.setVisible(true);
//                messageSendingStausLabel.setEnabled(true);
//                jb_send.setEnabled(false);
                //TO DO need change the session Id..
                sessionId = "001";
                String smsMessage = smsText.getText();
                String[] phoneNumbers = {"+94788370502","+94711498462","+94719028959"};
                //message chracter count less than 155
                String normalMessage ="";
                //message character count between 155 and 310
                String message1 ="";
                String message2 = "";
                //message charatcter count grether than 310
                String message11="";
                String message22="";
                String message33="";
            
                if (smsMessage.length()<=155)
                {
                    normalMessage = smsMessage;
                    out.write("Message character count is less than 155...");
                    out.newLine();
                    out.write("Message -> "+normalMessage);
                    out.newLine();
                }
                else if (smsMessage.length()>=156 && smsMessage.length()<=310)
                {
                    message1 = smsMessage.substring(0, 155);
                    message2 = smsMessage.substring(154);
                    out.write("Message character count betwenn 155 and 310...");
                    out.newLine();
                    out.write("Message 1 -> "+message1);
                    out.newLine();
                    out.write("Message 2 -> "+message2);
                    out.newLine();     
                }
                else
                {
                    message11 = smsMessage.substring(0, 155);
                    message22 = smsMessage.substring(154,310);
                    message33 = smsMessage.substring(309);
                    out.write("Message character count greather than 310...");
                    out.newLine();
                    out.write("Message 1 -> "+message11);
                    out.newLine();
                    out.write("Message 2 -> "+message22);
                    out.newLine();
                    out.write("Message 3 -> "+message33);
                    out.newLine();                    
                }
                out.write("-------------------------------------Start Message Sending--------------------------------------------");
                out.newLine();
                out.newLine();
                out.newLine();
                GSMConnect gsm = GSMConnect.getInstace();
                gsm.checkStatus();
                Thread.sleep(50000);
                gsm.sendMessage();
                Thread.sleep(50000);
                for (String phoneNo : phoneNumbers)
                {
                    if (smsMessage.length()<=155)
                    {
                        gsm.sendPhoneNu(phoneNo);
                        gsm.sendString(normalMessage);
                        Thread.sleep(3000);
                        out.write("Message Sent Successfully -> "+phoneNo);
                        out.newLine();
                    }
                    else if (smsMessage.length()>=156 && smsMessage.length()<=310)
                    {
                        gsm.sendPhoneNu(phoneNo);
                        gsm.sendString(message1);
                        Thread.sleep(3000);
                        out.write("Message 1 Sent Successfully -> "+phoneNo);
                        out.newLine();
                        gsm.sendPhoneNu(phoneNo);
                        gsm.sendString(message2);
                        Thread.sleep(3000);
                        out.write("Message 2 Sent Successfully -> "+phoneNo);
                        out.newLine();
                    }
                    else
                    {
                        gsm.sendPhoneNu(phoneNo);
                        gsm.sendString(message11);
                        Thread.sleep(3000);
                        out.write("Message 1 Sent Successfully -> "+phoneNo);
                        out.newLine();
                        gsm.sendPhoneNu(phoneNo);
                        gsm.sendString(message22);
                        Thread.sleep(3000);
                        out.write("Message 2 Sent Successfully -> "+phoneNo);
                        out.newLine();
                        gsm.sendPhoneNu(phoneNo);
                        gsm.sendString(message33);
                        Thread.sleep(3000);
                        out.write("Message 3 Sent Successfully -> "+phoneNo);
                        out.newLine();
                    }
                }
            
                Thread.sleep(50000);
                gsm.hangup();
//                messageSendingStausLabel.setText("");
//                messageSendingStausLabel.setVisible(false);
//                jb_send.setEnabled(true);
                out.write("-------------------------------------Finish Message Sending--------------------------------------------");
                out.newLine();
                out.newLine();
                out.newLine();
            } 
            else
            {
                JOptionPane.showMessageDialog(null,"SMS Message is empty \n Can't send SMS..","SMS Sending Fail Warning",JOptionPane.WARNING_MESSAGE );
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            try 
            {
                out.write(errors.toString());
                out.newLine();
            } 
            catch (IOException ex) 
            {
                e.printStackTrace();
            }
        }
    }
    
    private void readSms() {
        DbOperation dbOperation = new DbOperation();
        
        //sms reading part...
        try
        {
            GSMConnect gsm = GSMConnect.getInstace();
            gsm.checkStatus();
            Thread.sleep(50000);
            gsm.sendMessage();
            Thread.sleep(50000);
            gsm.selecttheMemory();
            Thread.sleep(50000);
            out.newLine();
            out.newLine();
            out.write("-------------------------------------Start Message Reading--------------------------------------------");
            out.newLine();
            out.newLine();
            while(true)
            {
                //TODO how much time we shoud run
                String tempString = gsm.getoutputString().toString();
                gsm.listSmsFromMemory();
                Thread.sleep(20000);
                String afterReadingSms = gsm.getoutputString().toString();
                String allMessageString = afterReadingSms.substring(tempString.length());
                MessageSeperator me = new MessageSeperator(allMessageString,sessionId) ;
                List<MessageResult> messageResultList = me.getSeperatedMessage();
                
                smsSaveInDb(messageResultList, dbOperation);
                
//                deleteSmsFromSim(messageResultList, gsm);
            }
            

        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            try 
            {
                out.write(errors.toString());
                out.newLine();
            } 
            catch (IOException ex) 
            {
                e.printStackTrace();
            }
                
        }   
    }

    private void deleteSmsFromSim(List<MessageResult> messageResultList, GSMConnect gsm) throws InterruptedException {
        for (MessageResult messageResult : messageResultList)
        {
            gsm.deleteASMS(messageResult.getIndex());
            Thread.sleep(2000);
        }
    }

    private void smsSaveInDb(List<MessageResult> messageResultList, DbOperation dbOperation) throws Exception {
        //TODO save messageResultList in db
        for (MessageResult messageResult : messageResultList)
        {
            //Save in the db
            List dbPhoneNumList = dbOperation.getMessageResults(messageResult.getPhoneNumber(),messageResult.getSessionId());
            if (dbPhoneNumList.isEmpty())
            {
                dbOperation.insertMessageResult(messageResult);
                out.write(messageResult.toString());
                out.write("Adding DB Successfully...");
                out.newLine();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jb_clear;
    private javax.swing.JButton jb_export_result;
    private javax.swing.JButton jb_send;
    private javax.swing.JComboBox jc_department;
    private javax.swing.JComboBox jc_mgtLevel;
    private javax.swing.JComboBox jc_site;
    private javax.swing.JTextField messagCountText;
    private javax.swing.JLabel messageSendingStausLabel;
    private javax.swing.JCheckBox responce_required_checkbox;
    private javax.swing.JTextArea smsText;
    // End of variables declaration//GEN-END:variables
    private static BufferedWriter out;
    private String sessionId;

    public static BufferedWriter getLog() 
    {
        return out;
    }
    
    @Override
    public void insertUpdate(DocumentEvent e) {
        if (e.getDocument() == smsText.getDocument())
        {
           warn(); 
        }       
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        if (e.getDocument() == smsText.getDocument())
        {
           warn(); 
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
       if (e.getDocument() == smsText.getDocument())
        {
           warn(); 
        }
    }
    
    public void warn() {
     
        messagCountText.setText(String.valueOf(smsText.getText().length()));
  }
}
