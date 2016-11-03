/**
 * 
 */
package com.bank.domain.sub;

import java.io.InputStream;
import java.util.UUID;

import com.bank.domain.Domain;

/**
 * @author Sudarsan
 *
 */
public class Customer extends Domain{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String accountNumber;
	private String firstName;
	private String lastName;
	private String gender;
	private String dateOfBirth;
	private String email;
	private String mobile;
	private InputStream userPic;
	private InputStream signature;
	
	public Customer() {
		setGuid(UUID.randomUUID().toString());
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
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
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the userPic
	 */
	public InputStream getUserPic() {
		return userPic;
	}

	/**
	 * @param userPic the userPic to set
	 */
	public void setUserPic(InputStream userPic) {
		this.userPic = userPic;
	}

	/**
	 * @return the signature
	 */
	public InputStream getSignature() {
		return signature;
	}

	/**
	 * @param signature the signature to set
	 */
	public void setSignature(InputStream signature) {
		this.signature = signature;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [accountNumber=");
		builder.append(accountNumber);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", dateOfBirth=");
		builder.append(dateOfBirth);
		builder.append(", email=");
		builder.append(email);
		builder.append(", mobile=");
		builder.append(mobile);
		builder.append(", userPic=");
		builder.append(userPic);
		builder.append(", signature=");
		builder.append(signature);
		builder.append("]");
		return builder.toString();
	}
	
	
}
