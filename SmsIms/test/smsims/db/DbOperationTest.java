/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smsims.db;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import smsims.om.Member;
import smsims.om.MessageResult;

/**
 *
 * @author Lasith.Chandrasekara
 */
public class DbOperationTest {
    
    public DbOperationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insertMember method, of class DbOperation.
     */
    //@Test
    public void testInsertMember() throws Exception {
        System.out.println("insertMember");
        Member member = null;
        DbOperation instance = new DbOperation();
        instance.insertMember(member);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMembers method, of class DbOperation.
     */
    //@Test
    public void testGetMembers() {
        System.out.println("getMembers");
        String name = "";
        DbOperation instance = new DbOperation();
        List expResult = null;
        List result = instance.getMembers(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMembersByEmployeeCode method, of class DbOperation.
     */
    //@Test
    public void testGetMembersByEmployeeCode() throws Exception {
        System.out.println("getMembersByEmployeeCode");
        String empCode = "000";
        DbOperation instance = new DbOperation();
        List<Member> expResult = null;
        List<Member> result = instance.getMembersByEmployeeCode(empCode);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertMessageResult method, of class DbOperation.
     */
    @Test
    public void testInsertMessageResult() throws Exception {
        System.out.println("insertMessageResult");
        MessageResult messageResult = new MessageResult();
        messageResult.setIndex("0");
        messageResult.setMessageStatus("read");
        messageResult.setPhoneNumber("0718604483");
        messageResult.setSenderDate("2013/01/03");
        messageResult.setSessionId("001");
        messageResult.setSmsContent("Hello world");
        DbOperation instance = new DbOperation();
        instance.insertMessageResult(messageResult);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    //@Test
    public void testGetMessageResults() throws Exception {
        System.out.println("getMessageResults");
        DbOperation instance = new DbOperation();
        List<Member> expResult = null;
        List<Member> result = instance.getMessageResults("0718604483");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
