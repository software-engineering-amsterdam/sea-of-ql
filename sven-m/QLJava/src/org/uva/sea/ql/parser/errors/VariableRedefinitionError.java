package org.uva.sea.ql.parser.errors;

import org.uva.sea.ql.ast.expression.Expr;
import org.uva.sea.ql.ast.expression.Ident;

public class VariableRedefinitionError extends SemanticError {
	private final static String FORMAT = "Variable redefined: %s";
	
	public VariableRedefinitionError(Ident id, Expr expression) {
		super(String.format(FORMAT, id), expression);
	}

}
