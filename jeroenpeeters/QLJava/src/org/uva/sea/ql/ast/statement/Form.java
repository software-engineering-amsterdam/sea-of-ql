package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Identifier;

public class Form extends Statement {

	private final Identifier identity;
	private final CompoundStatement compoundStatement;
	
	public Form(Identifier identity, CompoundStatement compoundStatement) {
		this.identity = identity;
		this.compoundStatement = compoundStatement;
	}

	public Identifier getIdentity() {
		return identity;
	}

	public CompoundStatement getCompoundStatement() {
		return compoundStatement;
	}
	
	public <T> T accept(final StatementVisitor<T> v){
		return v.visit(this);
	}
	
}