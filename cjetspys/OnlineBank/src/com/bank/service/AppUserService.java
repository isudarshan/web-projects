/**
 * 
 */
package com.bank.service;

import java.util.List;

import com.bank.domain.sub.AppUser;

/**
 * @author Sudarsan
 * 
 * 
 */
public interface AppUserService extends Service {

	/**
	 * @param userame
	 * @param password
	 * @return <code>AppUser</code>
	 * @throws Exception
	 *             This Method is to Authenticate AppUser and returns AppUser,
	 *             if given userName and password exisits.
	 */
	AppUser authenticate(String userName, String password) throws Exception;

	/**
	 * @param appUser
	 * @throws Exception
	 *             Creates AppUser in the DataStore <code>BankDb</code>
	 */
	void create(AppUser appUser) throws Exception;

	/**
	 * @param userName
	 * @param oldPassword
	 * @param newPassword
	 * @return <code>int</code>
	 * @throws Exception
	 *             This Method is to give provision to change the Password of an
	 *             existing <code>AppUser.</code>
	 */
	int changePassword(String userName, String oldPassword, String newPassword)
			throws Exception;

	/**
	 * @param userName
	 * @param question
	 * @param answer
	 * @return <code>AppUser</code>
	 * @throws Exception
	 *             Returns <code>AppUser</code> Password, if given userName,
	 *             question and answer matches with the Data Store.
	 */
	AppUser getPassword(String userName, String question, String answer)
			throws Exception;

	/**
	 * @param userName
	 * @param status
	 * @return <code>int</code>
	 * @throws Exception
	 *             This Method is to change the <code>Status</code> of the
	 *             AppUser, this used to activate and deactivate the
	 *             <code>AppUser</code>.
	 */
	int setStatus(String userName, int status) throws Exception;

	/**
	 * @return <code>List<AppUser></code>
	 * @throws Exception
	 * Returns the List of Users from the DataStore.
	 */
	List<AppUser> getAll() throws Exception;
}
