package org.uva.sea.ql.parser.errors;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.parser.errors.base.ISyntaxErrorReporter;
import org.uva.sea.ql.parser.errors.base.SyntaxErrorMessage;

/**
 * Syntax error reporter for the QL language.
 *
 * @author J. Dijkstra
 */
public class SyntaxErrorReporter implements ISyntaxErrorReporter {
	/**
	 * List of syntax errors.
	 */
	private List<SyntaxErrorMessage> errors = new ArrayList<SyntaxErrorMessage>();
	
	@Override
	public void reportError(final SyntaxErrorMessage syntaxErrorMessage) {
		errors.add(syntaxErrorMessage);
	}
	
	/**
	 * Check if there are any syntax errors.
	 * @return whether there are syntax errors or not
	 */
	public boolean hasSyntaxErrors() {
		return (errors.size() > 0);
	}

	@Override
	public List<SyntaxErrorMessage> getErrors() {
		return errors;
	}

	@Override
	public String toString() {
		final StringBuffer buffer = new StringBuffer();
		for (final SyntaxErrorMessage error : errors) {
			buffer.append(error.toString());
		}
		
		return buffer.toString();
	}
}
