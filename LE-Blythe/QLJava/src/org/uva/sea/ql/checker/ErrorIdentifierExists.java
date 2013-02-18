package org.uva.sea.ql.checker;

import org.uva.sea.ql.ast.Ident;

public class ErrorIdentifierExists extends Error{
	
	public ErrorIdentifierExists(Ident i) {
		super(String.format("Identifier already defined: %s\n", expressionToString(i)));
	}
}
