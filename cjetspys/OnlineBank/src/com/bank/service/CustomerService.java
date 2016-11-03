/**
 * 
 */
package com.bank.service;

import java.util.List;

import com.bank.domain.sub.Customer;

/**
 * @author Sudarsan
 * 
 */
public interface CustomerService extends Service {

	/**
	 * @param customer
	 * @throws Exception
	 *             Creates a Customer in the DataStore
	 */
	void create(Customer customer) throws Exception;

	/**
	 * @return <code>Customer</code> List
	 * @throws Exception
	 *             Returns a List of Customers from the DataStore
	 */
	List<Customer> getAll() throws Exception;

	/**
	 * @param accountNumber
	 * @return <code>Customer</code>
	 * @throws Exception
	 *             Returns a Customer from the DataStore, while passing
	 *             <code>accountNumber</code>.
	 */
	Customer findByAccountNumber(String accountNumber) throws Exception;

}
