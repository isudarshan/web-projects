/**
 * 
 */
package com.asiapp.utils.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Sudarsan
 * 
 */
public class AppSaiSpringContext {
	public static void init() {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "beans.xml", "services.xml" });
		AppContext.APPCONTEXT = context;

	}
}
