package org.uva.sea.ql.web;

import org.uva.sea.ql.ast.primary.typeClasses.BooleanType;
import org.uva.sea.ql.ast.primary.typeClasses.IntegerType;
import org.uva.sea.ql.ast.primary.typeClasses.StringType;
import org.uva.sea.ql.web.inputvalidation.QLInputValidationResult;
import org.uva.sea.ql.web.inputvalidation.QLInputValidator;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/validate")
public class ValidationController {

    private final IntegerType integerType;
    private final BooleanType booleanType;
    private final StringType stringType;

    @Inject
    private QLInputValidator inputValidator;

    public ValidationController() {
        this.integerType = new IntegerType();
        this.booleanType = new BooleanType();
        this.stringType = new StringType();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/integer")
    public Response validateIntegerQuestion(IdentifierValuePair identifierValuePair) {
        QLInputValidationResult result = inputValidator.validateIdentifierIsOfType(identifierValuePair, integerType);
        return result.toResponse();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/boolean")
    public Response validateBooleanQuestion(IdentifierValuePair identifierValuePair) {
        QLInputValidationResult result = inputValidator.validateIdentifierIsOfType(identifierValuePair, booleanType);
        return result.toResponse();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/string")
    public Response validateStringQuestion(IdentifierValuePair identifierValuePair) {
        QLInputValidationResult result = inputValidator.validateIdentifierIsOfType(identifierValuePair, stringType);
        return result.toResponse();
    }
}
