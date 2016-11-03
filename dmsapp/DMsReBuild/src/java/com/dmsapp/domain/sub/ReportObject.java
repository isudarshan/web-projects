/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmsapp.domain.sub;

/**
 *
 * @author Sudarsan
 */
public class ReportObject implements java.io.Serializable {

    private String studentId;
    private String studentName;
    private String internalOne;
    private String internalTwo;
    private String attendance;
    private String numberOfWorkingDays;
    private String numberOfPresentedDays;
    private String assignment;
    private Integer totalMarks;
    private String grandTotal;
    private String year;
    private String branch;
    private String semister;
    private String paper;
    private String paperCode;
    private String hasAssignment;
    private String howMany;

    public String getAssignment() {
        return assignment;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(String grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getHasAssignment() {
        return hasAssignment;
    }

    public void setHasAssignment(String hasAssignment) {
        this.hasAssignment = hasAssignment;
    }

    public String getHowMany() {
        return howMany;
    }

    public void setHowMany(String howMany) {
        this.howMany = howMany;
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

    public String getNumberOfPresentedDays() {
        return numberOfPresentedDays;
    }

    public void setNumberOfPresentedDays(String numberOfPresentedDays) {
        this.numberOfPresentedDays = numberOfPresentedDays;
    }

    public String getNumberOfWorkingDays() {
        return numberOfWorkingDays;
    }

    public void setNumberOfWorkingDays(String numberOfWorkingDays) {
        this.numberOfWorkingDays = numberOfWorkingDays;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    public String getPaperCode() {
        return paperCode;
    }

    public void setPaperCode(String paperCode) {
        this.paperCode = paperCode;
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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(Integer totalMarks) {
        this.totalMarks = totalMarks;
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
        retValue.append("ReportObject ( ").append(super.toString()).append(TAB).append("studentId = ").append(this.studentId).append(TAB).append("studentName = ").append(this.studentName).append(TAB).append("internalOne = ").append(this.internalOne).append(TAB).append("internalTwo = ").append(this.internalTwo).append(TAB).append("attendance = ").append(this.attendance).append(TAB).append("numberOfWorkingDays = ").append(this.numberOfWorkingDays).append(TAB).append("numberOfPresentedDays = ").append(this.numberOfPresentedDays).append(TAB).append("assignment = ").append(this.assignment).append(TAB).append("totalMarks = ").append(this.totalMarks).append(TAB).append("grandTotal = ").append(this.grandTotal).append(TAB).append("year = ").append(this.year).append(TAB).append("branch = ").append(this.branch).append(TAB).append("semister = ").append(this.semister).append(TAB).append("paper = ").append(this.paper).append(TAB).append("paperCode = ").append(this.paperCode).append(TAB).append("hasAssignment = ").append(this.hasAssignment).append(TAB).append("howMany = ").append(this.howMany).append(" )");
        return retValue.toString();
    }

    
}
