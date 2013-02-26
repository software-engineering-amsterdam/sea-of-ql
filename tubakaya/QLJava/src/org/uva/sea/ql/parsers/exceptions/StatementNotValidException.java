package org.uva.sea.ql.parsers.exceptions;

import org.uva.sea.ql.ast.Statement;

public class StatementNotValidException extends QLException {
	
	private static final long serialVersionUID = 1L;

	public Statement statement;
	
	public StatementNotValidException(Statement statement) {
		this.statement=statement;
	}

	@Override
	public String ToString() {
		return String.format("Invalid statement error occured. Statement type : {0}",statement.getClass());
	}
}
