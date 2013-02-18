package org.uva.sea.ql.web;

import com.google.inject.Inject;
import org.apache.commons.io.FileUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import org.uva.sea.ql.QLPropertiesUtil;
import org.uva.sea.ql.web.inputvalidation.QLInputValidationResult;
import org.uva.sea.ql.web.inputvalidation.QLInputValidator;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Path("/submit")
public class FormPersistenceController {

    private static final String SERIALIZATION_DESTINATION_FILE_SUFFIX = "/serialized.txt";

    private static final String CSV_HEADER_ROW = "identifierName,value";

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

        if (!erroneousResults.isEmpty()) {
            String errorMessageList = createErrorMessageListFromValidationResults(erroneousResults);
            return Response.status(Response.Status.BAD_REQUEST).entity(errorMessageList).build();
        }

        persistIdentifierValuePairs(identifierValuePairs);

        return Response.status(Response.Status.OK).entity(QLInputValidator.OK_MESSAGE).build();
    }

    private void persistIdentifierValuePairs(IdentifierValuePair[] identifierValuePairs) throws IOException {
        File outputFile = new File(QLPropertiesUtil.getProperty("qlTargetFolder") + SERIALIZATION_DESTINATION_FILE_SUFFIX);

        List<String> csvRows = new ArrayList<String>();
        csvRows.add(CSV_HEADER_ROW);
        for (IdentifierValuePair identifierValuePair : identifierValuePairs) {
            csvRows.add(identifierValuePair.toCsvRow());
        }

        FileUtils.writeLines(outputFile, csvRows);
    }

    private String createErrorMessageListFromValidationResults(List<QLInputValidationResult> erroneousResults) {
        StringBuilder stringBuilder = new StringBuilder();
        for (QLInputValidationResult erroneousResult : erroneousResults) {
            stringBuilder.append(erroneousResult.getMessage());
        }
        return stringBuilder.toString();
    }
}
