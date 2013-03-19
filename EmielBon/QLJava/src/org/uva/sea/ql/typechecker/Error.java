package org.uva.sea.ql.typechecker;

import org.uva.sea.ql.ast.Expression;

public class Error {

	private final Expression expression;
	private final String message;
	
	public Error(Expression expr, String message) {
		this.expression = expr;
		this.message = message;
	}

	public Expression getExpression() {
		return expression;
	}

	public String getMessage() {
		return message;
	}
	
	public String toString() {
		return "Error: " + message + " in \"" + expression + "\""; 
	}
	
}
