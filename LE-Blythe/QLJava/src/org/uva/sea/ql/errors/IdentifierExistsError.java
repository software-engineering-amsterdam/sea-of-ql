package org.uva.sea.ql.errors;

import org.uva.sea.ql.ast.Ident;

public class IdentifierExistsError extends Error{
	
	public IdentifierExistsError(Ident i) {
		super(String.format("Identifier already defined: %s\n", expressionToString(i)));
	}
}
