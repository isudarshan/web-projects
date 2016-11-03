/**
 * 
 */
package com.bank.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.bank.service.Service;

/**
 * @author Sudarsan
 * 
 */
public class ServiceImpl implements Service {

	private Connection connection = null;

	private InputStream inputStream = null;
	private Properties properties = null;

	private String driverName = null;
	private String url = null;
	private String userName = null;
	private String password = null;

	public ServiceImpl() {
		try {
			inputStream = new FileInputStream("database.properties");
			properties = new Properties();
			properties.load(inputStream);
			this.driverName = properties.getProperty("driverName");
			this.url = properties.getProperty("url");
			this.userName = properties.getProperty("userName");
			this.password = properties.getProperty("password");

		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	@Override
	public Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName(driverName);
		connection = DriverManager.getConnection(url, userName, password);
		return connection;
	}

	@Override
	public void closeConnection() throws SQLException {

		if (connection != null) {
			connection.close();
		}
	}

}
