package org.uva.sea.ql.ast;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.ast.exp.Identifier;

public class Form extends Block {

	private final Identifier identifier;
	private final CompoundStatement body;

	public Form(final Identifier identifier, final CompoundStatement body) {
		this.identifier = identifier;
		this.body = body;

		state.assertNotNull(identifier, "Form.identifier");
		state.assertNotNull(body, "Form.body");
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public CompoundStatement getBody() {
		return body;
	}

	@Override
	public <T> T accept(final StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Form [identifier=" + identifier + ", body=" + body + "]";
	}

}
