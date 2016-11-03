/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmsapp.domain.sub;

import com.dmsapp.domain.Domain;

/**
 *
 * @author Sudarsan
 */
public class Branch extends Domain implements java.io.Serializable {

    private String branch;

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        StringBuilder toStringBuilder = new StringBuilder();
        toStringBuilder.append(super.toString());
        toStringBuilder.append("\n");
        toStringBuilder.append("\nbranch: ");
        toStringBuilder.append(branch);
        return toStringBuilder.toString();
    }

}
