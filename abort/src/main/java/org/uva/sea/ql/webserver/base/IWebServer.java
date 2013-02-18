package org.uva.sea.ql.webserver.base;

import org.uva.sea.ql.webserver.WebServerException;

/**
 * Interface for webservers.
 * 
 * @author J. Dijkstra
 */
public interface IWebServer {
	/**
	 * Start the server.
	 * @throws WebServerException
	 */
	void startServer() throws WebServerException;

	/**
	 * Waits for the server thread to exit.
	 * @throws WebServerException
	 */
	void waitForServerThread() throws WebServerException;	
}
