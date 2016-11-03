/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asiapp.domain.sub;

import com.asiapp.domain.Domain;
import java.util.UUID;

/**
 *
 * @author Sudarsan
 */
public class Faculty extends Domain implements java.io.Serializable{

    private String facultyName;
    private String departmentName;
    private String departmentCode;
    private String email;
    private String mobile;
    
    public Faculty() {
        setGuid(UUID.randomUUID().toString());
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
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

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
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
        toStringBuilder.append("\nfacultyName: ");
        toStringBuilder.append(facultyName);
        toStringBuilder.append("\ndepartmentName: ");
        toStringBuilder.append(departmentName);
        toStringBuilder.append("\ndepartmentCode: ");
        toStringBuilder.append(departmentCode);
        toStringBuilder.append("\nemail: ");
        toStringBuilder.append(email);
        toStringBuilder.append("\nmobile: ");
        toStringBuilder.append(mobile);
        return toStringBuilder.toString();
    }


}
