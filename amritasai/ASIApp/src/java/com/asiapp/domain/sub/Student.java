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
public class Student extends Domain implements java.io.Serializable {

    private String studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String address;
    private String departmentName;
    private String departmentCode;
    private String year;
    private String semister;
    private String subjectName;
    private String subjectCode;

    public Student() {
        setGuid(UUID.randomUUID().toString());
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSemister() {
        return semister;
    }

    public void setSemister(String semister) {
        this.semister = semister;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String toString() {
        StringBuilder toStringBuilder = new StringBuilder();
        toStringBuilder.append(super.toString());
        toStringBuilder.append("\n");
        toStringBuilder.append("\nstudentId: ");
        toStringBuilder.append(studentId);
        toStringBuilder.append("\nfirstName: ");
        toStringBuilder.append(firstName);
        toStringBuilder.append("\nlastName: ");
        toStringBuilder.append(lastName);
        toStringBuilder.append("\nemail: ");
        toStringBuilder.append(email);
        toStringBuilder.append("\nmobile: ");
        toStringBuilder.append(mobile);
        toStringBuilder.append("\naddress: ");
        toStringBuilder.append(address);
        toStringBuilder.append("\ndepartmentName: ");
        toStringBuilder.append(departmentName);
        toStringBuilder.append("\ndepartmentCode: ");
        toStringBuilder.append(departmentCode);
        toStringBuilder.append("\nyear: ");
        toStringBuilder.append(year);
        toStringBuilder.append("\nsemister: ");
        toStringBuilder.append(semister);
        toStringBuilder.append("\nsubjectName: ");
        toStringBuilder.append(subjectName);
        toStringBuilder.append("\nsubjectCode: ");
        toStringBuilder.append(subjectCode);
        return toStringBuilder.toString();
    }

    
}
