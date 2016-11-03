/**
 * 
 */
package com.bank.utils.service;

import com.bank.service.AppUserService;
import com.bank.service.CustomerService;
import com.bank.service.impl.AppUserServiceImpl;
import com.bank.service.impl.CustomerSerivceImpl;

/**
 * @author Sudarsan
 * 
 */
public class ServiceUtils {

	/**
	 * @return <code>AppUserService<code>
	 * Utility method for using AppUserService.
	 */
	public static AppUserService getAppUserService() {
		return AppUserServiceImpl.getInstance();
	}

	/**
	 * @return<code>CustomerService</code>
	 * Utility method for using CustomerService.
	 */
	public static CustomerService getCustomerService() {
		return CustomerSerivceImpl.getInstance();
	}
}
