package com.bank.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.bank.domain.sub.Customer;
import com.bank.utils.service.ServiceUtils;

public class CustomerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Customer customer = new Customer();

		customer.setAccountNumber("1111");
		customer.setFirstName("aaa");
		customer.setLastName("aaa");
		customer.setGender("male");
		customer.setDateOfBirth("23/05/2013");
		customer.setEmail("aaa@gmail.com");
		customer.setMobile("77022393");
		InputStream userPic = null;

		try {

			userPic = new FileInputStream(new File("Koala.jpg"));
			customer.setUserPic(userPic);
			customer.setSignature(userPic);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		customer.setCreatedOn(new java.util.Date());
		customer.setCreatedBy(1);
		customer.setModifiedOn(new java.util.Date());
		customer.setModifiedBy(1);
		customer.setActive(1);

		try {
			ServiceUtils.getCustomerService().create(customer);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
