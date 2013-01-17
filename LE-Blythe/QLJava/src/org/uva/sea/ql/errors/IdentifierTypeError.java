package org.uva.sea.ql.errors;

import org.uva.sea.ql.ast.Ident;

public class IdentifierTypeError extends Exception{
	private static final long serialVersionUID = 3L;
	
	public IdentifierTypeError(Ident i, Class<?> type) {
		super(String.format("Identifier %s does not have type %s\n", i.getName(),  type.getName()));
	}
}
