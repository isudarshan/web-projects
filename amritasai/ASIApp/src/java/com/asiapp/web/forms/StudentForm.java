/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asiapp.web.forms;

/**
 *
 * @author Sudarsan
 */
public class StudentForm {

    private String departmentName;
    private String year;
    private String semister;
    private String subject;
    private String studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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
        toStringBuilder.append("\ndepartmentName: ");
        toStringBuilder.append(departmentName);
        toStringBuilder.append("\nyear: ");
        toStringBuilder.append(year);
        toStringBuilder.append("\nsemister: ");
        toStringBuilder.append(semister);
        toStringBuilder.append("\nsubject: ");
        toStringBuilder.append(subject);
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
        return toStringBuilder.toString();
    }   
    
    
}
