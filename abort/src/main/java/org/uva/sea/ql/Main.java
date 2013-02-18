package org.uva.sea.ql;


import com.beust.jcommander.*;

/**
 * Entry point for the QL Code Generator. Uses a startup controller to handle input and implement the code generation sequence.
 * 
 * @author J. Dijkstra
 */
public class Main {	
	/**
	 * Name of the application, used for usage description in the console.
	 */
	private static final String APPLICATION_NAME = "QLCodeGenerator";

	/**
	 * Entry point of the application.
	 * 
	 * @param args
	 *            command line arguments
	 * @see CommandLineParameters
	 */
    public static void main(String[] args) {
    	final CommandLineParameters parameters = new CommandLineParameters();
    	final JCommander jCommander = new JCommander(parameters);
    	jCommander.setProgramName(APPLICATION_NAME);
    	
    	try {
    		// Parse command line arguments necessary for a startup controller to initialize
    		jCommander.parse(args);
    		
    		// Initialize code generation startup
        	final IStartupController startupController = new BootstrapStartupController(parameters);
        	startupController.start();
    	}
    	catch (ParameterException exception) {
    		System.err.println("Invalid input, check the usage.");

    		jCommander.usage();
    	}
    }
}
