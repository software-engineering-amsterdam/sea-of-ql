package org.uva.sea.ql.parser.errors;

import org.uva.sea.ql.ast.expression.Expr;

public class VariableUndefinedError extends SemanticError {
	private final static String FORMAT = "Variable undefined: %s";

	public VariableUndefinedError(String varName, Expr expression) {
		super(String.format(FORMAT, varName), expression);
	}
	
}
