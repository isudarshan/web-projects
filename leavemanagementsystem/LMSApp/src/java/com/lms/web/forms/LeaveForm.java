/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lms.web.forms;

/**
 *
 * @author Sudarsan
 */
public class LeaveForm {

    private String employeeId;
    private String toDate;
    private String fromDate;
    private String leaveType;    
    private String reasonsforLeave;
    private String contactAddress;
    private String mobile;

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }  

    public String getReasonsforLeave() {
        return reasonsforLeave;
    }

    public void setReasonsforLeave(String reasonsforLeave) {
        this.reasonsforLeave = reasonsforLeave;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String toString() {
        StringBuilder toStringBuilder = new StringBuilder();
        toStringBuilder.append(super.toString());
        toStringBuilder.append("\n");
        toStringBuilder.append("\nemployeeId: ");
        toStringBuilder.append(employeeId);
        toStringBuilder.append("\ntoDate: ");
        toStringBuilder.append(toDate);
        toStringBuilder.append("\nfromDate: ");
        toStringBuilder.append(fromDate);
        toStringBuilder.append("\nleaveType: ");
        toStringBuilder.append(leaveType);        
        toStringBuilder.append("\nreasonsforLeave: ");
        toStringBuilder.append(reasonsforLeave);
        toStringBuilder.append("\ncontactAddress: ");
        toStringBuilder.append(contactAddress);
        toStringBuilder.append("\nmobile: ");
        toStringBuilder.append(mobile);
        return toStringBuilder.toString();
    }

    

}
