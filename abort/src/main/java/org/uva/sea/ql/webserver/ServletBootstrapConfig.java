package org.uva.sea.ql.webserver;

import java.util.*;

import javax.ws.rs.ext.*;

import org.codehaus.jackson.jaxrs.*;
import org.uva.sea.ql.ServerProperties;
import org.uva.sea.ql.ast.traversal.typechecking.base.ISymbolTable;
import org.uva.sea.ql.webserver.services.BootstrapWebService;

import com.google.inject.*;
import com.google.inject.servlet.*;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

/**
 * Bootstrap config to use with Jersey and Jetty
 * 
 * @author J. Dijkstra
 */
public class ServletBootstrapConfig extends GuiceServletContextListener {
	private final ISymbolTable symbolTable;
	private final ServerProperties properties;
	
	/**
	 * Constructor.
	 * 
	 * @param symbolTable symbol table to use for verification of input
	 * @param properties properties to use over the servlets
	 */
	public ServletBootstrapConfig(final ISymbolTable symbolTable, final ServerProperties properties) {
		this.symbolTable = symbolTable;
		this.properties = properties;
	}
	
	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new ServletModule() {
            @Override
            protected void configureServlets() {
                // bind the REST resources
        		bind(ISymbolTable.class).toInstance(symbolTable);
        		bind(ServerProperties.class).toInstance(properties);
                bind(BootstrapWebService.class);
                
                // Bind Jackson converters for JAXB/JSON serialization
                bind(JacksonJaxbJsonProvider.class).in(Singleton.class);
                bind(MessageBodyReader.class).to(JacksonJsonProvider.class);
                bind(MessageBodyWriter.class).to(JacksonJsonProvider.class);
                
                // Jersey configuration
                Map<String, String> initParams = new HashMap<String, String>();
                initParams.put("com.sun.jersey.config.feature.Trace", "true");
                initParams.put("com.sun.jersey.api.json.POJOMappingFeature", "true");

                serve("*").with(GuiceContainer.class, initParams);
            }
        });
	}
}