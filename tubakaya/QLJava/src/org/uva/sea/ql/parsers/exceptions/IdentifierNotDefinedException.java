package org.uva.sea.ql.parsers.exceptions;

import org.uva.sea.ql.ast.Identifier;

public class IdentifierNotDefinedException extends QLException {
	
	private static final long serialVersionUID = 1L;

	private Identifier identifier;
	
	public IdentifierNotDefinedException(Identifier identifier) {
		this.identifier=identifier;
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	@Override
	public String ToString() {
		return String.format("Non-defined identifier found. Identifier name : {0}",identifier.getName());
	}
}
