package org.uva.sea.ql;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.spi.container.servlet.ServletContainer;


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
	 * @throws Exception 
	 */
    public static void main(String[] args) throws Exception {
    	 Server server = new Server(8080);
    	 ServletContextHandler servletContextHandler = new ServletContextHandler(server, "/", true, false);
    	 servletContextHandler.addServlet(new ServletHolder(new ServletContainer(new PackagesResourceConfig("org.uva.sea.ql.webserver"))), "/");
    	 servletContextHandler.setAttribute("com.sun.jersey.api.json.POJOMappingFeature", true);
    	 server.start();
    }    
}
