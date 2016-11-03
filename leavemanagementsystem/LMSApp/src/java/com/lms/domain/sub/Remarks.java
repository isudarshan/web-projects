/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lms.domain.sub;

import com.lms.domain.Domain;
import java.util.UUID;

/**
 *
 * @author Sudarsan
 */
public class Remarks extends Domain implements java.io.Serializable{

    private String employeeId;
    private String type;
    private String status;
    private String remarks;
    private String leaveCount;
    
    public Remarks() {
        setGuid(UUID.randomUUID().toString());
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getLeaveCount() {
        return leaveCount;
    }

    public void setLeaveCount(String leaveCount) {
        this.leaveCount = leaveCount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        StringBuilder toStringBuilder = new StringBuilder();
        toStringBuilder.append(super.toString());
        toStringBuilder.append("\n");
        toStringBuilder.append("\nemployeeId: ");
        toStringBuilder.append(employeeId);
        toStringBuilder.append("\ntype: ");
        toStringBuilder.append(type);
        toStringBuilder.append("\nstatus: ");
        toStringBuilder.append(status);
        toStringBuilder.append("\nremarks: ");
        toStringBuilder.append(remarks);
        toStringBuilder.append("\nleaveCount: ");
        toStringBuilder.append(leaveCount);
        return toStringBuilder.toString();
    }
    

}
