package org.uva.sea.ql.web;

import org.uva.sea.ql.startup.WebApp;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.IOException;

@Path("/")
public class IndexController {

    @Inject
    private WebApp webApp;

    @GET
    public String getCode() throws IOException {
        return webApp.getGeneratedQLCode();
    }
}
