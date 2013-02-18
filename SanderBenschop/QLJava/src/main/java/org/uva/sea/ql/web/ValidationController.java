package org.uva.sea.ql.web;

import org.uva.sea.ql.ast.primary.Ident;
import org.uva.sea.ql.ast.primary.typeClasses.BooleanType;
import org.uva.sea.ql.ast.primary.typeClasses.IntegerType;
import org.uva.sea.ql.ast.primary.typeClasses.StringType;
import org.uva.sea.ql.ast.primary.typeClasses.Type;
import org.uva.sea.ql.visitor.semanticanalysis.SymbolTable;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/validate")
public class ValidationController {

    private static final String ERROR_MESSAGE = "No valid %s input.";

    private final IntegerType integerType;
    private final BooleanType booleanType;
    private final StringType stringType;

    @Inject
    private SymbolTable symbolTable;

    public ValidationController() {
        this.integerType = new IntegerType();
        this.booleanType = new BooleanType();
        this.stringType = new StringType();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/integer")
    public Response validateIntegerQuestion(IdentifierValuePair identifierValuePair) {
        return validateInput(identifierValuePair, integerType);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/boolean")
    public Response validateBooleanQuestion(IdentifierValuePair identifierValuePair) {
        return validateInput(identifierValuePair, booleanType);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/string")
    public Response validateStringQuestion(IdentifierValuePair identifierValuePair) {
        return validateInput(identifierValuePair, stringType);
    }

    private Response validateInput(IdentifierValuePair identifierValuePair, Type expectedType) {
        String identifierName = identifierValuePair.getIdentifierName(), value = identifierValuePair.getValue();
        if (identifierName != null && identifierIsOfType(identifierName, expectedType) && expectedType.canBeAssignedFromValue(value)) {
            return Response.status(Response.Status.OK).entity("Ok").build();
        } else {
            String errorMessage = String.format(ERROR_MESSAGE, expectedType.getObjectLiteralSimpleClassName());
            return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
        }
    }

    private boolean identifierIsOfType(String identName, Type type) {
        Ident ident = new Ident(identName);
        Type reduceableType = symbolTable.getReduceableType(ident);
        if (reduceableType == null) {
            return false;
        }
        return reduceableType.isCompatibleTo(type);
    }
}
