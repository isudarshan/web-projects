/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmsapp.domain.sub;

/**
 *
 * @author Sudarsan
 */
public class SubMaster {

    private Integer id;
    private String year;
    private String branch;
    private String semister;
    private String paper;
    private String paperCode;

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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


}
