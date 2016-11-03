/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asiapp.domain.sub;

import com.asiapp.domain.Domain;
import java.util.UUID;

/**
 *
 * @author Sudarsan
 */
public class Department extends Domain implements java.io.Serializable{

    private String departmentName;
    private String departmentCode;

    public Department() {
        setGuid(UUID.randomUUID().toString());
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String toString() {
        StringBuilder toStringBuilder = new StringBuilder();
        toStringBuilder.append(super.toString());
        toStringBuilder.append("\n");
        toStringBuilder.append("\ndepartmentName: ");
        toStringBuilder.append(departmentName);
        toStringBuilder.append("\ndepartmentCode: ");
        toStringBuilder.append(departmentCode);
        return toStringBuilder.toString();
    }
    
}
