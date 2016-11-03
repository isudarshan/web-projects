/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmsapp.web.forms;

/**
 *
 * @author Sudarsan
 */
public class HomeForm implements java.io.Serializable {

    private String year;
    private String branch;
    private String semister;
    private String paper;
    private String papaerCode;
    private String internalType;
    private String numberOfWorkingDays;
    private String hasAssMarks;

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getHasAssMarks() {
        return hasAssMarks;
    }

    public void setHasAssMarks(String hasAssMarks) {
        this.hasAssMarks = hasAssMarks;
    }

    public String getInternalType() {
        return internalType;
    }

    public void setInternalType(String internalType) {
        this.internalType = internalType;
    }

    public String getNumberOfWorkingDays() {
        return numberOfWorkingDays;
    }

    public void setNumberOfWorkingDays(String numberOfWorkingDays) {
        this.numberOfWorkingDays = numberOfWorkingDays;
    }

    public String getPapaerCode() {
        return papaerCode;
    }

    public void setPapaerCode(String papaerCode) {
        this.papaerCode = papaerCode;
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
        toStringBuilder.append("\nyear: ");
        toStringBuilder.append(year);
        toStringBuilder.append("\nbranch: ");
        toStringBuilder.append(branch);
        toStringBuilder.append("\nsemister: ");
        toStringBuilder.append(semister);
        toStringBuilder.append("\npaper: ");
        toStringBuilder.append(paper);
        toStringBuilder.append("\npapaerCode: ");
        toStringBuilder.append(papaerCode);
        toStringBuilder.append("\ninternalType: ");
        toStringBuilder.append(internalType);
        toStringBuilder.append("\nnumberOfWorkingDays: ");
        toStringBuilder.append(numberOfWorkingDays);
        toStringBuilder.append("\nhasAssMarks: ");
        toStringBuilder.append(hasAssMarks);
        return toStringBuilder.toString();
    }

    
   

}
