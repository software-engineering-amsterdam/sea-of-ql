package org.uva.sea.ql;

import java.io.*;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.traversal.codegeneration.BootstrapGenerator;
import org.uva.sea.ql.ast.traversal.codegeneration.base.*;
import org.uva.sea.ql.ast.traversal.typechecking.TypeChecker;
import org.uva.sea.ql.ast.traversal.typechecking.base.ITypeChecker;
import org.uva.sea.ql.parser.antlr.FormParser;
import org.uva.sea.ql.parser.base.*;
import org.uva.sea.ql.util.*;
import org.uva.sea.ql.webserver.*;
import org.uva.sea.ql.webserver.base.IWebServer;

/**
 * Startup an instance of the bootstrap code generation, type checking, server and interpreting module.
 * 
 * @author J. Dijkstra
 */
public class BootstrapStartupController implements IStartupController {
	/**
	 * Output file to generate code to.
	 */
	private static final String OUTPUT_FILE_NAME = "index.html";
	
	/**
	 * Input file to generate code from.
	 */
	private final File inputFile;
	
	/**
	 * Server properties (shared with ANT).
	 */
	private final ServerProperties properties = new ServerProperties();

	/**
	 * Bootstrap Server to spawn after code generation.
	 */
	private IWebServer server;
	
	/**
	 * Form used to type check, generate code 
	 */
	private Form form;

	/**
	 * One type checker that is first used to type check and later to validate server form input.
	 */
	private final ITypeChecker typeChecker = new TypeChecker();
	
	/**
	 * Constructor.
	 * 
	 * @param parameters command line parameters to use.
	 */
	public BootstrapStartupController(final CommandLineParameters parameters) {
		this.inputFile = parameters.getInputFile();
	}
	
	@Override
	public void start() {
		// Read properties file, return on error
		if (!checkAndReadPropertiesFile()) {
			outputShutdownDueToError();
			return;
		}
		
		// Parse form, return on error
		if (!checkAndParseForm()) {
			outputShutdownDueToError();
			return;
		}

		// On form type errors stop running
		if (checkForFormErrors()) {
			outputShutdownDueToError();
			return;
		}

		// Generate frontend, return on error
		if (!checkAndGenerateFrontend()) {
			outputShutdownDueToError();
			return;
		}
		
		// Start the server with the new contents, return on error
		if (!checkAndStartServer()) {
			outputShutdownDueToError();
			return;
		}

		// Open the generated page in a browser window, no fatal error so no need to check
		openGeneratedPageInBrowser();
			
		// Wait for server thread, no fatal error so no need to check
		waitForServer();
	}
	
	private void outputShutdownDueToError() {
		System.out.println("Shutting down due to one or more previous occurred errors");
	}
	
	private boolean checkAndParseForm() {
		try {
			final IFormParser parser = new FormParser();
			form = parser.parseForm(inputFile);
			
			if (parser.hasParsingErrors()) {
				System.err.println("The following parsing errors occurred:");
				parser.writeErrorLog(System.err);
				return false;
			}
		}
		catch (ParsingException e) {
			System.err.println(String.format("Failed to parse form: %s", e.getMessage()));
			return false;
		}
		
		return true;
	}
	
	private boolean checkAndStartServer() {
		try {
			server = new JettyBootstrapServer(properties, typeChecker, OUTPUT_FILE_NAME);
			server.startServer();
		}
		catch (WebServerException e) {
			System.err.println(String.format("Server Exception: %s", e.getMessage()));
			return false;
		}
		
		return true;
	}
	
	private void waitForServer() {
		try {
			server.waitForServerThread();
		} 
		catch (WebServerException e) {
			System.err.println(String.format("Server Exception: %s", e.getMessage()));
		}
	}
	
	private boolean checkAndReadPropertiesFile() {
		try {
			properties.readProperties();
		}
		catch (IOException e) {
			System.err.println(String.format("Failed to read properties file (%s)", ServerProperties.PROPERTIES_FILE_NAME));
			return false;
		}
		
		return true;
	}

	private boolean checkForFormErrors() {
		final boolean errors = typeChecker.checkFormErrors(form);
		if (errors) {
			System.err.println("Type checking resulted in the following type errors:");
			typeChecker.writeErrorLog(System.err);
		}
		return errors;
	}

	// Generates bootstrap HTML front-end
	private boolean checkAndGenerateFrontend() {
		try {
			final IWebGenerator generator = new BootstrapGenerator(properties.getTemplatesPath(), properties.getServerBaseURL());
			generator.generateFrontEnd(form, properties.getWebPath(), OUTPUT_FILE_NAME);
		}
		catch (WebGenerationException e) {
			System.err.println(String.format("Failed to generate file: %s", e.getMessage()));
			return false;
		}
		
		return true;
	}

	// Try to spawn the default browser with the generated front-end content
	private void openGeneratedPageInBrowser() {
		try {
			BrowserUtil.openURL(properties.getServerBaseURL());
		} 
		catch (BrowserException e) {
			System.err.println(String.format("Failed to open browser: %s", e.getMessage()));
			System.out.println("Try to open your browser manually with the following URL: ");
			System.out.println(properties.getServerBaseURL());
		}		
	}
}
