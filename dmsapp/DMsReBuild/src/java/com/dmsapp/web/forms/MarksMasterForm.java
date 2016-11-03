/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmsapp.web.forms;

/**
 *
 * @author Sudarsan
 */
public class MarksMasterForm {

    private String studentId;
    private String year;
    private String branch;
    private String semister;
    private String paper;
    private String internalOne;
    private String internalTwo;
    private String assignmentMarks;
    private String attendanceMarks;

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

    public String getInternalOne() {
        return internalOne;
    }

    public void setInternalOne(String internalOne) {
        this.internalOne = internalOne;
    }

    public String getInternalTwo() {
        return internalTwo;
    }

    public void setInternalTwo(String internalTwo) {
        this.internalTwo = internalTwo;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
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
        toStringBuilder.append("\nyear: ");
        toStringBuilder.append(year);
        toStringBuilder.append("\nbranch: ");
        toStringBuilder.append(branch);
        toStringBuilder.append("\nsemister: ");
        toStringBuilder.append(semister);
        toStringBuilder.append("\npaper: ");
        toStringBuilder.append(paper);
        toStringBuilder.append("\ninternalOne: ");
        toStringBuilder.append(internalOne);
        toStringBuilder.append("\ninternalTwo: ");
        toStringBuilder.append(internalTwo);
        toStringBuilder.append("\nassignmentMarks: ");
        toStringBuilder.append(assignmentMarks);
        toStringBuilder.append("\nattendanceMarks: ");
        toStringBuilder.append(attendanceMarks);
        return toStringBuilder.toString();
    }

    
}
