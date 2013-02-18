package org.uva.sea.ql.web;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/submit")
public class FormPersistenceController {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response validateAndPersistForm(String identifierNameValues) throws JSONException {
        JSONArray jsonArray = new JSONArray(identifierNameValues);
        return null;
    }
}
