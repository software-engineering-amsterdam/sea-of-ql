package org.uva.sea.ql.web;

import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.StringType;
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
        QLInputValidationResult result = inputValidator.validateInputForType(identifierValuePair, integerType);
        return createResponseFromInputValidationResult(result);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/boolean")
    public Response validateBooleanQuestion(IdentifierValuePair identifierValuePair) {
        QLInputValidationResult result = inputValidator.validateInputForType(identifierValuePair, booleanType);
        return createResponseFromInputValidationResult(result);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/string")
    public Response validateStringQuestion(IdentifierValuePair identifierValuePair) {
        QLInputValidationResult result = inputValidator.validateInputForType(identifierValuePair, stringType);
        return createResponseFromInputValidationResult(result);
    }

    public Response createResponseFromInputValidationResult(QLInputValidationResult qlInputValidationResult) {
        Response.ResponseBuilder builder;
        if (qlInputValidationResult.isCorrect()) {
            builder = Response.status(Response.Status.OK);
        } else {
            builder = Response.status(Response.Status.BAD_REQUEST);
        }
        return builder.entity(qlInputValidationResult.getMessage()).build();
    }
}
