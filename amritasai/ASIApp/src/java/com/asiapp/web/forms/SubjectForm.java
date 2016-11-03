/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asiapp.web.forms;

/**
 *
 * @author Sudarsan
 */
public class SubjectForm {

    private String subjectTitle;
    private String subjectCode;
    private String departmentName;
    private String year;
    private String semister;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getSemister() {
        return semister;
    }

    public void setSemister(String semister) {
        this.semister = semister;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
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
        toStringBuilder.append("\nsubjectTitle: ");
        toStringBuilder.append(subjectTitle);
        toStringBuilder.append("\nsubjectCode: ");
        toStringBuilder.append(subjectCode);
        toStringBuilder.append("\ndepartmentName: ");
        toStringBuilder.append(departmentName);       
        toStringBuilder.append("\nyear: ");
        toStringBuilder.append(year);
        toStringBuilder.append("\nsemister: ");
        toStringBuilder.append(semister);
        return toStringBuilder.toString();
    }
}
