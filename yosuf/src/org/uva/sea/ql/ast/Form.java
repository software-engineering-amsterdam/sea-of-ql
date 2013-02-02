package org.uva.sea.ql.ast;

import static julius.validation.Assertions.state;

public class Form implements ASTNode {

	private final Identifier identifier;
	private final ASTNode body;

	public Form(final Identifier identifier, final ASTNode body) {
		this.identifier = identifier;
		this.body = body;

		state.assertNotNull(identifier, "Form.identifier");
		state.assertNotNull(body, "Form.body");
	}

}
