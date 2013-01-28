package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Visitor;
import org.uva.sea.ql.ast.expression.Identifier;

public class Form extends BlockStatement {
	private final Identifier identifier;
	
	public Form(Identifier identifier, StatementList statements) {
		super(statements);
		this.identifier = identifier;
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
