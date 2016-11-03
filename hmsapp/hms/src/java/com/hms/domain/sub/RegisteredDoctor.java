/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.domain.sub;

import com.hms.domain.Domain;
import java.io.InputStream;
import java.util.UUID;

/**
 *
 * @author cmc
 */
public class RegisteredDoctor extends Domain{
   
    private String userName;

    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    private String doctorId;
    private String firstName;
    private String lastName;
    private String gender;
    private String specialization;
    private String mobileNumber;
    private String email;
    private String experience;
    private  byte[] photoGraph;
    
    public RegisteredDoctor() {
        setGuid(UUID.randomUUID().toString());
    }

    /**
     * @return the doctorId
     */
    public String getDoctorId() {
        return doctorId;
    }

    /**
     * @param doctorId the doctorId to set
     */
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the specialization
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * @param specialization the specialization to set
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     * @return the mobileNumber
     */
    public String getMobileNumber() {
        return mobileNumber;
    }

    /**
     * @param mobileNumber the mobileNumber to set
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the experience
     */
    public String getExperience() {
        return experience;
    }

    /**
     * @param experience the experience to set
     */
    public void setExperience(String experience) {
        this.experience = experience;
    }

    public byte[] getPhotoGraph() {
        return photoGraph;
    }

    public void setPhotoGraph(byte[] photoGraph) {
        this.photoGraph = photoGraph;
    }

    @Override
    public String toString() {
        return "RegisteredDoctor{" + "userName=" + userName + ", doctorId=" + doctorId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", specialization=" + specialization + ", mobileNumber=" + mobileNumber + ", email=" + email + ", experience=" + experience + ", photoGraph=" + photoGraph + '}';
    }

    

    
}
