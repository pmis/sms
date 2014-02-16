/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smsCore;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.comm.*;

public class GSMConnect implements SerialPortEventListener,
        CommPortOwnershipListener {

    private String comPort = null; // This COM Port must be connect with GSM Modem or your mobile phone
    private String messageString = "";
    private CommPortIdentifier portId = null;
    private Enumeration portList;
    private InputStream inputStream = null;
    private OutputStream outputStream = null;
    private  StringBuilder outputString = new StringBuilder();
    private SerialPort serialPort;
    private static GSMConnect gsm = null;
    private final static String COMM_PORT ="COM4";

    /** Creates a new instance of GSMConnect */
    
    public static GSMConnect getInstace()
    {
        if (gsm == null)
        {
            gsm = new GSMConnect(COMM_PORT);
        }
        
        return gsm;
    }
    
    public GSMConnect(String comm) {

        this.comPort = comm;

    }

    public boolean init() {

        portList = CommPortIdentifier.getPortIdentifiers();
        while (portList.hasMoreElements()) {
            portId = (CommPortIdentifier) portList.nextElement();
            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                if (portId.getName().equals(comPort)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void checkStatus() {
        send("ATZ\r\n");
        send("AT+CREG?\r\n");
    }

    public void send(String cmd) {
        try {

            outputStream.write(cmd.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  public void sendMessage() {

        send("AT+CMGF=1\r\n");

    }

    public void hangup() {
        send("ATH\r\n");
    }

    public void connect() throws NullPointerException, UnsupportedCommOperationException {
        if (portId != null) {
            try {
                portId.addPortOwnershipListener(this);
                serialPort = (SerialPort) portId.open("COM3", 2000);

            } catch (PortInUseException e) {
                e.printStackTrace();
            }

            try {
                inputStream = serialPort.getInputStream();
                outputStream = serialPort.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                /** These are the events we want to know about*/
                serialPort.addEventListener(this);
                serialPort.notifyOnDataAvailable(true);
            } catch (TooManyListenersException e) {
                e.printStackTrace();
            }



        } else {
            throw new NullPointerException("COM Port not found!!");
        }
    }

    public void disconnectPort() {
        portList = null;
        portId = null;

    }

    @Override
    public void serialEvent(javax.comm.SerialPortEvent serialPortEvent) {
        switch (serialPortEvent.getEventType()) {
            case SerialPortEvent.BI:
            case SerialPortEvent.OE:
            case SerialPortEvent.FE:
            case SerialPortEvent.PE:
            case SerialPortEvent.CD:
            case SerialPortEvent.CTS:
            case SerialPortEvent.DSR:
            case SerialPortEvent.RI:
            case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
            case SerialPortEvent.DATA_AVAILABLE:

                byte[] readBuffer = new byte[2048];
                try {
                    while (inputStream.available() > 0) {
                        int numBytes = inputStream.read(readBuffer);
                    }
//print response message
                    System.out.print(new String(readBuffer));
                    outputString.append(new String(readBuffer));
                } catch (IOException e) {
                }
                break;
        }
    }

    public void ownershipChange(int type) {
        switch (type) {
            case CommPortOwnershipListener.PORT_UNOWNED:
                System.out.println(portId.getName() + ": PORT_UNOWNED");
                break;
            case CommPortOwnershipListener.PORT_OWNED:
                System.out.println(portId.getName() + ": PORT_OWNED");
                break;
            case CommPortOwnershipListener.PORT_OWNERSHIP_REQUESTED:
                System.out.println(portId.getName() + ": PORT_INUSED");
                break;
        }

    }

    public void sendPhoneNu(String phoneNumber) {
        send("AT+CMGS=\"" + phoneNumber + "\"\r\n");
    }

    public void sendString(String message) {
        send(message + '\032' + "\r\n");
    }

    public void readSMS() {
        
        send("AT+CMGR=0\r\n");
    }
    
    public void listSmsFromMemory(){
        
        
        send("AT+CMGL=\"ALL\"\r\n");
    }
    
    public void selecttheMemory(){
        send("AT+CPMS=\"SM\"\r\n");
    }

    public void deleteAll() {
//        send("AT+CMGD=\"ALL\"\r\n");
        send("AT+CMGD=1,25\r\n");
    }
    
    public void deleteASMS(String index)
    {
        send("AT+CMGD="+index+"\r\n");
    }
    
    public void deleteSms() {
        try {
            send("AT+CMGD=0\r\n");
            Thread.sleep(500);
            send("AT+CMGD=1\r\n");
            Thread.sleep(500);
            send("AT+CMGD=2\r\n");
            Thread.sleep(500);
            send("AT+CMGD=3\r\n");
            Thread.sleep(500);
            send("AT+CMGD=4\r\n");
            Thread.sleep(500);
            send("AT+CMGD=5\r\n");
            Thread.sleep(500);
            send("AT+CMGD=6\r\n");
            Thread.sleep(500);
            send("AT+CMGD=7\r\n");
            Thread.sleep(500);
            send("AT+CMGD=8\r\n");
            Thread.sleep(500);
            send("AT+CMGD=9\r\n");
            Thread.sleep(500);
            send("AT+CMGD=10\r\n");
            Thread.sleep(500);
            send("AT+CMGD=11\r\n");
            Thread.sleep(500);
            send("AT+CMGD=12\r\n");
            Thread.sleep(500);
            send("AT+CMGD=13\r\n");
            Thread.sleep(500);
            send("AT+CMGD=14\r\n");
            Thread.sleep(500);
            send("AT+CMGD=15\r\n");
            Thread.sleep(500);
            send("AT+CMGD=16\r\n");
            Thread.sleep(500);
            send("AT+CMGD=17\r\n");
            Thread.sleep(500);
            send("AT+CMGD=18\r\n");
            Thread.sleep(500);
            send("AT+CMGD=19\r\n");
            Thread.sleep(500);
            send("AT+CMGD=20\r\n");
            Thread.sleep(500);
            send("AT+CMGD=21\r\n");
            Thread.sleep(500);
            send("AT+CMGD=22\r\n");
            Thread.sleep(500);
            send("AT+CMGD=23\r\n");
            Thread.sleep(500);
            send("AT+CMGD=24\r\n");
        } catch (InterruptedException ex) {
            Logger.getLogger(GSMConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String getoutputString(){
        return outputString.toString();
    }
}
