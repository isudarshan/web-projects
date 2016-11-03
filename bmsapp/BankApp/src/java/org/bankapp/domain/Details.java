package org.bankapp.domain;
// Generated Apr 21, 2014 10:52:35 AM by Hibernate Tools 3.2.1.GA

/**
 * Details generated by hbm2java
 */
public class Details implements java.io.Serializable {

    private Long detailsId;
    private String firstName;
    private String lastName;
    private String mobile;
    private String emailId;
    private String parentName;
    private String designation;
    private byte[] picture;
    private byte[] signature;
    private byte[] documents;
    private String accountType;
    private String securityQuestion;
    private String securityAnswer;
    private String DateOfBirth;
    private Double minimumBalance;
    private Address addressId;

    public Details() {
    }

    public Details(Long detailsId, String firstName, String lastName, String mobile, String parentName, String emailId, String designation, byte[] picture, byte[] signature, byte[] documents, String accountType, String securityQuestion, String securityAnswer, String DateOfBirth, Double minimumBalance, Address addressId) {
        this.detailsId = detailsId;
        this.firstName = firstName;
        this.designation = designation;
        this.lastName = lastName;
        this.mobile = mobile;
        this.emailId = emailId;
        this.picture = picture;
        this.parentName = parentName;
        this.signature = signature;
        this.documents = documents;
        this.accountType = accountType;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
        this.DateOfBirth = DateOfBirth;
        this.minimumBalance = minimumBalance;
        this.addressId = addressId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Long getDetailsId() {
        return detailsId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setDetailsId(Long detailsId) {
        this.detailsId = detailsId;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public byte[] getSignature() {
        return signature;
    }

    public void setSignature(byte[] signature) {
        this.signature = signature;
    }

    public byte[] getDocuments() {
        return documents;
    }

    public void setDocuments(byte[] documents) {
        this.documents = documents;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public Double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(Double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + (this.detailsId != null ? this.detailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Details other = (Details) obj;
        if (this.detailsId != other.detailsId && (this.detailsId == null || !this.detailsId.equals(other.detailsId))) {
            return false;
        }
        return true;
    }
}
