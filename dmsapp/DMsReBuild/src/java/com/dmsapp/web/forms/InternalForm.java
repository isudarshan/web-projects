/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmsapp.web.forms;

/**
 *
 * @author Sudarsan
 */
public class InternalForm implements java.io.Serializable {

    private String year;
    private String branch;
    private Integer semister;
    private String paper;
    private String internalType;

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
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

    public Integer getSemister() {
        return semister;
    }

    public void setSemister(Integer semister) {
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
        toStringBuilder.append("\ninternalType: ");
        toStringBuilder.append(internalType);
        return toStringBuilder.toString();
    }

    
}
