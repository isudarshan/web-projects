/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.domain.sub;

import com.hms.domain.Domain;
import java.util.UUID;

/**
 *
 * @author cmc
 */
public class AppUser extends Domain {

    private String userName;
    private String password;
    private String userRole;
    private String securityQuestion;
    private String answer;

    public AppUser() {
        setGuid(UUID.randomUUID().toString());
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "AppUser{" + "userName=" + userName + ", password=" + password + ", userRole=" + userRole + '}';
    }

   
}
