package org.uva.sea.ql.parser.errors;

import org.uva.sea.ql.ast.expression.Expr;

public abstract class SemanticError {
	private final String message;
	private final Expr expression;
	
	public SemanticError(String message, Expr expression) {
		this.message = message;
		this.expression = expression;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Expr getExpression() {
		return expression;
	}
}
