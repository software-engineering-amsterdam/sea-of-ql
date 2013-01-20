package org.uva.sea.ql.ast;

import org.uva.sea.ql.parser.ASTVisitor;

public class Form extends Expr{

	private final Ident identity;
	private final CompoundStatement compoundStatement;
	
	public Form(Ident identity, CompoundStatement compoundStatement) {
		this.identity = identity;
		this.compoundStatement = compoundStatement;
	}

	@Override
	public void accept(ASTVisitor v){
		super.accept(v);

		compoundStatement.accept(v);
	}
	
}