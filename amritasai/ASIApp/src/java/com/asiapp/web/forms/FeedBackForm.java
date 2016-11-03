/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asiapp.web.forms;

/**
 *
 * @author Sudarsan
 */
public class FeedBackForm {

    private String[] pun;
    private String[] comm;
    private String[] cls;
    private String[] dbts;
    private String[] subd;
    private String[] busg;
    private String subName;
    private String facultyName;
    private String studentId;
    private String year;
    private String semister;
    private String departmentName;

    public String[] getBusg() {
        return busg;
    }

    public void setBusg(String[] busg) {
        this.busg = busg;
    }

    public String[] getCls() {
        return cls;
    }

    public void setCls(String[] cls) {
        this.cls = cls;
    }

    public String[] getComm() {
        return comm;
    }

    public void setComm(String[] comm) {
        this.comm = comm;
    }

    public String[] getDbts() {
        return dbts;
    }

    public void setDbts(String[] dbts) {
        this.dbts = dbts;
    }

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

    public String[] getPun() {
        return pun;
    }

    public void setPun(String[] pun) {
        this.pun = pun;
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

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String[] getSubd() {
        return subd;
    }

    public void setSubd(String[] subd) {
        this.subd = subd;
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
        toStringBuilder.append("\npun: ");
        if (pun != null) {
            toStringBuilder.append("\nSize: ");
            toStringBuilder.append(pun.length);
            for (int i = 0; i < pun.length; ++i) {
                toStringBuilder.append("\nIndex ");
                toStringBuilder.append(i);
                toStringBuilder.append(": ");
                toStringBuilder.append(pun[i]);
            }
        } else {
            toStringBuilder.append("NULL");
        }
        toStringBuilder.append("\ncomm: ");
        if (comm != null) {
            toStringBuilder.append("\nSize: ");
            toStringBuilder.append(comm.length);
            for (int i = 0; i < comm.length; ++i) {
                toStringBuilder.append("\nIndex ");
                toStringBuilder.append(i);
                toStringBuilder.append(": ");
                toStringBuilder.append(comm[i]);
            }
        } else {
            toStringBuilder.append("NULL");
        }
        toStringBuilder.append("\ncls: ");
        if (cls != null) {
            toStringBuilder.append("\nSize: ");
            toStringBuilder.append(cls.length);
            for (int i = 0; i < cls.length; ++i) {
                toStringBuilder.append("\nIndex ");
                toStringBuilder.append(i);
                toStringBuilder.append(": ");
                toStringBuilder.append(cls[i]);
            }
        } else {
            toStringBuilder.append("NULL");
        }
        toStringBuilder.append("\ndbts: ");
        if (dbts != null) {
            toStringBuilder.append("\nSize: ");
            toStringBuilder.append(dbts.length);
            for (int i = 0; i < dbts.length; ++i) {
                toStringBuilder.append("\nIndex ");
                toStringBuilder.append(i);
                toStringBuilder.append(": ");
                toStringBuilder.append(dbts[i]);
            }
        } else {
            toStringBuilder.append("NULL");
        }
        toStringBuilder.append("\nsubd: ");
        if (subd != null) {
            toStringBuilder.append("\nSize: ");
            toStringBuilder.append(subd.length);
            for (int i = 0; i < subd.length; ++i) {
                toStringBuilder.append("\nIndex ");
                toStringBuilder.append(i);
                toStringBuilder.append(": ");
                toStringBuilder.append(subd[i]);
            }
        } else {
            toStringBuilder.append("NULL");
        }
        toStringBuilder.append("\nbusg: ");
        if (busg != null) {
            toStringBuilder.append("\nSize: ");
            toStringBuilder.append(busg.length);
            for (int i = 0; i < busg.length; ++i) {
                toStringBuilder.append("\nIndex ");
                toStringBuilder.append(i);
                toStringBuilder.append(": ");
                toStringBuilder.append(busg[i]);
            }
        } else {
            toStringBuilder.append("NULL");
        }
        toStringBuilder.append("\nsubName: ");
        toStringBuilder.append(subName);
        toStringBuilder.append("\nfacultyName: ");
        toStringBuilder.append(facultyName);
        toStringBuilder.append("\nstudentId: ");
        toStringBuilder.append(studentId);
        toStringBuilder.append("\nyear: ");
        toStringBuilder.append(year);
        toStringBuilder.append("\nsemister: ");
        toStringBuilder.append(semister);
        toStringBuilder.append("\ndepartmentName: ");
        toStringBuilder.append(departmentName);
        return toStringBuilder.toString();
    }

    

    
}
