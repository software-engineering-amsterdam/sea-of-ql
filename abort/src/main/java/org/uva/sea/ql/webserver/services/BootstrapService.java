package org.uva.sea.ql.webserver.services;

import java.io.*;
import java.util.*;

import javax.ws.rs.*;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.*;
import org.uva.sea.ql.ServerProperties;
import org.uva.sea.ql.ast.traversal.typechecking.base.ISymbolTable;
import org.uva.sea.ql.ast.types.datatypes.*;
import org.uva.sea.ql.webserver.base.IWebService;
import org.uva.sea.ql.webserver.models.*;

import com.google.inject.Inject;

@Path("/bootstrap")
@Produces("application/json")
@Consumes("application/json")
public class BootstrapService implements IWebService {
	// Know all types to validate
	private final StringType stringType = new StringType();
	private final BoolType boolType = new BoolType();
	private final IntType intType = new IntType();
	private final MoneyType moneyType = new MoneyType();
	
	@Inject
	private ISymbolTable symbolTable;
	
	@Inject
	private ServerProperties properties;

	@POST
	@Path("/validateInteger")
	public boolean validateInteger(final ValidationWrapper input) {
		return intType.isAssignableFrom(input.getValue());
	}
	
	@POST
	@Path("/validateString")
	public boolean validateString(final ValidationWrapper input) {
		return stringType.isAssignableFrom(input.getValue());
	}	

	@POST
	@Path("/validateMoney")	
	public boolean validateMoney(final ValidationWrapper input) {
		return moneyType.isAssignableFrom(input.getValue());
	}
	
	@POST
	@Path("/validateBoolean")
	public boolean validateBoolean(final ValidationWrapper input) {
		return boolType.isAssignableFrom(input.getValue());
	}
	
	@POST
	@Path("/persist")
	public boolean validateAndPersistForm(final FormWrapper form) {
		Map<String, String> inputValues = form.getFormMap();
		for (Map.Entry<String,String> entry : inputValues.entrySet()) {
			final String name = entry.getKey();
			final String value = entry.getValue();
			
			if (!symbolTable.getDataTypeByName(name).isAssignableFrom(value)) {
				System.err.println(String.format("Invalid input for %s (value: %s)", name, value));
				return false;
			}
		}
		
		if (hasMissingIdents(form)) {
			System.err.println("The form has been posted incomplete");
			return false;
		}

		return writeFormToFile(form);
	}
	
	private boolean hasMissingIdents(final FormWrapper form) {
		return symbolTable.isInputIncomplete(form.getFormMap().keySet());
	}
	
	private boolean writeFormToFile(final FormWrapper form) {
		final File outputFile = new File(String.format("%s/form-%d.json", properties.getSaveFormPath(), Calendar.getInstance().getTimeInMillis()));

		final ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(outputFile, form.getFormMap());
			
			return true;
		}
		catch (JsonGenerationException e) {
			System.err.println(String.format("Failed to generate JSON (%s)", e.getMessage()));
		} 
		catch (JsonMappingException e) {
			System.err.println(String.format("Failed to map JSON (%s)", e.getMessage()));
		}
		catch (IOException e) {
			System.err.println(String.format("IO Exception (%s)", e.getMessage()));
		}
		
		return false;
	}
}
