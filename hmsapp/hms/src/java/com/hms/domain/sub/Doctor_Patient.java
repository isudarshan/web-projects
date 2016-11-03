/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.domain.sub;

import com.hms.domain.Domain;

/**
 *
 * @author cmc
 */
public class Doctor_Patient {

    private String doctorId;
    private String patientId;
    private String doctorName;
    private String patientName;
    private String requiredConsultation;
    private Long id;
    private String observation;
    private String medicalHistory;

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getRequiredConsultation() {
        return requiredConsultation;
    }

    public void setRequiredConsultation(String requiredConsultation) {
        this.requiredConsultation = requiredConsultation;
    }

    @Override
    public String toString() {
        return "Doctor_Patient{" + "doctorId=" + doctorId + ", patientId=" + patientId + ", doctorName=" + doctorName + ", patientName=" + patientName + ", requiredConsultation=" + requiredConsultation + ", id=" + id + ", observation=" + observation + ", medicalHistory=" + medicalHistory + '}';
    }

  
}
