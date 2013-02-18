package org.uva.sea.ql.web;

import com.google.inject.Inject;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/submit")
public class FormPersistenceController {

    @Inject
    private ObjectMapper objectMapper;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response validateAndPersistForm(String jsonString) throws JSONException, IOException {
        IdentifierValuePair[] identifierValuePairs = objectMapper.readValue(jsonString, IdentifierValuePair[].class);
        for(IdentifierValuePair identifierValuePair : identifierValuePairs) {

        }
        return null;
    }


}
