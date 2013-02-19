package eu.karuza.ql.service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


import android.net.ConnectivityManager;
import android.util.Log;

import com.google.gson.Gson;

import eu.karuza.ql.FormResult;
import eu.karuza.ql.QLFrontEndException;
import eu.karuza.ql.QuestionResult;
import eu.karuza.ql.ServerResult;
import eu.karuza.ql.ast.AnswerableQuestion;
import eu.karuza.ql.ast.Form;
import eu.karuza.ql.error.ParseError;
import eu.karuza.ql.error.QLError;
import eu.karuza.ql.interpreter.Evaluator;
import eu.karuza.ql.parser.IParse;
import eu.karuza.ql.parser.ParserContext;
import eu.karuza.ql.parser.antlr.ANTLRParser;
import eu.karuza.ql.semantic.StatementSemanticChecker;
import eu.karuza.ql.widget.RowWrapper;
import eu.karuza.ql.widget.RowWrapperGenerator;

public class ParserService {

	private static final String BASE_URL = "http://192.168.1.68:8888/";
	private static final String GET_SURVEY_URL = "getform";
	private static final String STORE_URL = "storeform";

	private ConnectionService connector = new ConnectionService();

	public ParserContext fetchServerForm(ConnectivityManager connectionManager) throws QLFrontEndException {
		InputStream response = connector.createGetConnection(connectionManager, BASE_URL + GET_SURVEY_URL);
		ParserContext context = parseNewForm(response);
		return context;
	}

	public void storeFormAnswers(ConnectivityManager connectionManager, Form form) throws QLFrontEndException {
		Gson gson = new Gson();
		FormResult result = new FormResult();
		result.setName(form.getLabel());
		StoreListGenerator generator = new StoreListGenerator();
		form.accept(generator);
		List<QuestionResult> resultList = new ArrayList<QuestionResult>(); 
		for(AnswerableQuestion question : generator.getQuestions()) {
			QuestionResult questionResult = new QuestionResult();
			questionResult.setName(question.getName());
			questionResult.setValue(question.getRawValue().toString());
			resultList.add(questionResult);
		}
		result.setResult(resultList);
		String postBody = gson.toJson(result);
		Log.d("parserService", "post body: " + postBody);
		InputStream response = connector.createPostConnection(connectionManager, BASE_URL + STORE_URL, postBody);
		ServerResult serverResult = gson.fromJson(new InputStreamReader(response), ServerResult.class);
		if(!serverResult.getResponse().equals("ok")) {
			throw new QLFrontEndException();
		}
	}

	public ParserContext parseNewForm(InputStream form) {
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

	public ParserContext evaluateValues(ParserContext context) {
		return context;
	}

	public List<RowWrapper> getDisplayableData(ParserContext context) {
		Form form = context.getForm();
		form.accept(new Evaluator());
		List<RowWrapper> resultList = new ArrayList<RowWrapper>();
		form.accept(new RowWrapperGenerator(resultList));
		return resultList;
	}
}
