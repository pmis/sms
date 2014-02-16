/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smsims.om;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Lasith
 */
@Entity
@Table(name = "member_details")
public class Member {
    
    @Id @GeneratedValue
    private Integer id;
    
    private String empCode;
    
    private String name;
    
    private String tpNumber;
    
    private String department;
    
    private String site;
    
    private String mgtLevel; 
    
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the tpNumber
     */
    public String getTpNumber() {
        return tpNumber;
    }

    /**
     * @param tpNumber the tpNumber to set
     */
    public void setTpNumber(String tpNumber) {
        this.tpNumber = tpNumber;
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getMgtLevel() {
        return mgtLevel;
    }

    public void setMgtLevel(String mgtLevel) {
        this.mgtLevel = mgtLevel;
    }    
    
    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
