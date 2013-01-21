package org.uva.sea.ql.ast;

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
