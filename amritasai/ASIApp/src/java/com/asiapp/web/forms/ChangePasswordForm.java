/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asiapp.web.forms;

/**
 *
 * @author Sudarsan
 */
public class ChangePasswordForm {

    private String studentId;
    private String currentPassword;
    private String newPassword;
    private String confirmPassword;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String toString() {
        StringBuilder toStringBuilder = new StringBuilder();
        toStringBuilder.append(super.toString());
        toStringBuilder.append("\n");
        toStringBuilder.append("\nstudentId: ");
        toStringBuilder.append(studentId);
        toStringBuilder.append("\ncurrentPassword: ");
        toStringBuilder.append(currentPassword);
        toStringBuilder.append("\nnewPassword: ");
        toStringBuilder.append(newPassword);
        toStringBuilder.append("\nconfirmPassword: ");
        toStringBuilder.append(confirmPassword);
        return toStringBuilder.toString();
    }
    

}
