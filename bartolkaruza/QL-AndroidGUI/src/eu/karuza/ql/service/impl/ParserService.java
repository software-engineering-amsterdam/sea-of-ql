package eu.karuza.ql.service.impl;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.net.ConnectivityManager;
import android.util.Log;

import com.google.gson.Gson;

import eu.karuza.ql.FormResult;
import eu.karuza.ql.QLFrontEndException;
import eu.karuza.ql.ServerResult;
import eu.karuza.ql.ast.Form;
import eu.karuza.ql.error.ParseError;
import eu.karuza.ql.error.QLError;
import eu.karuza.ql.parser.IParse;
import eu.karuza.ql.parser.ParserContext;
import eu.karuza.ql.parser.antlr.ANTLRParser;
import eu.karuza.ql.service.IConnectionService;
import eu.karuza.ql.service.IParserService;
import eu.karuza.ql.service.ServiceFactory;
import eu.karuza.ql.service.StoreListGenerator;
import eu.karuza.ql.ui.widget.RowWrapper;
import eu.karuza.ql.ui.widget.RowWrapperGenerator;
import eu.karuza.ql.visitor.impl.StatementSemanticChecker;

public class ParserService implements IParserService{

	private static final String BASE_URL = "http://10.0.2.2:8888/";
//	private static final String BASE_URL = "http://ql-surveytool.appspot.com/";
	private static final String GET_SURVEY_URL = "getform";
	private static final String STORE_URL = "storeform";

	private IConnectionService connector = ServiceFactory.getConnectionService();

	@Override
	public ServerResult storeFormAnswers(ConnectivityManager connectionManager, Form form) throws QLFrontEndException {
		Gson gson = new Gson();
		FormResult result = makeFormResult(form);
		String postBody = gson.toJson(result);
		InputStream response = connector.createPostConnection(connectionManager, BASE_URL + STORE_URL, postBody);
		ServerResult serverResult = gson.fromJson(new InputStreamReader(response), ServerResult.class);
		if(!serverResult.getResponse().equals("ok")) {
			throw new QLFrontEndException("Server sent error: " + serverResult.getResponse());
		}
		return serverResult;
	}
	
	@Override
	public ParserContext fetchServerForm(ConnectivityManager connectionManager) throws QLFrontEndException {
		InputStream response = connector.createGetConnection(connectionManager, BASE_URL + GET_SURVEY_URL);
		ParserContext context = parseNewForm(response);
		return context;
	}

	private ParserContext parseNewForm(InputStream form) {
		ParserContext context = new ParserContext();
		IParse parser = new ANTLRParser();
		Form formHolder;
		try {
			formHolder = (Form) parser.parseNodeFromStream(form);
		} catch (ParseError e) {
			context.addError(new QLError(e.getLocalizedMessage()));
			Log.e("parserError", e.getLocalizedMessage());
			return context; // Parse exception occurred, abort further checking
		}
		StatementSemanticChecker statementChecker = new StatementSemanticChecker(context);
		formHolder.accept(statementChecker);
		context.setForm(formHolder);
		return context;
	}

	public List<RowWrapper> getDisplayableData(ParserContext context) {
		Form form = context.getForm();
		List<RowWrapper> resultList = new ArrayList<RowWrapper>();
		form.accept(new RowWrapperGenerator(resultList));
		return resultList;
	}
	
	private FormResult makeFormResult(Form form) {
		FormResult result = new FormResult();
		result.setName(form.getLabel());
		StoreListGenerator generator = new StoreListGenerator();
		form.accept(generator);
		result.setResult(generator.getQuestions());
		return result;
	}
}
