package org.uva.sea.ql.errors;

import org.uva.sea.ql.ast.Ident;

public class IdentifierScopeError extends Exception{
	private static final long serialVersionUID = 2L;
	
	public IdentifierScopeError(Ident i) {
		super(String.format("Undeclared identifier: %s\n", i.getName()));
	}
}
