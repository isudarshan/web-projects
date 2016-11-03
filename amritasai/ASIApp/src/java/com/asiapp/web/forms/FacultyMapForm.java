/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asiapp.web.forms;

/**
 *
 * @author Sudarsan
 */
public class FacultyMapForm {

    private String departmentName;
    private String year;
    private String semister;
    private String subject;
    private String facultyName;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getSemister() {
        return semister;
    }

    public void setSemister(String semister) {
        this.semister = semister;
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
        toStringBuilder.append("\nfacultyName: ");
        toStringBuilder.append(facultyName);
        return toStringBuilder.toString();
    }

    
}
