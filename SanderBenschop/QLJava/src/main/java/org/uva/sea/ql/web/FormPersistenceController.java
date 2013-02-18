package org.uva.sea.ql.web;

import com.google.inject.Inject;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import org.uva.sea.ql.web.inputvalidation.QLInputValidationResult;
import org.uva.sea.ql.web.inputvalidation.QLInputValidator;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Path("/submit")
public class FormPersistenceController {

    @Inject
    private QLInputValidator inputValidator;
    @Inject
    private ObjectMapper objectMapper;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response validateAndPersistForm(String jsonString) throws JSONException, IOException {
        IdentifierValuePair[] identifierValuePairs = objectMapper.readValue(jsonString, IdentifierValuePair[].class);
        List<QLInputValidationResult> erroneousResults = new ArrayList<QLInputValidationResult>();
        for(IdentifierValuePair identifierValuePair : identifierValuePairs) {
            QLInputValidationResult result = inputValidator.validateInput(identifierValuePair);
            if (!result.isCorrect()) erroneousResults.add(result);
        }
        return createResultFromValidationResults(erroneousResults);
    }

    private Response createResultFromValidationResults(List<QLInputValidationResult> erroneousResults) {
        if (erroneousResults.isEmpty()) {
            return Response.status(Response.Status.OK).entity(QLInputValidator.OK_MESSAGE).build();
        } else {
            String errorMessageList = createErrorMessageListFromValidationResults(erroneousResults);
            return Response.status(Response.Status.BAD_REQUEST).entity(errorMessageList).build();
        }
    }

    private String createErrorMessageListFromValidationResults(List<QLInputValidationResult> erroneousResults) {
        StringBuilder stringBuilder = new StringBuilder();
        for (QLInputValidationResult erroneousResult : erroneousResults) {
            stringBuilder.append(erroneousResult.getMessage());
        }
        return stringBuilder.toString();
    }
}
