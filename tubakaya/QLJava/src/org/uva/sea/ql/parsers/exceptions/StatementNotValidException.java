package org.uva.sea.ql.parsers.exceptions;

import org.uva.sea.ql.core.dom.Statement;

public class StatementNotValidException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public Statement statement;
	
	public StatementNotValidException(Statement statement) {
		this.statement=statement;
	}

}
