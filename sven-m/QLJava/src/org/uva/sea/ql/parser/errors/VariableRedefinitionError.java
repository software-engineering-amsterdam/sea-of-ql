package org.uva.sea.ql.parser.errors;

import org.uva.sea.ql.ast.expressions.Expr;

public class VariableRedefinitionError extends SemanticError {
	private final static String FORMAT = "Variable redefined: %s";
	
	public VariableRedefinitionError(String varName, Expr expression) {
		super(String.format(FORMAT, varName), expression);
	}

}
