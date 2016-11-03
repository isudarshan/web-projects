/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lms.web.forms;

/**
 *
 * @author Sudarsan
 */
public class SecurityForm {

     private String employeeId;
    private String question;
    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String toString() {
        StringBuilder toStringBuilder = new StringBuilder();
        toStringBuilder.append(super.toString());
        toStringBuilder.append("\n");
        toStringBuilder.append("\nemployeeId: ");
        toStringBuilder.append(employeeId);
        toStringBuilder.append("\nquestion: ");
        toStringBuilder.append(question);
        toStringBuilder.append("\nanswer: ");
        toStringBuilder.append(answer);
        return toStringBuilder.toString();
    }
}
