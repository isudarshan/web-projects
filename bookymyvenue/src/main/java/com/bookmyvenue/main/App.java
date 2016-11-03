package com.bookmyvenue.main;

import com.bookmyvenue.rest.resource.HelloResource;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

/**
 * @author Lakshmi Prasannam
 *
 */
public class App extends Application<Configuration> {
	public static void main(String[] args) {
		try {
			new App().run(new String[] { "server" });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run(Configuration configuration, Environment environment) throws Exception {
		final HelloResource helloResource = new HelloResource();
		environment.jersey().register(helloResource);

	}
}
