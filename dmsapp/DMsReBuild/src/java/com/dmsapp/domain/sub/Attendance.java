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
public class Attendance extends Domain implements java.io.Serializable {

    private String year;
    private String branch;
    private String semister;
    private String paper;
    private String paperCode;
    private String numberOfWorkingDays;

    public Attendance() {
        setGuid(UUID.randomUUID().toString());
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
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
        toStringBuilder.append("\nyear: ");
        toStringBuilder.append(year);
        toStringBuilder.append("\nbranch: ");
        toStringBuilder.append(branch);
        toStringBuilder.append("\nsemister: ");
        toStringBuilder.append(semister);
        toStringBuilder.append("\npaper: ");
        toStringBuilder.append(paper);
        toStringBuilder.append("\npaperCode: ");
        toStringBuilder.append(paperCode);
        toStringBuilder.append("\nnumberOfWorkingDays: ");
        toStringBuilder.append(numberOfWorkingDays);
        return toStringBuilder.toString();
    }

    
}
