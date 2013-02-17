package org.uva.sea.ql;

import java.io.File;

import com.beust.jcommander.Parameter;

public class CommandLineParameters {
	@Parameter(names = {"-i"}, description = "QL input file", required = true)
	private File inputFile;
	
	@Parameter(names = {"-p"}, description = "Port to run the REST server on", required = false)
	private int port = 8080;
	
	public File getInputFile() {
		return inputFile;
	}
	
	public int getPort() {
		return port;
	}
}
