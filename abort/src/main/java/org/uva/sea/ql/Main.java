package org.uva.sea.ql;

import org.uva.sea.ql.base.IStartupController;

import com.beust.jcommander.*;

/**
 * TODO: write this.
 * 
 * @author abort
 */
public class Main {	
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
    	jCommander.setProgramName("QLBawss");
    	
    	try {
    		jCommander.parse(args);
    		
        	final IStartupController startupController = new BootstrapStartupController(parameters);
        	startupController.start();
    	}
    	catch(ParameterException exception) {
    		System.err.println("Invalid input, check the usage.");
    		jCommander.usage();
    	}
    }
}
