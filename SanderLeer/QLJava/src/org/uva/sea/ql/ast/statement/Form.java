package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.ASTNodeVisitor;
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
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
