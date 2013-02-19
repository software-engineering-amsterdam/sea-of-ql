package org.uva.sea.ql.web;

import org.uva.sea.ql.bootstrapping.QLProgram;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.IOException;

@Path("/")
public class WebappIndexController {

    @Inject
    private QLProgram qlProgram;

    @GET
    public String getCode() throws IOException {
        return qlProgram.getGeneratedQLCode();
    }
}
