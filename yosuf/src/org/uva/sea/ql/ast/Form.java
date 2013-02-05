package org.uva.sea.ql.ast;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.ast.exp.Identifier;

public class Form implements ASTNode {

	private final Identifier identifier;
	private final ASTNode body;

	public Form(final Identifier identifier, final ASTNode body) {
		this.identifier = identifier;
		this.body = body;

		state.assertNotNull(identifier, "Form.identifier");
		state.assertNotNull(body, "Form.body");
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public ASTNode getBody() {
		return body;
	}

}
