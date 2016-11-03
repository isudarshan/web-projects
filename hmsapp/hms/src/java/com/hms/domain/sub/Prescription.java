/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.domain.sub;

/**
 *
 * @author cmc
 */
public class Prescription {
    
    private Long id;
    private String doctorId;
    private String DoctorName;
    private String patientId;
    private String patientName;
    private String prescription;
    private String testSuggested;

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
        return DoctorName;
    }

    public void setDoctorName(String DoctorName) {
        this.DoctorName = DoctorName;
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

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getTestSuggested() {
        return testSuggested;
    }

    public void setTestSuggested(String testSuggested) {
        this.testSuggested = testSuggested;
    }

    @Override
    public String toString() {
        return "Prescription{" + "id=" + id + ", doctorId=" + doctorId + ", DoctorName=" + DoctorName + ", patientId=" + patientId + ", patientName=" + patientName + ", prescription=" + prescription + ", testSuggested=" + testSuggested + '}';
    }
    
}
