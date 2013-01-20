package org.uva.sea.ql.ast;

public class Form implements ASTNode {
	private final Identifier identifier;
	private final ASTNode statements;
	
	public Form(Identifier identifier, ASTNode statements) {
		this.identifier = identifier;
		this.statements = statements;
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public ASTNode getStatements() {
		return statements;
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
