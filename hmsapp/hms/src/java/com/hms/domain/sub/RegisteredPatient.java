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
public class RegisteredPatient extends Domain{

    private String userName;
    private String patientId;
    private String firstName;
    private String lastName;
    private String gender;
    private String address;
    private String height;
    private String weight;
    private String mobileNumber;
    private String observation;
    private String requestedConsultant;
    private String dateOfBirth;
    private String age;
    private String medicalHistory;
    private double consultationFee;
    private byte[] photograph;

    public byte[] getPhotograph() {
        return photograph;
    }

    public void setPhotograph(byte[] photograph) {
        this.photograph = photograph;
    }
    
    public RegisteredPatient(){
        setGuid(UUID.randomUUID().toString());
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

   

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getRequestedConsultant() {
        return requestedConsultant;
    }

    public void setRequestedConsultant(String requestedConsultant) {
        this.requestedConsultant = requestedConsultant;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }
     @Override
    public String toString() {
        return "RegisteredPatient{" + "userName=" + userName + ", patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", address=" + address + ", height=" + height + ", weight=" + weight + ", mobileNumber=" + mobileNumber + ", observation=" + observation + ", requestedConsultant=" + requestedConsultant + ", dateOfBirth=" + dateOfBirth + ", age=" + age + ", medicalHistory=" + medicalHistory + ", consultationFee=" + consultationFee + '}';
    }
}
