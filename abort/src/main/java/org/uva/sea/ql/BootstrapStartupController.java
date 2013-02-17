package org.uva.sea.ql;

import java.io.*;
import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.*;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.traversal.codegen.*;
import org.uva.sea.ql.ast.traversal.codegen.base.WebGenerationException;
import org.uva.sea.ql.ast.traversal.typechecking.TypeChecker;
import org.uva.sea.ql.ast.traversal.typechecking.base.ITypeChecker;
import org.uva.sea.ql.base.IStartupController;
import org.uva.sea.ql.parser.ParsingException;
import org.uva.sea.ql.parser.antlr.FormParser;
import org.uva.sea.ql.parser.base.IFormParser;
import org.uva.sea.ql.webserver.ServletConfig;
import org.uva.sea.ql.webserver.base.EmptyServlet;

import com.google.inject.servlet.GuiceFilter;

public class BootstrapStartupController implements IStartupController {
	private static final String OUTPUT_FILE_NAME = "index.html";

	private final int port;
	private final File inputFile;
	private final PathProperties properties = new PathProperties();

	private final IFormParser parser = new FormParser();
	private final ITypeChecker typeChecker = new TypeChecker();

	public BootstrapStartupController(final CommandLineParameters parameters) {
		this.inputFile = parameters.getInputFile();
		this.port = parameters.getPort();
	}
	
	@Override
	public void start() {
		IWebGenerator generator;
		try {
			properties.readProperties();

			// Spawn generator using the path of the templates defined in the shared property file (shared with ant)
			generator = new BootstrapGenerator(properties.getTemplatesPath());
		}
		catch (IOException e) {
			System.err.println(String.format("Failed to read properties file (%s)", PathProperties.PROPERTIES_FILE_NAME));
			return;
		}
		
		Form form;
		try {
			form = parser.parseForm(inputFile);
		}
		catch (ParsingException e) {
			System.err.println(String.format("Failed to parse form: %s", e.getMessage()));
			return;
		}

		if (typeChecker.checkFormErrors(form)) {
			System.err.println("Type checking resulted in the following type errors:");
			typeChecker.writeErrorLog(System.err);
			return;
		}

		try {
			generator.generateFrontend(form, properties.getWebPath(), OUTPUT_FILE_NAME);
		}
		catch (WebGenerationException e) {
			System.err.println(String.format("Failed to generate file: %s", e.getMessage()));
			return;
		}

		startServer();
	}
	
	
	private void startServer() {
		Server server = new Server(port);

		// Create two different content handlers on different binding paths
		final ServletContextHandler dynamicContentHandler = createServletContextHandler();
		final ResourceHandler staticContentHandler = createStaticContentHandler();

		HandlerCollection handlers = new HandlerCollection();
		handlers.addHandler(dynamicContentHandler);
		handlers.addHandler(staticContentHandler);
		server.setHandler(handlers);
		
		try {
			server.start();
			server.join();
		}
		catch (Exception e) {
			System.err.println("Failed to start the server; " + e.getMessage());
		}
	}
	
	private ServletContextHandler createServletContextHandler() {
		final ServletContextHandler servletContextHandler = new ServletContextHandler();

		// Spawn the webservices
		servletContextHandler.addEventListener(new ServletConfig(typeChecker));
		servletContextHandler.addFilter(GuiceFilter.class, "/ws/*", EnumSet.of(DispatcherType.REQUEST));
		servletContextHandler.addServlet(EmptyServlet.class, "/ws/*");
		
		return servletContextHandler;
	}
	
	private ResourceHandler createStaticContentHandler() {
		final ResourceHandler resourceHandler = new ResourceHandler();
		resourceHandler.setDirectoriesListed(false);
		resourceHandler.setWelcomeFiles(new String[] { "index.html" });

		resourceHandler.setResourceBase(properties.getWebPath());

		return resourceHandler;
	}
}
