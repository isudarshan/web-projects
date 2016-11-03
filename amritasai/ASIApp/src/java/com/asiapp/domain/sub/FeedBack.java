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
public class FeedBack extends Domain implements java.io.Serializable {

    private String studentId;
    private String departmentName;
    private String departmentCode;
    private String year;
    private String semister;
    private String subjectName;
    private String subjectCode;
    private String facultyName;
    private String feedBackTotal;
    
    public FeedBack() {
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

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFeedBackTotal() {
        return feedBackTotal;
    }

    public void setFeedBackTotal(String feedBackTotal) {
        this.feedBackTotal = feedBackTotal;
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
        toStringBuilder.append("\nfacultyName: ");
        toStringBuilder.append(facultyName);
        toStringBuilder.append("\nfeedBackTotal: ");
        toStringBuilder.append(feedBackTotal);
        return toStringBuilder.toString();
    }


}
