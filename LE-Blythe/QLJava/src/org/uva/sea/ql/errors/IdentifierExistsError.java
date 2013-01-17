package org.uva.sea.ql.errors;

import org.uva.sea.ql.ast.Ident;

public class IdentifierExistsError extends Exception{
	private static final long serialVersionUID = 4L;
	
	public IdentifierExistsError(Ident i) {
		super(String.format("Identifier already defined: %s\n", i.getName()));
	}
}
