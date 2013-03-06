package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expression.Identifier;

public class Form implements ASTNode {

	private final Identifier identity;
	private final CompoundStatement compoundStatement;
	
	public Form(Identifier identity, CompoundStatement compoundStatement) {
		this.identity = identity;
		this.compoundStatement = compoundStatement;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}

	public Identifier getIdentity() {
		return identity;
	}

	public CompoundStatement getCompoundStatement() {
		return compoundStatement;
	}
	
}