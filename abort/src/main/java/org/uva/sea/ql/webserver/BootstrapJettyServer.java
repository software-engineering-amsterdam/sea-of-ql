package org.uva.sea.ql.webserver;

import java.util.EnumSet;

import javax.servlet.*;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.*;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.uva.sea.ql.ServerProperties;
import org.uva.sea.ql.ast.traversal.typechecking.base.ITypeChecker;
import org.uva.sea.ql.webserver.base.EmptyServlet;

import com.google.inject.servlet.GuiceFilter;

public class BootstrapJettyServer {
	private static final String WEBSERVICE_BINDING_PATH = "/ws/*";
	private Server server;
	private final ServerProperties properties;
	private final ITypeChecker typeChecker;
	
	public BootstrapJettyServer(final ServerProperties properties, final ITypeChecker typeChecker) {
		this.properties = properties;
		this.typeChecker = typeChecker;
		
		server = new Server(properties.getServerPort());
	}
	
	public void startServer() throws ServerException {
		// Create two different content handlers on different binding paths
		final ServletContextHandler dynamicContentHandler = createServletContextHandler();
		final ResourceHandler staticContentHandler = createStaticContentHandler();

		HandlerCollection handlers = new HandlerCollection();
		handlers.addHandler(dynamicContentHandler);
		handlers.addHandler(staticContentHandler);
		server.setHandler(handlers);
		
		try {
			server.start();
		}
		catch (Exception e) {
			throw new ServerException(e);
		}
	}
	
	private ServletContextHandler createServletContextHandler() {
		final ServletContextHandler servletContextHandler = new ServletContextHandler();

		// Spawn the webservices
		final ServletContextListener config = new BootstrapServletConfig(typeChecker.getSymbolTable(), properties); 
		servletContextHandler.addEventListener(config);
		servletContextHandler.addFilter(GuiceFilter.class, WEBSERVICE_BINDING_PATH, EnumSet.of(DispatcherType.REQUEST));
		servletContextHandler.addServlet(EmptyServlet.class, WEBSERVICE_BINDING_PATH);
		
		return servletContextHandler;
	}
	
	private ResourceHandler createStaticContentHandler() {
		final ResourceHandler resourceHandler = new ResourceHandler();
		resourceHandler.setDirectoriesListed(false);
		resourceHandler.setWelcomeFiles(new String[] { "index.html" });

		resourceHandler.setResourceBase(properties.getWebPath());

		return resourceHandler;
	}
	
	public void waitForServerThread() throws ServerException {
		try {
			server.join();
		}
		catch (InterruptedException e) {
			throw new ServerException(e);
		}
	}
}
