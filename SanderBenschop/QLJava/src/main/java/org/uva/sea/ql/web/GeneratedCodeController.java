package org.uva.sea.ql.web;

import org.apache.commons.io.FileUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.File;
import java.io.IOException;

@Path("/")
public class GeneratedCodeController {

    private static final String FILE_NAME = "./target/ql/index.html";

    @GET
    public String getCode() throws IOException {
        File file = new File(FILE_NAME);
        return FileUtils.readFileToString(file);
    }
}
