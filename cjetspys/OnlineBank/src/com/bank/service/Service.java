/**
 * 
 */
package com.bank.service;

import java.sql.Connection;

/**
 * @author Sudarsan
 *
 */
public interface Service {

	Connection getConnection() throws Exception;
	
	void closeConnection() throws Exception;
}
