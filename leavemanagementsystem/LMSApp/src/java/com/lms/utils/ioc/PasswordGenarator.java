/**
 * 
 */
package com.lms.utils.ioc;

import java.util.Calendar;
import java.util.Random;

/**
 * @author Sudarsan
 * 
 */
public final class PasswordGenarator {

	public static String genaratePassword() {

		Random random = new Random(System.currentTimeMillis());
		String randValue = String.valueOf((1 + random.nextInt(2)) * 10000
				+ random.nextInt(10000));

		StringBuilder builder = new StringBuilder();
		Calendar calendar = Calendar.getInstance();
		builder.append("LMS").append(randValue)
				.append(calendar.get(Calendar.YEAR));

		return builder.toString();

	}

}
