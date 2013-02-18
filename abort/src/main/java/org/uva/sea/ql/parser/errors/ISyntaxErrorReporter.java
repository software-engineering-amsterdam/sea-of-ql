package org.uva.sea.ql.parser.errors;

import java.util.List;


/**
 * Interface for syntax error reporters for the QL language.
 * 
 * @author J. Dijkstra
 */
public interface ISyntaxErrorReporter {
	/**
	 * 
	 * @param syntaxErrorMessage
	 */
	void reportError(SyntaxErrorMessage syntaxErrorMessage);

	/**
	 * Retrieve list of syntax errors.
	 * 
	 * @return syntax errors
	 */
	List<SyntaxErrorMessage> getErrors();

	/**
	 * Check whether syntax errors are present or not.
	 * 
	 * @return whether syntax errors are present or not
	 */
	boolean hasSyntaxErrors();
}
