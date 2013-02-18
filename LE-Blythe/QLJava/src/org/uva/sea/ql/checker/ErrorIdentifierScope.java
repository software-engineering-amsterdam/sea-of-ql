package org.uva.sea.ql.checker;

import org.uva.sea.ql.ast.Ident;

public class ErrorIdentifierScope extends Error{
	
	public ErrorIdentifierScope(Ident i) {
		super(String.format("Undeclared identifier: %s\n", expressionToString(i)));
	}
}
