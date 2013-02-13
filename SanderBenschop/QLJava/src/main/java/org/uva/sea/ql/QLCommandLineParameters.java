package org.uva.sea.ql;

import com.beust.jcommander.Parameter;

import java.io.File;

public class QLCommandLineParameters {

    @Parameter(names = {"input", "i"}, description = "The QL input file", required = true)
    private File inputFile;

    @Parameter(names = {"port", "p"}, description = "The port the server will run on, default is 8080.", required = false)
    private int hostPort = 8080;

    public File getInputFile() {
        return inputFile;
    }

    public int getHostPort() {
        return hostPort;
    }
}
