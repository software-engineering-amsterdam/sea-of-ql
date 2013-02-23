package eu.karuza.ql.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.gson.Gson;

import eu.karuza.ql.FormResult;
import eu.karuza.ql.ServerResult;

@SuppressWarnings("serial")
public class QL_Survey_StoreServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Gson gson = new Gson();
		String resultString = readRequestToString(req.getReader());
		FormResult result = gson.fromJson(resultString, FormResult.class);
		storeResult(result, resultString);
		ServerResult serverResult = new ServerResult();
		serverResult.setResponse("ok");
		resp.setCharacterEncoding(Constants.ENCODING);
		resp.setContentType(Constants.CONTENT_TYPE_JSON + Constants.ENCODING);
		resp.getWriter().write(gson.toJson(serverResult));
	}
	
	private void storeResult(FormResult result, String resultString) {
		Key formKey = KeyFactory.createKey(Constants.DATA_FORM_NAME, result.getName());
		Entity storedForm = new Entity(Constants.DATA_FORM_ELEMENT, formKey);
		storedForm.setProperty(Constants.DATA_FORM_RESULT, resultString);
		storedForm.setProperty(Constants.DATA_TIMESTAMP, Calendar.getInstance().getTimeInMillis());
		DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();
		dataStore.put(storedForm);
	}
	
	private String readRequestToString(BufferedReader reader) throws IOException {
		StringBuilder builder = new StringBuilder();
		String buffer = "";
		while((buffer = reader.readLine()) != null) {
			builder.append(buffer);
		}
		return builder.toString();
	}

}
