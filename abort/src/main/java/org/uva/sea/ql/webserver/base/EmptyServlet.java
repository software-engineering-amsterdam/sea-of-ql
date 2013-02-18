package org.uva.sea.ql.webserver.base;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * And empty servlet needed for the filters of the config to kick in.
 * 
 * @author J. Dijkstra
 */
public class EmptyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException,
			IOException {
		throw new IllegalStateException("Unable to service request");
	}
}