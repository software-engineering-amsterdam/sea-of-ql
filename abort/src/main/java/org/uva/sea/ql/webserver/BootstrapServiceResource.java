package org.uva.sea.ql.webserver;

import javax.ws.rs.*;

@Path("/bootstrap")
public class BootstrapServiceResource implements IServlet {
	
	@GET
	@Produces("application/json")
	@Path("/sayHello")
	public String sayHello() {
		return "HELLO!";
	}

	@GET
	@Produces("application/json")
	@Path("/sayBye")
	public String sayBye() {
		return "BYE!";
	}
}
