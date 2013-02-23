package org.uva.sea.ql.parsers.exceptions;

import org.uva.sea.ql.core.dom.Identifier;

public class IdentifierNotDefinedException extends Exception {
	
	private static final long serialVersionUID = 1L;

	private Identifier identifier;
	
	public IdentifierNotDefinedException(Identifier identifier) {
		this.identifier=identifier;
	}

	public Identifier getIdentifier() {
		return identifier;
	}
}
