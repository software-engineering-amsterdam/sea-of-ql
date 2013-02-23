package eu.karuza.ql.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.gson.Gson;

import eu.karuza.ql.FormResult;
import eu.karuza.ql.QuestionResult;

@SuppressWarnings("serial")
public class QL_Survey_DisplayServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String formName = req.getParameter(Constants.DATA_FORM_NAME);
		Key formKey = KeyFactory.createKey(Constants.DATA_FORM_NAME, formName);
		Query query = new Query(Constants.DATA_FORM_ELEMENT, formKey);
		DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();
		PreparedQuery preparedQuery = dataStore.prepare(query);
		PrintWriter writer = resp.getWriter();
		Gson gson = new Gson();
		for(Entity result : preparedQuery.asIterable()) {
			FormResult formResult = gson.fromJson((String)result.getProperty(Constants.DATA_FORM_RESULT), FormResult.class);
			writer.println(result.getProperty(Constants.DATA_TIMESTAMP) + "");
			if(formResult != null) {
				for(QuestionResult question : formResult.getResult()) {
					writer.println(question.getName());
					writer.println(question.getValue());
					writer.println();
				}
			}
			
		}
	}
}
