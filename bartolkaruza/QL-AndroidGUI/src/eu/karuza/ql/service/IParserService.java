package eu.karuza.ql.service;

import java.util.List;

import android.net.ConnectivityManager;
import eu.karuza.ql.QLFrontEndException;
import eu.karuza.ql.ServerResult;
import eu.karuza.ql.ast.Form;
import eu.karuza.ql.parser.ParserContext;
import eu.karuza.ql.ui.widget.RowWrapper;

public interface IParserService {
	
	/**
	 * Method used to store a completed form on the back-end. This operation is blocking, with network operations
	 * 
	 * @param connectionManager - The connectionmanager used to check network connectivity
	 * @param form - The form that needs to be stored
	 * @return
	 * @throws QLFrontEndException
	 */
	public ServerResult storeFormAnswers(ConnectivityManager connectionManager, Form form) throws QLFrontEndException;

	/**
	 * Service method that retrieves, parses and checks a form from the server. This operation is blocking, with network operations
	 * 
	 * @param connectionManager - The connectionmanager used to check network connectivity
	 * @return
	 * @throws QLFrontEndException
	 */
	public ParserContext fetchServerForm(ConnectivityManager connectionManager) throws QLFrontEndException;

	/**
	 * Service method that generates a list of RowWrapper objects which are currently visible and need to be displayed
	 * This operation is blocking but only performs operations on local data, can be called from the UI thread
	 * 
	 * @param context - Must be a parser context with the Form value set
	 * @return - The usable list for displaying
	 */
	public List<RowWrapper> getDisplayableData(ParserContext context);

}
