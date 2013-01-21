package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.parser.ASTVisitor;

public class Form implements ASTNode {

	private final Ident identity;
	private final CompoundStatement compoundStatement;
	
	public Form(Ident identity, CompoundStatement compoundStatement) {
		this.identity = identity;
		this.compoundStatement = compoundStatement;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}

	public Ident getIdentity() {
		return identity;
	}

	public CompoundStatement getCompoundStatement() {
		return compoundStatement;
	}
	
}