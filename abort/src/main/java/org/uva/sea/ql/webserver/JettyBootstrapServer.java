package org.uva.sea.ql.webserver;

import java.util.EnumSet;

import javax.servlet.*;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.*;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.uva.sea.ql.ServerProperties;
import org.uva.sea.ql.ast.traversal.typechecking.base.ITypeChecker;
import org.uva.sea.ql.webserver.base.*;

import com.google.inject.servlet.GuiceFilter;

/**
 * 
 * 
 * @author J. Dijkstra
 */
public class JettyBootstrapServer implements IWebServer {
	/**
	 * Webservice binding path.
	 */
	private static final String WEBSERVICE_BINDING_PATH = "/ws/*";
	/**
	 * Jetty Server instance.
	 */
	private final Server server;
	/**
	 * Properties to use for the server.
	 */
	private final ServerProperties properties;
	/**
	 * Type checker to use for validating input coming from generated code received on this server.
	 */
	private final ITypeChecker typeChecker;

	/**
	 * File name of the generated front end to display.
	 */
	private final String frontEndFileName;

	/**
	 * Constructor.
	 * 
	 * @param properties
	 *            properties to use
	 * @param typeChecker
	 *            type checker to use for validating input coming from generated code received on this server.
	 * @param frontEndFileName
	 *            file name of the generated front end to display
	 */
	public JettyBootstrapServer(final ServerProperties properties, final ITypeChecker typeChecker,
			final String frontEndFileName) {
		this.properties = properties;
		this.typeChecker = typeChecker;
		this.frontEndFileName = frontEndFileName;

		server = new Server(properties.getServerPort());
	}

	@Override
	public void startServer() throws WebServerException {
		// Create two different content handlers on different binding paths
		final ServletContextHandler dynamicContentHandler = createServletContextHandler();
		final ResourceHandler staticContentHandler = createStaticContentHandler();

		final HandlerCollection handlers = new HandlerCollection();
		handlers.addHandler(dynamicContentHandler);
		handlers.addHandler(staticContentHandler);
		server.setHandler(handlers);

		try {
			server.start();
		} catch (final Exception e) {
			throw new WebServerException(e);
		}
	}

	/**
	 * Creates dynamic content handler (servlets).
	 * 
	 * @return content handler
	 */
	private ServletContextHandler createServletContextHandler() {
		final ServletContextHandler servletContextHandler = new ServletContextHandler();

		// Spawn the webservices
		final ServletContextListener config = new ServletBootstrapConfig(typeChecker.getSymbolTable(), properties);
		servletContextHandler.addEventListener(config);
		servletContextHandler.addFilter(GuiceFilter.class, WEBSERVICE_BINDING_PATH, EnumSet.of(DispatcherType.REQUEST));
		servletContextHandler.addServlet(EmptyServlet.class, WEBSERVICE_BINDING_PATH);

		return servletContextHandler;
	}

	/**
	 * Creates static content handler.
	 * 
	 * @return content handler
	 */
	private ResourceHandler createStaticContentHandler() {
		final ResourceHandler resourceHandler = new ResourceHandler();
		resourceHandler.setDirectoriesListed(false);
		resourceHandler.setWelcomeFiles(new String[] { frontEndFileName });

		resourceHandler.setResourceBase(properties.getWebPath());

		return resourceHandler;
	}

	@Override
	public void waitForServerThread() throws WebServerException {
		try {
			server.join();
		} catch (final InterruptedException e) {
			throw new WebServerException(e);
		}
	}
}
