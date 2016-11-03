/**
 * 
 */
package com.bank.utils.service;

import java.util.Calendar;
import java.util.Random;

/**
 * @author Sudarsan This Class Genarates Random Unique Account Numbers for the
 *         Customers at the time of Customer creation.
 * 
 */
public final class AccountNumberGenarator {

	/**
	 * @return <code>String</code> Unique Random Account Number
	 */
	public static String genarateAccountNumber() {

		Random random = new Random(System.currentTimeMillis());
		String randValue = String.valueOf((1 + random.nextInt(2)) * 10000
				+ random.nextInt(10000));

		StringBuilder builder = new StringBuilder();
		Calendar calendar = Calendar.getInstance();
		builder.append("ACC").append(randValue)
				.append(calendar.get(Calendar.YEAR));

		return builder.toString();

	}

}
