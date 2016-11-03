/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmsapp.web.forms;

/**
 *
 * @author Sudarsan
 */
public class UpdateForm implements java.io.Serializable{

    private Integer id;
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
    private Integer active;
    private String internalOne;
    private String internalTwo;

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        final String TAB = "    ";
        StringBuilder retValue = new StringBuilder();
        retValue.append("UpdateForm ( ").append(super.toString()).append(TAB).append("id = ").append(this.id).append(TAB).append("studentId = ").append(this.studentId).append(TAB).append("surName = ").append(this.surName).append(TAB).append("firstName = ").append(this.firstName).append(TAB).append("marks = ").append(this.marks).append(TAB).append("assignmentMarks = ").append(this.assignmentMarks).append(TAB).append("attendanceMarks = ").append(this.attendanceMarks).append(TAB).append("rating = ").append(this.rating).append(TAB).append("year = ").append(this.year).append(TAB).append("branch = ").append(this.branch).append(TAB).append("semister = ").append(this.semister).append(TAB).append("paper = ").append(this.paper).append(TAB).append("internalType = ").append(this.internalType).append(TAB).append("active = ").append(this.active).append(TAB).append("internalOne = ").append(this.internalOne).append(TAB).append("internalTwo = ").append(this.internalTwo).append(" )");
        return retValue.toString();
    }

    
}
