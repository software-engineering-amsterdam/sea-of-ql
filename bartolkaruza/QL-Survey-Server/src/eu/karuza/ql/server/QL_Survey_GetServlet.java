package eu.karuza.ql.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class QL_Survey_GetServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		InputStream stream = getServletContext().getResourceAsStream("/WEB-INF/QL");
		resp.setContentType(Constants.CONTENT_TYPE_PLAIN + Constants.ENCODING);
		InputStreamReader reader = new InputStreamReader(stream, Constants.ENCODING);
		char[] buffer = new char[1];
		StringBuilder builder = new StringBuilder(1);
		while(reader.read(buffer) != -1) {
			builder.append(buffer);
			builder.trimToSize();
		}
		System.out.println(builder.toString());
		System.out.println("length: " + builder.toString().getBytes().length);
		resp.setContentLength(builder.toString().getBytes(Constants.ENCODING).length);
		resp.getWriter().write(builder.toString());
	}
}
