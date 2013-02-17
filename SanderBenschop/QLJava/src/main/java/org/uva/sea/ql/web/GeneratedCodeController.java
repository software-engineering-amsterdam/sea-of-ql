package org.uva.sea.ql.web;

import org.uva.sea.ql.GeneratedCodeReaderWriter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.IOException;

@Path("/")
public class GeneratedCodeController {

    @GET
    public String getCode() throws IOException {
        return GeneratedCodeReaderWriter.readGeneratedCode();
    }
}
