/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asiapp.domain.sub;

/**
 *
 * @author Sudarsan
 */
public class ReportObject implements java.io.Serializable{
    private String facultyName;
    private String departmentName;
    private String year;
    private String semister;
    private String subjectName;
    private String totalStudents;
    private String totalPoints;
    private String gainedPoints;

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

    public String getGainedPoints() {
        return gainedPoints;
    }

    public void setGainedPoints(String gainedPoints) {
        this.gainedPoints = gainedPoints;
    }

    public String getSemister() {
        return semister;
    }

    public void setSemister(String semister) {
        this.semister = semister;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(String totalPoints) {
        this.totalPoints = totalPoints;
    }

    public String getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(String totalStudents) {
        this.totalStudents = totalStudents;
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
        toStringBuilder.append("\nfacultyName: ");
        toStringBuilder.append(facultyName);
        toStringBuilder.append("\ndepartmentName: ");
        toStringBuilder.append(departmentName);
        toStringBuilder.append("\nyear: ");
        toStringBuilder.append(year);
        toStringBuilder.append("\nsemister: ");
        toStringBuilder.append(semister);
        toStringBuilder.append("\nsubjectName: ");
        toStringBuilder.append(subjectName);
        toStringBuilder.append("\ntotalStudents: ");
        toStringBuilder.append(totalStudents);
        toStringBuilder.append("\ntotalPoints: ");
        toStringBuilder.append(totalPoints);
        toStringBuilder.append("\ngainedPoints: ");
        toStringBuilder.append(gainedPoints);
        return toStringBuilder.toString();
    }

    

}
