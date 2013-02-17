package org.uva.sea.ql.webserver.base;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * An Empty, "do nothing servlet" to add to the context. Otherwise, the filters will never kick in.
 */
public class EmptyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        throw new IllegalStateException("unable to service request");
    }
}