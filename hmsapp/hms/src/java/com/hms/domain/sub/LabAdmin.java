/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.domain.sub;

/**
 *
 * @author cmc
 */
public class LabAdmin {

    private Long id;
    private String userName;
    private String doctorId;
    private String testFee;
    private String doctorName;
    private String patientId;
    private String patientName;
    private String report;
    private String testSuggested;
    private byte[] uploadReport;
    private byte[] photo;

    public byte[] getUploadReport() {
        return uploadReport;
    }

    public void setUploadReport(byte[] uploadReport) {
        this.uploadReport = uploadReport;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getTestSuggested() {
        return testSuggested;
    }

    public void setTestSuggested(String testSuggested) {
        this.testSuggested = testSuggested;
    }

    public String getTestFee() {
        return testFee;
    }

    public void setTestFee(String testFee) {
        this.testFee = testFee;
    }

    @Override
    public String toString() {
        return "LabAdmin{" + "id=" + id + ", doctorId=" + doctorId + ", testFee=" + testFee + ", doctorName=" + doctorName + ", patientId=" + patientId + ", patientName=" + patientName + ", report=" + report + ", testSuggested=" + testSuggested + '}';
    }
}
