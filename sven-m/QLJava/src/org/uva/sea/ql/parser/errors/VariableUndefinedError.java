package org.uva.sea.ql.parser.errors;

import org.uva.sea.ql.ast.expression.Expr;
import org.uva.sea.ql.ast.expression.Ident;

public class VariableUndefinedError extends SemanticError {
	private final static String FORMAT = "Variable undefined: %s";

	public VariableUndefinedError(Ident id, Expr expression) {
		super(String.format(FORMAT, id.getName()), expression);
	}
	
}
