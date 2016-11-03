/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lms.domain.sub;

import com.lms.domain.Domain;
import java.util.UUID;

/**
 *
 * @author Sudarsan
 */
public class Staff extends Domain implements java.io.Serializable{

    private String employeeId;
    private String departmentName;
    private String fullName;
    private String dateOfBirth;
    private String gender;
    private String email;
    private String mobile;
    
    public Staff() {
        setGuid(UUID.randomUUID().toString());
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String toString() {
        StringBuilder toStringBuilder = new StringBuilder();
        toStringBuilder.append(super.toString());
        toStringBuilder.append("\n");
        toStringBuilder.append("\nemployeeId: ");
        toStringBuilder.append(employeeId);
        toStringBuilder.append("\ndepartmentName: ");
        toStringBuilder.append(departmentName);
        toStringBuilder.append("\nfullName: ");
        toStringBuilder.append(fullName);
        toStringBuilder.append("\ndateOfBirth: ");
        toStringBuilder.append(dateOfBirth);
        toStringBuilder.append("\ngender: ");
        toStringBuilder.append(gender);
        toStringBuilder.append("\nemail: ");
        toStringBuilder.append(email);
        toStringBuilder.append("\nmobile: ");
        toStringBuilder.append(mobile);
        return toStringBuilder.toString();
    }

   
    
}
