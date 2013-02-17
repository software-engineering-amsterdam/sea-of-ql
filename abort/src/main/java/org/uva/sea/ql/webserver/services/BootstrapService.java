package org.uva.sea.ql.webserver.services;

import java.util.*;

import javax.ws.rs.*;

import org.uva.sea.ql.ast.traversal.typechecking.SymbolTable;
import org.uva.sea.ql.ast.traversal.typechecking.base.ITypeChecker;
import org.uva.sea.ql.ast.types.datatypes.*;
import org.uva.sea.ql.webserver.base.IWebService;

import com.google.inject.Inject;

@Path("/bootstrap")
@Produces("application/json")
@Consumes("application/json")
public class BootstrapService implements IWebService {
	// Knows all types to validate
	private final StringType stringType = new StringType();
	private final BoolType boolType = new BoolType();
	private final IntType intType = new IntType();
	private final MoneyType moneyType = new MoneyType();
	
	@Inject
	private ITypeChecker typeChecker;
	
	@GET
	@Produces("application/json")
	@Path("/sayHello")
	public String sayHello() {
		return "HELLO!";
	}

	@POST
	@Path("/validateInteger")
	public boolean validateInteger(final String input) {
		return intType.isAssignableFrom(input);
	}
	
	@POST
	@Path("/validateString")
	public boolean validateString(final String input) {
		return stringType.isAssignableFrom(input);
	}	

	@POST
	@Path("/validateMoney")	
	public boolean validateMoney(final String input) {
		return moneyType.isAssignableFrom(input);
	}
	
	@POST
	@Path("/validateBool")
	public boolean validateBoolean(final String input) {
		return boolType.isAssignableFrom(input);
	}
	
	@POST
	@Path("/persist")
	public void validateAndPersistForm(final Map<String, String> inputValues) {
		SymbolTable table = typeChecker.getSymbolTable();

	}
}
