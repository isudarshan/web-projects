/**
 * 
 */
package com.bank.utils.queries;

/**
 * @author Sudarsan
 * 
 */
public interface AppUserQueries {

	public static final String INSERT = "INSERT INTO APPUSER(GUID, USERNAME, PASSWORD, QUESTION, ANSWER, USERROLE, CREATEDON, CREATEDBY, MODIFIEDON, MODIFIEDBY, ACTIVE) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	public static final String GET_ALL = "SELECT * FROM APPUSER";
	public static final String AUTHENTICATE = "SELECT * FROM APPUSER WHERE USERNAME = ? AND PASSWORD = ?";
	public static final String GET_PASSWORD = "SELECT * FROM APPUSER WHERE QUESTION = ? AND ANSWER = ? AND USERNAME = ?";
	public static final String CHANGE_PASSWORD = "UPDATE APPUSER SET PASSWORD = ? WHERE USERNAME = ?";
	public static final String CHANGE_STAUS = "UPDATE APPUSER SET MODIFIEDBY = ?, MODIFIEDON = ?, ACTIVE = ? WHERE USERNAME = ?";
}
