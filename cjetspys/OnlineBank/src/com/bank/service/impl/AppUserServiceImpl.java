/**
 * 
 */
package com.bank.service.impl;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import com.bank.domain.sub.AppUser;
import com.bank.service.AppUserService;
import com.bank.utils.queries.AppUserQueries;

/**
 * @author Sudarsan
 * 
 */
public class AppUserServiceImpl extends ServiceImpl implements AppUserService {

	private PreparedStatement preparedStatement = null;
	private Statement statement = null;
	Scanner scanner = new Scanner(System.in);
	private static AppUserServiceImpl appUserServiceImpl = new AppUserServiceImpl();

	/**
	 * Creates a SingleTon Service for <code>AppUser.</code>
	 */
	private AppUserServiceImpl() {

	}

	/**
	 * @return <code>AppUserService</code> Provides a Single Instance for
	 *         <code>AppUserService</code>.
	 */
	public static AppUserService getInstance() {
		return appUserServiceImpl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bank.service.AppUserService#authenticate(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public AppUser authenticate(String userName, String password)
			throws Exception {

		preparedStatement = getConnection().prepareStatement(
				AppUserQueries.AUTHENTICATE);
		preparedStatement.setString(1, userName);
		preparedStatement.setString(2, password);

		ResultSet resultSet = preparedStatement.executeQuery();
		AppUser appUser = null;
		if (resultSet.next()) {

			appUser = new AppUser();

			appUser.setId(resultSet.getInt(1));
			appUser.setGuid(resultSet.getString(2));
			appUser.setUserName(resultSet.getString(3));
			appUser.setPassword(resultSet.getString(4));
			appUser.setQuestion(resultSet.getString(5));
			appUser.setAnswer(resultSet.getString(6));
			appUser.setUserRole(resultSet.getString(7));
			appUser.setCreatedOn(resultSet.getDate(8));
			appUser.setCreatedBy(resultSet.getInt(9));
			appUser.setModifiedOn(resultSet.getDate(10));
			appUser.setModifiedBy(resultSet.getInt(11));
			appUser.setActive(resultSet.getInt(12));

		}
		resultSet.close();
		preparedStatement.close();
		closeConnection();

		return appUser;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bank.service.AppUserService#create(com.bank.domain.sub.AppUser)
	 */
	@Override
	public void create(AppUser appUser) throws Exception {
		preparedStatement = getConnection().prepareStatement(
				AppUserQueries.INSERT);
		preparedStatement.setString(1, appUser.getGuid());
		preparedStatement.setString(2, appUser.getUserName());
		preparedStatement.setString(3, appUser.getPassword());
		preparedStatement.setString(4, appUser.getQuestion());
		preparedStatement.setString(5, appUser.getAnswer());
		preparedStatement.setString(6, appUser.getUserRole());
		preparedStatement.setDate(7, new java.sql.Date(appUser.getCreatedOn()
				.getTime()));
		preparedStatement.setInt(8, appUser.getCreatedBy());
		preparedStatement.setDate(9, new java.sql.Date(appUser.getModifiedOn()
				.getTime()));
		preparedStatement.setInt(10, appUser.getModifiedBy());
		preparedStatement.setInt(11, appUser.getActive());
		preparedStatement.executeUpdate();
		preparedStatement.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bank.service.AppUserService#changePassword(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public int changePassword(String userName, String oldPassword,
			String newPassword) throws Exception {

		int flag = 0;
		AppUser appUser = authenticate(userName, oldPassword);

		if (appUser == null) {
			flag = -1;
			return flag;
		}

		System.out.println(appUser);
		preparedStatement = getConnection().prepareStatement(
				AppUserQueries.CHANGE_PASSWORD);

		preparedStatement.setString(1, newPassword);
		preparedStatement.setString(2, appUser.getUserName());

		return preparedStatement.executeUpdate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bank.service.AppUserService#getPassword(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public AppUser getPassword(String userName, String question, String answer)
			throws Exception {
		// TODO By Yash
		preparedStatement = getConnection().prepareStatement(
				AppUserQueries.GET_PASSWORD);
		preparedStatement.setString(1, question);
		preparedStatement.setString(2, answer);
		preparedStatement.setString(3, userName);
		ResultSet resultSet = preparedStatement.executeQuery();
		AppUser appUser = null;
		if (resultSet.next()) {
			appUser = new AppUser();

			appUser.setId(resultSet.getInt(1));
			appUser.setGuid(resultSet.getString(2));
			appUser.setUserName(resultSet.getString(3));
			appUser.setPassword(resultSet.getString(4));
			appUser.setQuestion(resultSet.getString(5));
			appUser.setAnswer(resultSet.getString(6));
			appUser.setUserRole(resultSet.getString(7));
			appUser.setCreatedOn(resultSet.getDate(8));
			appUser.setCreatedBy(resultSet.getInt(9));
			appUser.setModifiedOn(resultSet.getDate(10));
			appUser.setModifiedBy(resultSet.getInt(11));
			appUser.setActive(resultSet.getInt(12));

		}
		return appUser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bank.service.AppUserService#setStatus(java.lang.String)
	 */
	@Override
	public int setStatus(String userName, int status) throws Exception {

		preparedStatement = getConnection().prepareStatement(
				AppUserQueries.CHANGE_STAUS);
		preparedStatement.setInt(1, 1);
		preparedStatement.setDate(2,
				new java.sql.Date(new java.util.Date().getTime()));
		preparedStatement.setInt(3, status);
		preparedStatement.setString(4, userName);
		int flag = preparedStatement.executeUpdate();
		preparedStatement.close();
		closeConnection();
		return flag;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bank.service.AppUserService#getAll()
	 */
	@Override
	public List<AppUser> getAll() throws Exception {

		List<AppUser> userList = new ArrayList<AppUser>();
		statement = getConnection().createStatement();
		ResultSet resultSet = statement.executeQuery(AppUserQueries.GET_ALL);

		while (resultSet.next()) {

			AppUser appUser = new AppUser();
			appUser.setId(resultSet.getInt(1));
			appUser.setGuid(resultSet.getString(2));
			appUser.setUserName(resultSet.getString(3));
			appUser.setPassword(resultSet.getString(4));
			appUser.setQuestion(resultSet.getString(5));
			appUser.setAnswer(resultSet.getString(6));
			appUser.setUserRole(resultSet.getString(7));
			appUser.setCreatedOn(resultSet.getDate(8));
			appUser.setCreatedBy(resultSet.getInt(9));
			appUser.setModifiedOn(resultSet.getDate(10));
			appUser.setModifiedBy(resultSet.getInt(11));
			appUser.setActive(resultSet.getInt(12));

			userList.add(appUser);

		}
		resultSet.close();
		statement.close();
		closeConnection();
		return userList;

	}

}
