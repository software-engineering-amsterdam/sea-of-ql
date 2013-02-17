package org.uva.sea.ql.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.error.ParseError;
import org.uva.sea.ql.error.QLError;
import org.uva.sea.ql.interpreter.Evaluator;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParserContext;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.semantic.StatementSemanticChecker;
import org.uva.sea.ql.widget.RowWrapper;
import org.uva.sea.ql.widget.RowWrapperGenerator;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class ParserService {
	
	public ParserContext fetchServerForm(ConnectivityManager connectionManager) throws QLFrontEndException {
		NetworkInfo info = connectionManager.getActiveNetworkInfo();
		URLConnection connection;
		if(info != null && info.isConnected()) {
			URL url;
			try {
				url = new URL("http://192.168.1.68:8888/ql_survey_server");
			} catch (MalformedURLException e) {
				throw new QLFrontEndException();
			}
			try {
				connection = url.openConnection();
				ParserContext context = parseNewForm(connection.getInputStream());
				Log.d("contentLength", "length: " +connection.getContentLength());
				return context;
			} catch (IOException e) {
				throw new QLFrontEndException();
			}
		} else {
			throw new QLFrontEndException("No connection available");
		}
	}

	public ParserContext parseNewForm(InputStream form) {
		ParserContext context = new ParserContext();
		IParse parser = new ANTLRParser();
		Form formHolder;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(form, "UTF-8"));
			StringBuilder builder = new StringBuilder();
			String line = null;
			while((line = reader.readLine()) != null) {
				builder.append(line);
			}
			form.close();
			Log.d("stringError", builder.toString());
			formHolder = (Form) parser.parseNode(builder.toString());
		} catch (ParseError e) {
			context.addError(new QLError(e.getLocalizedMessage()));
			Log.e("parserError", e.getLocalizedMessage());
			return context; // Parse exception occurred, abort further checking
		} catch (IOException e) {
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
