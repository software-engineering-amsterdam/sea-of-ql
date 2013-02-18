package org.uva.sea.ql.parser.errors;

import java.util.*;

import org.uva.sea.ql.parser.errors.base.*;

/**
 * Syntax error reporter for the QL language.
 * 
 * @author J. Dijkstra
 */
public class SyntaxErrorReporter implements ISyntaxErrorReporter {
	/**
	 * List of syntax errors.
	 */
	private final List<SyntaxErrorMessage> errors = new ArrayList<SyntaxErrorMessage>();

	@Override
	public void reportError(final SyntaxErrorMessage syntaxErrorMessage) {
		errors.add(syntaxErrorMessage);
	}

	@Override
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
