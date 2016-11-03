/**
 * 
 */
package com.bookmyvenue.rest.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Lakshmi Prasannam
 *
 */
@Path("/hello-world")
public class HelloResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHello() {
		return "Hello, World !";
	}
}
