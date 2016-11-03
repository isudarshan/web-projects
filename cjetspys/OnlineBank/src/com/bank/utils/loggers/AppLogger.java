/**
 * 
 */
package com.bank.utils.loggers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author Sudarsan
 * 
 */
public class AppLogger {

	static {

		Properties properties = new Properties();
		try {

			InputStream inputStream = new FileInputStream("log4j.properties");
			properties.load(inputStream);
			PropertyConfigurator.configure(properties);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Logger getLogger() {
		Logger LOG = Logger.getRootLogger();
		return LOG;
	}
}
