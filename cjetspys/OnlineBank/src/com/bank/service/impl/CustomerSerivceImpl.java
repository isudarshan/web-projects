/**
 * 
 */
package com.bank.service.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bank.domain.sub.Customer;
import com.bank.service.CustomerService;
import com.bank.utils.loggers.AppLogger;
import com.bank.utils.queries.CustomerQueries;

/**
 * @author Sudarsan
 * 
 */
public class CustomerSerivceImpl extends ServiceImpl implements CustomerService {

	private PreparedStatement preparedStatement = null;
	private Statement statement = null;
	private static Logger LOG = AppLogger.getLogger();
	private static CustomerSerivceImpl customerSerivceImpl = new CustomerSerivceImpl();

	/**
	 * Creates a SingleTon Service for <code>Customer.</code>
	 */
	private CustomerSerivceImpl() {

	}

	/**
	 * @return <code>CustomerService<code>
	 * 
	 */
	public static CustomerService getInstance() {
		return customerSerivceImpl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bank.service.CustomerService#create(com.bank.domain.sub.Customer)
	 */
	@Override
	public void create(Customer customer) throws Exception {

		
		LOG.debug("PIC SIZE : "+customer.getUserPic().available());
		LOG.debug("SIG SIZE : "+customer.getSignature().available());
		preparedStatement = getConnection().prepareStatement(
				CustomerQueries.INSERT);

		preparedStatement.setString(1, customer.getGuid());
		preparedStatement.setString(2, customer.getAccountNumber());
		preparedStatement.setString(3, customer.getFirstName());
		preparedStatement.setString(4, customer.getLastName());
		preparedStatement.setString(5, customer.getGender());
		preparedStatement.setString(6, customer.getDateOfBirth());
		preparedStatement.setString(7, customer.getEmail());
		preparedStatement.setString(8, customer.getMobile());
		preparedStatement.setBlob(9, customer.getUserPic());
		preparedStatement.setBlob(10, customer.getSignature());
		preparedStatement.setDate(11, new java.sql.Date(customer.getCreatedOn()
				.getTime()));
		preparedStatement.setInt(12, customer.getCreatedBy());
		preparedStatement.setDate(13, new java.sql.Date(customer
				.getModifiedOn().getTime()));
		preparedStatement.setInt(14, customer.getModifiedBy());
		preparedStatement.setInt(15, customer.getActive());

		preparedStatement.executeUpdate();
		preparedStatement.close();
		closeConnection();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bank.service.CustomerService#getAll()
	 */
	@Override
	public List<Customer> getAll() throws Exception {
		
		List<Customer> customerList = new ArrayList<Customer>();
		statement = getConnection().createStatement();
		ResultSet resultSet = statement.executeQuery(CustomerQueries.GET_ALL);

		while (resultSet.next()) {

			Customer customer = new Customer();
			
			customer.setId(resultSet.getInt(1));
			customer.setGuid(resultSet.getString(2));
			customer.setAccountNumber(resultSet.getString(3));
			customer.setFirstName(resultSet.getString(4));
			customer.setLastName(resultSet.getString(5));
			customer.setGender(resultSet.getString(6));
			customer.setDateOfBirth(resultSet.getString(7));
			customer.setEmail(resultSet.getString(8));
			customer.setMobile(resultSet.getString(9));
			customer.setUserPic(resultSet.getBinaryStream(10));
			customer.setSignature(resultSet.getBinaryStream(11));
			customer.setCreatedOn(resultSet.getDate(12));
			customer.setCreatedBy(resultSet.getInt(13));
			customer.setModifiedOn(resultSet.getDate(14));
			customer.setModifiedBy(resultSet.getInt(15));
			customer.setActive(resultSet.getInt(16));

			customerList.add(customer);

		}
		resultSet.close();
		statement.close();
		closeConnection();
		
		return customerList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bank.service.CustomerService#findByAccountNumber(java.lang.String)
	 */
	@Override
	public Customer findByAccountNumber(String accountNumber) throws Exception {

		preparedStatement = getConnection().prepareStatement(CustomerQueries.FIND_BY_ACCOUNTNUMBER);
		
		preparedStatement.setString(1, accountNumber);
		ResultSet resultSet = preparedStatement.executeQuery();
		Customer customer = null;
		if(resultSet.next()){
			customer = new Customer(); 
			
			customer.setId(resultSet.getInt(1));
			customer.setGuid(resultSet.getString(2));
			customer.setAccountNumber(resultSet.getString(3));
			customer.setFirstName(resultSet.getString(4));
			customer.setLastName(resultSet.getString(5));
			customer.setGender(resultSet.getString(6));
			customer.setDateOfBirth(resultSet.getString(7));
			customer.setEmail(resultSet.getString(8));
			customer.setMobile(resultSet.getString(9));
			customer.setUserPic(resultSet.getBinaryStream(10));
			customer.setSignature(resultSet.getBinaryStream(11));
			customer.setCreatedOn(resultSet.getDate(12));
			customer.setCreatedBy(resultSet.getInt(13));
			customer.setModifiedOn(resultSet.getDate(14));
			customer.setModifiedBy(resultSet.getInt(15));
			customer.setActive(resultSet.getInt(16));
		}
		
		preparedStatement.close();
		closeConnection();
		return customer;
	}

}
