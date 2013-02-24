package org.uva.sea.ql.parser.typechecker.error;

import org.uva.sea.ql.ast.expression.Expr;

public class VariableRedefinitionError extends SemanticError {
	private final static String FORMAT = "Variable redefined: %s";
	
	public VariableRedefinitionError(String varName, Expr expression) {
		super(String.format(FORMAT, varName), expression);
	}

}
