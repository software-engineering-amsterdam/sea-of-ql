package org.uva.sea.ql.webserver;

import java.util.*;

import javax.ws.rs.*;

import org.uva.sea.ql.ast.types.datatypes.*;

@Path("/bootstrap")
public class BootstrapServiceResource implements IServlet {
	private static final List<DataType> types = new ArrayList<DataType>();
	
	// Knows all types to validate
	static {
		types.add(new IntType());
		types.add(new BoolType());
		types.add(new StringType());
		types.add(new MoneyType());
	}
	
	@GET
	@Produces("application/json")
	@Path("/sayHello")
	public String sayHello() {
		return "HELLO!";
	}

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/validateType")
	// TODO: validate using QLparser for all inputs? 
	public boolean validateInteger(final String input) {
		return false;
		//return IntType.isAssignableFrom(input);
	}
	
	@GET
	@Produces("application/json")
	@Path("/sayBye")
	public String sayBye() {
		return "BYE!";
	}
	
	private DataType createDataType(String type) {
		if (type.equalsIgnoreCase("string")) return new StringType();
		else if (type.equalsIgnoreCase("int")) return new IntType();
		else if (type.equalsIgnoreCase("money")) return new MoneyType();
		else if (type.equalsIgnoreCase("bool")) return new BoolType();
		return null;
	}
}
