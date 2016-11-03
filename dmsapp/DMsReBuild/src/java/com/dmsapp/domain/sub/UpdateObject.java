/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmsapp.domain.sub;

import com.dmsapp.domain.Domain;

/**
 *
 * @author Sudarsan
 */
public class UpdateObject extends Domain implements java.io.Serializable{

    private String studentId;
    private String surName;
    private String firstName;
    private String marks;
    private String assignmentMarks;
    private String attendanceMarks;
    private String rating;
    private String year;
    private String branch;
    private String semister;
    private String paper;
    private String internalType;

    public String getAssignmentMarks() {
        return assignmentMarks;
    }

    public void setAssignmentMarks(String assignmentMarks) {
        this.assignmentMarks = assignmentMarks;
    }

    public String getAttendanceMarks() {
        return attendanceMarks;
    }

    public void setAttendanceMarks(String attendanceMarks) {
        this.attendanceMarks = attendanceMarks;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getInternalType() {
        return internalType;
    }

    public void setInternalType(String internalType) {
        this.internalType = internalType;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
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

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
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
        toStringBuilder.append("\nsurName: ");
        toStringBuilder.append(surName);
        toStringBuilder.append("\nfirstName: ");
        toStringBuilder.append(firstName);
        toStringBuilder.append("\nmarks: ");
        toStringBuilder.append(marks);
        toStringBuilder.append("\nassignmentMarks: ");
        toStringBuilder.append(assignmentMarks);
        toStringBuilder.append("\nattendanceMarks: ");
        toStringBuilder.append(attendanceMarks);
        toStringBuilder.append("\nrating: ");
        toStringBuilder.append(rating);
        toStringBuilder.append("\nyear: ");
        toStringBuilder.append(year);
        toStringBuilder.append("\nbranch: ");
        toStringBuilder.append(branch);
        toStringBuilder.append("\nsemister: ");
        toStringBuilder.append(semister);
        toStringBuilder.append("\npaper: ");
        toStringBuilder.append(paper);
        toStringBuilder.append("\ninternalType: ");
        toStringBuilder.append(internalType);
        return toStringBuilder.toString();
    }

    
}
