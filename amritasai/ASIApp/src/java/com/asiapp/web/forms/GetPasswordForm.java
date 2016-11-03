/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asiapp.web.forms;

/**
 *
 * @author Sudarsan
 */
public class GetPasswordForm {

    private String studentId;
    private String question;
    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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
        toStringBuilder.append("\nquestion: ");
        toStringBuilder.append(question);
        toStringBuilder.append("\nanswer: ");
        toStringBuilder.append(answer);
        return toStringBuilder.toString();
    }

    
}
