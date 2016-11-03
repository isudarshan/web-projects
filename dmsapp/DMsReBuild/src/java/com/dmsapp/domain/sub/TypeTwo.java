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
public class TypeTwo extends Domain implements java.io.Serializable {

    private String studentId;
    private String surName;
    private String firstName;
    private String interTwoMarks;
    private String assignmentMarks;
    private String attendanceMarks;
    private String rating;
    private String year;
    private String branch;
    private Integer semister;
    private String paper;
    private String internalType;

    public TypeTwo() {
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getInterTwoMarks() {
        return interTwoMarks;
    }

    public void setInterTwoMarks(String interTwoMarks) {
        this.interTwoMarks = interTwoMarks;
    }

    public String getInternalType() {
        return internalType;
    }

    public void setInternalType(String internalType) {
        this.internalType = internalType;
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

    public Integer getSemister() {
        return semister;
    }

    public void setSemister(Integer semister) {
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
        StringBuilder toStringBuilder = new StringBuilder();
        toStringBuilder.append(super.toString());
        toStringBuilder.append("\n");
        toStringBuilder.append("\nstudentId: ");
        toStringBuilder.append(studentId);
        toStringBuilder.append("\nsurName: ");
        toStringBuilder.append(surName);
        toStringBuilder.append("\nfirstName: ");
        toStringBuilder.append(firstName);
        toStringBuilder.append("\ninterTwoMarks: ");
        toStringBuilder.append(interTwoMarks);
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
