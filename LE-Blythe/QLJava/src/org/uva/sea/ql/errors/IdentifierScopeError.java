package org.uva.sea.ql.errors;

import org.uva.sea.ql.ast.Ident;

public class IdentifierScopeError extends Error{
	
	public IdentifierScopeError(Ident i) {
		super(String.format("Undeclared identifier: %s\n", expressionToString(i)));
	}
}
