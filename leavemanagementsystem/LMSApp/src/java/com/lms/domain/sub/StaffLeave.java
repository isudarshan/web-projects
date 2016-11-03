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
public class StaffLeave extends Domain implements java.io.Serializable {

    private String employeeId;
    private String leaveStart;
    private String leaveEnd;
    private String type;
    private String reasons;
    private String address;
    private String mobile;
    private String leaveCount;

    public StaffLeave() {
        setGuid(UUID.randomUUID().toString());
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getLeaveEnd() {
        return leaveEnd;
    }

    public void setLeaveEnd(String leaveEnd) {
        this.leaveEnd = leaveEnd;
    }

    public String getLeaveStart() {
        return leaveStart;
    }

    public void setLeaveStart(String leaveStart) {
        this.leaveStart = leaveStart;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons;
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
        toStringBuilder.append("\nleaveStart: ");
        toStringBuilder.append(leaveStart);
        toStringBuilder.append("\nleaveEnd: ");
        toStringBuilder.append(leaveEnd);
        toStringBuilder.append("\ntype: ");
        toStringBuilder.append(type);
        toStringBuilder.append("\nreasons: ");
        toStringBuilder.append(reasons);
        toStringBuilder.append("\naddress: ");
        toStringBuilder.append(address);
        toStringBuilder.append("\nmobile: ");
        toStringBuilder.append(mobile);
        toStringBuilder.append("\nleaveCount: ");
        toStringBuilder.append(leaveCount);
        return toStringBuilder.toString();
    }
}
