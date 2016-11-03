/**
 * 
 */
package com.bank.domain.sub;

import java.util.UUID;

import com.bank.domain.Domain;

/**
 * @author Sudarsan
 * 
 */
public class AppUser extends Domain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private String question;
	private String answer;
	private String userRole;

	public AppUser() {
		setGuid(UUID.randomUUID().toString());
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question
	 *            the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer
	 *            the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole
	 *            the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AppUser [userName=");
		builder.append(userName);
		builder.append(", password=");
		builder.append(password);
		builder.append(", question=");
		builder.append(question);
		builder.append(", answer=");
		builder.append(answer);
		builder.append(", userRole=");
		builder.append(userRole);
		builder.append("]");
		return builder.toString();
	}

}
