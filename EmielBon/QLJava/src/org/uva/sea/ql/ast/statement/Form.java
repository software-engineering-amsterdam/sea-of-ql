package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Identifier;

public class Form extends Statement {
	
	private final Identifier id;
	private final Statements body;
	
	public Form(Identifier id, Statements body) {
		this.id = id;
		this.body = body;
	}

	public Identifier getIdentifier() {
		return id;
	}

	public Statements getBody() {
		return body;
	}

	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
