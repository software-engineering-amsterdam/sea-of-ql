package eu.karuza.ql.service;

import java.io.InputStream;
import java.util.List;

import android.net.ConnectivityManager;
import eu.karuza.ql.QLFrontEndException;
import eu.karuza.ql.ServerResult;
import eu.karuza.ql.ast.Form;
import eu.karuza.ql.parser.ParserContext;
import eu.karuza.ql.ui.widget.RowWrapper;

public interface IParserService {
	public ServerResult storeFormAnswers(ConnectivityManager connectionManager, Form form) throws QLFrontEndException;

	public ParserContext fetchServerForm(ConnectivityManager connectionManager) throws QLFrontEndException;

	public ParserContext parseNewForm(InputStream form);

	public ParserContext evaluateValues(ParserContext context);

	public List<RowWrapper> getDisplayableData(ParserContext context);

}
