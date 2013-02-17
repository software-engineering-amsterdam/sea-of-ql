package org.uva.sea.ql.webserver.services;

import java.util.*;

import javax.ws.rs.*;

import org.uva.sea.ql.ast.types.datatypes.*;
import org.uva.sea.ql.ast.types.literals.*;
import org.uva.sea.ql.webserver.base.IWebService;

@Path("/bootstrap")
@Produces("application/json")
@Consumes("application/json")
public class BootstrapService implements IWebService {
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
	@Path("/validateInteger")
	// TODO: validate using QLparser for all inputs? 
	public boolean validateInteger(final String input) {
		return types.get(0).isAssignableFrom(input);
	}
	
	@POST
	@Path("/validateIntLiteral")
	// TODO: validate using QLparser for all inputs? 
	public String validateIntLiteral(final IntLiteral literal) {
		System.out.println("literal: " + literal.getValue());
		return "hey";
	}	
	
	@POST
	@Path("/validateStringLiteral")
	// TODO: validate using QLparser for all inputs? 
	public String validateStringLiteral(final StringLiteral literal) {
		System.out.println("literal: " + literal.getValue());
		return "hey";
	}

	@POST
	@Path("/validateMoneyLiteral")	
	public String validateMoneyLiteral(final MoneyLiteral literal) {
		System.out.println("literal: " + literal.getValue());
		return "hi";
	}

	@GET
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
