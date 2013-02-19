package org.uva.sea.ql.web;

import com.google.inject.Inject;
import org.apache.commons.io.FileUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import org.uva.sea.ql.general.QLPropertiesUtil;
import org.uva.sea.ql.web.inputvalidation.QLInputValidationResult;
import org.uva.sea.ql.web.inputvalidation.QuestionValidator;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Path("/submit")
public class PersistenceController {

    private static final String SERIALIZATION_DESTINATION_FILE_SUFFIX = "/serialized.txt";
    private static final String CSV_HEADER_ROW = "identifierName,value";

    @Inject
    private QuestionValidator inputValidator;
    @Inject
    private ObjectMapper objectMapper;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response validateAndPersistForm(String jsonString) throws JSONException, IOException {
        IdentifierValuePair[] identifierValuePairs = objectMapper.readValue(jsonString, IdentifierValuePair[].class);

        QLInputValidationResult validationResult = inputValidator.validateInput(identifierValuePairs);
        if (!validationResult.isCorrect()) {
            return Response.status(Response.Status.BAD_REQUEST).entity(validationResult.getMessage()).build();
        }

        persistIdentifierValuePairs(identifierValuePairs);

        return Response.status(Response.Status.OK).entity(QLInputValidationResult.OK_MESSAGE).build();
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
}
