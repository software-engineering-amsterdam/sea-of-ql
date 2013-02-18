package org.uva.sea.ql;

import java.io.File;

import com.beust.jcommander.Parameter;

/**
 * Represents command line parameters, so JCommander can parse them for us.
 * 
 * @author J. Dijkstra
 */
public class CommandLineParameters {
	@Parameter(names = { "-i" }, description = "QL input file path", required = true)
	private File inputFile;

	/**
	 * Retrieve the QL input file.
	 * 
	 * @return input file
	 */
	public File getInputFile() {
		return inputFile;
	}
}