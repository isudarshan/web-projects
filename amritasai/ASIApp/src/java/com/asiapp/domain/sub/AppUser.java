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
public class AppUser extends Domain implements java.io.Serializable{

    private String userName;
    private String password;
    private String userRole;
    private String question;
    private String answer;

    public AppUser() {
        setGuid(UUID.randomUUID().toString());
    }
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String toString() {
        StringBuilder toStringBuilder = new StringBuilder();
        toStringBuilder.append(super.toString());
        toStringBuilder.append("\n");
        toStringBuilder.append("\nuserName: ");
        toStringBuilder.append(userName);
        toStringBuilder.append("\npassword: ");
        toStringBuilder.append(password);
        toStringBuilder.append("\nuserRole: ");
        toStringBuilder.append(userRole);
        toStringBuilder.append("\nquestion: ");
        toStringBuilder.append(question);
        toStringBuilder.append("\nanswer: ");
        toStringBuilder.append(answer);
        return toStringBuilder.toString();
    }


}
