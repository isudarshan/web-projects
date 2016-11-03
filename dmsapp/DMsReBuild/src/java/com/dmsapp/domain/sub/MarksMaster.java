/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmsapp.domain.sub;

import com.dmsapp.domain.Domain;
import java.util.UUID;

/**
 *
 * @author Sudarsan
 */
public class MarksMaster extends Domain implements java.io.Serializable {

    private String studentId;
    private String year;
    private String branch;
    private String semister;
    private String paper;
    private String internalOne;
    private String internalTwo;
    private String assignmentMarks;
    private String attendanceMarks;

    public MarksMaster() {
        setGuid(UUID.randomUUID().toString());
    }

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

    @Override
    public String toString() {
        final String TAB = "    ";
        StringBuilder retValue = new StringBuilder();
        retValue.append("MarksMaster ( ").append(super.toString()).append(TAB).append("studentId = ").append(this.studentId).append(TAB).append("year = ").append(this.year).append(TAB).append("branch = ").append(this.branch).append(TAB).append("semister = ").append(this.semister).append(TAB).append("paper = ").append(this.paper).append(TAB).append("internalOne = ").append(this.internalOne).append(TAB).append("internalTwo = ").append(this.internalTwo).append(TAB).append("assignmentMarks = ").append(this.assignmentMarks).append(TAB).append("attendanceMarks = ").append(this.attendanceMarks).append(" )");
        return retValue.toString();
    }
}
