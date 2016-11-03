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
public class Bal extends Domain implements java.io.Serializable{


    private String employeeId;
    private String total;

    public Bal() {
        setGuid(UUID.randomUUID().toString());
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String toString() {
        StringBuilder toStringBuilder = new StringBuilder();
        toStringBuilder.append(super.toString());
        toStringBuilder.append("\n");
        toStringBuilder.append("\nemployeeId: ");
        toStringBuilder.append(employeeId);
        toStringBuilder.append("\ntotal: ");
        toStringBuilder.append(total);
        return toStringBuilder.toString();
    }

}
